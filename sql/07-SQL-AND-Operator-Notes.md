# SQL AND Operator – Notes

## 1. What is the AND Operator?

The **WHERE** clause can use one or more **AND** operators.

- The **AND** operator filters records based on **more than one condition**.
- **Important:** A row is returned only if **all** the conditions are **TRUE**.

**Example:** Select all customers from Spain whose name starts with the letter `'G'`:

```sql
SELECT *
FROM Customers
WHERE Country = 'Spain' AND CustomerName LIKE 'G%';
```

---

## 2. Syntax

```sql
SELECT column1, column2, ...
FROM table_name
WHERE condition1 AND condition2 AND condition3 ...;
```

- You can chain any number of conditions with **AND**.
- Every condition must be TRUE for the row to be included.

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

## 4. All Conditions Must Be TRUE

With **AND**, a record is shown only when **every** condition is TRUE.

**Example:** Customers where Country is `"Brazil"` **and** City is `"Rio de Janeiro"` **and** CustomerID is greater than 50:

```sql
SELECT * FROM Customers
WHERE Country = 'Brazil'
AND City = 'Rio de Janeiro'
AND CustomerID > 50;
```

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
- Without parentheses, the order of evaluation can change the result.

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

- Because of operator precedence, this is read as:  
  `(Country = 'Spain' AND CustomerName LIKE 'G%') OR (CustomerName LIKE 'R%')`
- So you get: all Spanish customers whose name starts with G **plus all** customers whose name starts with R **from any country**.
- That is usually **not** what you want when you mean “Spain and (G or R)”.

**Rule:** Use parentheses to make the intended grouping clear when mixing AND and OR.

---

## Quick Reference

| Goal | Example |
|------|---------|
| Two conditions (both required) | `WHERE Country = 'Spain' AND CustomerName LIKE 'G%'` |
| Three or more conditions | `WHERE Country = 'Brazil' AND City = 'Rio de Janeiro' AND CustomerID > 50` |
| AND with OR (correct logic) | `WHERE Country = 'Spain' AND (CustomerName LIKE 'G%' OR CustomerName LIKE 'R%')` |
| Remember | AND = all TRUE; use () when mixing AND and OR |
