# SQL CASE Expression – Notes

## 1. What Is the CASE Expression?

The **CASE** expression returns **different values** depending on **conditions** in the query (similar to if-then-else in other languages).

- CASE evaluates **WHEN** conditions in order and **stops at the first one that is true**, then returns the corresponding **THEN** value.
- If **no** condition is true, it returns the **ELSE** value (if present), otherwise **NULL**.

---

## 2. Syntax

```sql
CASE
  WHEN condition1 THEN result1
  WHEN condition2 THEN result2
  WHEN conditionN THEN resultN
  ELSE default_result
END;
```

- **ELSE** is optional. Omit it when you want NULL when no condition matches.
- The whole **CASE ... END** is one expression; use **AS** after END to give the column a name (e.g. in SELECT).

---

## 3. CASE Example: Categorize Price

Use CASE to add a column that labels each product’s price as Low, Medium, or High:

```sql
SELECT ProductName, Price,
CASE
  WHEN Price < 20 THEN 'Low Cost'
  WHEN Price BETWEEN 20 AND 50 THEN 'Medium Cost'
  ELSE 'High Cost'
END AS PriceCategory
FROM Products;
```

- **Price &lt; 20** → 'Low Cost'
- **Price between 20 and 50** → 'Medium Cost'
- **Otherwise** → 'High Cost'

---

## 4. Simple CASE (Value Match)

Some databases support a **simple** form that compares one expression to fixed values:

```sql
CASE column_name
  WHEN value1 THEN result1
  WHEN value2 THEN result2
  ELSE default_result
END;
```

This is equivalent to `CASE WHEN column_name = value1 THEN result1 WHEN column_name = value2 THEN result2 ... END`. The **searched** form (WHEN condition THEN result) is more flexible and works everywhere.

---

## 5. Using CASE in ORDER BY and WHERE

**ORDER BY** — control sort order (e.g. sort by category, then by price):

```sql
SELECT ProductName, Price, ...
FROM Products
ORDER BY
  CASE WHEN Price < 20 THEN 1 WHEN Price BETWEEN 20 AND 50 THEN 2 ELSE 3 END,
  Price;
```

**WHERE** — filter using a computed value (less common; often you can write the condition directly without CASE).

---

## Quick Reference

| Goal | Use |
|------|-----|
| One result per condition (first match wins) | `CASE WHEN cond1 THEN res1 WHEN cond2 THEN res2 ELSE res3 END` |
| Name the result column | `... END AS ColumnName` |
| Default when no match | `ELSE default_result`; omit ELSE for NULL |
| Compare one value to many | Simple form: `CASE col WHEN v1 THEN r1 WHEN v2 THEN r2 END` |

**Remember:** CASE is an expression; it returns a single value per row. Conditions are evaluated in order; the first true one determines the result.
