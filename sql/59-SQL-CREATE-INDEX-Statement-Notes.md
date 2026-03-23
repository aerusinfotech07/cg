# SQL CREATE INDEX Statement – Notes

## 1. What Are Indexes?

**Indexes** are structures that help the database **find rows faster** when you search or join on the indexed column(s).

- **CREATE INDEX** creates an index on one or more columns of a table.
- Users do **not** see indexes; they are used internally to speed up **queries** (e.g. WHERE, JOIN, ORDER BY).
- **Downside:** Inserts, updates, and deletes can be **slower** when there are many indexes, because the database must update the indexes too. Create indexes on columns that are **often used in search conditions**, not on every column.

---

## 2. CREATE INDEX Syntax

**Standard index** (duplicate values allowed):

```sql
CREATE INDEX index_name
ON table_name (column1, column2, ...);
```

**Unique index** (no duplicate values in the indexed column(s)):

```sql
CREATE UNIQUE INDEX index_name
ON table_name (column1, column2, ...);
```

**Note:** Index syntax and options (e.g. ascending/descending, partial indexes) **vary by database**. Check your database’s documentation.

---

## 3. CREATE INDEX Examples

**Index on one column (LastName):**

```sql
CREATE INDEX idx_lastname
ON Persons (LastName);
```

**Index on multiple columns (LastName, FirstName):**

```sql
CREATE INDEX idx_pname
ON Persons (LastName, FirstName);
```

- A composite index on (LastName, FirstName) can help queries that filter or sort by LastName, or by LastName and FirstName together. Column order can matter for performance depending on the query.

---

## 4. DROP INDEX

To remove an index, use the syntax appropriate for your database.

**MS Access:**

```sql
DROP INDEX index_name ON table_name;
```

**SQL Server:**

```sql
DROP INDEX table_name.index_name;
```

**DB2 / Oracle:**

```sql
DROP INDEX index_name;
```

**MySQL:**

```sql
ALTER TABLE table_name
DROP INDEX index_name;
```

---

## Quick Reference

| Goal | Example |
|------|---------|
| Create index (duplicates allowed) | `CREATE INDEX idx_name ON table_name (col1, col2);` |
| Create unique index | `CREATE UNIQUE INDEX idx_name ON table_name (col);` |
| Drop index (MySQL) | `ALTER TABLE table_name DROP INDEX index_name;` |
| Drop index (SQL Server) | `DROP INDEX table_name.index_name;` |
| Drop index (Oracle, etc.) | `DROP INDEX index_name;` |

**Remember:** Indexes speed up reads but can slow down writes. Create them on columns that are frequently used in WHERE, JOIN, and ORDER BY.
