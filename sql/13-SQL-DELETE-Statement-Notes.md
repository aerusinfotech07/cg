# SQL DELETE Statement – Notes

## 1. What is DELETE?

The **DELETE** statement is used to **delete existing records** from a table.

---

## 2. Syntax

```sql
DELETE FROM table_name WHERE condition;
```

- **WHERE** – limits which rows are deleted. **If you omit WHERE, all rows in the table are deleted.**

**Warning:** Be careful when deleting. Always use a **WHERE** clause unless you intend to remove every row from the table.

---

## 3. Demo Database: Customers Table (selection)

| CustomerID | CustomerName | ContactName | Address | City | PostalCode | Country |
|------------|--------------|-------------|---------|------|------------|---------|
| 1 | Alfreds Futterkiste | Maria Anders | Obere Str. 57 | Berlin | 12209 | Germany |
| 2 | Ana Trujillo Emparedados y helados | Ana Trujillo | Avda. de la Constitución 2222 | México D.F. | 05021 | Mexico |
| 3 | Antonio Moreno Taquería | Antonio Moreno | Mataderos 2312 | México D.F. | 05023 | Mexico |
| 4 | Around the Horn | Thomas Hardy | 120 Hanover Sq. | London | WA1 1DP | UK |
| 5 | Berglunds snabbköp | Christina Berglund | Berguvsvägen 8 | Luleå | S-958 22 | Sweden |

---

## 4. SQL DELETE Example (specific rows)

Use **WHERE** to delete only the row(s) that match the condition.

**Example:** Delete the customer "Alfreds Futterkiste" from the Customers table:

```sql
DELETE FROM Customers WHERE CustomerName = 'Alfreds Futterkiste';
```

After the delete, that row is gone; the table still has the other customers. The table structure (columns, indexes) is unchanged.

---

## 5. Delete All Records

You can delete **all rows** in a table without removing the table itself. The table structure, columns, and indexes stay; only the data is removed.

**Syntax:**

```sql
DELETE FROM table_name;
```

**Example:** Delete every row in the Customers table:

```sql
DELETE FROM Customers;
```

After this, the Customers table is **empty** but still exists. You can insert new rows into it.

---

## 6. Delete a Table (DROP TABLE)

To remove the **entire table** (structure and data), use **DROP TABLE**, not DELETE.

**Syntax:**

```sql
DROP TABLE table_name;
```

**Example:** Drop the entire Customers table:

```sql
DROP TABLE Customers;
```

After DROP TABLE, the table no longer exists. To use it again, you must **CREATE TABLE** again.

---

## Quick Reference

| Goal | Example |
|------|---------|
| Delete specific row(s) | `DELETE FROM Customers WHERE CustomerName = 'Alfreds Futterkiste';` |
| Delete rows matching a condition | `DELETE FROM Customers WHERE Country = 'Mexico';` |
| Delete all rows (table stays) | `DELETE FROM Customers;` |
| Remove the table completely | `DROP TABLE Customers;` |
| **Avoid** deleting all rows by mistake | Always use **WHERE** unless you intend to clear the whole table. |

**Remember:**  
- **DELETE FROM table_name** – removes rows; table structure remains.  
- **DROP TABLE table_name** – removes the table and all its data.
