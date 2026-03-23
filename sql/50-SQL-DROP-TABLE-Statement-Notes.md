# SQL DROP TABLE Statement – Notes

## 1. What Does DROP TABLE Do?

The **DROP TABLE** statement **removes an existing table** from the database.

- The table and **all its data** are **permanently deleted**.
- The table structure (columns, constraints) is gone; the table no longer exists.

---

## 2. Syntax

```sql
DROP TABLE table_name;
```

- **table_name** — name of the table to drop.

**Warning:** Dropping a table deletes **all** data in it. This cannot be undone. Make sure you have a backup or no longer need the table before running DROP TABLE.

---

## 3. Example

Drop the table **Shippers**:

```sql
DROP TABLE Shippers;
```

---

## 4. Optional Clauses (Database-Dependent)

- **MySQL, PostgreSQL, SQL Server (recent):**  
  `DROP TABLE IF EXISTS table_name;` — no error if the table does not exist.
- **Multiple tables:**  
  `DROP TABLE table1, table2, table3;` — drop several tables in one statement (syntax may vary).

---

## 5. TRUNCATE TABLE — Remove Data, Keep Table

**TRUNCATE TABLE** deletes **all rows** in the table but **keeps the table** (structure, columns, constraints).

**Syntax:**

```sql
TRUNCATE TABLE table_name;
```

- The table is **empty** after TRUNCATE; you can insert new data.
- Typically **faster** than `DELETE FROM table_name` when clearing the whole table, because it does not row-by-row delete (implementation varies by database).
- **Difference from DROP:** DROP removes the table entirely; TRUNCATE keeps the table and only removes data.

---

## Quick Reference

| Goal | Example |
|------|---------|
| Remove table and all data | `DROP TABLE table_name;` |
| Drop only if table exists | `DROP TABLE IF EXISTS table_name;` |
| Remove all data, keep table | `TRUNCATE TABLE table_name;` |

**Remember:** DROP TABLE removes the table completely. Use TRUNCATE TABLE when you want to empty the table but keep its definition.
