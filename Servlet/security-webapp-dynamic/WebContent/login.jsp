<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8" />
  <title>Login</title>
  <style>
    body { font-family: Arial, sans-serif; margin: 24px; }
    .row { margin: 8px 0; }
    input[type="text"], input[type="password"] { width: 200px; }
  </style>
</head>
<body>
  <h2>Login</h2>
  <!-- Container expects these exact names: j_username, j_password, and form action j_security_check -->
  <form method="post" action="j_security_check">
    <div class="row">
      <label for="j_username">User name:</label><br/>
      <input id="j_username" type="text" name="j_username" required />
    </div>
    <div class="row">
      <label for="j_password">Password:</label><br/>
      <input id="j_password" type="password" name="j_password" required />
    </div>
    <div class="row">
      <input type="submit" value="Login" />
    </div>
  </form>
  <p><small>With Tomcat default realm: try user <code>tomcat</code> / <code>tomcat</code> (or add users in conf/tomcat-users.xml).</small></p>
</body>
</html>
