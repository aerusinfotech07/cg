# Introduction to SQL – Notes

## 1. What is SQL?

- **SQL** is a standard language for **accessing and manipulating databases**.
- **Full form:** **S**tructured **Q**uery **L**anguage.
- **What it does:**
  - Lets you **access** databases.
  - Lets you **manipulate** databases (query, insert, update, delete, create objects).
- **Standards:**
  - **ANSI** (American National Standards Institute) – 1986.
  - **ISO** (International Organization for Standardization) – 1987.

---

## 2. What Can SQL Do?

| Category | Capability |
|----------|------------|
| **Query & retrieve** | Execute queries against a database; retrieve data from a database. |
| **Data modification** | Insert records, update records, delete records. |
| **Schema & structure** | Create new databases; create new tables in a database. |
| **Programmability** | Create stored procedures in a database. |
| **Views** | Create views in a database. |
| **Security** | Set permissions on tables, procedures, and views. |

---

## 3. SQL is a Standard – But…

- SQL is an **ANSI/ISO standard**, but there are **different versions** of the SQL language (e.g. MySQL, PostgreSQL, SQL Server, Oracle).
- To be **compliant** with the ANSI standard, vendors support at least the **major commands** in a similar way, for example:
  - `SELECT`
  - `UPDATE`
  - `DELETE`
  - `INSERT`
  - `WHERE`
- **Note:** Most SQL database products also add **proprietary extensions** on top of the standard.

---

## 4. Using SQL in Your Web Site

To build a website that **shows data from a database**, you typically need:

1. **An RDBMS database**  
   e.g. MS Access, SQL Server, MySQL.
2. **A server-side scripting language**  
   e.g. PHP, ASP, Node.js, Python.
3. **SQL**  
   To get (or change) the data you need.
4. **HTML / CSS**  
   To structure and style the page.

Flow: **Browser → Server (script) → SQL → RDBMS → Data → Back to page.**

---

## 5. RDBMS (Relational Database Management System)

- **RDBMS** = **R**elational **D**atabase **M**anagement **S**ystem.
- RDBMS is the **basis for SQL** and for modern database systems such as:
  - MS SQL Server  
  - IBM DB2  
  - Oracle  
  - MySQL  
  - Microsoft Access  

### Tables

- Data in an RDBMS is stored in **tables**.
- A **table** is a collection of **related data** and has:
  - **Columns** (vertical) – e.g. CustomerID, CustomerName, ContactName, Address, City, PostalCode, Country.
  - **Rows** (horizontal) – each row is one **record** (one entity, e.g. one customer).

### Example

```sql
SELECT * FROM Customers;
```

- **Columns** in the Customers table: CustomerID, CustomerName, ContactName, Address, City, PostalCode, Country.
- **Record / Row:** one horizontal entry (e.g. one customer).  
  If the table has 91 rows, there are 91 records.

---

## Quick Reference

| Term | Meaning |
|------|--------|
| **SQL** | Structured Query Language; standard for accessing and manipulating databases. |
| **ANSI/ISO** | SQL is standardized by ANSI (1986) and ISO (1987). |
| **RDBMS** | Relational Database Management System; stores data in tables (columns and rows). |
| **Table** | Collection of related data in columns and rows. |
| **Column** | Vertical entity in a table (one attribute). |
| **Row / Record** | Horizontal entity in a table (one complete entry). |
