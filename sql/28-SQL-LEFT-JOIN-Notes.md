# SQL LEFT JOIN – Notes

## 1. What Is LEFT JOIN?

The **LEFT JOIN** returns:
- **All rows** from the **left** table (table1), and  
- **Only the matched rows** from the **right** table (table2).

If a row in the left table has **no match** in the right table, the columns from the right table appear as **NULL** in the result.

- **LEFT JOIN** and **LEFT OUTER JOIN** are the same; the **OUTER** keyword is optional.

---

## 2. Syntax

```sql
SELECT column_name(s)
FROM table1
LEFT JOIN table2
ON table1.column_name = table2.column_name;
```

The **ON** clause defines how the two tables are linked (e.g. key = foreign key).

---

## 3. Demo Database (selection)

**Customers**

| CustomerID | CustomerName | ContactName | Address | City | PostalCode | Country |
|------------|--------------|-------------|---------|------|------------|---------|
| 1 | Alfreds Futterkiste | Maria Anders | Obere Str. 57 | Berlin | 12209 | Germany |
| 2 | Ana Trujillo Emparedados y helados | Ana Trujillo | Avda. de la Constitución 2222 | México D.F. | 05021 | Mexico |
| 3 | Antonio Moreno Taquería | Antonio Moreno | Mataderos 2312 | México D.F. | 05023 | Mexico |

**Orders**

| OrderID | CustomerID | EmployeeID | OrderDate | ShipperID |
|---------|------------|------------|-----------|-----------|
| 10308 | 2 | 7 | 1996-09-18 | 3 |
| 10309 | 37 | 3 | 1996-09-19 | 1 |
| 10310 | 77 | 8 | 1996-09-20 | 2 |

---

## 4. LEFT JOIN Example

Return **all customers** and their orders, including customers who have **no** orders (right-side columns will be NULL for them):

```sql
SELECT Customers.CustomerName, Orders.OrderID
FROM Customers
LEFT JOIN Orders ON Customers.CustomerID = Orders.CustomerID
ORDER BY Customers.CustomerName;
```

- Every row from **Customers** appears.
- If a customer has orders, you get one row per order with that customer’s name and the OrderID.
- If a customer has no orders, you get one row with their name and **OrderID = NULL**.

---

## 5. Finding Rows with No Match (WHERE ... IS NULL)

To get only rows from the left table that **do not** have a match in the right table, add a **WHERE** clause that filters for **NULL** in a column from the right table.

**Example:** Customers who have **not** placed any order:

```sql
SELECT Customers.CustomerName, Orders.OrderID
FROM Customers
LEFT JOIN Orders ON Customers.CustomerID = Orders.CustomerID
WHERE Orders.CustomerID IS NULL;
```

- LEFT JOIN gives all customers; for those with no orders, `Orders.CustomerID` is NULL.
- **WHERE Orders.CustomerID IS NULL** keeps only those rows, so you see only customers with no orders.

---

## Quick Reference

| Goal | Example |
|------|---------|
| All left rows + matches from right (unmatched right = NULL) | `FROM t1 LEFT JOIN t2 ON t1.col = t2.col` |
| Same as LEFT JOIN | Use `LEFT OUTER JOIN` |
| Only left rows with **no** match in right | Add `WHERE t2.column IS NULL` after the LEFT JOIN |

**Remember:** LEFT JOIN keeps **every** row from the left table; missing matches on the right show as NULL. Use `WHERE right_table.column IS NULL` to get “only unmatched” rows.
