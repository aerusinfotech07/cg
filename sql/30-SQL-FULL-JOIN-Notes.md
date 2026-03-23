# SQL FULL JOIN – Notes

## 1. What Is FULL JOIN?

The **FULL JOIN** (or **FULL OUTER JOIN**) returns **all rows** when there is a match in **either** the left or the right table.

- If a row in the **left** table has **no match** in the right table, the result includes that left row with **NULL** for all columns from the right table.
- If a row in the **right** table has **no match** in the left table, the result includes that right row with **NULL** for all columns from the left table.

So you get: all matched pairs **plus** all unmatched rows from **both** tables.

- **FULL JOIN** and **FULL OUTER JOIN** are the same; the **OUTER** keyword is optional.

**Note:** FULL JOIN can produce **very large result sets**, since it combines the effect of LEFT and RIGHT JOIN.

---

## 2. Syntax

```sql
SELECT column_name(s)
FROM table1
FULL JOIN table2
ON table1.column_name = table2.column_name
WHERE condition;
```

**WHERE** is optional; use it to filter the result.

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

## 4. FULL JOIN Example

Return **all customers** and **all orders**: matched pairs plus customers with no orders (OrderID NULL) and orders with no matching customer (CustomerName NULL).

```sql
SELECT Customers.CustomerName, Orders.OrderID
FROM Customers
FULL JOIN Orders ON Customers.CustomerID = Orders.CustomerID;
```

**Sample result:**

| CustomerName | OrderID |
|-------------|---------|
| NULL | 10309 |
| NULL | 10310 |
| Alfreds Futterkiste | NULL |
| Ana Trujillo Emparedados y helados | 10308 |
| Antonio Moreno Taquería | NULL |

- Rows with **CustomerName NULL** are orders whose CustomerID has no match in Customers.
- Rows with **OrderID NULL** are customers who have no orders (or no orders in the result set).

**Note:** FULL JOIN returns every matching record from both tables and also every row that has no match in the other table.

---

## 5. MySQL: No Native FULL JOIN

**MySQL does not support** FULL OUTER JOIN. To get the same result, use a **UNION** of a LEFT JOIN and a RIGHT JOIN (excluding the inner match twice), for example:

```sql
SELECT Customers.CustomerName, Orders.OrderID
FROM Customers
LEFT JOIN Orders ON Customers.CustomerID = Orders.CustomerID
UNION
SELECT Customers.CustomerName, Orders.OrderID
FROM Customers
RIGHT JOIN Orders ON Customers.CustomerID = Orders.CustomerID;
```

---

## Quick Reference

| Goal | Example |
|------|---------|
| All rows from both tables (matched + unmatched from each side) | `FROM t1 FULL JOIN t2 ON t1.col = t2.col` |
| Same as FULL JOIN | Use `FULL OUTER JOIN` |
| MySQL workaround | `LEFT JOIN ... UNION ... RIGHT JOIN` (see above) |

**Remember:** FULL JOIN keeps **every** row from **both** tables; missing matches show as NULL on the other side.
