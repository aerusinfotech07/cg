package com.example.security;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Protected servlet: only reachable after container authentication.
 * Shows how to get the authenticated user (principal) from the request.
 */
@WebServlet("/info")
public class SecureInfoServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    resp.setContentType("text/html; charset=UTF-8");
    PrintWriter out = resp.getWriter();
    out.println("<!DOCTYPE html><html><head><meta charset='UTF-8'/><title>Secure Info</title></head><body>");
    out.println("<h2>Secure servlet (container-authenticated)</h2>");
    out.println("<p><strong>User principal:</strong> " + (req.getUserPrincipal() != null ? req.getUserPrincipal().getName() : "—") + "</p>");
    out.println("<p><strong>Remote user:</strong> " + req.getRemoteUser() + "</p>");
    out.println("<p><strong>Auth type:</strong> " + req.getAuthType() + "</p>");
    out.println("<p><strong>Is user in role 'user':</strong> " + req.isUserInRole("user") + "</p>");
    out.println("<p><a href='" + req.getContextPath() + "/index.jsp'>Home</a> | <a href='" + req.getContextPath() + "/logout.jsp'>Logout</a></p>");
    out.println("</body></html>");
  }
}
