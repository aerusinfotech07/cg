# SQL ALTER TABLE Statement – Notes

## 1. What Does ALTER TABLE Do?

The **ALTER TABLE** statement changes an **existing table** by:

- **Adding** columns  
- **Dropping** (removing) columns  
- **Modifying** column data types or properties  
- **Adding or dropping** constraints (e.g. primary key, foreign key, unique, check)

Exact syntax depends on the database (SQL Server, MySQL, Oracle, etc.).

---

## 2. ALTER TABLE – ADD Column

Add a new column to the table.

**Syntax:**

```sql
ALTER TABLE table_name
ADD column_name datatype;
```

**Example — add Email to Customers:**

```sql
ALTER TABLE Customers
ADD Email varchar(255);
```

---

## 3. ALTER TABLE – DROP COLUMN

Remove a column from the table.

**Syntax:**

```sql
ALTER TABLE table_name
DROP COLUMN column_name;
```

**Example — remove Email from Customers:**

```sql
ALTER TABLE Customers
DROP COLUMN Email;
```

**Note:** Some database systems restrict or do not allow dropping columns (e.g. if they are referenced or have constraints). Check your database documentation.

---

## 4. ALTER TABLE – RENAME COLUMN

Rename a column. Syntax varies by database.

**Generic (e.g. Oracle, PostgreSQL, MySQL 8):**

```sql
ALTER TABLE table_name
RENAME COLUMN old_name TO new_name;
```

**SQL Server** (stored procedure):

```sql
EXEC sp_rename 'table_name.old_name', 'new_name', 'COLUMN';
```

---

## 5. ALTER TABLE – Change Column Data Type

Change the data type (or size) of a column. Syntax varies.

**SQL Server / MS Access:**

```sql
ALTER TABLE table_name
ALTER COLUMN column_name datatype;
```

**MySQL / Oracle (older):**

```sql
ALTER TABLE table_name
MODIFY COLUMN column_name datatype;
```

**Oracle 10g and later:**

```sql
ALTER TABLE table_name
MODIFY column_name datatype;
```

*(Exact keywords and rules differ; see your database’s data types reference.)*

---

## 6. Example: Persons Table

**Initial Persons table:**

| ID | LastName | FirstName | Address | City |
|----|----------|-----------|---------|------|
| 1 | Hansen | Ola | Timoteivn 10 | Sandnes |
| 2 | Svendson | Tove | Borgvn 23 | Sandnes |
| 3 | Pettersen | Kari | Storgt 20 | Stavanger |

**Add column DateOfBirth (type date):**

```sql
ALTER TABLE Persons
ADD DateOfBirth date;
```

**Table after ADD:**

| ID | LastName | FirstName | Address | City | DateOfBirth |
|----|----------|-----------|---------|------|-------------|
| 1 | Hansen | Ola | Timoteivn 10 | Sandnes | (empty) |
| 2 | Svendson | Tove | Borgvn 23 | Sandnes | (empty) |
| 3 | Pettersen | Kari | Storgt 20 | Stavanger | (empty) |

**Change DateOfBirth to type year (e.g. SQL Server / MS Access):**

```sql
ALTER TABLE Persons
ALTER COLUMN DateOfBirth year;
```

*(In MySQL you would use MODIFY COLUMN; in Oracle, MODIFY.)*

**Drop column DateOfBirth:**

```sql
ALTER TABLE Persons
DROP COLUMN DateOfBirth;
```

**Table after DROP COLUMN:** back to the original four columns (ID, LastName, FirstName, Address, City).

---

## Quick Reference

| Action | SQL Server / MS Access | MySQL / Oracle (typical) |
|--------|------------------------|---------------------------|
| Add column | `ALTER TABLE t ADD col datatype;` | Same |
| Drop column | `ALTER TABLE t DROP COLUMN col;` | Same |
| Rename column | `EXEC sp_rename 't.old','new','COLUMN';` | `ALTER TABLE t RENAME COLUMN old TO new;` |
| Change type | `ALTER TABLE t ALTER COLUMN col datatype;` | `ALTER TABLE t MODIFY COLUMN col datatype;` |

**Remember:** ALTER TABLE changes the structure of an existing table; exact syntax (ADD, DROP, RENAME, ALTER/MODIFY) depends on your database.
