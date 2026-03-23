# SQL NULL Values – Notes

## 1. What is a NULL Value?

If a column in a table is **optional**, you can insert or update a row **without** giving a value for that column. The column is then stored as **NULL**.

- A **NULL** value means the data is **unknown**, **missing**, or **not applicable**.
- NULL is **not** a value (like 0 or `''`); it is a **placeholder** for “no value.”

**Important:** NULL is **different from**:
- **Zero (0)** – a numeric value
- **Empty string (`''`)** – a string value

A column that is NULL is one that was **left blank** when the record was created (or explicitly set to NULL).

---

## 2. How to Test for NULL Values?

You **cannot** test for NULL with normal comparison operators such as `=`, `<`, `>`, or `<>`.

Use these operators instead:
- **IS NULL** – the column has no value (is NULL)
- **IS NOT NULL** – the column has some value (is not NULL)

---

## 3. Syntax

### IS NULL

```sql
SELECT column_names
FROM table_name
WHERE column_name IS NULL;
```

### IS NOT NULL

```sql
SELECT column_names
FROM table_name
WHERE column_name IS NOT NULL;
```

---

## 4. Demo Database: Customers Table (selection)

| CustomerID | CustomerName | ContactName | Address | City | PostalCode | Country |
|------------|--------------|-------------|---------|------|------------|---------|
| 1 | Alfreds Futterkiste | Maria Anders | Obere Str. 57 | Berlin | 12209 | Germany |
| 2 | Ana Trujillo Emparedados y helados | Ana Trujillo | Avda. de la Constitución 2222 | México D.F. | 05021 | Mexico |
| 3 | Antonio Moreno Taquería | Antonio Moreno | Mataderos 2312 | México D.F. | 05023 | Mexico |
| 4 | Around the Horn | Thomas Hardy | 120 Hanover Sq. | London | WA1 1DP | UK |
| 5 | Berglunds snabbköp | Christina Berglund | Berguvsvägen 8 | Luleå | S-958 22 | Sweden |

---

## 5. The IS NULL Operator

Use **IS NULL** to find rows where a column has **no value** (NULL).

**Example:** List customers where the "Address" field is NULL:

```sql
SELECT CustomerName, ContactName, Address
FROM Customers
WHERE Address IS NULL;
```

**Tip:** Always use **IS NULL** (and **IS NOT NULL**) to test for NULL—do **not** use `= NULL` or `<> NULL`.

---

## 6. The IS NOT NULL Operator

Use **IS NOT NULL** to find rows where a column **has** a value (is not NULL).

**Example:** List customers where the "Address" field is not empty:

```sql
SELECT CustomerName, ContactName, Address
FROM Customers
WHERE Address IS NOT NULL;
```

---

## Quick Reference

| Goal | Example |
|------|---------|
| Find rows where column is missing/unknown | `WHERE column_name IS NULL` |
| Find rows where column has a value | `WHERE column_name IS NOT NULL` |
| Wrong (does not work as intended) | `WHERE column_name = NULL` or `WHERE column_name <> NULL` |

**Remember:** NULL means “no value”; use **IS NULL** and **IS NOT NULL** to test it.
