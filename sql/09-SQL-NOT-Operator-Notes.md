# SQL NOT Operator – Notes

## 1. What is the NOT Operator?

The **NOT** operator is used in the **WHERE** clause to return all records that **do not match** the given condition.

- It **reverses** the result of a condition: TRUE becomes FALSE and vice versa.
- Use it to **exclude** rows that match certain criteria.

**Example:** Select all customers that are **NOT** from Spain:

```sql
SELECT * FROM Customers
WHERE NOT Country = 'Spain';
```

Here, **NOT** is used together with the **=** operator.

---

## 2. Syntax

```sql
SELECT column1, column2, ...
FROM table_name
WHERE NOT condition;
```

**NOT** can also be combined with other operators to exclude data:

| Combination    | Purpose |
|----------------|---------|
| **NOT LIKE**   | Exclude rows matching a pattern |
| **NOT BETWEEN**| Exclude rows inside a range |
| **NOT IN**     | Exclude rows matching any value in a list (or subquery) |
| **IS NOT NULL**| Exclude rows where the value is NULL |
| **NOT EXISTS** | Exclude rows when a subquery returns no rows |

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

## 4. The NOT LIKE Operator

**NOT LIKE** excludes rows that match a given **character pattern**.

### Wildcards often used with LIKE / NOT LIKE

| Wildcard | Meaning |
|----------|---------|
| **%** | Zero, one, or multiple characters |
| **_** | Exactly one character |

**Example:** Select all customers whose name does **not** start with the letter `'A'`:

```sql
SELECT * FROM Customers
WHERE CustomerName NOT LIKE 'A%';
```

---

## 5. The NOT BETWEEN Operator

**NOT BETWEEN** selects rows where the value is **outside** the given range (the range is inclusive).

- Can be used with **numeric**, **text**, or **date** values.

**Example:** Select all customers with a CustomerID **not between** 10 and 60:

```sql
SELECT * FROM Customers
WHERE CustomerID NOT BETWEEN 10 AND 60;
```

- Returns rows with CustomerID &lt; 10 or CustomerID &gt; 60.

---

## 6. The NOT IN Operator

**NOT IN** excludes rows that match **any** value in a list (or in a subquery result).

**Example:** Select all customers whose city is **not** Paris or London:

```sql
SELECT * FROM Customers
WHERE City NOT IN ('Paris', 'London');
```

---

## 7. NOT Greater Than

“Not greater than” means **less than or equal to**. In SQL it is often written with **NOT** or with **&lt;=**.

**Example:** Select all customers with a CustomerID **not greater than** 50:

```sql
SELECT * FROM Customers
WHERE NOT CustomerID > 50;
```

- Same result as: `WHERE CustomerID <= 50`

---

## 8. NOT Less Than

“Not less than” means **greater than or equal to**. In SQL it is often written with **NOT** or with **&gt;=**.

**Example:** Select all customers with a CustomerID **not less than** 50:

```sql
SELECT * FROM Customers
WHERE NOT CustomerID < 50;
```

- Same result as: `WHERE CustomerID >= 50`

---

## Quick Reference

| Goal | Example |
|------|---------|
| Exclude one value | `WHERE NOT Country = 'Spain'` |
| Exclude by pattern | `WHERE CustomerName NOT LIKE 'A%'` |
| Outside a range | `WHERE CustomerID NOT BETWEEN 10 AND 60` |
| Exclude list of values | `WHERE City NOT IN ('Paris', 'London')` |
| Not greater than (≤) | `WHERE NOT CustomerID > 50` or `WHERE CustomerID <= 50` |
| Not less than (≥) | `WHERE NOT CustomerID < 50` or `WHERE CustomerID >= 50` |
