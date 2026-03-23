# SQL Working With Dates – Notes

## 1. The Main Challenge

When working with dates in SQL:

- The **format** of the value you insert or compare should match what the database expects for that column (or use a format the database accepts).
- If the column stores **date and time**, comparisons can be tricky: a condition like `OrderDate = '2008-11-11'` may not match rows that have a time component (e.g. `2008-11-11 13:23:44`), depending on how the database compares date/time values.

So: match the format for the column type, and be clear whether you are dealing with **date only** or **date and time**.

---

## 2. Date Data Types

**MySQL** — common types for storing date or date/time:

| Type | Format |
|------|--------|
| **DATE** | YYYY-MM-DD |
| **DATETIME** | YYYY-MM-DD HH:MI:SS |
| **TIMESTAMP** | YYYY-MM-DD HH:MI:SS |
| **YEAR** | YYYY or YY |

**SQL Server** — common types:

| Type | Format / notes |
|------|-----------------|
| **DATE** | YYYY-MM-DD |
| **DATETIME** | YYYY-MM-DD HH:MI:SS |
| **SMALLDATETIME** | YYYY-MM-DD HH:MI:SS (smaller range) |
| **TIMESTAMP** | A unique number (not date/time display) |

The **date type** is chosen when you **create the table** (CREATE TABLE). Use the type that fits your need (date only vs date and time).

---

## 3. Working With Dates (Date Only)

**Orders table (date only):**

| OrderId | ProductName | OrderDate   |
|---------|-------------|-------------|
| 1       | Geitost     | 2008-11-11  |
| 2       | Camembert Pierrot | 2008-11-09  |
| 3       | Mozzarella di Giovanni | 2008-11-11  |
| 4       | Mascarpone Fabioli | 2008-10-29  |

Select rows where **OrderDate** is **2008-11-11**:

```sql
SELECT * FROM Orders WHERE OrderDate = '2008-11-11';
```

**Result:** Rows with OrderId 1 and 3. When the column has **no time portion**, comparing with a date string like `'2008-11-11'` works as expected.

---

## 4. When a Time Portion Is Stored

**Orders table (with time):**

| OrderId | ProductName | OrderDate            |
|---------|-------------|----------------------|
| 1       | Geitost     | 2008-11-11 13:23:44  |
| 2       | Camembert Pierrot | 2008-11-09 15:45:21  |
| 3       | Mozzarella di Giovanni | 2008-11-11 11:12:01  |
| 4       | Mascarpone Fabioli | 2008-10-29 14:56:59  |

The same query:

```sql
SELECT * FROM Orders WHERE OrderDate = '2008-11-11';
```

may return **no rows** in many databases, because the stored values are date**time** (e.g. `2008-11-11 13:23:44`), not exactly `2008-11-11` with no time.

**Tip:** To keep queries simple, avoid storing a time component if you only care about the date. If you do store time, filter by **date range** or use **date functions** (e.g. cast to date, or `DATE(OrderDate) = '2008-11-11'` where supported):

```sql
-- Example: all orders on 2008-11-11 (MySQL)
SELECT * FROM Orders WHERE DATE(OrderDate) = '2008-11-11';

-- Or use a range (works in most databases)
SELECT * FROM Orders WHERE OrderDate >= '2008-11-11' AND OrderDate < '2008-11-12';
```

---

## Quick Reference

| Situation | Suggestion |
|-----------|------------|
| Column is date only | Use `WHERE date_column = 'YYYY-MM-DD'`. |
| Column is date+time, you want one day | Use a range: `>= 'YYYY-MM-DD' AND < 'YYYY-MM-DD' + 1 day`, or a date function (e.g. `DATE(col)`) if your DB supports it. |
| Inserting dates | Use the format expected by the column type (e.g. YYYY-MM-DD for DATE). |
| Choosing type | Use DATE when you only need the day; use DATETIME/TIMESTAMP when you need time. |

**Remember:** Match the date format to the column type, and decide whether you need date only or date and time so comparisons behave as you expect.
