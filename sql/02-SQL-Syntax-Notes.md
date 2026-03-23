# SQL Syntax – Notes

## 1. SQL Statements

- Most actions on a database are done with **SQL statements**.
- SQL statements use **keywords** that are easy to understand.
- **Example:** Select all records from the table named `"Customers"`:

```sql
SELECT * FROM Customers;
```

---

## 2. Database Tables

- A database usually has **one or more tables**.
- Each table has a **name** (e.g. `"Customers"`, `"Orders"`) and holds **records (rows)** of data.
- **Sample database:** Northwind (included in MS Access and MS SQL Server).

### Example: Customers Table (selection)

| CustomerID | CustomerName | ContactName | Address | City | PostalCode | Country |
|------------|--------------|-------------|---------|------|------------|---------|
| 1 | Alfreds Futterkiste | Maria Anders | Obere Str. 57 | Berlin | 12209 | Germany |
| 2 | Ana Trujillo Emparedados y helados | Ana Trujillo | Avda. de la Constitución 2222 | México D.F. | 05021 | Mexico |
| 3 | Antonio Moreno Taquería | Antonio Moreno | Mataderos 2312 | México D.F. | 05023 | Mexico |
| 4 | Around the Horn | Thomas Hardy | 120 Hanover Sq. | London | WA1 1DP | UK |
| 5 | Berglunds snabbköp | Christina Berglund | Berguvsvägen 8 | Luleå | S-958 22 | Sweden |

- **Rows:** 5 records (one per customer).
- **Columns:** 7 – CustomerID, CustomerName, ContactName, Address, City, PostalCode, Country.

---

## 3. Important Syntax Rules

### SQL keywords are NOT case sensitive

- `select` is the same as `SELECT`.
- In these notes, SQL **keywords are written in UPPER-CASE** for clarity.

### Semicolon after SQL statements

- **Some** database systems require a **semicolon** at the end of each SQL statement.
- Semicolon is the **standard** way to **separate** SQL statements when more than one is run in the same call to the server.
- In this tutorial, a **semicolon is used at the end of each SQL statement**.

---

## 4. Some of the Most Important SQL Commands

| Command | Purpose |
|--------|---------|
| **SELECT** | Extracts data from a database |
| **UPDATE** | Updates data in a database |
| **DELETE** | Deletes data from a database |
| **INSERT INTO** | Inserts new data into a database |
| **CREATE DATABASE** | Creates a new database |
| **ALTER DATABASE** | Modifies a database |
| **CREATE TABLE** | Creates a new table |
| **ALTER TABLE** | Modifies a table |
| **DROP TABLE** | Deletes a table |
| **CREATE INDEX** | Creates an index (search key) |
| **DROP INDEX** | Deletes an index |

### Summary by category

| Category | Commands |
|----------|----------|
| **Query data** | SELECT |
| **Modify data** | INSERT INTO, UPDATE, DELETE |
| **Database** | CREATE DATABASE, ALTER DATABASE |
| **Table** | CREATE TABLE, ALTER TABLE, DROP TABLE |
| **Index** | CREATE INDEX, DROP INDEX |
