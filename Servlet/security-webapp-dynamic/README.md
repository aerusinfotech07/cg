# Web Application Security Demo (no Maven)

Simple servlet/JSP example for **web application security**: container security, four authentication models, forcing HTTPS, and JAAS.

## Topics

1. **Container's role** — Who enforces access and performs authentication (see NOTES.md).
2. **Four authentication models** — BASIC, FORM, DIGEST, CLIENT-CERT (this app uses FORM).
3. **Force encryption** — `transport-guarantee` CONFIDENTIAL in web.xml redirects HTTP to HTTPS for protected URLs.
4. **JAAS** — Pluggable authentication; container can use JAAS/Realm; app uses getUserPrincipal / isUserInRole.

## Run (Eclipse + Tomcat 9)

1. **New Dynamic Web Project** → name `security-webapp-dynamic`, runtime Tomcat 9, web module 3.1.
2. Copy `src` and `WebContent` into the project.
3. **Build path** → Add Library → Server Runtime → Tomcat 9.
4. Add a user in Tomcat: edit `conf/tomcat-users.xml`:
   ```xml
   <user username="tomcat" password="tomcat" roles="user"/>
   ```
5. Run on Server. Open: `http://localhost:8080/security-webapp-dynamic/`
6. Click "Go to protected area" → you get the login page. Log in with `tomcat` / `tomcat`.

## HTTPS (optional)

To test **CONFIDENTIAL** (redirect to HTTPS):

1. Configure an HTTPS connector in Tomcat (e.g. in `conf/server.xml`, port 8443).
2. For protected URLs, use `https://localhost:8443/security-webapp-dynamic/secure/welcome.jsp` (or let the container redirect from HTTP).

## Files

- **NOTES.md** — Full explanation of all four topics and code.
- **WebContent/WEB-INF/web.xml** — Security constraints, FORM login, CONFIDENTIAL.
- **login.jsp** — Form with `j_username`, `j_password`, action `j_security_check`.
- **SecureInfoServlet** — Example of `getUserPrincipal()`, `isUserInRole("user")`.
