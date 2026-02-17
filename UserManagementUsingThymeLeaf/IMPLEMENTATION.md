# Implementation Guide: User Management Projects

This document describes the **UserManagement**, **UserManagementUsingJSP**, and **UserManagementUsingThymeLeaf** projects, and provides step-by-step notes to implement or replicate all changes.

---

## 1. Overview of Projects

| Project | View technology | Port | Packaging | Description |
|--------|------------------|------|------------|-------------|
| **UserManagement** | REST API only (no UI) | 8080 | JAR | CRUD REST API; Swagger UI at `/swagger-ui.html` |
| **UserManagementUsingJSP** | JSP + JSTL | 8081 | WAR | Same backend; web UI with JSP pages |
| **UserManagementUsingThymeLeaf** | Thymeleaf | 8082 | JAR | Same backend; web UI with Thymeleaf HTML templates |

All three share the same **domain model** (User, Address, Geo, Company), **repository**, and **service** logic. Only the **presentation layer** (REST vs JSP vs Thymeleaf) differs.

---

## 2. Prerequisites

Before implementing or running any project, ensure:

- **Java 8** (or 11) installed; `JAVA_HOME` set if required.
- **Maven 3.6+** installed; `mvn` on `PATH`.
- **MySQL 5.7+** (or 8.x) installed and running.
- **IDE** (Eclipse, IntelliJ, or VS Code) optional but useful.

---

## 3. Database Setup (All Projects)

Use the same database for all three applications so you can point JSP and Thymeleaf to existing data.

### Step 1: Create database

```sql
CREATE DATABASE usermanagement;
```

### Step 2: Configure credentials

In each project’s `src/main/resources/application.properties` set:

```properties
spring.datasource.username=root
spring.datasource.password=root
```

Change `root`/`root` to your MySQL username and password.  
If MySQL runs on another host/port, update:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/usermanagement?useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&allowPublicKeyRetrieval=true
```

### Step 3: Tables

Tables are created/updated automatically by JPA with:

```properties
spring.jpa.hibernate.ddl-auto=update
```

No manual DDL is required unless you prefer to run scripts yourself.

---

## 4. Implementing / Running UserManagementUsingJSP

### Step 1: Open the project

- **Eclipse:** File → Import → Maven → Existing Maven Projects → select `UserManagementUsingJSP` folder.
- **IntelliJ:** File → Open → select `UserManagementUsingJSP` (detect as Maven project).
- **VS Code:** Open folder `UserManagementUsingJSP`; ensure Java and Maven extensions are installed.

### Step 2: Resolve dependencies

From project root:

```bash
cd UserManagementUsingJSP
mvn clean install
```

Fix any JDK/encoding issues if the build fails (e.g. ensure Java 8 in `pom.xml` and `JAVA_HOME`).

### Step 3: Configure database

Edit `src/main/resources/application.properties` as in **Section 3** (database URL, username, password).

### Step 4: Run the application

```bash
mvn spring-boot:run
```

Or run the main class `com.usermanagement.UserManagementUsingJSPApplication` from your IDE.

### Step 5: Verify

- Open **http://localhost:8081/users** in a browser.
- You should see the user list (empty if no data).
- Use “Add New User” to create a user, then View / Edit / Delete to confirm CRUD.

### Notes (JSP)

- JSPs live under `src/main/webapp/WEB-INF/jsp/` (prefix/suffix in `application.properties`: `spring.mvc.view.prefix`, `spring.mvc.view.suffix=.jsp`).
- WAR packaging: you can deploy the generated WAR to an external Tomcat, or run with embedded Tomcat as above.
- For new-user form, the controller initializes empty `Address`, `Geo`, and `Company` so the JSP form can bind nested objects without nulls.

---

## 5. Implementing / Running UserManagementUsingThymeLeaf

### Step 1: Open the project

Same as JSP: import/open `UserManagementUsingThymeLeaf` as a Maven project in your IDE or terminal.

### Step 2: Resolve dependencies

```bash
cd UserManagementUsingThymeLeaf
mvn clean install
```

### Step 3: Configure database

Same as **Section 3**: adjust `src/main/resources/application.properties` (URL, username, password).

### Step 4: Run the application

```bash
mvn spring-boot:run
```

Or run `com.usermanagement.UserManagementUsingThymeLeafApplication` from the IDE.

### Step 5: Verify

- Open **http://localhost:8082/users**.
- Test list, Add, View, Edit, Delete as for the JSP project.

### Notes (Thymeleaf)

- Templates are in `src/main/resources/templates/` (default Thymeleaf location; no extra view config needed).
- Form binding uses `th:object` and `th:field`; validation errors use `th:errors` and `#fields.hasErrors()`.
- Port 8082 avoids clashes with UserManagement (8080) and UserManagementUsingJSP (8081).

---

## 6. Summary of Changes (What Was Implemented)

### UserManagementUsingJSP

- **pom.xml:** Spring Boot 2.7.18, `spring-boot-starter-web`, `spring-boot-starter-data-jpa`, `spring-boot-starter-validation`, MySQL driver, `tomcat-embed-jasper`, JSTL; packaging `war`.
- **Main class:** `UserManagementUsingJSPApplication` extending `SpringBootServletInitializer` for WAR deployment.
- **Entities:** User, Address, Geo, Company (same as UserManagement).
- **Repository:** `UserRepository` (JpaRepository).
- **Service:** `UserService` (CRUD and duplicate username/email checks).
- **Controller:** `UserViewController` – GET/POST for list, new, edit, view, delete.
- **Views:** `list.jsp`, `userForm.jsp`, `viewUser.jsp` under `src/main/webapp/WEB-INF/jsp/`.
- **Configuration:** `application.properties` with server port 8081, datasource, JPA, and JSP view prefix/suffix.

### UserManagementUsingThymeLeaf

- **pom.xml:** Same as above except `spring-boot-starter-thymeleaf` instead of JSP/Jasper/JSTL; packaging `jar`.
- **Main class:** `UserManagementUsingThymeLeafApplication` (standard `@SpringBootApplication`).
- **Entities, Repository, Service:** Same as JSP project.
- **Controller:** `UserViewController` – same URL mapping and flow as JSP, returning Thymeleaf view names.
- **Views:** `list.html`, `userForm.html`, `viewUser.html` in `src/main/resources/templates/`.
- **Configuration:** `application.properties` with server port 8082, datasource, JPA, and optional `spring.thymeleaf.cache=false` for development.

---

## 7. Steps to Replicate From Scratch (High Level)

If you need to recreate a similar project elsewhere:

1. Create a Spring Boot 2.7.x project (e.g. from start.spring.io) with Web, JPA, Validation, MySQL.
2. Add either **Tomcat Embed Jasper + JSTL** (for JSP) or **Thymeleaf** (for Thymeleaf).
3. Define entities: User (with relations to Address, Company), Address (with Geo), Geo, Company.
4. Create `UserRepository` extending `JpaRepository<User, Long>` and add `findByUsername`, `findByEmail`, `existsByUsername`, `existsByEmail`.
5. Implement `UserService` with `getAllUsers`, `getUserById`, `createUser`, `updateUser`, `deleteUser` and duplicate checks.
6. Add a single `UserViewController` with GET/POST mappings for list, new, save, view, edit, update, delete.
7. For JSP: set `spring.mvc.view.prefix=/WEB-INF/jsp/` and `suffix=.jsp`; place JSPs under `src/main/webapp/WEB-INF/jsp/` and use `<form:form>`, `<c:forEach>`, etc.
8. For Thymeleaf: place HTML templates in `src/main/resources/templates/` and use `th:each`, `th:object`, `th:field`, `th:if`, `th:text`, `@{...}` for URLs.
9. Configure `application.properties` (server port, datasource, JPA) and run with `mvn spring-boot:run` or from the IDE.

---

## 8. Troubleshooting

| Issue | What to check |
|-------|----------------|
| Port already in use | Change `server.port` in `application.properties` (e.g. 8083). |
| Database connection failed | MySQL running; URL/host/port correct; username/password correct; database `usermanagement` created. |
| JSP not found / 404 on pages | View prefix/suffix in `application.properties`; JSPs under `WEB-INF/jsp/`; controller returns exact view name (e.g. `"list"` → `list.jsp`). |
| Thymeleaf template not found | Templates under `src/main/resources/templates/`; controller returns name without `.html` (e.g. `"list"` → `list.html`). |
| Validation errors not showing | JSP: `<form:errors path="..."/>`; Thymeleaf: `th:errors="*{...}"` and `#fields.hasErrors('...')`. |
| Nested object null on form | In controller’s “new user” method, set `user.setAddress(new Address())`, `user.getAddress().setGeo(new Geo())`, `user.setCompany(new Company())` before adding `user` to the model. |

---

## 9. Quick Reference – URLs

| Action | JSP (port 8081) | Thymeleaf (port 8082) |
|--------|------------------|------------------------|
| List users | GET http://localhost:8081/users | GET http://localhost:8082/users |
| New user form | GET http://localhost:8081/users/new | GET http://localhost:8082/users/new |
| View user | GET http://localhost:8081/users/{id} | GET http://localhost:8082/users/{id} |
| Edit user form | GET http://localhost:8081/users/{id}/edit | GET http://localhost:8082/users/{id}/edit |

POST endpoints (create, update, delete) are used by the forms; no need to call them manually for normal use.
