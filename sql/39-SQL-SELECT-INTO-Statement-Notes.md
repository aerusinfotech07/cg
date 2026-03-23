# SQL SELECT INTO Statement – Notes

## 1. What Is SELECT INTO?

The **SELECT INTO** statement **copies data** from one (or more) tables **into a new table**.

- The new table is **created** by the statement and gets its structure from the result of the SELECT (column names and types from the source, or from expressions/aliases).
- You can copy all columns, selected columns, or the result of a JOIN, and optionally filter with **WHERE**.

**Note:** **SELECT INTO** (creating a new table in one step) is supported in **SQL Server**, **MS Access**, and some others. **MySQL** does not support this syntax; use **CREATE TABLE newtable AS SELECT ...** or **INSERT INTO newtable SELECT ...** instead.

---

## 2. Syntax

**Copy all columns into a new table:**

```sql
SELECT *
INTO newtable [IN externaldb]
FROM oldtable
WHERE condition;
```

**Copy only some columns into a new table:**

```sql
SELECT column1, column2, column3, ...
INTO newtable [IN externaldb]
FROM oldtable
WHERE condition;
```

- **IN externaldb** (optional) — in some databases, copy the new table into another database or file (e.g. MS Access: `IN 'Backup.mdb'`).
- The new table gets column names and types from the SELECT list. Use **AS** in the SELECT to define new column names.

---

## 3. SELECT INTO Examples

**Backup copy of Customers:**

```sql
SELECT * INTO CustomersBackup2017
FROM Customers;
```

**Copy into a table in another database (e.g. MS Access):**

```sql
SELECT * INTO CustomersBackup2017 IN 'Backup.mdb'
FROM Customers;
```

**Copy only selected columns:**

```sql
SELECT CustomerName, ContactName INTO CustomersBackup2017
FROM Customers;
```

**Copy only rows that match a condition (e.g. German customers):**

```sql
SELECT * INTO CustomersGermany
FROM Customers
WHERE Country = 'Germany';
```

**Copy from a join into a new table:**

```sql
SELECT Customers.CustomerName, Orders.OrderID
INTO CustomersOrderBackup2017
FROM Customers
LEFT JOIN Orders ON Customers.CustomerID = Orders.CustomerID;
```

---

## 4. Empty Table with Same Schema

To create a **new, empty table** with the same columns and types as an existing table (no data), use a **WHERE** condition that is always false so no rows are copied:

```sql
SELECT * INTO newtable
FROM oldtable
WHERE 1 = 0;
```

---

## 5. MySQL Alternative

In **MySQL**, use one of:

**Create new table and copy data (one statement):**

```sql
CREATE TABLE newtable AS
SELECT * FROM oldtable WHERE condition;
```

**Create table first, then insert:**

```sql
CREATE TABLE newtable LIKE oldtable;
INSERT INTO newtable SELECT * FROM oldtable WHERE condition;
```

---

## Quick Reference

| Goal | Example (SQL Server / MS Access) |
|------|----------------------------------|
| Copy full table | `SELECT * INTO newtable FROM oldtable;` |
| Copy with filter | `SELECT * INTO newtable FROM oldtable WHERE condition;` |
| Copy selected columns | `SELECT col1, col2 INTO newtable FROM oldtable;` |
| Copy from join | `SELECT a.col, b.col INTO newtable FROM t1 a JOIN t2 b ON ...;` |
| Empty table, same schema | `SELECT * INTO newtable FROM oldtable WHERE 1 = 0;` |

**Remember:** SELECT INTO creates a new table and fills it in one step. Syntax and support differ by database; MySQL uses CREATE TABLE ... AS SELECT or INSERT INTO ... SELECT.
