# SQL CREATE TABLE Statement – Notes

## 1. What Does CREATE TABLE Do?

The **CREATE TABLE** statement creates a **new table** in the current database.

- You define **column names** and **data types** for each column.
- The table is empty until you insert data (e.g. with **INSERT INTO**).

---

## 2. Syntax

```sql
CREATE TABLE table_name (
    column1 datatype,
    column2 datatype,
    column3 datatype,
    ...
);
```

- **column1, column2, ...** — names of the columns.
- **datatype** — the type of data the column can hold (e.g. **int**, **varchar(n)**, **date**, **decimal**). See your database’s **data types reference** for the full list.

---

## 3. CREATE TABLE Example

Create a table **Persons** with five columns: PersonID, LastName, FirstName, Address, City:

```sql
CREATE TABLE Persons (
    PersonID int,
    LastName varchar(255),
    FirstName varchar(255),
    Address varchar(255),
    City varchar(255)
);
```

- **PersonID** — integer.
- **LastName, FirstName, Address, City** — variable-length character data, max 255 characters each.

The new **Persons** table is empty and has this structure:

| PersonID | LastName | FirstName | Address | City |
|----------|----------|-----------|---------|------|
|          |          |           |         |      |

**Tip:** Add rows with the **INSERT INTO** statement.

---

## 4. Create a Table from Another Table (Copy)

You can create a new table **from the result of a SELECT** so that the new table has the same column definitions (and, if you do not filter, the same data). Syntax and support vary by database.

**Syntax (e.g. MySQL, PostgreSQL):**

```sql
CREATE TABLE new_table_name AS
    SELECT column1, column2, ...
    FROM existing_table_name
    WHERE ...;
```

- The new table’s columns come from the SELECT list (names and types). You can copy all columns (`SELECT *`) or a subset, and use **WHERE** to copy only certain rows.

**Example — new table as a copy of part of Customers:**

```sql
CREATE TABLE TestTable AS
SELECT CustomerName, ContactName
FROM Customers;
```

- **TestTable** has two columns (CustomerName, ContactName) and is filled with the rows returned by the SELECT. Omit the **WHERE** to copy all rows; add **WHERE** to copy only some.

**Note:** In **SQL Server**, the similar approach is **SELECT ... INTO new_table FROM ...** (see notes on SELECT INTO). In **Oracle**, you can use **CREATE TABLE ... AS SELECT ...**.

---

## Quick Reference

| Goal | Example |
|------|---------|
| Create empty table | `CREATE TABLE t (id int, name varchar(255));` |
| Create from query (MySQL, etc.) | `CREATE TABLE new_t AS SELECT col1, col2 FROM old_t WHERE ...;` |
| Add data later | `INSERT INTO table_name ...` |

**Remember:** Define each column with a name and data type. Use CREATE TABLE ... AS SELECT to create a table from an existing table or query when your database supports it.
