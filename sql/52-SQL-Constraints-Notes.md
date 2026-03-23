# SQL Constraints – Notes

## 1. What Are SQL Constraints?

**Constraints** are rules you define on a table so that the data meets your requirements.

- They **limit the type or values** of data that can be stored (e.g. no NULLs, unique values, range checks).
- If an **insert, update, or delete** breaks a constraint, the database **rejects the action** (and typically returns an error).
- Constraints help keep data **accurate and consistent**.

You can define constraints **when creating the table** (CREATE TABLE) or **later** (ALTER TABLE).

---

## 2. Syntax (CREATE TABLE)

```sql
CREATE TABLE table_name (
    column1 datatype constraint,
    column2 datatype constraint,
    column3 datatype constraint,
    ...
);
```

Constraints can be written **on the column** (column-level) or **after the column list** (table-level). Table-level constraints are used for primary keys, unique keys, or foreign keys that involve more than one column.

---

## 3. Column-Level vs Table-Level

- **Column-level** — The constraint is defined with a single column (e.g. `LastName varchar(255) NOT NULL`). It applies to that column only.
- **Table-level** — The constraint is defined after all columns (e.g. `PRIMARY KEY (col1, col2)`). It can apply to one or more columns and is often used for composite keys or when naming the constraint.

---

## 4. Commonly Used Constraints

| Constraint | Description |
|------------|-------------|
| **NOT NULL** | The column cannot contain NULL. Every row must have a value for this column. |
| **UNIQUE** | All values in the column (or combination of columns) must be different. NULL is often allowed once (database-dependent). |
| **PRIMARY KEY** | Uniquely identifies each row. Implies **NOT NULL** and **UNIQUE**. A table normally has one primary key (single or composite). |
| **FOREIGN KEY** | Links a column (or columns) to a primary or unique key in another table. Prevents inserts/updates that would break the relationship (referential integrity). |
| **CHECK** | Values in the column must satisfy a condition (e.g. `Price > 0`, `Status IN ('A','B','C')`). |
| **DEFAULT** | If no value is given for the column on insert, this default value is used. |
| **CREATE INDEX** | Indexes are not constraints but are often discussed with them. They speed up **retrieval** (and sometimes enforce UNIQUE). Created with **CREATE INDEX** or **UNIQUE INDEX**. |

---

## 5. Summary

- **NOT NULL** — No NULLs allowed.  
- **UNIQUE** — All values must be different.  
- **PRIMARY KEY** — Unique identifier for each row (NOT NULL + UNIQUE).  
- **FOREIGN KEY** — References another table; preserves links between tables.  
- **CHECK** — Values must meet a condition.  
- **DEFAULT** — Value used when none is supplied.  
- **Index** — Improves query speed; unique indexes can enforce uniqueness.

Constraints can be added in **CREATE TABLE** or with **ALTER TABLE**. Exact syntax (e.g. naming, where to put the constraint) varies by database.

---

## Quick Reference

| Goal | Typical approach |
|------|-------------------|
| Disallow NULL | `column_name datatype NOT NULL` |
| Unique values | `column_name datatype UNIQUE` or `UNIQUE (col1, col2)` |
| Primary key | `column_name datatype PRIMARY KEY` or `PRIMARY KEY (col1, col2)` |
| Reference another table | `FOREIGN KEY (col) REFERENCES other_table(key_col)` |
| Restrict values | `CHECK (condition)` |
| Default value | `column_name datatype DEFAULT value` |

**Remember:** Constraints enforce rules on data; violating a constraint causes the operation to be aborted.
