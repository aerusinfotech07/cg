package com.example.async;

import java.io.IOException;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Asynchronous servlet: starts async context and registers with broadcaster.
 * The request thread is released; response is completed when a message arrives or timeout occurs.
 */
@WebServlet(value = "/updates", asyncSupported = true)
public class AsyncLongPollServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    resp.setHeader("Cache-Control", "no-store");
    resp.setHeader("Pragma", "no-cache");

    AsyncContext context = req.startAsync();
    AsyncBroadcaster.getInstance().register(context);
  }
}
