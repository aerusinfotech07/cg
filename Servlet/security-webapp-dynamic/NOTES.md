
---

## 1. Role of the Container in Security

### What the container does

The **container** (e.g. Tomcat, Jetty) is responsible for:

- **Enforcing access control**: Before a request reaches your servlet or JSP, the container checks whether the requested URL is protected and whether the user is authenticated and has the required role.
- **Running the authentication process**: When an unauthenticated user hits a protected URL, the container redirects to the login page (FORM) or sends a 401 with `WWW-Authenticate` (BASIC/DIGEST), or checks the client certificate (CLIENT-CERT).
- **Storing the identity after login**: After successful authentication, the container associates the **principal** (user identity) and **roles** with the request (and usually with the session for FORM auth).
- **Exposing identity to the application**: Your code can call `request.getUserPrincipal()`, `request.getRemoteUser()`, and `request.isUserInRole("role")` without handling passwords or tokens yourself.

### What the application does

The **application** only declares security in `web.xml` (or annotations):

- Which URLs are protected (`<url-pattern>` inside `<security-constraint>`).
- Which role is required (`<auth-constraint>` with `<role-name>`).
- How the user should log in (`<login-config>`: FORM, BASIC, etc.).
- Whether to force HTTPS (`<transport-guarantee>CONFIDENTIAL</transport-guarantee>`).

The application does **not** implement password checking; the container does that using a **Realm** (or JAAS).

### Summary

| Responsibility              | Who does it        |
|----------------------------|--------------------|
| Decide which URLs need auth| Application (web.xml) |
| Show login form / challenge| Container          |
| Verify username/password   | Container (Realm/JAAS) |
| Attach principal to request| Container          |
| Check roles                | Container          |
| Use principal in servlets | Application (getUserPrincipal, isUserInRole) |

---

## 2. Four Authentication Models

The Servlet/Java EE spec defines four ways the container can authenticate the user. You choose one in `web.xml` with `<auth-method>` inside `<login-config>`.

### 2.1 BASIC

- **How it works:** Browser shows a built-in username/password dialog. Credentials are sent with **every request** in the `Authorization` header (Base64-encoded, not encrypted).
- **Config in web.xml:**
  ```xml
  <login-config>
    <auth-method>BASIC</auth-method>
    <realm-name>YourRealm</realm-name>
  </login-config>
  ```
- **Use when:** Simple APIs or internal tools. **Always use over HTTPS** so the Base64 credentials are not sent in clear text.

### 2.2 FORM

- **How it works:** Your application provides a custom HTML form. User submits `j_username` and `j_password`; the form **action must be** `j_security_check`. The container intercepts that request, validates credentials via its Realm, and then redirects to the requested resource or to the error page.
- **Config in web.xml (used in this project):**
  ```xml
  <login-config>
    <auth-method>FORM</auth-method>
    <realm-name>Security Demo Realm</realm-name>
    <form-login-config>
      <form-login-page>/login.jsp</form-login-page>
      <form-error-page>/login-error.jsp</form-error-page>
    </form-login-config>
  </login-config>
  ```
- **Code in login.jsp:** The form must use exact names and action:
  ```html
  <form method="post" action="j_security_check">
    <input type="text" name="j_username" />
    <input type="password" name="j_password" />
    <input type="submit" value="Login" />
  </form>
  ```
- **Use when:** You want a custom login page and session-based login (typical for web apps).

### 2.3 DIGEST

- **How it works:** Similar to BASIC, but the password is not sent. The server sends a **nonce**; the client sends a hash (MD5 of username, realm, password, nonce, etc.). The server verifies the hash. More secure than BASIC over HTTP, but still better with HTTPS.
- **Config:**
  ```xml
  <login-config>
    <auth-method>DIGEST</auth-method>
    <realm-name>Security Demo Realm</realm-name>
  </login-config>
  ```
- **Note:** The Realm must support digest verification (e.g. store password hashes or precomputed digest). Tomcat’s default MemoryRealm can be configured for digest.

### 2.4 CLIENT-CERT

- **How it works:** Authentication is based on the **client’s X.509 certificate** (TLS mutual authentication). No username/password form; the container validates the certificate and maps it to a principal/roles.
- **Config:**
  ```xml
  <login-config>
    <auth-method>CLIENT-CERT</auth-method>
    <realm-name>Security Demo Realm</realm-name>
  </login-config>
  ```
- **Requires:** Server configured for TLS and client certificates; Realm that maps certificates to users/roles (e.g. JNDIRealm or custom Realm).

### Summary

| Model        | Login UI        | Credentials sent as     | Typical use        |
|-------------|-----------------|--------------------------|--------------------|
| BASIC       | Browser dialog  | Base64 each request      | APIs, simple UIs   |
| FORM        | Your HTML form  | Once (then session)      | Web applications   |
| DIGEST      | Browser dialog  | Hash (no plain password) | When no HTTPS      |
| CLIENT-CERT | None            | Client certificate       | High-security/m2m  |

This project implements **FORM**; an example snippet for **BASIC** is in `WEB-INF/web.xml.basic-auth-example`.

---

## 3. Forcing Encryption Between Browser and Server

### Why

Without HTTPS, credentials and session cookies can be read or modified on the network. **Confidentiality** and **integrity** between the browser and the server require TLS (HTTPS).

### How (declarative in web.xml)

Inside a **`<security-constraint>`**, add **`<user-data-constraint>`** with **`<transport-guarantee>CONFIDENTIAL</transport-guarantee>`**:

```xml
<security-constraint>
  <web-resource-collection>
    <web-resource-name>Protected area</web-resource-name>
    <url-pattern>/secure/*</url-pattern>
    <url-pattern>/info</url-pattern>
    ...
  </web-resource-collection>
  <auth-constraint>
    <role-name>user</role-name>
  </auth-constraint>
  <user-data-constraint>
    <description>Require HTTPS</description>
    <transport-guarantee>CONFIDENTIAL</transport-guarantee>
  </user-data-constraint>
</security-constraint>
```

### What the container does

- For any request that matches this constraint, if the request comes over **HTTP**, the container **redirects** the browser to the **same URL over HTTPS** (e.g. `https://host:443/...`). Port 443 is typical; the exact port is configured on the server (e.g. Tomcat’s HTTPS connector).
- So: **encryption is forced** for all protected URLs without any code in your servlets or JSPs.

### Values of `transport-guarantee`

| Value         | Meaning                          |
|---------------|----------------------------------|
| `NONE`        | No requirement (default)         |
| `INTEGRAL`    | Data must not be changed in transit (e.g. TLS) |
| `CONFIDENTIAL`| Data must not be read or changed (e.g. TLS with encryption) |

In practice, both INTEGRAL and CONFIDENTIAL are implemented with HTTPS.

### In this project

The same `<security-constraint>` that protects `/secure/*` and `/info` and requires the `user` role also has `<transport-guarantee>CONFIDENTIAL</transport-guarantee>`. So access to the protected area is forced over HTTPS. You must configure an HTTPS connector in Tomcat for this to work (see README).

---

## 4. Role of JAAS in Pluggable/Extensible Authentication

### What is JAAS?

**JAAS** (Java Authentication and Authorization Service) is a standard Java API for **pluggable** authentication and authorization. You implement or configure **LoginModules** that:

- Obtain credentials (e.g. from a callback).
- Verify them (e.g. against a database, LDAP, or custom logic).
- Populate a **Subject** with principals and credentials.

The **container** can use JAAS so that the same declarative security in `web.xml` works with your custom authentication logic.

### How it fits with the web container

- The **web application** still only declares: protected URLs, roles, and login method (FORM, BASIC, etc.).
- The **container** still intercepts login (e.g. `j_security_check`), still enforces roles, and still sets `request.getUserPrincipal()` and session.
- The **difference** is where the container gets user/password verification and role information:
  - **Built-in Realm** (e.g. Tomcat MemoryRealm, JDBCRealm): container’s built-in implementation.
  - **JAAS**: container calls into a JAAS **LoginModule** (or a Realm that uses JAAS), so you can plug in database, LDAP, OAuth, or any custom logic without changing the web app’s security declarations.

So JAAS provides **pluggable/extensible authentication**: you swap or add LoginModules (or Realms that use them) instead of hard-coding authentication in the application.

### In Tomcat specifically

- Tomcat uses the **Realm** interface for authentication. It does not use JAAS by default, but you can:
  - Use **JAASRealm**: configure a `login.config` and LoginModules; Tomcat uses JAAS to authenticate.
  - Or implement a **custom Realm** that calls your own code (e.g. database or REST API); the idea is the same “pluggable” pattern as JAAS.

### What the application code does

The application does **not** call JAAS directly. It only:

- Declares security in `web.xml` (as in this project).
- Uses `request.getUserPrincipal()`, `request.getRemoteUser()`, `request.getAuthType()`, and `request.isUserInRole("role")`.

Example from **SecureInfoServlet.java**:

```java
// Container has already authenticated; we only read the result.
String name = req.getUserPrincipal() != null ? req.getUserPrincipal().getName() : "—";
String remoteUser = req.getRemoteUser();
String authType = req.getAuthType();
boolean inRole = req.isUserInRole("user");
```

So: **JAAS (or a custom Realm) is the pluggable “backend” used by the container; the web app stays the same.**

---

## Project Structure and Code Summary

```
security-webapp-dynamic/
  src/com/example/security/
    SecureInfoServlet.java   → Protected servlet; shows principal and role
  WebContent/
    index.jsp                → Public home with links to protected URLs
    login.jsp                → FORM login (j_username, j_password, j_security_check)
    login-error.jsp          → Shown after failed login
    logout.jsp               → Invalidates session, redirects to home
    secure/
      welcome.jsp            → Protected JSP; shows principal, auth type
    WEB-INF/
      web.xml                → Security constraints, FORM login, CONFIDENTIAL
      web.xml.basic-auth-example  → Example BASIC login-config
  docs/
    JAAS-Realm-notes.txt     → Short note on JAAS and Realms
  NOTES.md                   → This file
```

### web.xml (explanation)

- **`<security-role>`**  
  Declares the role name `user` used in constraints.

- **`<security-constraint>`**  
  - **`<web-resource-collection>`**: URLs `/secure/*` and `/info` are protected; GET and POST.
  - **`<auth-constraint>`**: Only users in role `user` can access.
  - **`<user-data-constraint>`** with **`CONFIDENTIAL`**: These URLs must be accessed over HTTPS.

- **`<login-config>`**  
  **FORM** auth; custom login page `login.jsp`, error page `login-error.jsp`; realm name for display/logs.

### login.jsp (explanation)

- Form **action** must be `j_security_check` so the container handles the POST.
- Input **names** must be `j_username` and `j_password`.  
No application code handles the POST; the container validates and creates the session.

### SecureInfoServlet / welcome.jsp (explanation)

- Only run after the container has authenticated the user.
- **getUserPrincipal()**: identity (e.g. username).
- **getRemoteUser()**: same, as a string.
- **getAuthType()**: e.g. `"FORM"`, `"BASIC"`.
- **isUserInRole("user")**: whether the user has the role required by the constraint.

---

## How to Run (no Maven)

1. Create a **Dynamic Web Project** in Eclipse (or similar), target **Tomcat 9**, module version **3.1**.
2. Copy `src` and `WebContent` into the project.
3. Add **Tomcat 9** to the project’s build path (Server Runtime).
4. Add a user with role `user` in Tomcat’s realm (e.g. in `conf/tomcat-users.xml`):
   ```xml
   <user username="tomcat" password="tomcat" roles="user"/>
   ```
5. **Optional (for HTTPS):** Configure an HTTPS connector in Tomcat (e.g. in `conf/server.xml`) and use port 8443. Then open `https://localhost:8443/security-webapp-dynamic/` for protected pages; the container will redirect HTTP to HTTPS for protected URLs.
6. Deploy and open: `http://localhost:8080/security-webapp-dynamic/` (or HTTPS URL if configured).

---

## Summary Table

| Topic                    | Main idea |
|--------------------------|-----------|
| **Container’s role**     | Enforces access, runs login, verifies credentials via Realm/JAAS, attaches principal to request. App only declares constraints and uses principal/roles. |
| **Four auth models**     | BASIC (browser dialog, Base64); FORM (your form, `j_security_check`); DIGEST (hash); CLIENT-CERT (certificate). Chosen in `<login-config>`. |
| **Force encryption**     | `<user-data-constraint>` with `<transport-guarantee>CONFIDENTIAL</transport-guarantee>` in the same `<security-constraint>`. Container redirects HTTP → HTTPS. |
| **JAAS**                 | Pluggable authentication; container can use JAAS LoginModules (or Realms) to verify users/roles; web app code stays the same and uses getUserPrincipal / isUserInRole. |
