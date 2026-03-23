# SQL EXISTS Operator – Notes

## 1. What Is EXISTS?

The **EXISTS** operator is used in a **WHERE** clause to test whether a **subquery returns any rows**.

- **EXISTS** is **TRUE** if the subquery returns **at least one** row.
- **EXISTS** is **FALSE** if the subquery returns **no** rows.

The subquery is often **correlated**: it refers to a column from the outer query (e.g. `Suppliers.SupplierID`) so the check is done per row of the outer table.

---

## 2. Syntax

```sql
SELECT column_name(s)
FROM table_name
WHERE EXISTS (subquery);
```

The subquery is usually a **SELECT** that can reference columns from the outer query. The actual columns selected in the subquery do not matter for EXISTS; only whether any row is returned matters.

---

## 3. Demo Database (selection)

**Products**

| ProductID | ProductName | SupplierID | CategoryID | Unit | Price |
|-----------|-------------|------------|------------|------|-------|
| 1 | Chais | 1 | 1 | 10 boxes x 20 bags | 18.00 |
| 2 | Chang | 1 | 1 | 24 - 12 oz bottles | 19.00 |
| 3 | Aniseed Syrup | 1 | 2 | 12 - 550 ml bottles | 10.00 |
| 4 | Chef Anton's Cajun Seasoning | 2 | 2 | 48 - 6 oz jars | 22.00 |
| 5 | Chef Anton's Gumbo Mix | 2 | 2 | 36 boxes | 21.35 |

**Suppliers**

| SupplierID | SupplierName | ContactName | Address | City | PostalCode | Country |
|------------|--------------|-------------|---------|------|------------|---------|
| 1 | Exotic Liquid | Charlotte Cooper | 49 Gilbert St. | London | EC1 4SD | UK |
| 2 | New Orleans Cajun Delights | Shelley Burke | P.O. Box 78934 | New Orleans | 70117 | USA |
| 3 | Grandma Kelly's Homestead | Regina Murphy | 707 Oxford Rd. | Ann Arbor | 48104 | USA |
| 4 | Tokyo Traders | Yoshi Nagase | 9-8 Sekimai Musashino-shi | Tokyo | 100 | Japan |

---

## 4. EXISTS Examples

**Suppliers that have at least one product with price less than 10:**

```sql
SELECT SupplierName
FROM Suppliers
WHERE EXISTS (
  SELECT ProductName
  FROM Products
  WHERE Products.SupplierID = Suppliers.SupplierID AND Price < 10
);
```

- For each supplier row, the subquery checks whether **that** supplier (via `Suppliers.SupplierID`) has any product with `Price < 10`. If yes, EXISTS is TRUE and the supplier is returned.

**Suppliers that have at least one product with price equal to 22:**

```sql
SELECT SupplierName
FROM Suppliers
WHERE EXISTS (
  SELECT ProductName
  FROM Products
  WHERE Products.SupplierID = Suppliers.SupplierID AND Price = 22
);
```

- Same idea: keep only suppliers for whom the subquery returns at least one row (here, a product with Price = 22).

---

## 5. EXISTS vs IN

- **EXISTS** checks whether the subquery returns **any** row; the subquery can be correlated and often uses `SELECT 1` or `SELECT *` (only existence matters).
- **IN** checks whether a value is in a **list** or in the result of a subquery (one column).  
For “rows in outer table that have a match in subquery,” **EXISTS** and **IN** can often express the same logic; **EXISTS** can be more efficient when the database can stop the subquery as soon as one row is found.

---

## Quick Reference

| Goal | Use |
|------|-----|
| Keep rows where subquery returns at least one row | `WHERE EXISTS (SELECT ... FROM ... WHERE outer.col = inner.col AND ...)` |
| Exclude such rows | `WHERE NOT EXISTS (subquery)` |
| Correlated subquery | Subquery references a column from the outer query (e.g. `Suppliers.SupplierID`). |

**Remember:** EXISTS is TRUE if the subquery returns one or more rows; the selected columns in the subquery do not affect the result.
