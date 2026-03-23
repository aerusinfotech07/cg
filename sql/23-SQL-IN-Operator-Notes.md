# SQL IN Operator – Notes

## 1. What Is the IN Operator?

The **IN** operator is used in the **WHERE** clause to test whether a column’s value matches **any** value in a given list.

- **IN** is a shorthand for multiple **OR** conditions, so queries are shorter and easier to read.

**Example:** All customers from Germany, France, or UK:

```sql
SELECT * FROM Customers
WHERE Country IN ('Germany', 'France', 'UK');
```

Same result using OR:

```sql
SELECT * FROM Customers
WHERE Country = 'Germany' OR Country = 'France' OR Country = 'UK';
```

---

## 2. Syntax

```sql
SELECT column_name(s)
FROM table_name
WHERE column_name IN (value1, value2, ...);
```

- List values in parentheses, separated by commas. For text, use quotes; for numbers, no quotes.

---

## 3. Demo Database: Customers Table (selection)

| CustomerID | CustomerName | ContactName | Address | City | PostalCode | Country |
|------------|--------------|-------------|---------|------|------------|---------|
| 1 | Alfreds Futterkiste | Maria Anders | Obere Str. 57 | Berlin | 12209 | Germany |
| 2 | Ana Trujillo Emparedados y helados | Ana Trujillo | Avda. de la Constitución 2222 | México D.F. | 05021 | Mexico |
| 3 | Antonio Moreno Taquería | Antonio Moreno | Mataderos 2312 | México D.F. | 05023 | Mexico |
| 4 | Around the Horn | Thomas Hardy | 120 Hanover Sq. | London | WA1 1DP | UK |
| 5 | Berglunds snabbköp | Christina Berglund | Berguvsvägen 8 | Luleå | S-958 22 | Sweden |

---

## 4. The NOT IN Operator

**NOT IN** returns rows where the column value is **not** any of the listed values.

**Example:** All customers **not** from Germany, France, or UK:

```sql
SELECT * FROM Customers
WHERE Country NOT IN ('Germany', 'France', 'UK');
```

---

## 5. IN with a Subquery (IN (SELECT))

You can use **IN** with a **subquery**: the list of values comes from another query.

**Example:** All customers who have at least one order in the Orders table:

```sql
SELECT * FROM Customers
WHERE CustomerID IN (SELECT CustomerID FROM Orders);
```

The subquery `(SELECT CustomerID FROM Orders)` returns a set of customer IDs; the main query returns customers whose ID is in that set.

---

## 6. NOT IN with a Subquery (NOT IN (SELECT))

**NOT IN (subquery)** returns rows that do **not** match any value from the subquery.

**Example:** All customers who have **no** orders in the Orders table:

```sql
SELECT * FROM Customers
WHERE CustomerID NOT IN (SELECT CustomerID FROM Orders);
```

If IN (SELECT CustomerID FROM Orders) returns 74 customers, then NOT IN returns the rest (e.g. 17 customers who haven’t placed any orders), depending on your data.

**Note:** If the subquery can return NULL, NOT IN can behave unexpectedly in some databases (NULL in the list can make NOT IN match no rows). Prefer EXISTS / NOT EXISTS or a subquery that excludes NULLs when needed.

---

## Quick Reference

| Goal | Example |
|------|---------|
| Match any in list | `WHERE Country IN ('Germany', 'France', 'UK');` |
| Exclude list | `WHERE Country NOT IN ('Germany', 'France', 'UK');` |
| Match subquery result | `WHERE CustomerID IN (SELECT CustomerID FROM Orders);` |
| Exclude subquery result | `WHERE CustomerID NOT IN (SELECT CustomerID FROM Orders);` |

**Remember:** IN (value1, value2, ...) is equivalent to multiple OR conditions; IN (SELECT ...) uses a subquery to supply the list.
