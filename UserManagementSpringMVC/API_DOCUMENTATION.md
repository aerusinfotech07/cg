# UserManagementSpringMVC - REST API Documentation

Complete API reference with testing instructions, endpoint details, and sample requests/responses.

---

## Table of Contents

1. [Prerequisites](#prerequisites)
2. [Base URL & Headers](#base-url--headers)
3. [How to Test](#how-to-test)
4. [Users API](#users-api)
5. [Employees API](#employees-api)
6. [Error Responses](#error-responses)
7. [Data Models](#data-models)

---

## Prerequisites

- Application deployed and running (e.g., Tomcat on port 8080)
- Database configured and accessible
- Application context: `UserManagementSpringMVC` (or your configured context)

---

## Base URL & Headers

| Item | Value |
|------|-------|
| **Base URL** | `http://localhost:8080/UserManagementSpringMVC` |
| **Content-Type** | `application/json` |
| **Accept** | `application/json` |

For remote: replace `localhost` with your server hostname/IP.

---

## How to Test

### Option 1: cURL (Command Line)

```bash
# Windows PowerShell - escape double quotes with backtick
curl -X GET "http://localhost:8080/UserManagementSpringMVC/api/users"

# Linux/Mac/Git Bash
curl -X GET "http://localhost:8080/UserManagementSpringMVC/api/users"
```

### Option 2: Postman

1. Create a new request
2. Set method (GET, POST, PUT, DELETE)
3. Enter URL
4. Headers: `Content-Type: application/json`, `Accept: application/json`
5. For POST/PUT: Body → raw → JSON → paste request body

### Option 3: Browser

GET requests can be tested directly in the browser address bar.

---

## Users API

Base path: `/api/users`

---

### 1. Get All Users

**GET** `/api/users`

**Request:** No body required

**Sample cURL:**
```bash
curl -X GET "http://localhost:8080/UserManagementSpringMVC/api/users" -H "Accept: application/json"
```

**Sample Response (200 OK):**
```json
[
  {
    "id": 1,
    "name": "John Doe",
    "username": "johndoe",
    "email": "john.doe@example.com",
    "phone": "555-1234",
    "website": "https://johndoe.com",
    "address": {
      "id": 1,
      "street": "123 Main St",
      "suite": "Apt 4",
      "city": "New York",
      "zipcode": "10001",
      "geo": {
        "id": 1,
        "lat": "-37.3159",
        "lng": "81.1496"
      }
    },
    "company": {
      "id": 1,
      "name": "Acme Inc",
      "catchPhrase": "Multi-layered client-server",
      "bs": "harness real-time e-markets"
    }
  }
]
```

---

### 2. Get User by ID

**GET** `/api/users/{id}`

**Path Parameters:**

| Name | Type | Required | Description |
|------|------|----------|-------------|
| id | Long | Yes | User ID |

**Sample cURL:**
```bash
curl -X GET "http://localhost:8080/UserManagementSpringMVC/api/users/1" -H "Accept: application/json"
```

**Sample Response (200 OK):**
```json
{
  "id": 1,
  "name": "John Doe",
  "username": "johndoe",
  "email": "john.doe@example.com",
  "phone": "555-1234",
  "website": "https://johndoe.com",
  "address": {
    "id": 1,
    "street": "123 Main St",
    "suite": "Apt 4",
    "city": "New York",
    "zipcode": "10001",
    "geo": {
      "id": 1,
      "lat": "-37.3159",
      "lng": "81.1496"
    }
  },
  "company": {
    "id": 1,
    "name": "Acme Inc",
    "catchPhrase": "Multi-layered client-server",
    "bs": "harness real-time e-markets"
  }
}
```

**Sample Response (404 Not Found):**
```json
{
  "message": "User not found with id: 999"
}
```

---

### 3. Get User by Username

**GET** `/api/users/username/{username}`

**Path Parameters:**

| Name | Type | Required | Description |
|------|------|----------|-------------|
| username | String | Yes | Unique username |

**Sample cURL:**
```bash
curl -X GET "http://localhost:8080/UserManagementSpringMVC/api/users/username/johndoe" -H "Accept: application/json"
```

**Sample Response (200 OK):** Same structure as Get User by ID

---

### 4. Get User by Email

**GET** `/api/users/email/{email}`

**Path Parameters:**

| Name | Type | Required | Description |
|------|------|----------|-------------|
| email | String | Yes | Unique email |

**Sample cURL:**
```bash
curl -X GET "http://localhost:8080/UserManagementSpringMVC/api/users/email/john.doe@example.com" -H "Accept: application/json"
```

**Sample Response (200 OK):** Same structure as Get User by ID

---

### 5. Create User

**POST** `/api/users`

**Request Body:**

| Field | Type | Required | Description |
|-------|------|----------|-------------|
| name | String | Yes | Full name |
| username | String | Yes | Unique username |
| email | String | Yes | Unique email |
| phone | String | No | Phone number |
| website | String | No | Website URL |
| address | Object | No | Address object |
| company | Object | No | Company object |

**Sample cURL (minimal):**
```bash
curl -X POST "http://localhost:8080/UserManagementSpringMVC/api/users" ^
  -H "Content-Type: application/json" ^
  -H "Accept: application/json" ^
  -d "{\"name\":\"Jane Smith\",\"username\":\"janesmith\",\"email\":\"jane@example.com\"}"
```

**Sample cURL (full - Linux/Mac):**
```bash
curl -X POST "http://localhost:8080/UserManagementSpringMVC/api/users" \
  -H "Content-Type: application/json" \
  -H "Accept: application/json" \
  -d '{
    "name": "Jane Smith",
    "username": "janesmith",
    "email": "jane@example.com",
    "phone": "555-5678",
    "website": "https://janesmith.com",
    "address": {
      "street": "456 Oak Ave",
      "suite": "Suite 10",
      "city": "Los Angeles",
      "zipcode": "90001",
      "geo": {
        "lat": "34.0522",
        "lng": "-118.2437"
      }
    },
    "company": {
      "name": "Tech Corp",
      "catchPhrase": "Innovation at scale",
      "bs": "synergize scalable supply-chains"
    }
  }'
```

**Sample Request Body (full):**
```json
{
  "name": "Jane Smith",
  "username": "janesmith",
  "email": "jane@example.com",
  "phone": "555-5678",
  "website": "https://janesmith.com",
  "address": {
    "street": "456 Oak Ave",
    "suite": "Suite 10",
    "city": "Los Angeles",
    "zipcode": "90001",
    "geo": {
      "lat": "34.0522",
      "lng": "-118.2437"
    }
  },
  "company": {
    "name": "Tech Corp",
    "catchPhrase": "Innovation at scale",
    "bs": "synergize scalable supply-chains"
  }
}
```

**Sample Response (201 Created):**
```json
{
  "id": 2,
  "name": "Jane Smith",
  "username": "janesmith",
  "email": "jane@example.com",
  "phone": "555-5678",
  "website": "https://janesmith.com",
  "address": {
    "id": 2,
    "street": "456 Oak Ave",
    "suite": "Suite 10",
    "city": "Los Angeles",
    "zipcode": "90001",
    "geo": {
      "id": 2,
      "lat": "34.0522",
      "lng": "-118.2437"
    }
  },
  "company": {
    "id": 2,
    "name": "Tech Corp",
    "catchPhrase": "Innovation at scale",
    "bs": "synergize scalable supply-chains"
  }
}
```

---

### 6. Update User

**PUT** `/api/users/{id}`

**Path Parameters:** `id` (Long) - User ID

**Request Body:** Same structure as Create User. Include all fields to update.

**Sample cURL:**
```bash
curl -X PUT "http://localhost:8080/UserManagementSpringMVC/api/users/2" ^
  -H "Content-Type: application/json" ^
  -H "Accept: application/json" ^
  -d "{\"name\":\"Jane Smith Updated\",\"username\":\"janesmith\",\"email\":\"jane.updated@example.com\",\"phone\":\"555-9999\"}"
```

**Sample Request Body:**
```json
{
  "name": "Jane Smith Updated",
  "username": "janesmith",
  "email": "jane.updated@example.com",
  "phone": "555-9999",
  "website": "https://janesmith.com",
  "address": {
    "street": "456 Oak Ave",
    "suite": "Suite 10",
    "city": "Los Angeles",
    "zipcode": "90001"
  },
  "company": {
    "name": "Tech Corp",
    "catchPhrase": "Innovation at scale",
    "bs": "synergize scalable supply-chains"
  }
}
```

**Sample Response (200 OK):** Returns updated user object (same structure as Get by ID)

---

### 7. Delete User

**DELETE** `/api/users/{id}`

**Path Parameters:** `id` (Long) - User ID

**Sample cURL:**
```bash
curl -X DELETE "http://localhost:8080/UserManagementSpringMVC/api/users/2" -H "Accept: application/json"
```

**Sample Response (204 No Content):** Empty body

**Sample Response (404 Not Found):**
```json
{
  "message": "User not found with id: 999"
}
```

---

## Employees API

Base path: `/api/employees`

---

### 1. Get All Employees

**GET** `/api/employees`

**Sample cURL:**
```bash
curl -X GET "http://localhost:8080/UserManagementSpringMVC/api/employees" -H "Accept: application/json"
```

**Sample Response (200 OK):**
```json
[
  {
    "id": 1,
    "name": "Alice Johnson",
    "employeeCode": "EMP001",
    "email": "alice.johnson@company.com",
    "phone": "555-1111",
    "designation": "Software Engineer",
    "department": "Engineering",
    "joinDate": "2023-01-15",
    "salary": 75000.00,
    "address": {
      "id": 1,
      "street": "100 Tech Park",
      "suite": "Building B",
      "city": "San Francisco",
      "zipcode": "94102",
      "geo": {
        "id": 1,
        "lat": "37.7749",
        "lng": "-122.4194"
      }
    }
  }
]
```

---

### 2. Get Employee by ID

**GET** `/api/employees/{id}`

**Path Parameters:** `id` (Long) - Employee ID

**Sample cURL:**
```bash
curl -X GET "http://localhost:8080/UserManagementSpringMVC/api/employees/1" -H "Accept: application/json"
```

**Sample Response (200 OK):**
```json
{
  "id": 1,
  "name": "Alice Johnson",
  "employeeCode": "EMP001",
  "email": "alice.johnson@company.com",
  "phone": "555-1111",
  "designation": "Software Engineer",
  "department": "Engineering",
  "joinDate": "2023-01-15",
  "salary": 75000.00,
  "address": {
    "id": 1,
    "street": "100 Tech Park",
    "suite": "Building B",
    "city": "San Francisco",
    "zipcode": "94102",
    "geo": {
      "id": 1,
      "lat": "37.7749",
      "lng": "-122.4194"
    }
  }
}
```

---

### 3. Get Employee by Code

**GET** `/api/employees/code/{employeeCode}`

**Path Parameters:** `employeeCode` (String) - Unique employee code

**Sample cURL:**
```bash
curl -X GET "http://localhost:8080/UserManagementSpringMVC/api/employees/code/EMP001" -H "Accept: application/json"
```

**Sample Response (200 OK):** Same structure as Get Employee by ID

---

### 4. Get Employee by Email

**GET** `/api/employees/email/{email}`

**Path Parameters:** `email` (String) - Unique email

**Sample cURL:**
```bash
curl -X GET "http://localhost:8080/UserManagementSpringMVC/api/employees/email/alice.johnson@company.com" -H "Accept: application/json"
```

---

### 5. Create Employee

**POST** `/api/employees`

**Request Body:**

| Field | Type | Required | Description |
|-------|------|----------|-------------|
| name | String | Yes | Full name |
| employeeCode | String | Yes | Unique employee code |
| email | String | Yes | Unique email |
| phone | String | No | Phone number |
| designation | String | No | Job title |
| department | String | No | Department name |
| joinDate | String | No | Date in `yyyy-MM-dd` format |
| salary | Double | No | Salary amount |
| address | Object | No | Address object |

**Sample Request Body:**
```json
{
  "name": "Bob Williams",
  "employeeCode": "EMP002",
  "email": "bob.williams@company.com",
  "phone": "555-2222",
  "designation": "Senior Developer",
  "department": "Engineering",
  "joinDate": "2024-03-01",
  "salary": 95000.00,
  "address": {
    "street": "200 Innovation Dr",
    "suite": "Floor 3",
    "city": "San Francisco",
    "zipcode": "94103",
    "geo": {
      "lat": "37.7849",
      "lng": "-122.4094"
    }
  }
}
```

**Sample cURL:**
```bash
curl -X POST "http://localhost:8080/UserManagementSpringMVC/api/employees" ^
  -H "Content-Type: application/json" ^
  -H "Accept: application/json" ^
  -d "{\"name\":\"Bob Williams\",\"employeeCode\":\"EMP002\",\"email\":\"bob.williams@company.com\",\"designation\":\"Senior Developer\",\"department\":\"Engineering\",\"joinDate\":\"2024-03-01\",\"salary\":95000.00}"
```

**Sample Response (201 Created):** Returns created employee with generated `id` and nested IDs

---

### 6. Update Employee

**PUT** `/api/employees/{id}`

**Path Parameters:** `id` (Long) - Employee ID

**Sample Request Body:**
```json
{
  "name": "Bob Williams Jr",
  "employeeCode": "EMP002",
  "email": "bob.williams@company.com",
  "phone": "555-3333",
  "designation": "Tech Lead",
  "department": "Engineering",
  "joinDate": "2024-03-01",
  "salary": 110000.00,
  "address": {
    "street": "200 Innovation Dr",
    "suite": "Floor 3",
    "city": "San Francisco",
    "zipcode": "94103"
  }
}
```

**Sample cURL:**
```bash
curl -X PUT "http://localhost:8080/UserManagementSpringMVC/api/employees/2" ^
  -H "Content-Type: application/json" ^
  -H "Accept: application/json" ^
  -d "{\"name\":\"Bob Williams Jr\",\"employeeCode\":\"EMP002\",\"email\":\"bob.williams@company.com\",\"designation\":\"Tech Lead\",\"salary\":110000.00}"
```

**Sample Response (200 OK):** Returns updated employee object

---

### 7. Delete Employee

**DELETE** `/api/employees/{id}`

**Path Parameters:** `id` (Long) - Employee ID

**Sample cURL:**
```bash
curl -X DELETE "http://localhost:8080/UserManagementSpringMVC/api/employees/2" -H "Accept: application/json"
```

**Sample Response (204 No Content):** Empty body

---

## Error Responses

| HTTP Status | Description | Response Body |
|-------------|-------------|---------------|
| 200 OK | Success | Resource object(s) |
| 201 Created | Resource created | Created resource object |
| 204 No Content | Success, no body (e.g. DELETE) | Empty |
| 400 Bad Request | Invalid request (e.g. ID in create) | `{"message": "..."}` |
| 404 Not Found | Resource not found | `{"message": "..."}` |
| 500 Internal Server Error | Server error | Varies |

**Error response format:**
```json
{
  "message": "User not found with id: 999"
}
```

---

## Data Models

### User
```json
{
  "id": "Long (auto)",
  "name": "String",
  "username": "String",
  "email": "String",
  "phone": "String",
  "website": "String",
  "address": "Address",
  "company": "Company"
}
```

### Employee
```json
{
  "id": "Long (auto)",
  "name": "String",
  "employeeCode": "String",
  "email": "String",
  "phone": "String",
  "designation": "String",
  "department": "String",
  "joinDate": "yyyy-MM-dd",
  "salary": "Double",
  "address": "Address"
}
```

### Address
```json
{
  "id": "Long (auto)",
  "street": "String",
  "suite": "String",
  "city": "String",
  "zipcode": "String",
  "geo": "Geo"
}
```

### Geo
```json
{
  "id": "Long (auto)",
  "lat": "String",
  "lng": "String"
}
```

### Company
```json
{
  "id": "Long (auto)",
  "name": "String",
  "catchPhrase": "String",
  "bs": "String"
}
```

---

## Quick Test Checklist

| # | API | Method | Endpoint | Expected |
|---|-----|--------|----------|----------|
| 1 | Users | GET | /api/users | 200, array |
| 2 | Users | GET | /api/users/1 | 200 or 404 |
| 3 | Users | POST | /api/users | 201, user object |
| 4 | Users | PUT | /api/users/1 | 200, user object |
| 5 | Users | DELETE | /api/users/1 | 204 |
| 6 | Employees | GET | /api/employees | 200, array |
| 7 | Employees | GET | /api/employees/1 | 200 or 404 |
| 8 | Employees | POST | /api/employees | 201, employee object |
| 9 | Employees | PUT | /api/employees/1 | 200, employee object |
| 10 | Employees | DELETE | /api/employees/1 | 204 |
