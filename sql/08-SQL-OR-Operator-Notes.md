# SQL OR Operator – Notes

## 1. What is the OR Operator?

The **WHERE** clause can use one or more **OR** operators.

- The **OR** operator filters records based on **more than one condition**.
- **Important:** A row is returned if **any** of the conditions is **TRUE**.

**Example:** Select all customers from Germany **or** Spain:

```sql
SELECT *
FROM Customers
WHERE Country = 'Germany' OR Country = 'Spain';
```

---

## 2. Syntax

```sql
SELECT column1, column2, ...
FROM table_name
WHERE condition1 OR condition2 OR condition3 ...;
```

- You can chain any number of conditions with **OR**.
- A record is included if **at least one** condition is TRUE.

---

## 3. Demo Database: Customers Table

| CustomerID | CustomerName | ContactName | Address | City | PostalCode | Country |
|------------|--------------|-------------|---------|------|------------|---------|
| 1 | Alfreds Futterkiste | Maria Anders | Obere Str. 57 | Berlin | 12209 | Germany |
| 2 | Ana Trujillo Emparedados y helados | Ana Trujillo | Avda. de la Constitución 2222 | México D.F. | 05021 | Mexico |
| 3 | Antonio Moreno Taquería | Antonio Moreno | Mataderos 2312 | México D.F. | 05023 | Mexico |
| 4 | Around the Horn | Thomas Hardy | 120 Hanover Sq. | London | WA1 1DP | UK |
| 5 | Berglunds snabbköp | Christina Berglund | Berguvsvägen 8 | Luleå | S-958 22 | Sweden |

---

## 4. At Least One Condition Must Be True

With **OR**, a record is shown when **any** of the conditions is TRUE.

**Example:** Customers where City is `"Berlin"` **or** CustomerName starts with `"G"` **or** Country is `"Norway"`:

```sql
SELECT * FROM Customers
WHERE City = 'Berlin' OR CustomerName LIKE 'G%' OR Country = 'Norway';
```

- A row is returned if it matches **one or more** of these three conditions.

---

## 5. AND vs. OR

| Operator | Meaning | Record is shown when |
|----------|---------|----------------------|
| **AND** | All conditions must be true | **Every** condition is TRUE |
| **OR** | At least one condition must be true | **Any** condition is TRUE |

---

## 6. Combining AND and OR

You can use **AND** and **OR** in the same WHERE clause.

- Use **parentheses ()** to group conditions so the logic is correct.
- Without parentheses, operator precedence can produce the wrong result.

### Correct: with parentheses

Select Spanish customers whose name starts with **either** `"G"` **or** `"R"`:

```sql
SELECT * FROM Customers
WHERE Country = 'Spain' AND (CustomerName LIKE 'G%' OR CustomerName LIKE 'R%');
```

- Result: Only customers from Spain **and** (name starts with G **or** R).

### Incorrect: without parentheses

```sql
SELECT * FROM Customers
WHERE Country = 'Spain' AND CustomerName LIKE 'G%' OR CustomerName LIKE 'R%';
```

- This is evaluated as:  
  `(Country = 'Spain' AND CustomerName LIKE 'G%') OR (CustomerName LIKE 'R%')`
- So you get: Spanish customers whose name starts with G **plus all** customers whose name starts with R **from any country**.
- That is usually **not** what you want when you mean “Spain and (G or R)”.

**Rule:** Use parentheses when mixing AND and OR so the intended grouping is clear.

---

## Quick Reference

| Goal | Example |
|------|---------|
| Either of two values | `WHERE Country = 'Germany' OR Country = 'Spain'` |
| Any of three or more conditions | `WHERE City = 'Berlin' OR CustomerName LIKE 'G%' OR Country = 'Norway'` |
| OR with AND (correct logic) | `WHERE Country = 'Spain' AND (CustomerName LIKE 'G%' OR CustomerName LIKE 'R%')` |
| Remember | OR = at least one TRUE; use () when combining with AND |
