 **StockSphere – Web Based Inventory Management System** using **React (UI) + Node.js (Backend) + MySQL/MongoDB**.
---

# StockSphere

## Web Based Inventory Management System

### Software Requirement & Design Document

---

# 1. Project Overview

**StockSphere** is a **Web-Based Inventory Management System (IMS)** designed to help organizations manage their products, suppliers, inventory levels, and stock transactions efficiently.

The system helps businesses:

* Track product inventory
* Manage suppliers and categories
* Record stock-in and stock-out transactions
* Monitor stock levels
* Generate reports and analytics

The application supports two primary user roles:

1. **Inventory Staff**
2. **Administrators**

The system is developed using a **modern full-stack architecture**.

Frontend: **React.js**
Backend: **Node.js (Express.js)**
Database: **MySQL / MongoDB**

The architecture is modular and scalable, allowing future extension into:

* Microservices architecture
* Mobile applications
* Cloud deployment
* Real-time analytics

---

# 2. Technology Stack

## Frontend

| Technology              | Purpose           |
| ----------------------- | ----------------- |
| React.js                | UI Development    |
| React Router            | Page navigation   |
| Axios                   | API communication |
| Material UI / Bootstrap | UI components     |
| Redux / Context API     | State management  |

---

## Backend

| Technology | Purpose                  |
| ---------- | ------------------------ |
| Node.js    | Server runtime           |
| Express.js | REST API framework       |
| JWT        | Authentication           |
| bcrypt     | Password encryption      |
| Nodemailer | Email notifications      |
| multer     | File upload (future use) |

---

## Database

Option 1: **MySQL (Relational Database)**
Option 2: **MongoDB (NoSQL Database)**

---

# 3. System Architecture

```id="stock_architecture"
               +------------------------+
               |       React UI         |
               |    (Frontend Layer)    |
               +------------------------+
                         |
                         | REST APIs
                         ↓
               +------------------------+
               |    Node.js Backend     |
               |     Express Server     |
               +------------------------+
                         |
                         ↓
               +------------------------+
               |        Database        |
               |    MySQL / MongoDB     |
               +------------------------+
```

---

# 4. User Roles

The system contains two major roles.

## Inventory Staff

Inventory staff members manage inventory operations.

They can:

* Add products
* Update products
* View stock levels
* Record stock transactions
* Monitor stock alerts
* View transaction history

---

## Administrator

Administrators manage system configuration.

They can:

* Manage categories
* Manage suppliers
* Manage users
* Configure reorder thresholds
* View system reports
* Monitor audit logs

---

# 5. Core Modules

The system consists of the following modules:

1. Authentication Module
2. Product Management Module
3. Category Management Module
4. Supplier Management Module
5. Inventory Transaction Module
6. Reporting & Analytics Module
7. Notification Module

---

# 6. UI Design (React)

## Main Layout

```id="stock_layout"
Navbar
Sidebar
Dashboard
Content Area
Footer
```

---

# 7. Inventory Staff Interface

## Dashboard Page

Displays:

* Total products
* Current stock value
* Low stock alerts
* Recent transactions

Components:

```id="dashboard_components"
Dashboard
StockSummary
LowStockAlerts
RecentTransactions
```

---

## Product Management Page

Inventory staff can:

* Add new product
* Update product
* Delete product
* Search products

Components:

```id="product_components"
ProductList
AddProductForm
EditProductForm
ProductSearch
```

---

## Stock Transaction Page

Inventory staff can:

* Record stock-in
* Record stock-out
* View transaction history

Components:

```id="transaction_components"
StockInForm
StockOutForm
TransactionHistory
```

---

## Product Details Page

Displays:

* Product information
* Stock level
* Supplier details
* Transaction history

Components:

```id="product_detail"
ProductDetails
TransactionLog
```

---

# 8. Admin Dashboard UI

Administrators have access to system configuration.

Admin Features:

* Category management
* Supplier management
* User management
* Inventory reports
* Audit logs

Components:

```id="admin_components"
AdminDashboard
CategoryManagement
SupplierManagement
UserManagement
ReportsPanel
```

---

# 9. Backend API Design (Node.js)

Base API URL

```id="api_base"
/api
```

---

# Authentication APIs

| Method | API                   | Description       |
| ------ | --------------------- | ----------------- |
| POST   | /auth/register        | Register user     |
| POST   | /auth/login           | Login             |
| POST   | /auth/change-password | Change password   |
| POST   | /auth/forgot-password | Password recovery |

---

# Product APIs

| Method | API           | Description         |
| ------ | ------------- | ------------------- |
| GET    | /products     | Get product list    |
| GET    | /products/:id | Get product details |
| POST   | /products     | Add product         |
| PUT    | /products/:id | Update product      |
| DELETE | /products/:id | Delete product      |

---

# Category APIs

| Method | API             | Description     |
| ------ | --------------- | --------------- |
| GET    | /categories     | List categories |
| POST   | /categories     | Add category    |
| PUT    | /categories/:id | Update category |
| DELETE | /categories/:id | Delete category |

---

# Supplier APIs

| Method | API            | Description     |
| ------ | -------------- | --------------- |
| GET    | /suppliers     | List suppliers  |
| POST   | /suppliers     | Add supplier    |
| PUT    | /suppliers/:id | Update supplier |
| DELETE | /suppliers/:id | Delete supplier |

---

# Transaction APIs

| Method | API                     | Description         |
| ------ | ----------------------- | ------------------- |
| POST   | /transactions/stock-in  | Record stock-in     |
| POST   | /transactions/stock-out | Record stock-out    |
| GET    | /transactions           | Transaction history |

---

# Reports APIs

| Method | API                | Description            |
| ------ | ------------------ | ---------------------- |
| GET    | /reports/low-stock | Low stock report       |
| GET    | /reports/valuation | Stock valuation report |
| GET    | /reports/movement  | Stock movement report  |

---

# 10. Database Design (MySQL)

## Users Table

```id="users_table"
users
------
user_id PK
name
email
password
role
status
created_at
```

---

## Products Table

```id="products_table"
products
--------
product_id PK
name
sku
category_id FK
supplier_id FK
price
quantity
reorder_level
created_at
```

---

## Categories Table

```id="categories_table"
categories
----------
category_id PK
category_name
description
```

---

## Suppliers Table

```id="suppliers_table"
suppliers
---------
supplier_id PK
supplier_name
contact_person
phone
email
address
```

---

## Transactions Table

```id="transactions_table"
transactions
------------
transaction_id PK
product_id FK
transaction_type
quantity
transaction_date
performed_by
```

Transaction Types:

```
IN
OUT
```

---

## Notifications Table

```id="notifications_table"
notifications
-------------
notification_id PK
user_id FK
message
status
created_date
```

---

# 11. Folder Structure

## React Frontend

```id="frontend_structure"
stocksphere-frontend

src
 ├── components
 │    ├── products
 │    ├── suppliers
 │    ├── transactions
 │    └── notifications
 │
 ├── pages
 │    ├── Dashboard
 │    ├── Products
 │    ├── Suppliers
 │    ├── Transactions
 │    └── Reports
 │
 ├── services
 │    └── api.js
 │
 ├── context
 │    └── AuthContext.js
 │
 └── App.js
```

---

## Node.js Backend

```id="backend_structure"
stocksphere-backend

src
 ├── controllers
 │    ├── authController.js
 │    ├── productController.js
 │    ├── supplierController.js
 │    └── transactionController.js
 │
 ├── routes
 │    ├── authRoutes.js
 │    ├── productRoutes.js
 │    ├── supplierRoutes.js
 │
 ├── models
 │    ├── User.js
 │    ├── Product.js
 │    ├── Supplier.js
 │
 ├── middleware
 │    └── authMiddleware.js
 │
 ├── services
 │    └── reportService.js
 │
 ├── config
 │    └── db.js
 │
 └── server.js
```

---

# 12. Notification System

Notifications include:

* Low stock alerts
* Stock replenishment reminders
* System updates
* Account status updates

Notification Structure:

```id="notification_structure"
notification_id
user_id
message
status
created_date
```

---

# 13. Reporting & Analytics

Reports include:

* Low Stock Report
* Stock Valuation Report
* Supplier Purchase Report
* Transaction History
* Fast Moving Items
* Slow Moving Items

---

# 14. Business Rules

The system follows the following rules:

1. SKU must be unique for each product.
2. Product quantity cannot be negative.
3. Stock-out cannot exceed available quantity.
4. Only administrators can delete suppliers and categories.
5. Reorder alerts trigger when quantity ≤ reorder level.
6. All transactions are logged for audit tracking.

---

# 15. Future Enhancements

The system can be extended with:

* Barcode scanning integration
* Mobile inventory app
* Cloud database integration
* AI-based demand forecasting
* Supplier ordering automation
* Microservices architecture
* Real-time notifications

---

# 16. Definition of Done

The project is considered complete when:

✔ React UI implemented
✔ Node.js REST APIs working
✔ Database integrated
✔ Product management implemented
✔ Stock-in and stock-out workflows functional
✔ Low stock alert system implemented
✔ Inventory reports generated
✔ Code repository submitted including:

* Complete source code
* ERD Diagram
* Application Architecture Diagram
* Clean folder structure
* README documentation

---

