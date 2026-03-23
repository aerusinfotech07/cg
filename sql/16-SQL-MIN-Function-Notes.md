# SQL MIN() Function – Notes

## 1. What Does MIN() Do?

The **MIN()** function returns the **smallest value** of the selected column.

- MIN() works with **numeric**, **string**, and **date** data types.
- Ignores NULL values when determining the minimum.

---

## 2. Syntax

```sql
SELECT MIN(column_name)
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

## 4. Basic MIN() Example

Return the **lowest price** in the Products table:

```sql
SELECT MIN(Price)
FROM Products;
```

---

## 5. Set Column Name (Alias)

The result of `MIN(Price)` has no meaningful column name by default. Use **AS** to give it a descriptive name:

```sql
SELECT MIN(Price) AS SmallestPrice
FROM Products;
```

---

## 6. MIN() with Date Column

MIN() on a date/time column returns the **earliest** value.

**Example:** Earliest birth date in the Employees table:

```sql
SELECT MIN(BirthDate) AS EarliestBirthdate
FROM Employees;
```

---

## 7. MIN() with GROUP BY

Use **GROUP BY** to get the **smallest value per group** (e.g. per category).

**Example:** Smallest price for each category in Products:

```sql
SELECT MIN(Price) AS SmallestPrice, CategoryID
FROM Products
GROUP BY CategoryID;
```

You get one row per CategoryID with that category’s minimum price.

---

## Quick Reference

| Goal | Example |
|------|---------|
| Smallest value in a column | `SELECT MIN(Price) FROM Products;` |
| Give result a name | `SELECT MIN(Price) AS SmallestPrice FROM Products;` |
| Earliest date | `SELECT MIN(BirthDate) AS EarliestBirthdate FROM Employees;` |
| Smallest per group | `SELECT MIN(Price) AS SmallestPrice, CategoryID FROM Products GROUP BY CategoryID;` |

**Remember:** MIN() returns the smallest value; it works with numbers, strings, and dates. Use GROUP BY for one minimum per group.
