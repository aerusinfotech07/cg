# UserManagementUsingJSP

User Management System with **JSP** views, based on the same structure as UserManagement. CRUD operations with a web UI rendered by JSP.

## Stack

- Spring Boot 2.7.18
- Spring Data JPA, MySQL
- JSP + JSTL for views
- WAR packaging (deployable to Tomcat or run with embedded Tomcat)

## Project layout

- `entity/` – User, Address, Geo, Company
- `repository/` – UserRepository
- `service/` – UserService
- `controller/UserViewController` – MVC controller for JSP (list, new, edit, view, delete)
- `src/main/webapp/WEB-INF/jsp/` – list.jsp, userForm.jsp, viewUser.jsp

## Run

1. Create DB: `CREATE DATABASE usermanagement;`
2. Set `spring.datasource.username` and `spring.datasource.password` in `application.properties` if needed.
3. Run:

```bash
mvn spring-boot:run
```

4. Open: **http://localhost:8081/users**

## Pages

- **GET /users** – List all users  
- **GET /users/new** – New user form  
- **POST /users** – Create user  
- **GET /users/{id}** – View user  
- **GET /users/{id}/edit** – Edit user form  
- **POST /users/{id}** – Update user  
- **POST /users/{id}/delete** – Delete user  
