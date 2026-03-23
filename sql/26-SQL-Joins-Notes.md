# SQL JOIN Clause – Notes

## 1. What Is a JOIN?

The **JOIN** clause is used to **combine rows** from two or more tables based on a **related column** between them.

- The related column is often a **foreign key** in one table (e.g. `Orders.CustomerID`) that references a **primary key** in another (e.g. `Customers.CustomerID`).
- JOINs let you show data from multiple tables in one result set (e.g. order ID with customer name instead of only customer ID).

---

## 2. Types of JOINs

| JOIN type | Description |
|-----------|-------------|
| **(INNER) JOIN** | Returns only rows that have **matching values in both** tables. Rows with no match in the other table are excluded. |
| **LEFT (OUTER) JOIN** | Returns **all rows from the left** table, and **matched rows** from the right table. Unmatched left rows get NULL for right-side columns. |
| **RIGHT (OUTER) JOIN** | Returns **all rows from the right** table, and **matched rows** from the left table. Unmatched right rows get NULL for left-side columns. |
| **FULL (OUTER) JOIN** | Returns all rows when there is a match in **either** table. Rows that don’t match get NULL on the other side. *(Not supported in MySQL; use UNION of LEFT and RIGHT.)* |

---

## 3. The Relationship Between Tables

**Orders** (one row):

| OrderID | CustomerID | OrderDate   |
|---------|------------|-------------|
| 10308   | 2          | 1996-09-18  |

**Customers** (matching row):

| CustomerID | CustomerName                        | ContactName     | Country |
|------------|-------------------------------------|-----------------|---------|
| 2          | Ana Trujillo Emparedados y helados  | Ana Trujillo    | Mexico  |

The **Orders.CustomerID** column refers to **Customers.CustomerID**. That shared column is used to **join** the two tables.

---

## 4. INNER JOIN Example

**INNER JOIN** returns only rows where there is a match in **both** tables (orders that have a customer, and customers that have orders).

**SQL:**

```sql
SELECT Orders.OrderID, Customers.CustomerName, Orders.OrderDate
FROM Orders
INNER JOIN Customers ON Orders.CustomerID = Customers.CustomerID;
```

**Result (example):**

| OrderID | CustomerName                        | OrderDate   |
|---------|-------------------------------------|-------------|
| 10308   | Ana Trujillo Emparedados y helados   | 1996-09-18  |
| 10365   | Antonio Moreno Taquería             | 1996-11-27  |
| 10383   | Around the Horn                     | 1996-11-15  |
| 10355   | Around the Horn                     | 1996-12-16  |
| 10278   | Berglunds snabbköp                   | 1996-12-16  |

- **FROM Orders** – start from the Orders table.
- **INNER JOIN Customers ON Orders.CustomerID = Customers.CustomerID** – add customer data only where `CustomerID` matches.
- Columns are written as `Table.Column` when the same name exists in both tables (e.g. `Orders.OrderID`, `Customers.CustomerName`).

---

## 5. Syntax Summary

```sql
SELECT column_list
FROM left_table
[INNER | LEFT | RIGHT | FULL] JOIN right_table
  ON left_table.column = right_table.column;
```

- **ON** defines **which columns** link the two tables.
- Use **table aliases** (e.g. `Orders AS o`) to shorten the query when you use many columns.

---

## Quick Reference

| Need | Use |
|------|-----|
| Only rows that match in both tables | `INNER JOIN ... ON ...` |
| All rows from left table + matches from right | `LEFT JOIN ... ON ...` |
| All rows from right table + matches from left | `RIGHT JOIN ... ON ...` |
| All rows from both (match or not) | `FULL JOIN ... ON ...` (or UNION in MySQL) |

**Remember:** JOIN combines tables on a **related column**; the **ON** clause specifies that relationship.
