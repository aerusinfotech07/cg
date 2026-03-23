# SQL ALL Operator – Notes

## 1. What Is ALL?

The **ALL** operator compares a value to **every** value returned by a subquery.

- **ALL** is **TRUE** only if the comparison holds for **every** value in the subquery result.
- If the subquery returns no rows, **ALL** is typically evaluated as **TRUE** (vacuous case: “every row satisfies” when there are no rows).

**ALL** is typically used with **WHERE** and **HAVING**.

---

## 2. Syntax

```sql
SELECT column_name(s)
FROM table_name
WHERE column_name operator ALL (subquery);
```

**Note:** The operator must be a standard comparison operator: **=**, **<>**, **!=**, **>**, **>=**, **<**, or **<=**.

---

## 3. Demo Database (selection)

**Products**

| ProductID | ProductName | Price |
|-----------|-------------|-------|
| 1 | Chais | 18.00 |
| 2 | Chang | 19.00 |
| 3 | Aniseed Syrup | 10.00 |
| 4 | Chef Anton's Cajun Seasoning | 22.00 |

**OrderDetails**

| OrderDetailID | ProductID | Quantity |
|---------------|-----------|----------|
| 1 | 11 | 12 |
| 2 | 42 | 10 |
| 3 | 72 | 5 |
| 4 | 14 | 9 |

---

## 4. ALL Example

**Product names where the product’s ProductID equals ALL of the ProductIDs returned by the subquery** (i.e. ProductIDs from OrderDetails where Quantity = 10):

```sql
SELECT ProductName
FROM Products
WHERE ProductID = ALL (
  SELECT ProductID
  FROM OrderDetails
  WHERE Quantity = 10
);
```

- The subquery returns all ProductIDs that have Quantity = 10 (e.g. product 42 in the sample).
- **ProductID = ALL (subquery)** is TRUE only if the product’s ProductID equals **every** value in that set. A single ProductID can equal “all” only when the subquery returns **exactly one** value (or zero, depending on the database).
- Here, OrderDetails has many different Quantity values (not only 10), so the subquery may return zero, one, or several ProductIDs. If it returns more than one ProductID, no product can equal all of them, so the result is empty. So this query typically returns **no rows** (FALSE) when there are multiple different quantities.

---

## 5. ALL vs ANY

| Operator | TRUE when |
|----------|-----------|
| **ANY** | The comparison holds for **at least one** value in the subquery result. |
| **ALL** | The comparison holds for **every** value in the subquery result. |

Examples:
- **column > ALL (subquery)** — column is greater than **every** value (i.e. greater than the **maximum** of the subquery).
- **column < ALL (subquery)** — column is less than **every** value (i.e. less than the **minimum** of the subquery).

---

## Quick Reference

| Goal | Use |
|------|-----|
| Value must satisfy condition for every subquery value | `WHERE col operator ALL (SELECT ...)` |
| Greater than every value (greater than max) | `WHERE col > ALL (SELECT ...)` |
| Less than every value (less than min) | `WHERE col < ALL (SELECT ...)` |
| Empty subquery | ALL is often TRUE (no value fails the “every” check). |

**Remember:** ALL requires the comparison to be true for **every** row in the subquery result; ANY requires it for **at least one** row.
