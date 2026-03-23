package com.example.async;

import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import javax.servlet.AsyncContext;
import javax.servlet.AsyncEvent;
import javax.servlet.AsyncListener;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

/**
 * Holds async contexts (long-polling clients) and broadcasts messages to them.
 * Uses AsyncListener for timeout (sends JSON) and cleanup.
 */
public final class AsyncBroadcaster {
  private static final AsyncBroadcaster INSTANCE = new AsyncBroadcaster();

  private final List<AsyncContext> listeners = new ArrayList<>();
  private final Deque<String> backlog = new ArrayDeque<>();

  private AsyncBroadcaster() {
  }

  public static AsyncBroadcaster getInstance() {
    return INSTANCE;
  }

  public void register(final AsyncContext context) {
    context.setTimeout(25000L);
    context.addListener(new AsyncListener() {
      @Override
      public void onComplete(AsyncEvent event) {
        remove(event.getAsyncContext());
      }

      @Override
      public void onTimeout(AsyncEvent event) throws IOException {
        send(event.getAsyncContext(), "{\"type\":\"timeout\"}");
      }

      @Override
      public void onError(AsyncEvent event) {
        remove(event.getAsyncContext());
      }

      @Override
      public void onStartAsync(AsyncEvent event) {
      }
    });

    String msg = pollBacklog();
    if (msg != null) {
      send(context, msg);
      return;
    }

    synchronized (listeners) {
      listeners.add(context);
    }
  }

  public void broadcast(String jsonMessage) {
    List<AsyncContext> snapshot;
    synchronized (listeners) {
      snapshot = new ArrayList<>(listeners);
      listeners.clear();
    }

    if (snapshot.isEmpty()) {
      pushBacklog(jsonMessage);
      return;
    }

    for (AsyncContext ctx : snapshot) {
      send(ctx, jsonMessage);
    }
  }

  private void remove(AsyncContext ctx) {
    synchronized (listeners) {
      listeners.remove(ctx);
    }
  }

  private void send(AsyncContext ctx, String jsonMessage) {
    try {
      ServletResponse resp = ctx.getResponse();
      HttpServletResponse http = (HttpServletResponse) resp;
      http.setContentType("application/json");
      http.setCharacterEncoding("UTF-8");
      http.getWriter().write(jsonMessage);
      http.getWriter().flush();
    } catch (IOException ignored) {
    } finally {
      ctx.complete();
      remove(ctx);
    }
  }

  private void pushBacklog(String message) {
    synchronized (backlog) {
      if (backlog.size() >= 50) {
        backlog.removeFirst();
      }
      backlog.addLast(message);
    }
  }

  private String pollBacklog() {
    synchronized (backlog) {
      return backlog.pollFirst();
    }
  }
}
