# SQL Wildcard Characters – Notes

## 1. What Are Wildcards?

A **wildcard character** substitutes for one or more characters in a string.

Wildcards are used with the **LIKE** operator in a **WHERE** clause to search for a **pattern** in a column.

**Example:** All customers whose name starts with 'a':

```sql
SELECT * FROM Customers
WHERE CustomerName LIKE 'a%';
```

---

## 2. Wildcard Characters Overview

| Symbol | Description | Database support |
|--------|-------------|------------------|
| **%** | Zero or more characters | Standard (SQL Server, MySQL, Oracle, etc.) |
| **_**(underscore) | Exactly one character | Standard |
| **[]** | Any single character **inside** the brackets | SQL Server, MS Access * |
| **^** | Any character **not** in the brackets | SQL Server, MS Access * |
| **-** | Any single character in a **range** (inside []) | SQL Server, MS Access * |
| **{}** | Escaped character | Oracle only ** |

\* **[]**, **^**, and **-** are **not** supported in PostgreSQL and MySQL. Use multiple LIKE conditions or other expressions instead.

\** **{}** is supported only in Oracle.

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

## 4. Using the % Wildcard

**%** stands for **any number of characters** (including zero).

**Example:** CustomerName **ends with** 'es':

```sql
SELECT * FROM Customers
WHERE CustomerName LIKE '%es';
```

**Example:** CustomerName **contains** 'mer':

```sql
SELECT * FROM Customers
WHERE CustomerName LIKE '%mer%';
```

---

## 5. Using the _ Wildcard

**_**(underscore) stands for **exactly one** character (any character).

**Example:** City starts with any one character, then 'ondon' (e.g. London):

```sql
SELECT * FROM Customers
WHERE City LIKE '_ondon';
```

**Example:** City starts with 'L', then any three characters, then 'on' (e.g. London):

```sql
SELECT * FROM Customers
WHERE City LIKE 'L___on';
```

---

## 6. Using the [] Wildcard (SQL Server / MS Access)

**[]** matches **any single character** listed inside the brackets.

**Example:** CustomerName starts with 'b', 's', or 'p' (SQL Server / MS Access):

```sql
SELECT * FROM Customers
WHERE CustomerName LIKE '[bsp]%';
```

**MySQL / PostgreSQL equivalent** (no []): use multiple LIKE conditions with OR:

```sql
SELECT * FROM Customers
WHERE CustomerName LIKE 'b%' OR CustomerName LIKE 's%' OR CustomerName LIKE 'p%';
```

---

## 7. Using the - Wildcard (Range inside [])

Inside **[]**, **-** defines a **range** of characters (e.g. a–f).

**Example:** CustomerName starts with 'a' through 'f' (SQL Server / MS Access):

```sql
SELECT * FROM Customers
WHERE CustomerName LIKE '[a-f]%';
```

**MySQL / PostgreSQL:** use multiple conditions or other string functions; [] and - are not supported in LIKE.

---

## 8. Combining Wildcards

Use **%** and **_ ** together in one pattern.

**Example:** CustomerName starts with 'a' and has at least 3 characters:

```sql
SELECT * FROM Customers
WHERE CustomerName LIKE 'a__%';
```

**Example:** CustomerName has 'r' in the **second** position:

```sql
SELECT * FROM Customers
WHERE CustomerName LIKE '_r%';
```

---

## 9. Without Wildcards

If the pattern has **no** wildcards, LIKE requires an **exact match** (subject to collation).

**Example:** Country is exactly 'Spain':

```sql
SELECT * FROM Customers
WHERE Country LIKE 'Spain';
```

For simple equality, `WHERE Country = 'Spain'` is equivalent.

---

## Quick Reference

| Goal | Pattern (standard) | Example |
|------|-------------------|---------|
| Starts with | `'x%'` | `LIKE 'a%'` |
| Ends with | `'%x'` | `LIKE '%es'` |
| Contains | `'%x%'` | `LIKE '%mer%'` |
| One char then text | `'_text'` | `LIKE '_ondon'` |
| One of several first chars | `[bsp]%` (SQL Server) | `LIKE '[bsp]%'` |
| Range of first chars | `[a-f]%` (SQL Server) | `LIKE '[a-f]%'` |
| Exact match | no wildcards | `LIKE 'Spain'` |

**Remember:** **%** = any number of characters; **_ ** = one character. **[]** and **-** are database-specific (e.g. SQL Server, not MySQL/PostgreSQL).
