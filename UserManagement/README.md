# UserManagement - Spring Boot Application

A Spring Boot REST API application for managing users with CRUD operations, following layered architecture and connected to MySQL 5.7 database.

## Project Structure

```
UserManagement/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/usermanagement/
│   │   │       ├── UserManagementApplication.java (Main Application)
│   │   │       ├── entity/ (Domain Models)
│   │   │       │   ├── User.java
│   │   │       │   ├── Address.java
│   │   │       │   ├── Geo.java
│   │   │       │   └── Company.java
│   │   │       ├── repository/ (Data Access Layer)
│   │   │       │   └── UserRepository.java
│   │   │       ├── service/ (Business Logic Layer)
│   │   │       │   └── UserService.java
│   │   │       └── controller/ (REST API Layer)
│   │   │           └── UserController.java
│   │   └── resources/
│   │       └── application.properties
│   └── test/
└── pom.xml
```

## Architecture Layers

1. **Entity Layer** (`entity/`): Domain models representing database tables
   - User, Address, Geo, Company

2. **Repository Layer** (`repository/`): Data access layer using Spring Data JPA
   - UserRepository extends JpaRepository

3. **Service Layer** (`service/`): Business logic layer
   - UserService handles CRUD operations and business rules

4. **Controller Layer** (`controller/`): REST API endpoints
   - UserController exposes REST endpoints for CRUD operations

## Prerequisites

- Java 8 or higher
- Maven 3.6+
- MySQL 5.7
- IDE (IntelliJ IDEA, Eclipse, or VS Code)

## Database Setup

1. Create MySQL database:
```sql
CREATE DATABASE usermanagement;
```

2. Update `application.properties` with your MySQL credentials:
```properties
spring.datasource.username=your_username
spring.datasource.password=your_password
```

## Running the Application

1. **Build the project:**
```bash
mvn clean install
```

2. **Run the application:**
```bash
mvn spring-boot:run
```

Or run `UserManagementApplication.java` directly from your IDE.

The application will start on `http://localhost:8080`

## API Endpoints

### Get All Users
```
GET /api/users
```

### Get User by ID
```
GET /api/users/{id}
```

### Get User by Username
```
GET /api/users/username/{username}
```

### Get User by Email
```
GET /api/users/email/{email}
```

### Create User
```
POST /api/users
Content-Type: application/json

{
  "name": "Leanne Graham",
  "username": "Bret",
  "email": "Sincere@april.biz",
  "address": {
    "street": "Kulas Light",
    "suite": "Apt. 556",
    "city": "Gwenborough",
    "zipcode": "92998-3874",
    "geo": {
      "lat": "-37.3159",
      "lng": "81.1496"
    }
  },
  "phone": "1-770-736-8031 x56442",
  "website": "hildegard.org",
  "company": {
    "name": "Romaguera-Crona",
    "catchPhrase": "Multi-layered client-server neural-net",
    "bs": "harness real-time e-markets"
  }
}
```

### Update User
```
PUT /api/users/{id}
Content-Type: application/json

{
  "name": "Updated Name",
  ...
}
```

### Delete User
```
DELETE /api/users/{id}
```

## Features

- ✅ Full CRUD operations (Create, Read, Update, Delete)
- ✅ Layered architecture (Entity, Repository, Service, Controller)
- ✅ MySQL 5.7 database integration
- ✅ JPA/Hibernate for ORM
- ✅ Input validation
- ✅ Error handling
- ✅ RESTful API design
- ✅ Nested object support (Address with Geo, Company)

## Technologies Used

- Spring Boot 2.7.18
- Spring Data JPA
- MySQL Connector 5.1.49
- Hibernate
- Maven
- Java 8

## Notes

- The application uses `spring.jpa.hibernate.ddl-auto=update` which automatically creates/updates database tables
- All nested entities (Address, Geo, Company) are cascaded with User operations
- Username and Email are unique constraints
- The API includes proper error handling and validation
