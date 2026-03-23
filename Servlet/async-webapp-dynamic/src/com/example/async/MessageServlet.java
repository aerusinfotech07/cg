package com.example.async;

import java.io.IOException;
import java.time.Instant;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Accepts POST with "text" parameter and broadcasts to all long-polling clients.
 * Client sends request via JavaScript; response is processed in JavaScript.
 */
@WebServlet("/send")
public class MessageServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    req.setCharacterEncoding("UTF-8");
    String text = req.getParameter("text");
    if (text == null || text.trim().isEmpty()) {
      resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "text is required");
      return;
    }

    String json = "{\"type\":\"message\",\"text\":" + toJson(text.trim()) + ",\"ts\":\"" + Instant.now().toString() + "\"}";
    AsyncBroadcaster.getInstance().broadcast(json);

    resp.setContentType("application/json");
    resp.setCharacterEncoding("UTF-8");
    resp.getWriter().write("{\"status\":\"ok\"}");
  }

  private String toJson(String input) {
    String escaped = input.replace("\\", "\\\\").replace("\"", "\\\"").replace("\n", "\\n").replace("\r", "\\r");
    return "\"" + escaped + "\"";
  }
}
