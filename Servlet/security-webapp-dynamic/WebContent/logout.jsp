<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
  // Invalidate the session to log the user out (container stores auth in session for FORM auth)
  if (session != null) {
    session.invalidate();
  }
  response.sendRedirect(request.getContextPath() + "/index.jsp");
%>
