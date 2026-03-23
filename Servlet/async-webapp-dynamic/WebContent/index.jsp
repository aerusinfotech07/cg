<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8" />
  <title>Async Servlet + Server-Push Demo</title>
  <style>
    body { font-family: Arial, sans-serif; margin: 24px; }
    .row { margin-bottom: 12px; }
    #log { border: 1px solid #ccc; height: 220px; overflow: auto; padding: 8px; }
    .msg { margin: 4px 0; }
    .meta { color: #666; font-size: 12px; }
  </style>
</head>
<body>
  <h2>Asynchronous Web Application</h2>
  <p>Long polling + JavaScript HTTP + response in JS = server-push effect.</p>

  <div class="row">
    <input id="text" type="text" placeholder="Type a message" size="40" />
    <button id="send">Send</button>
  </div>

  <div class="row">
    <strong>Status:</strong> <span id="status">Idle</span>
  </div>

  <div id="log"></div>

  <script src="js/app.js"></script>
</body>
</html>
