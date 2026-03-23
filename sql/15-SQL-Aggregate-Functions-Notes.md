# SQL Aggregate Functions – Notes

## 1. What Are Aggregate Functions?

An **aggregate function** performs a **calculation on a set of values** and **returns a single value**.

- They operate on many rows (or a group of rows) and produce one result (e.g. total, average, count).
- They are often used with the **GROUP BY** clause: GROUP BY splits the result set into groups, and the aggregate returns one value **per group**.

---

## 2. Commonly Used SQL Aggregate Functions

| Function   | Description                                      |
|-----------|---------------------------------------------------|
| **MIN()** | Returns the **smallest** value in a column         |
| **MAX()** | Returns the **largest** value in a column         |
| **COUNT()** | Returns the **number of rows** in a set         |
| **SUM()** | Returns the **sum** of a numeric column           |
| **AVG()** | Returns the **average** value of a numeric column |

These are covered in more detail in the following notes chapters.

---

## 3. NULL Handling

- **Aggregate functions ignore NULL values** when computing (e.g. SUM, AVG, MIN, MAX).
- **Exception:** **COUNT(\*)** counts **all** rows, including those with NULLs in any column.  
  **COUNT(column_name)** counts only non-NULL values in that column.

---

## 4. With and Without GROUP BY

- **Without GROUP BY:** The whole result set is one “group”; you get a single aggregate value.
- **With GROUP BY:** Rows are split into groups (e.g. by country); you get one aggregate value **per group**.

Example (single value for whole table):

```sql
SELECT COUNT(*) FROM Customers;
SELECT AVG(Price) FROM Products;
```

Example (one value per group):

```sql
SELECT Country, COUNT(*) FROM Customers GROUP BY Country;
```

---

## Quick Reference

| Function   | Use for                          | Ignores NULL?     |
|-----------|-----------------------------------|--------------------|
| MIN(column) | Smallest value                  | Yes                |
| MAX(column) | Largest value                   | Yes                |
| COUNT(*)  | Number of rows (all rows)        | No (counts all)    |
| COUNT(column) | Number of non-NULL values    | Yes (ignores NULL) |
| SUM(column) | Total of numeric column        | Yes                |
| AVG(column) | Average of numeric column      | Yes                |

**Remember:** Aggregates work on a set of values and return one value (per group when used with GROUP BY).
