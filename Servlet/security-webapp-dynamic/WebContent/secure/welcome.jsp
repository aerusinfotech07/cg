<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page session="true" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8" />
  <title>Protected Page</title>
  <style>
    body { font-family: Arial, sans-serif; margin: 24px; }
  </style>
</head>
<body>
  <h2>Protected area</h2>
  <p>You are logged in. The container has authenticated you and set the principal in the request.</p>
  <p><strong>User (principal):</strong> <%= request.getUserPrincipal() != null ? request.getUserPrincipal().getName() : "—" %></p>
  <p><strong>Remote user:</strong> <%= request.getRemoteUser() %></p>
  <p><strong>Auth type:</strong> <%= request.getAuthType() %></p>
  <p><a href="<%= request.getContextPath() %>/index.jsp">Back to home</a> | <a href="<%= request.getContextPath() %>/logout.jsp">Logout</a></p>
</body>
</html>
