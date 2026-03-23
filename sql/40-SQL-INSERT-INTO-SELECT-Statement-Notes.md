# SQL INSERT INTO SELECT Statement – Notes

## 1. What Is INSERT INTO SELECT?

The **INSERT INTO SELECT** statement **copies data** from an existing table (or query result) and **inserts it into another existing table**.

- The **target table** must already exist. Only **new rows** are added; existing rows in the target table are **not** changed or deleted.
- **Data types** (and ideally column order/count) in the source and target must be **compatible** for the columns you are copying.

---

## 2. Syntax

**Copy all columns from one table to another:**

```sql
INSERT INTO target_table
SELECT * FROM source_table
WHERE condition;
```

**Note:** If you omit column names, the **number and order** of columns in the target table must match the SELECT list (and thus the source). Otherwise, list columns explicitly.

**Copy only some columns:**

```sql
INSERT INTO target_table (column1, column2, column3, ...)
SELECT column1, column2, column3, ...
FROM source_table
WHERE condition;
```

- The list of columns after **INSERT INTO target_table** must match the **number, order, and compatible types** of the columns in the SELECT list.

---

## 3. Demo Database (selection)

**Customers**

| CustomerID | CustomerName | ContactName | Address | City | PostalCode | Country |
|------------|--------------|-------------|---------|------|------------|---------|
| 1 | Alfreds Futterkiste | Maria Anders | Obere Str. 57 | Berlin | 12209 | Germany |
| 2 | Ana Trujillo Emparedados y helados | Ana Trujillo | Avda. de la Constitución 2222 | México D.F. | 05021 | Mexico |
| 3 | Antonio Moreno Taquería | Antonio Moreno | Mataderos 2312 | México D.F. | 05023 | Mexico |

**Suppliers**

| SupplierID | SupplierName | ContactName | Address | City | PostalCode | Country |
|------------|--------------|-------------|---------|------|------------|---------|
| 1 | Exotic Liquid | Charlotte Cooper | 49 Gilbert St. | London | EC1 4SD | UK |
| 2 | New Orleans Cajun Delights | Shelley Burke | P.O. Box 78934 | New Orleans | 70117 | USA |
| 3 | Grandma Kelly's Homestead | Regina Murphy | 707 Oxford Rd. | Ann Arbor | 48104 | USA |

---

## 4. INSERT INTO SELECT Examples

**Copy selected columns from Suppliers into Customers** (only CustomerName, City, Country filled; other columns in Customers get NULL or default):

```sql
INSERT INTO Customers (CustomerName, City, Country)
SELECT SupplierName, City, Country FROM Suppliers;
```

**Copy all columns from Suppliers into Customers** (target table must have the same number and compatible types of columns in the same order):

```sql
INSERT INTO Customers
SELECT * FROM Suppliers;
```

**Copy only German suppliers into Customers** (selected columns, with filter):

```sql
INSERT INTO Customers (CustomerName, City, Country)
SELECT SupplierName, City, Country FROM Suppliers
WHERE Country = 'Germany';
```

---

## 5. INSERT INTO SELECT vs SELECT INTO

| Statement | Target | Use |
|-----------|--------|-----|
| **INSERT INTO SELECT** | **Existing** table | Add rows from another table (or query) into a table that already exists. |
| **SELECT INTO** (SQL Server, etc.) | **New** table | Create a new table and fill it in one step. |

---

## Quick Reference

| Goal | Example |
|------|---------|
| Copy all columns | `INSERT INTO target SELECT * FROM source WHERE condition;` |
| Copy selected columns | `INSERT INTO target (col1, col2) SELECT col1, col2 FROM source;` |
| Copy with filter | `INSERT INTO target (col1, col2) SELECT col1, col2 FROM source WHERE condition;` |
| Match types and order | Source and target columns must be compatible; list columns explicitly when structures differ. |

**Remember:** INSERT INTO SELECT adds rows to an **existing** table; data types (and column order when using *) must match.
