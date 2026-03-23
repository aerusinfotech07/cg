# SQL AVG() Function – Notes

## 1. What Does AVG() Do?

The **AVG()** function returns the **average value** of a numeric column.

- AVG() **ignores NULL** values when calculating the average.

**Example:** Average price of all products:

```sql
SELECT AVG(Price)
FROM Products;
```

**Note:** NULL values in the column are ignored.

---

## 2. Syntax

```sql
SELECT AVG(column_name)
FROM table_name
WHERE condition;
```

- **WHERE** is optional; use it to average only rows that meet a condition.

---

## 3. Demo Database: Products Table (selection)

| ProductID | ProductName | SupplierID | CategoryID | Unit | Price |
|-----------|-------------|------------|------------|------|-------|
| 1 | Chais | 1 | 1 | 10 boxes x 20 bags | 18.00 |
| 2 | Chang | 1 | 1 | 24 - 12 oz bottles | 19.00 |
| 3 | Aniseed Syrup | 1 | 2 | 12 - 550 ml bottles | 10.00 |
| 4 | Chef Anton's Cajun Seasoning | 2 | 2 | 48 - 6 oz jars | 22.00 |
| 5 | Chef Anton's Gumbo Mix | 2 | 2 | 36 boxes | 21.35 |

---

## 4. Add a WHERE Clause

Restrict which rows are included in the average:

**Example:** Average price of products in category 1:

```sql
SELECT AVG(Price)
FROM Products
WHERE CategoryID = 1;
```

---

## 5. Use an Alias

Give the average column a name with **AS**:

```sql
SELECT AVG(Price) AS [average price]
FROM Products;
```

---

## 6. Higher Than Average (Subquery)

Use AVG() in a **subquery** to compare each row to the overall average.

**Example:** All products with a price higher than the average price:

```sql
SELECT * FROM Products
WHERE Price > (SELECT AVG(Price) FROM Products);
```

The subquery `(SELECT AVG(Price) FROM Products)` returns a single value; the outer query returns rows where Price is greater than that value.

---

## 7. AVG() with GROUP BY

Use **GROUP BY** to get **one average per group** (e.g. per category).

**Example:** Average price for each category:

```sql
SELECT AVG(Price) AS AveragePrice, CategoryID
FROM Products
GROUP BY CategoryID;
```

You get one row per CategoryID with that category’s average price.

---

## Quick Reference

| Goal | Example |
|------|---------|
| Average of a column | `SELECT AVG(Price) FROM Products;` |
| Average with condition | `SELECT AVG(Price) FROM Products WHERE CategoryID = 1;` |
| Name the result | `SELECT AVG(Price) AS [average price] FROM Products;` |
| Rows above average | `SELECT * FROM Products WHERE Price > (SELECT AVG(Price) FROM Products);` |
| Average per group | `SELECT AVG(Price) AS AveragePrice, CategoryID FROM Products GROUP BY CategoryID;` |

**Remember:** AVG() works on numeric columns and ignores NULL values. Use a subquery to filter by “above/below average.”
