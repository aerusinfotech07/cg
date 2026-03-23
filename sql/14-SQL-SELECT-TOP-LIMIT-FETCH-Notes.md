# SQL SELECT TOP, LIMIT, and FETCH FIRST – Notes

## 1. What Are They For?

**SELECT TOP**, **LIMIT**, and **FETCH FIRST** are used to **limit the number of rows** returned by a query.

- Useful on large tables: returning fewer rows can improve performance.
- Different databases use different syntax; the idea is the same: “return only the first N rows.”

**Note:** Not all systems support the same clause. Common variants:
- **SQL Server / MS Access** – `SELECT TOP number|percent ...`
- **MySQL** – `LIMIT number`
- **Oracle 12+** – `FETCH FIRST number ROWS ONLY`

---

## 2. Syntax by Database

### SQL Server / MS Access

```sql
SELECT TOP number|percent column_name(s)
FROM table_name
WHERE condition;
```

### MySQL

```sql
SELECT column_name(s)
FROM table_name
WHERE condition
LIMIT number;
```

### Oracle 12+

```sql
SELECT column_name(s)
FROM table_name
ORDER BY column_name(s)
FETCH FIRST number ROWS ONLY;
```

*(In Oracle, FETCH FIRST is typically used with ORDER BY so “first” is well-defined.)*

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

## 4. First N Rows – Equivalent Examples

**SQL Server / MS Access:** First 3 records

```sql
SELECT TOP 3 * FROM Customers;
```

**MySQL:** First 3 records

```sql
SELECT * FROM Customers
LIMIT 3;
```

**Oracle:** First 3 records

```sql
SELECT * FROM Customers
FETCH FIRST 3 ROWS ONLY;
```

---

## 5. TOP PERCENT (SQL Server / MS Access, Oracle)

Return a **percentage** of rows instead of a fixed count.

**SQL Server / MS Access:** First 50% of rows

```sql
SELECT TOP 50 PERCENT * FROM Customers;
```

**Oracle:** First 50% of rows

```sql
SELECT * FROM Customers
FETCH FIRST 50 PERCENT ROWS ONLY;
```

*(MySQL does not have a built-in “TOP PERCENT”; you would use a subquery or application logic.)*

---

## 6. With WHERE Clause

Limit applies to the **filtered** result set.

**SQL Server / MS Access:** First 3 customers where Country is Germany

```sql
SELECT TOP 3 * FROM Customers
WHERE Country = 'Germany';
```

**MySQL:**

```sql
SELECT * FROM Customers
WHERE Country = 'Germany'
LIMIT 3;
```

**Oracle:**

```sql
SELECT * FROM Customers
WHERE Country = 'Germany'
FETCH FIRST 3 ROWS ONLY;
```

---

## 7. With ORDER BY (Recommended for “First N”)

Without ORDER BY, “first” rows are not guaranteed to be in a meaningful order. Use **ORDER BY** when you want the “first N” according to some sort order.

**Example:** Sort by CustomerName descending, then take the first 3.

**SQL Server / MS Access:**

```sql
SELECT TOP 3 * FROM Customers
ORDER BY CustomerName DESC;
```

**MySQL:**

```sql
SELECT * FROM Customers
ORDER BY CustomerName DESC
LIMIT 3;
```

**Oracle:**

```sql
SELECT * FROM Customers
ORDER BY CustomerName DESC
FETCH FIRST 3 ROWS ONLY;
```

---

## Quick Reference

| Database        | Limit N rows     | Limit by percent | With WHERE / ORDER BY      |
|----------------|------------------|------------------|----------------------------|
| SQL Server / MS Access | `SELECT TOP 3 * FROM t` | `SELECT TOP 50 PERCENT * FROM t` | Same; WHERE/ORDER BY before semicolon |
| MySQL          | `... LIMIT 3`    | (no built-in)    | `WHERE ... ORDER BY ... LIMIT 3` |
| Oracle 12+     | `... FETCH FIRST 3 ROWS ONLY` | `... FETCH FIRST 50 PERCENT ROWS ONLY` | ORDER BY usually before FETCH FIRST |

**Remember:** For a meaningful “first N,” use **ORDER BY** so the order is defined.
