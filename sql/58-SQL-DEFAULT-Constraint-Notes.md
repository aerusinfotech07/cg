# SQL DEFAULT Constraint – Notes

## 1. What Is the DEFAULT Constraint?

The **DEFAULT** constraint gives a column a **default value**.

- When you **insert** a new row and **do not** specify a value for that column, the database uses the default.
- Defaults apply only to **new** rows; existing rows are not changed. You can still provide an explicit value (including NULL if the column allows it) on insert.

---

## 2. DEFAULT on CREATE TABLE

**MySQL / SQL Server / Oracle / MS Access** — add DEFAULT after the column type:

```sql
CREATE TABLE Persons (
    ID int NOT NULL,
    LastName varchar(255) NOT NULL,
    FirstName varchar(255),
    Age int,
    City varchar(255) DEFAULT 'Sandnes'
);
```

**System or function default** (e.g. current date) — syntax is database-dependent. Example in **SQL Server**:

```sql
CREATE TABLE Orders (
    ID int NOT NULL,
    OrderNumber int NOT NULL,
    OrderDate date DEFAULT GETDATE()
);
```

- **GETDATE()** (SQL Server) supplies the current date/time when a row is inserted without an OrderDate. In **MySQL** you might use **CURRENT_DATE** or **CURRENT_TIMESTAMP**; in **Oracle**, **SYSDATE** or **CURRENT_TIMESTAMP**.

---

## 3. DEFAULT on ALTER TABLE

To add or change a default for an **existing** column, use ALTER TABLE. Syntax varies by database.

**MySQL:**

```sql
ALTER TABLE Persons
ALTER City SET DEFAULT 'Sandnes';
```

**SQL Server:**

```sql
ALTER TABLE Persons
ADD CONSTRAINT df_City
DEFAULT 'Sandnes' FOR City;
```

**MS Access:**

```sql
ALTER TABLE Persons
ALTER COLUMN City SET DEFAULT 'Sandnes';
```

**Oracle:**

```sql
ALTER TABLE Persons
MODIFY City DEFAULT 'Sandnes';
```

---

## 4. Drop a DEFAULT Constraint

**MySQL:**

```sql
ALTER TABLE Persons
ALTER City DROP DEFAULT;
```

**SQL Server / Oracle / MS Access:**

```sql
ALTER TABLE Persons
ALTER COLUMN City DROP DEFAULT;
```

**Note:** In SQL Server, if the default was added with **ADD CONSTRAINT name DEFAULT ... FOR City**, you drop it with **DROP CONSTRAINT name** (e.g. `ALTER TABLE Persons DROP CONSTRAINT df_City;`).

---

## Quick Reference

| Goal | Example |
|------|---------|
| DEFAULT on CREATE | `City varchar(255) DEFAULT 'Sandnes'` |
| System value (e.g. current date) | `OrderDate date DEFAULT GETDATE()` (SQL Server); use equivalent in others |
| Add DEFAULT (MySQL) | `ALTER TABLE t ALTER col SET DEFAULT 'value';` |
| Add DEFAULT (SQL Server) | `ALTER TABLE t ADD CONSTRAINT name DEFAULT 'value' FOR col;` |
| Add DEFAULT (Oracle) | `ALTER TABLE t MODIFY col DEFAULT 'value';` |
| Drop DEFAULT (MySQL) | `ALTER TABLE t ALTER col DROP DEFAULT;` |
| Drop DEFAULT (others) | `ALTER TABLE t ALTER COLUMN col DROP DEFAULT;` or DROP CONSTRAINT |

**Remember:** DEFAULT is used when no value is given on insert; exact syntax for adding or dropping defaults differs by database.
