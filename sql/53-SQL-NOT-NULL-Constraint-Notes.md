# SQL NOT NULL Constraint – Notes

## 1. What Is the NOT NULL Constraint?

By default, a column can hold **NULL** values (unless the database or table definition says otherwise).

The **NOT NULL** constraint forces a column **not to accept NULL**. Every row must have a **value** for that column.

- You **cannot insert** a new row without providing a value for a NOT NULL column (unless a DEFAULT is defined).
- You **cannot update** a row by setting a NOT NULL column to NULL.

---

## 2. NOT NULL on CREATE TABLE

Add **NOT NULL** after the column’s data type when creating the table.

**Example — Persons table with ID, LastName, and FirstName required; Age optional:**

```sql
CREATE TABLE Persons (
    ID int NOT NULL,
    LastName varchar(255) NOT NULL,
    FirstName varchar(255) NOT NULL,
    Age int
);
```

- **ID**, **LastName**, and **FirstName** cannot be NULL.
- **Age** has no NOT NULL constraint, so it can be NULL.

---

## 3. NOT NULL on ALTER TABLE

To add or enforce NOT NULL on an **existing** column, use ALTER TABLE. Syntax depends on the database.

**SQL Server / MS Access:**

```sql
ALTER TABLE Persons
ALTER COLUMN Age int NOT NULL;
```

**MySQL / Oracle (prior to 10g):**

```sql
ALTER TABLE Persons
MODIFY COLUMN Age int NOT NULL;
```

**Oracle 10g and later:**

```sql
ALTER TABLE Persons
MODIFY Age int NOT NULL;
```

**Note:** If the column already contains NULLs, the database may reject the ALTER until you update those rows to non-NULL values.

---

## Quick Reference

| Goal | Example |
|------|---------|
| Column cannot be NULL (CREATE TABLE) | `column_name datatype NOT NULL` |
| Add NOT NULL to existing column (SQL Server) | `ALTER TABLE t ALTER COLUMN col datatype NOT NULL;` |
| Add NOT NULL (MySQL / Oracle) | `ALTER TABLE t MODIFY COLUMN col datatype NOT NULL;` |

**Remember:** NOT NULL ensures the column always has a value; insert and update operations must supply a non-NULL value (or rely on DEFAULT if defined).
