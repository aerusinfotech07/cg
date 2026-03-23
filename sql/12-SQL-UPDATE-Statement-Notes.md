# SQL UPDATE Statement – Notes

## 1. What is UPDATE?

The **UPDATE** statement is used to **update or modify** one or more existing records in a table.

---

## 2. Syntax

```sql
UPDATE table_name
SET column1 = value1, column2 = value2, ...
WHERE condition;
```

- **SET** – list the columns to change and their new values (separate with commas).
- **WHERE** – limits which rows are updated. **If you omit WHERE, all rows in the table are updated.**

**Warning:** Be careful when updating. Always use a **WHERE** clause unless you really intend to change every row.

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

## 4. UPDATE One Record

Use **WHERE** to target a single row (e.g. by primary key).

**Example:** Update the customer with CustomerID = 1: set new ContactName and City.

```sql
UPDATE Customers
SET ContactName = 'Alfred Schmidt', City = 'Frankfurt'
WHERE CustomerID = 1;
```

Result for row 1:

| CustomerID | CustomerName | ContactName | Address | City | PostalCode | Country |
|------------|--------------|-------------|---------|------|------------|---------|
| 1 | Alfreds Futterkiste | Alfred Schmidt | Obere Str. 57 | Frankfurt | 12209 | Germany |

---

## 5. UPDATE Multiple Records

The **WHERE** clause decides which rows are updated. A condition that matches several rows will update all of them.

**Example:** Set ContactName to "Juan" for every customer where Country is "Mexico":

```sql
UPDATE Customers
SET ContactName = 'Juan'
WHERE Country = 'Mexico';
```

All rows with Country = 'Mexico' get ContactName = 'Juan' (e.g. CustomerID 2 and 3 in the demo).

---

## 6. Update Warning: Omitting WHERE

If you **omit the WHERE clause**, the UPDATE applies to **every row** in the table.

**Example (dangerous):**

```sql
UPDATE Customers
SET ContactName = 'Juan';
```

This sets ContactName to "Juan" for **all** customers. Use this only when you really want to change every record.

---

## Quick Reference

| Goal | Example |
|------|---------|
| Update one or more columns for specific rows | `UPDATE t SET col1 = v1, col2 = v2 WHERE condition;` |
| Update one row (by key) | `UPDATE Customers SET ContactName = 'X', City = 'Y' WHERE CustomerID = 1;` |
| Update many rows | `UPDATE Customers SET ContactName = 'Juan' WHERE Country = 'Mexico';` |
| **Avoid** updating all rows by mistake | Always include a **WHERE** clause unless you intend to update the whole table. |

**Remember:** The WHERE clause specifies which record(s) to update. Omitting it updates **all** records.
