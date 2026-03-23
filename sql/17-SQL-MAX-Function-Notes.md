# SQL MAX() Function – Notes

## 1. What Does MAX() Do?

The **MAX()** function returns the **largest value** of the selected column.

- MAX() works with **numeric**, **string**, and **date** data types.
- Ignores NULL values when determining the maximum.

---

## 2. Syntax

```sql
SELECT MAX(column_name)
FROM table_name
WHERE condition;
```

- **WHERE** is optional; use it to restrict which rows are considered.

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

## 4. Basic MAX() Example

Return the **highest price** in the Products table:

```sql
SELECT MAX(Price)
FROM Products;
```

---

## 5. Set Column Name (Alias)

The result of `MAX(Price)` has no meaningful column name by default. Use **AS** to give it a descriptive name:

```sql
SELECT MAX(Price) AS HighestPrice
FROM Products;
```

---

## 6. MAX() with Date Column

MAX() on a date/time column returns the **latest** value.

**Example:** Latest birth date in the Employees table:

```sql
SELECT MAX(BirthDate) AS LatestBirthdate
FROM Employees;
```

---

## 7. MAX() with GROUP BY

Use **GROUP BY** to get the **largest value per group** (e.g. per category).

**Example:** Highest price for each category in Products:

```sql
SELECT MAX(Price) AS HighestPrice, CategoryID
FROM Products
GROUP BY CategoryID;
```

You get one row per CategoryID with that category’s maximum price.

---

## Quick Reference

| Goal | Example |
|------|---------|
| Largest value in a column | `SELECT MAX(Price) FROM Products;` |
| Give result a name | `SELECT MAX(Price) AS HighestPrice FROM Products;` |
| Latest date | `SELECT MAX(BirthDate) AS LatestBirthdate FROM Employees;` |
| Largest per group | `SELECT MAX(Price) AS HighestPrice, CategoryID FROM Products GROUP BY CategoryID;` |

**Remember:** MAX() returns the largest value; it works with numbers, strings, and dates. Use GROUP BY for one maximum per group.
