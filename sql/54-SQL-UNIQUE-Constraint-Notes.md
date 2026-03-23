# SQL UNIQUE Constraint – Notes

## 1. What Is the UNIQUE Constraint?

The **UNIQUE** constraint ensures that **all values** in a column (or combination of columns) are **different**.

- No two rows can have the same value(s) in the UNIQUE column(s).
- **NULL** is often allowed and may be treated as distinct (e.g. multiple NULLs allowed) or as a single value—behavior is database-dependent.

---

## 2. UNIQUE vs PRIMARY KEY

- Both **UNIQUE** and **PRIMARY KEY** enforce **uniqueness** for a column or set of columns.
- A **PRIMARY KEY** implies **UNIQUE** (and usually NOT NULL). There can be **only one** PRIMARY KEY per table.
- You can have **multiple UNIQUE** constraints on a table (e.g. UNIQUE on Email, UNIQUE on (LastName, FirstName)).

---

## 3. UNIQUE on CREATE TABLE

**SQL Server / Oracle / MS Access** — add UNIQUE on the column:

```sql
CREATE TABLE Persons (
    ID int NOT NULL UNIQUE,
    LastName varchar(255) NOT NULL,
    FirstName varchar(255),
    Age int
);
```

**MySQL** — column-level or table-level UNIQUE:

```sql
CREATE TABLE Persons (
    ID int NOT NULL,
    LastName varchar(255) NOT NULL,
    FirstName varchar(255),
    Age int,
    UNIQUE (ID)
);
```

**Named UNIQUE and multiple columns** (MySQL / SQL Server / Oracle / MS Access):

```sql
CREATE TABLE Persons (
    ID int NOT NULL,
    LastName varchar(255) NOT NULL,
    FirstName varchar(255),
    Age int,
    CONSTRAINT UC_Person UNIQUE (ID, LastName)
);
```

- **UC_Person** is the constraint name. The combination **(ID, LastName)** must be unique (each pair can appear only once).

---

## 4. UNIQUE on ALTER TABLE

Add a UNIQUE constraint to an **existing** table.

**Single column:**

```sql
ALTER TABLE Persons
ADD UNIQUE (ID);
```

**Named constraint, multiple columns:**

```sql
ALTER TABLE Persons
ADD CONSTRAINT UC_Person UNIQUE (ID, LastName);
```

**Note:** The column(s) must not already contain duplicate values, or the ADD will fail.

---

## 5. Drop a UNIQUE Constraint

**MySQL** (UNIQUE is implemented as an index):

```sql
ALTER TABLE Persons
DROP INDEX UC_Person;
```

**SQL Server / Oracle / MS Access:**

```sql
ALTER TABLE Persons
DROP CONSTRAINT UC_Person;
```

Use the **constraint name** you gave when creating the UNIQUE (e.g. UC_Person). If you did not name it, the database generated a name; check the system catalog or error messages to find it.

---

## Quick Reference

| Goal | Example |
|------|---------|
| UNIQUE on one column (CREATE) | `ID int UNIQUE` or `UNIQUE (ID)` |
| Named UNIQUE, multiple columns | `CONSTRAINT name UNIQUE (col1, col2)` |
| Add UNIQUE (ALTER) | `ALTER TABLE t ADD UNIQUE (col);` or `ADD CONSTRAINT name UNIQUE (col1, col2);` |
| Drop UNIQUE (MySQL) | `ALTER TABLE t DROP INDEX constraint_name;` |
| Drop UNIQUE (SQL Server, etc.) | `ALTER TABLE t DROP CONSTRAINT constraint_name;` |

**Remember:** UNIQUE forbids duplicate values in the column(s); you can have several UNIQUE constraints per table but only one PRIMARY KEY.
