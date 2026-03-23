# SQL Comments – Notes

## 1. What Are Comments For?

**Comments** in SQL are used to:

- **Explain** parts of a statement or script (for people reading the code).
- **Disable** execution of one or more statements (e.g. while testing or debugging).

**Note:** Comments are **not supported** in **Microsoft Access** databases.

---

## 2. Single-Line Comments

Single-line comments start with **`--`** (two hyphens).

Everything from **`--`** to the **end of that line** is ignored and not executed.

**Example — comment as explanation:**

```sql
-- Select all:
SELECT * FROM Customers;
```

**Example — comment out the rest of a line:**

```sql
SELECT * FROM Customers -- WHERE City='Berlin';
```

**Example — comment out a whole statement:**

```sql
-- SELECT * FROM Customers;
SELECT * FROM Products;
```

---

## 3. Multi-Line Comments

Multi-line comments start with **`/*`** and end with **`*/`**.

Everything **between** `/*` and `*/` is ignored, even across multiple lines.

**Example — comment as explanation:**

```sql
/*Select all the columns
of all the records
in the Customers table:*/
SELECT * FROM Customers;
```

**Example — comment out several statements:**

```sql
/*SELECT * FROM Customers;
SELECT * FROM Products;
SELECT * FROM Orders;
SELECT * FROM Categories;*/
SELECT * FROM Suppliers;
```

**Example — comment out part of a line:**

```sql
SELECT CustomerName, /*City,*/ Country FROM Customers;
```

**Example — comment out part of a statement:**

```sql
SELECT * FROM Customers WHERE (CustomerName LIKE 'L%'
OR CustomerName LIKE 'R%' /*OR CustomerName LIKE 'S%'
OR CustomerName LIKE 'T%'*/ OR CustomerName LIKE 'W%')
AND Country='USA'
ORDER BY CustomerName;
```

---

## Quick Reference

| Style    | Syntax     | Use |
|----------|------------|-----|
| Single-line | `-- text` | From `--` to end of line; one line only. |
| Multi-line  | `/* text */` | Any number of lines between `/*` and `*/`. |

**Remember:** Use `--` for short, single-line notes; use `/* ... */` for longer blocks or to disable multiple statements. Comments are not supported in MS Access.
