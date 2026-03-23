# SQL PRIMARY KEY Constraint – Notes

## 1. What Is the PRIMARY KEY Constraint?

The **PRIMARY KEY** constraint **uniquely identifies each row** in a table.

- Primary key values must be **unique** (no duplicates).
- Primary key columns **cannot be NULL**.
- A table can have **only one** primary key. The key can be a **single column** or a **combination of columns** (composite primary key).

---

## 2. PRIMARY KEY on CREATE TABLE

**MySQL** — define the primary key after the columns (table-level):

```sql
CREATE TABLE Persons (
    ID int NOT NULL,
    LastName varchar(255) NOT NULL,
    FirstName varchar(255),
    Age int,
    PRIMARY KEY (ID)
);
```

**SQL Server / Oracle / MS Access** — add PRIMARY KEY on the column:

```sql
CREATE TABLE Persons (
    ID int NOT NULL PRIMARY KEY,
    LastName varchar(255) NOT NULL,
    FirstName varchar(255),
    Age int
);
```

**Composite primary key** (multiple columns) — MySQL / SQL Server / Oracle / MS Access:

```sql
CREATE TABLE Persons (
    ID int NOT NULL,
    LastName varchar(255) NOT NULL,
    FirstName varchar(255),
    Age int,
    CONSTRAINT PK_Person PRIMARY KEY (ID, LastName)
);
```

- **PK_Person** is the constraint name. The primary key is the **pair** (ID, LastName); the combination must be unique and neither column can be NULL.

---

## 3. PRIMARY KEY on ALTER TABLE

Add a primary key to an **existing** table.

**Single column:**

```sql
ALTER TABLE Persons
ADD PRIMARY KEY (ID);
```

**Named composite primary key:**

```sql
ALTER TABLE Persons
ADD CONSTRAINT PK_Person PRIMARY KEY (ID, LastName);
```

**Note:** The column(s) must already be **NOT NULL** and must not contain duplicates, or the ADD will fail.

---

## 4. Drop a PRIMARY KEY Constraint

**MySQL:**

```sql
ALTER TABLE Persons
DROP PRIMARY KEY;
```

**SQL Server / Oracle / MS Access:**

```sql
ALTER TABLE Persons
DROP CONSTRAINT PK_Person;
```

Use the constraint name you gave when creating the primary key (e.g. PK_Person). If it was not named, the database generated a name; check the system catalog to find it.

---

## Quick Reference

| Goal | Example |
|------|---------|
| Single-column PK (CREATE, MySQL) | `PRIMARY KEY (ID)` at end of column list |
| Single-column PK (CREATE, SQL Server, etc.) | `ID int NOT NULL PRIMARY KEY` |
| Composite PK (CREATE) | `CONSTRAINT PK_Person PRIMARY KEY (ID, LastName)` |
| Add PK (ALTER) | `ALTER TABLE t ADD PRIMARY KEY (col);` or `ADD CONSTRAINT name PRIMARY KEY (col1, col2);` |
| Drop PK (MySQL) | `ALTER TABLE t DROP PRIMARY KEY;` |
| Drop PK (SQL Server, etc.) | `ALTER TABLE t DROP CONSTRAINT constraint_name;` |

**Remember:** PRIMARY KEY = unique + NOT NULL; one per table; can be one column or several (composite).
