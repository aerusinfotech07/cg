# SQL CHECK Constraint – Notes

## 1. What Is the CHECK Constraint?

The **CHECK** constraint **limits the values** that can be stored in a column (or set of columns).

- If you define CHECK on a **column**, only values that satisfy the condition are allowed for that column.
- If you define CHECK on the **table**, the condition can use **several columns** in the same row (e.g. “Age >= 18 AND City = 'Sandnes'”).

When an INSERT or UPDATE violates the condition, the database **rejects** the operation.

---

## 2. CHECK on CREATE TABLE

**MySQL** — table-level CHECK after the columns:

```sql
CREATE TABLE Persons (
    ID int NOT NULL,
    LastName varchar(255) NOT NULL,
    FirstName varchar(255),
    Age int,
    CHECK (Age >= 18)
);
```

**SQL Server / Oracle / MS Access** — column-level CHECK:

```sql
CREATE TABLE Persons (
    ID int NOT NULL,
    LastName varchar(255) NOT NULL,
    FirstName varchar(255),
    Age int CHECK (Age >= 18)
);
```

**Named CHECK and multiple columns** (MySQL / SQL Server / Oracle / MS Access):

```sql
CREATE TABLE Persons (
    ID int NOT NULL,
    LastName varchar(255) NOT NULL,
    FirstName varchar(255),
    Age int,
    City varchar(255),
    CONSTRAINT CHK_Person CHECK (Age >= 18 AND City = 'Sandnes')
);
```

- **CHK_Person** is the constraint name. The condition can reference more than one column (e.g. Age and City).

---

## 3. CHECK on ALTER TABLE

Add a CHECK constraint to an **existing** table.

**Unnamed, single condition:**

```sql
ALTER TABLE Persons
ADD CHECK (Age >= 18);
```

**Named, multiple columns:**

```sql
ALTER TABLE Persons
ADD CONSTRAINT CHK_PersonAge CHECK (Age >= 18 AND City = 'Sandnes');
```

**Note:** Existing rows must satisfy the new CHECK, or the ADD will fail.

---

## 4. Drop a CHECK Constraint

**SQL Server / Oracle / MS Access:**

```sql
ALTER TABLE Persons
DROP CONSTRAINT CHK_PersonAge;
```

**MySQL:**

```sql
ALTER TABLE Persons
DROP CHECK CHK_PersonAge;
```

Use the actual constraint name (the one you gave or the one the database generated).

---

## Quick Reference

| Goal | Example |
|------|---------|
| CHECK on one column (CREATE, MySQL) | `CHECK (Age >= 18)` at end of column list |
| CHECK on one column (CREATE, SQL Server, etc.) | `Age int CHECK (Age >= 18)` |
| Named CHECK, multiple columns | `CONSTRAINT CHK_Person CHECK (Age >= 18 AND City = 'Sandnes')` |
| Add CHECK (ALTER) | `ALTER TABLE t ADD CHECK (condition);` or `ADD CONSTRAINT name CHECK (condition);` |
| Drop CHECK (SQL Server, etc.) | `ALTER TABLE t DROP CONSTRAINT constraint_name;` |
| Drop CHECK (MySQL) | `ALTER TABLE t DROP CHECK constraint_name;` |

**Remember:** CHECK enforces a condition on column values; the condition can use one or more columns in the row.
