# SQL SUM() Function – Notes

## 1. What Does SUM() Do?

The **SUM()** function calculates the **total sum** of values in a specified **numeric** column.

- SUM() **ignores NULL** values in the column.

**Example:** Total of the Quantity column in OrderDetails:

```sql
SELECT SUM(Quantity)
FROM OrderDetails;
```

---

## 2. Syntax

```sql
SELECT SUM(column_name)
FROM table_name
WHERE condition;
```

- **WHERE** is optional; use it to sum only rows that meet a condition.

---

## 3. Demo Database: OrderDetails Table (selection)

| OrderDetailID | OrderID | ProductID | Quantity |
|---------------|---------|-----------|----------|
| 1 | 10248 | 11 | 12 |
| 2 | 10248 | 42 | 10 |
| 3 | 10248 | 72 | 5 |
| 4 | 10249 | 14 | 9 |
| 5 | 10249 | 51 | 40 |

---

## 4. Add a WHERE Clause

Restrict which rows are included in the sum:

**Example:** Sum of Quantity only for ProductID = 11:

```sql
SELECT SUM(Quantity)
FROM OrderDetails
WHERE ProductID = 11;
```

---

## 5. Use an Alias

Give the summed column a name with **AS**:

```sql
SELECT SUM(Quantity) AS total
FROM OrderDetails;
```

---

## 6. SUM() with GROUP BY

Use **GROUP BY** to get **one sum per group** (e.g. total quantity per order).

**Example:** Total quantity for each OrderID:

```sql
SELECT OrderID, SUM(Quantity) AS [Total Quantity]
FROM OrderDetails
GROUP BY OrderID;
```

You get one row per OrderID with that order’s total quantity.

---

## 7. SUM() with an Expression

The argument to SUM() can be an **expression** (e.g. multiplication), not only a column.

**Example:** Assume each unit costs 10 dollars; total earnings:

```sql
SELECT SUM(Quantity * 10)
FROM OrderDetails;
```

**Example:** Actual total amount using price from the Products table (join OrderDetails with Products):

```sql
SELECT SUM(Price * Quantity)
FROM OrderDetails
LEFT JOIN Products ON OrderDetails.ProductID = Products.ProductID;
```

This sums (price × quantity) for each order detail row, using the real product price.

---

## Quick Reference

| Goal | Example |
|------|---------|
| Sum a column | `SELECT SUM(Quantity) FROM OrderDetails;` |
| Sum with condition | `SELECT SUM(Quantity) FROM OrderDetails WHERE ProductID = 11;` |
| Name the result | `SELECT SUM(Quantity) AS total FROM OrderDetails;` |
| Sum per group | `SELECT OrderID, SUM(Quantity) AS [Total Quantity] FROM OrderDetails GROUP BY OrderID;` |
| Sum of expression | `SELECT SUM(Quantity * 10) FROM OrderDetails;` |
| Sum with joined table | `SELECT SUM(Price * Quantity) FROM OrderDetails LEFT JOIN Products ON OrderDetails.ProductID = Products.ProductID;` |

**Remember:** SUM() works on numeric columns (or numeric expressions), and ignores NULL values.
