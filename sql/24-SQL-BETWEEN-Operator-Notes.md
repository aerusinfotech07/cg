# SQL BETWEEN Operator – Notes

## 1. What Is the BETWEEN Operator?

The **BETWEEN** operator is used in the **WHERE** clause to select values **within a specified range**.

- The range is **inclusive**: both the start and end values are included.
- Values can be **numbers**, **text**, or **dates**.

**Example:** All products with a price between 10 and 20 (including 10 and 20):

```sql
SELECT * FROM Products
WHERE Price BETWEEN 10 AND 20;
```

---

## 2. Syntax

```sql
SELECT column_name(s)
FROM table_name
WHERE column_name BETWEEN value1 AND value2;
```

- **value1** must be the lower bound and **value2** the upper bound (for numbers and dates). For text, order depends on collation (usually alphabetical).

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

## 4. NOT BETWEEN

**NOT BETWEEN** selects values **outside** the range (strictly less than value1 or strictly greater than value2).

**Example:** All products with a price **not** between 10 and 20:

```sql
SELECT * FROM Products
WHERE Price NOT BETWEEN 10 AND 20;
```

---

## 5. BETWEEN with IN

You can combine **BETWEEN** with **AND** and **IN** in the same WHERE clause.

**Example:** Products with price between 10 and 20 **and** CategoryID in (1, 2, 3):

```sql
SELECT * FROM Products
WHERE Price BETWEEN 10 AND 20
AND CategoryID IN (1, 2, 3);
```

---

## 6. BETWEEN with Text Values

For text, BETWEEN uses **alphabetical** (collation) order. Rows are included when the column value is between the two strings.

**Example:** ProductName alphabetically between 'Carnarvon Tigers' and 'Mozzarella di Giovanni':

```sql
SELECT * FROM Products
WHERE ProductName BETWEEN 'Carnarvon Tigers' AND 'Mozzarella di Giovanni'
ORDER BY ProductName;
```

**Example:** ProductName between 'Carnarvon Tigers' and 'Chef Anton's Cajun Seasoning' (escape an apostrophe in a string with two single quotes `''`):

```sql
SELECT * FROM Products
WHERE ProductName BETWEEN 'Carnarvon Tigers' AND 'Chef Anton''s Cajun Seasoning'
ORDER BY ProductName;
```

---

## 7. NOT BETWEEN with Text

**Example:** ProductName **not** alphabetically between the two names:

```sql
SELECT * FROM Products
WHERE ProductName NOT BETWEEN 'Carnarvon Tigers' AND 'Mozzarella di Giovanni'
ORDER BY ProductName;
```

---

## 8. BETWEEN with Dates

BETWEEN is often used for **date ranges**. Use the format your database expects (e.g. **'YYYY-MM-DD'**).

**Example:** All orders placed in July 1996:

```sql
SELECT * FROM Orders
WHERE OrderDate BETWEEN '1996-07-01' AND '1996-07-31';
```

**Sample Orders table (selection):**

| OrderID | CustomerID | EmployeeID | OrderDate | ShipperID |
|---------|------------|-------------|-----------|-----------|
| 10248 | 90 | 5 | 1996-07-04 | 3 |
| 10249 | 81 | 6 | 1996-07-05 | 1 |
| 10250 | 34 | 4 | 1996-07-08 | 2 |
| 10251 | 84 | 3 | 1996-07-08 | 1 |
| 10252 | 76 | 4 | 1996-07-09 | 2 |

---

## Quick Reference

| Goal | Example |
|------|---------|
| Numeric range (inclusive) | `WHERE Price BETWEEN 10 AND 20` |
| Outside range | `WHERE Price NOT BETWEEN 10 AND 20` |
| Combine with IN | `WHERE Price BETWEEN 10 AND 20 AND CategoryID IN (1,2,3)` |
| Text range (alphabetical) | `WHERE ProductName BETWEEN 'A' AND 'M' ORDER BY ProductName` |
| Date range | `WHERE OrderDate BETWEEN '1996-07-01' AND '1996-07-31'` |

**Remember:** BETWEEN is **inclusive** on both ends. For dates, match your database’s date format.
