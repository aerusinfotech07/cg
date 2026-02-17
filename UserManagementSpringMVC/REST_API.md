# REST API - UserManagementSpringMVC

REST endpoints are exposed in the **`com.usermanagement.api`** package. They use the same services as the JSP UI and return JSON.

Base URL (relative to app context): e.g. `http://localhost:8080/UserManagementSpringMVC`

---

## Users API — `/api/users`

| Method | Path | Description |
|--------|------|-------------|
| GET | `/api/users` | List all users |
| GET | `/api/users/{id}` | Get user by ID |
| GET | `/api/users/username/{username}` | Get user by username |
| GET | `/api/users/email/{email}` | Get user by email |
| POST | `/api/users` | Create user (JSON body) |
| PUT | `/api/users/{id}` | Update user (JSON body) |
| DELETE | `/api/users/{id}` | Delete user |

---

## Employees API — `/api/employees`

| Method | Path | Description |
|--------|------|-------------|
| GET | `/api/employees` | List all employees |
| GET | `/api/employees/{id}` | Get employee by ID |
| GET | `/api/employees/code/{employeeCode}` | Get employee by code |
| GET | `/api/employees/email/{email}` | Get employee by email |
| POST | `/api/employees` | Create employee (JSON body) |
| PUT | `/api/employees/{id}` | Update employee (JSON body) |
| DELETE | `/api/employees/{id}` | Delete employee |

---

## Request/Response

- **Content-Type:** `application/json` for request body and responses.
- **404:** Body is `{ "message": "..." }`.
- **POST:** Returns `201 Created` with the created entity in the body.
- **DELETE:** Returns `204 No Content` on success.

## Example

```bash
# Get all users
curl http://localhost:8080/UserManagementSpringMVC/api/users

# Get user by ID
curl http://localhost:8080/UserManagementSpringMVC/api/users/1

# Create user
curl -X POST http://localhost:8080/UserManagementSpringMVC/api/users \
  -H "Content-Type: application/json" \
  -d '{"name":"John","username":"john","email":"john@example.com"}'
```
