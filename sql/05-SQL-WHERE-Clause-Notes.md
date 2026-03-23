# SQL WHERE Clause – Notes

## 1. What is the WHERE Clause?

The **WHERE** clause is used to **filter records**.

- It returns only the rows that **satisfy a given condition**.
- It is used to **extract only those records** that fulfill a specific condition.

**Example:** Select all customers from Mexico:

```sql
SELECT * FROM Customers
WHERE Country = 'Mexico';
```

---

## 2. Syntax

```sql
SELECT column1, column2, ...
FROM table_name
WHERE condition;
```

**Note:** The WHERE clause is not only used in **SELECT**; it is also used in **UPDATE**, **DELETE**, and other statements.

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

## 4. Text Fields vs. Numeric Fields

| Field type | Quotes | Example |
|------------|--------|---------|
| **Text (string)** | Use **single quotes** (most systems also allow double quotes) | `WHERE Country = 'Mexico'` |
| **Numeric** | **No quotes** | `WHERE CustomerID = 1` |

**Example – numeric (no quotes):**

```sql
SELECT * FROM Customers
WHERE CustomerID = 1;
```

**Example – text (single quotes):**

```sql
SELECT * FROM Customers
WHERE Country = 'Mexico';
```

---

## 5. Operators in the WHERE Clause

You can use operators other than **=** to filter (e.g. greater than, less than, pattern match).

**Example:** Select all customers with a CustomerID **greater than** 80:

```sql
SELECT * FROM Customers
WHERE CustomerID > 80;
```

### Operators table

| Operator | Description | Example use |
|----------|-------------|-------------|
| **=** | Equal | `WHERE Country = 'Mexico'` |
| **>** | Greater than | `WHERE CustomerID > 80` |
| **<** | Less than | `WHERE CustomerID < 10` |
| **>=** | Greater than or equal | `WHERE CustomerID >= 5` |
| **<=** | Less than or equal | `WHERE CustomerID <= 100` |
| **<>** | Not equal *(in some SQL versions written as !=)* | `WHERE Country <> 'UK'` |
| **BETWEEN** | Between a certain range | `WHERE CustomerID BETWEEN 1 AND 10` |
| **LIKE** | Search for a pattern | `WHERE CustomerName LIKE 'A%'` |
| **IN** | Multiple possible values for a column | `WHERE Country IN ('Mexico', 'UK')` |

---

## Quick Reference

| Goal | Example |
|------|---------|
| Filter by text | `WHERE Country = 'Mexico'` (use single quotes) |
| Filter by number | `WHERE CustomerID = 1` (no quotes) |
| Compare numbers | `WHERE CustomerID > 80` |
| WHERE in other statements | Use with SELECT, UPDATE, DELETE, etc. |
