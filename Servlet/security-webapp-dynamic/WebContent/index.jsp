<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8" />
  <title>Web Application Security Demo</title>
  <style>
    body { font-family: Arial, sans-serif; margin: 24px; }
    a { margin-right: 12px; }
  </style>
</head>
<body>
  <h2>Web Application Security Demo</h2>
  <p>This page is <strong>public</strong>. No login required.</p>
  <p>
    <a href="secure/welcome.jsp">Go to protected area (requires login)</a><br/>
    <a href="info">Protected servlet (requires login + HTTPS)</a>
  </p>
  <p><small>If you use HTTP, the container will redirect to HTTPS for protected URLs (when transport-guarantee is CONFIDENTIAL).</small></p>
</body>
</html>
