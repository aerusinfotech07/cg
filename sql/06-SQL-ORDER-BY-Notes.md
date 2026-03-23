# SQL ORDER BY Keyword – Notes

## 1. What is ORDER BY?

The **ORDER BY** keyword is used to **sort the result-set** in ascending or descending order.

- **Default:** Sorts in **ascending order (ASC)** if you do not specify ASC or DESC.

**Example:** Sort products from lowest to highest price:

```sql
SELECT * FROM Products
ORDER BY Price;
```

---

## 2. Syntax

```sql
SELECT column1, column2, ...
FROM table_name
ORDER BY column1, column2, ... ASC|DESC;
```

- List one or more columns to sort by.
- **ASC** = ascending (default).  
- **DESC** = descending.

---

## 3. Demo Database: Products Table

| ProductID | ProductName | SupplierID | CategoryID | Unit | Price |
|-----------|-------------|------------|------------|------|-------|
| 1 | Chais | 1 | 1 | 10 boxes x 20 bags | 18 |
| 2 | Chang | 1 | 1 | 24 - 12 oz bottles | 19 |
| 3 | Aniseed Syrup | 1 | 2 | 12 - 550 ml bottles | 10 |
| 4 | Chef Anton's Cajun Seasoning | 2 | 2 | 48 - 6 oz jars | 22 |
| 5 | Chef Anton's Gumbo Mix | 2 | 2 | 36 boxes | 21.35 |

---

## 4. ORDER BY DESC (Descending)

To sort in **descending** order, use the **DESC** keyword.

**Example:** Sort products from highest to lowest price:

```sql
SELECT * FROM Products
ORDER BY Price DESC;
```

---

## 5. Order Alphabetically (Strings)

For **text/string** columns, ORDER BY sorts **alphabetically** (A–Z when ascending).

**Example:** Sort the `ProductName` column in alphabetical order:

```sql
SELECT * FROM Products
ORDER BY ProductName;
```

---

## 6. Alphabetically DESC

To sort text in **reverse alphabetical order** (Z–A), use **DESC**:

**Example:** Sort `ProductName` in descending alphabetical order:

```sql
SELECT * FROM Products
ORDER BY ProductName DESC;
```

---

## 7. ORDER BY Several Columns

You can sort by **more than one column**. The result is sorted by the **first** column; then rows with the same value in that column are sorted by the **second** column, and so on.

**Example:** Select all from `Customers`, sort by `Country` first, then by `CustomerName`:

```sql
SELECT * FROM Customers
ORDER BY Country, CustomerName;
```

- First: order by Country (e.g. Germany, Mexico, UK).
- Then: within the same Country, order by CustomerName.

---

## 8. Combine ASC and DESC

Each column can have its **own** sort direction.

**Example:** Sort by `Country` **ASC** and by `CustomerName` **DESC**:

```sql
SELECT * FROM Customers
ORDER BY Country ASC, CustomerName DESC;
```

- Countries in ascending order (A–Z).
- Within each country, customer names in descending order (Z–A).

---

## Quick Reference

| Goal | Example |
|------|---------|
| Sort ascending (default) | `ORDER BY Price` or `ORDER BY Price ASC` |
| Sort descending | `ORDER BY Price DESC` |
| Sort text A–Z | `ORDER BY ProductName` or `ORDER BY ProductName ASC` |
| Sort text Z–A | `ORDER BY ProductName DESC` |
| Sort by multiple columns | `ORDER BY Country, CustomerName` |
| Mixed ASC/DESC | `ORDER BY Country ASC, CustomerName DESC` |
