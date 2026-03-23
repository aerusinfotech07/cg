# SQL COUNT() Function – Notes

## 1. What Does COUNT() Do?

The **COUNT()** function returns the **number of rows** that match a specified criterion.

The behavior depends on the argument inside the parentheses:

| Form | Behavior |
|------|----------|
| **COUNT(\*)** | Counts the **total number of rows** in the table (includes rows with NULL in any column). |
| **COUNT(column_name)** | Counts only **non-NULL** values in that column. |
| **COUNT(DISTINCT column_name)** | Counts only **unique, non-NULL** values in that column (duplicates counted once). |

---

## 2. Syntax

```sql
SELECT COUNT([DISTINCT] column_name | *)
FROM table_name
WHERE condition;
```

- **WHERE** is optional; use it to count only rows that satisfy a condition.

---

## 3. Demo Database: Products Table (selection)

| ProductID | ProductName | SupplierID | CategoryID | Unit | Price |
|-----------|-------------|------------|------------|------|-------|
| 1 | Chais | 1 | 1 | 10 boxes x 20 bags | 18.00 |
| 2 | Chang | 1 | 1 | 24 - 12 oz bottles | 19.00 |
| 3 | Aniseed Syrup | 1 | 2 | 12 - 550 ml bottles | 10.00 |
| 4 | Chef Anton's Cajun Seasoning | 2 | 2 | 48 - 6 oz jars | 22.00 |
| 5 | Chef Anton's Gumbo Mix | 2 | 2 | 36 boxes | 21.35 |

---

## 4. Using COUNT(*)

Counts the **total number of rows** in the table (including rows with NULLs).

```sql
SELECT COUNT(*)
FROM Products;
```

---

## 5. Using COUNT(column_name)

Counts only **non-NULL** values in the specified column.

**Example:** Count non-null ProductName values:

```sql
SELECT COUNT(ProductName)
FROM Products;
```

---

## 6. Using COUNT(DISTINCT column_name)

Counts only **unique, non-NULL** values; duplicate values in the column are counted once.

**Example:** How many different prices are in the Products table?

```sql
SELECT COUNT(DISTINCT Price)
FROM Products;
```

---

## 7. Add a WHERE Clause

Restrict which rows are counted by adding **WHERE**:

**Example:** Count products where Price is greater than 20:

```sql
SELECT COUNT(ProductID)
FROM Products
WHERE Price > 20;
```

(You can use COUNT(*) or any non-NULL column; COUNT(ProductID) counts rows where ProductID is not NULL, which is typically all rows if ProductID is the primary key.)

---

## 8. Use an Alias

Give the count column a descriptive name with **AS**:

```sql
SELECT COUNT(*) AS [Number of records]
FROM Products;
```

*(Some databases use double quotes or backticks for names with spaces; `[Number of records]` is SQL Server / MS Access style.)*

---

## 9. COUNT() with GROUP BY

Use **GROUP BY** to get a **count per group** (e.g. per category).

**Example:** Number of records (products) for each category:

```sql
SELECT COUNT(*) AS [Number of records], CategoryID
FROM Products
GROUP BY CategoryID;
```

You get one row per CategoryID with that category’s row count.

---

## Quick Reference

| Goal | Example |
|------|---------|
| Total rows in table | `SELECT COUNT(*) FROM Products;` |
| Non-NULL values in a column | `SELECT COUNT(ProductName) FROM Products;` |
| Unique values in a column | `SELECT COUNT(DISTINCT Price) FROM Products;` |
| Count with condition | `SELECT COUNT(ProductID) FROM Products WHERE Price > 20;` |
| Name the count column | `SELECT COUNT(*) AS [Number of records] FROM Products;` |
| Count per group | `SELECT COUNT(*) AS [Number of records], CategoryID FROM Products GROUP BY CategoryID;` |

**Remember:** COUNT(*) counts all rows; COUNT(column) counts non-NULLs; COUNT(DISTINCT column) counts unique non-NULLs.
