# SQL SELECT DISTINCT Statement – Notes

## 1. What is SELECT DISTINCT?

The **SELECT DISTINCT** statement returns only **distinct (unique)** values.

- A column can have **many duplicate values**.
- Sometimes you only want to **list the distinct values** (no duplicates).

**Example:** Select all distinct (unique) countries from the `"Customers"` table:

```sql
SELECT DISTINCT Country FROM Customers;
```

---

## 2. Syntax

```sql
SELECT DISTINCT column1, column2, ...
FROM table_name;
```

You can use one or more columns. Duplicate **combinations** of those columns are removed from the result.

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

## 4. With vs Without DISTINCT

### Without DISTINCT

- If you **omit** the `DISTINCT` keyword, the query returns the column value from **every row** (duplicates included).

```sql
SELECT Country FROM Customers;
```

- Result: one row per customer; the same country can appear many times.

### With DISTINCT

```sql
SELECT DISTINCT Country FROM Customers;
```

- Result: **one row per unique country**; duplicates are removed.

---

## 5. Count Distinct Values

Use **COUNT(DISTINCT column_name)** to get the **number of unique values** in a column.

**Example:** Count the number of unique countries:

```sql
SELECT COUNT(DISTINCT Country) FROM Customers;
```

---

## 6. MS Access Note

**COUNT(DISTINCT column_name)** is **not supported** in Microsoft Access.

**Workaround for MS Access:** Use a subquery that returns distinct values, then count the rows:

```sql
SELECT Count(*) AS DistinctCountries
FROM (SELECT DISTINCT Country FROM Customers);
```

- Inner query: `SELECT DISTINCT Country FROM Customers` → list of unique countries.
- Outer query: `Count(*)` → number of rows in that list (= number of distinct countries).

---

## Quick Reference

| Goal | SQL |
|------|-----|
| List unique values (one column) | `SELECT DISTINCT column_name FROM table_name;` |
| List unique combinations (multiple columns) | `SELECT DISTINCT col1, col2 FROM table_name;` |
| Count unique values | `SELECT COUNT(DISTINCT column_name) FROM table_name;` |
| Count distinct in MS Access | `SELECT Count(*) AS Alias FROM (SELECT DISTINCT column_name FROM table_name);` |
