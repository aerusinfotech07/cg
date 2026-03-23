# SQL Views – Notes

## 1. What Is a View?

A **view** is a **virtual table** defined by the result of an SQL query.

- It has **rows and columns** like a real table, but the data comes from one or more **base tables** (or other views) in the database.
- You can build a view from **SELECT** (with JOINs, WHERE, functions, etc.) and then query the view as if it were a single table.

Views are created with **CREATE VIEW**. The database does not store the view’s rows separately; when you query the view, the database runs the underlying SELECT and returns the result. So a view typically shows **up-to-date data** from the base tables each time it is queried.

---

## 2. CREATE VIEW Syntax

```sql
CREATE VIEW view_name AS
SELECT column1, column2, ...
FROM table_name
WHERE condition;
```

- **view_name** — name of the view. Use the same naming rules as for tables; if the name has spaces or special characters, quote it (e.g. `[Brazil Customers]` in SQL Server, or the database’s identifier quotes).
- The **SELECT** can use any allowed SQL (JOINs, subqueries, aggregates, etc.).

---

## 3. CREATE VIEW Examples

**View: customers from Brazil**

```sql
CREATE VIEW [Brazil Customers] AS
SELECT CustomerName, ContactName
FROM Customers
WHERE Country = 'Brazil';
```

**Query the view:**

```sql
SELECT * FROM [Brazil Customers];
```

**View: products above average price**

```sql
CREATE VIEW [Products Above Average Price] AS
SELECT ProductName, Price
FROM Products
WHERE Price > (SELECT AVG(Price) FROM Products);
```

**Query the view:**

```sql
SELECT * FROM [Products Above Average Price];
```

---

## 4. Updating a View (CREATE OR REPLACE VIEW)

To **change** the definition of a view, use **CREATE OR REPLACE VIEW** (supported in MySQL, Oracle, PostgreSQL; SQL Server uses **ALTER VIEW**).

**Add the City column to the Brazil Customers view:**

```sql
CREATE OR REPLACE VIEW [Brazil Customers] AS
SELECT CustomerName, ContactName, City
FROM Customers
WHERE Country = 'Brazil';
```

**SQL Server** — use ALTER VIEW with the full new definition:

```sql
ALTER VIEW [Brazil Customers] AS
SELECT CustomerName, ContactName, City
FROM Customers
WHERE Country = 'Brazil';
```

---

## 5. Dropping a View

To **remove** a view, use **DROP VIEW**:

```sql
DROP VIEW view_name;
```

**Example:**

```sql
DROP VIEW [Brazil Customers];
```

After this, the view no longer exists; base tables are unchanged.

---

## Quick Reference

| Goal | Example |
|------|---------|
| Create view | `CREATE VIEW name AS SELECT ... FROM ... WHERE ...;` |
| Query view | `SELECT * FROM view_name;` |
| Change view (MySQL, Oracle, etc.) | `CREATE OR REPLACE VIEW name AS SELECT ...;` |
| Change view (SQL Server) | `ALTER VIEW name AS SELECT ...;` |
| Delete view | `DROP VIEW view_name;` |

**Remember:** A view is a saved query that you query like a table; data comes from base tables and is typically current each time you use the view.
