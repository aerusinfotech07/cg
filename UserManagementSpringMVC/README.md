# UserManagementSpringMVC

Spring MVC project with JSP presentation, Hibernate DAO, MySQL, and form validation.

## Project Structure

```
UserManagementSpringMVC/
├── src/main/
│   ├── java/com/usermanagement/
│   │   ├── controller/     - UserController (Spring MVC)
│   │   ├── dao/            - UserDAO (Hibernate)
│   │   ├── entity/         - User, Address, Geo, Company
│   │   ├── service/        - UserService
│   │   └── validator/      - UserValidator
│   └── webapp/
│       ├── WEB-INF/
│       │   ├── spring/     - applicationContext.xml, dispatcher-servlet.xml
│       │   ├── views/user/ - list.jsp, form.jsp, view.jsp
│       │   └── web.xml
│       └── index.jsp
└── pom.xml
```

## Features

- **Presentation**: JSP with Bootstrap
- **Validation**: Spring Validator (UserValidator)
- **DAO**: Spring Hibernate DAO with annotations
- **Database**: MySQL 5.7
- **CRUD**: Create, Read, Update, Delete users

## Prerequisites

- Java 8+
- Maven
- MySQL 5.7
- Tomcat 9+

## Setup

1. **Create MySQL database:**
```sql
CREATE DATABASE usermanagement;
```

2. **Update database credentials** in `applicationContext.xml`:
```xml
<property name="url" value="jdbc:mysql://localhost:3306/usermanagement?..."/>
<property name="username" value="your_username"/>
<property name="password" value="your_password"/>
```

3. **Build the project:**
```bash
mvn clean package
```

4. **Deploy** the WAR file to Tomcat:
- Copy `target/UserManagementSpringMVC.war` to Tomcat's `webapps/` folder

## URLs

- List users: `http://localhost:8080/UserManagementSpringMVC/users`
- Create user: `http://localhost:8080/UserManagementSpringMVC/users/create`
- Edit user: `http://localhost:8080/UserManagementSpringMVC/users/edit/{id}`
- View user: `http://localhost:8080/UserManagementSpringMVC/users/view/{id}`
- Delete user: `http://localhost:8080/UserManagementSpringMVC/users/delete/{id}`

## Form Validation

The UserValidator validates:
- Name (required)
- Username (required, unique)
- Email (required, valid format, unique)
- Address: street, city, zipcode (required)
- Company name (required)

## Technologies

- Spring MVC 5.3.30
- Hibernate 5.6.15
- MySQL Connector 5.1.49
- JSTL 1.2
- Bootstrap 5.2.3
