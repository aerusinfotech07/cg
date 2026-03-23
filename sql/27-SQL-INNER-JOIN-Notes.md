# SQL INNER JOIN – Notes

## 1. What Is INNER JOIN?

The **INNER JOIN** returns only rows that have **matching values in both** tables.

- Rows that exist in one table but have no matching row in the other table are **not** returned.
- **Tip:** You can write **JOIN** instead of **INNER JOIN**; INNER is the default join type.

---

## 2. Syntax

```sql
SELECT column_name(s)
FROM table1
INNER JOIN table2
ON table1.column_name = table2.column_name;
```

The **ON** clause specifies which columns link the two tables (usually a key in one table and a foreign key in the other).

---

## 3. INNER JOIN Example: Products and Categories

**Products** (one row):

| ProductID | ProductName   | CategoryID | Price  |
|-----------|---------------|------------|--------|
| 3         | Aniseed Syrup | 2          | 10.00  |

**Categories** (matching row):

| CategoryID | CategoryName | Description |
|------------|--------------|-------------|
| 2          | Condiments   | Sweet and savory sauces, relishes, spreads, and seasonings |

The relationship is the **CategoryID** column. Join Products and Categories on it:

```sql
SELECT ProductID, ProductName, CategoryName
FROM Products
INNER JOIN Categories ON Products.CategoryID = Categories.CategoryID;
```

**Note:** INNER JOIN returns only rows with a match in **both** tables. A product with no CategoryID, or a CategoryID not in the Categories table, would not appear in the result.

---

## 4. Naming the Columns (Table Prefix)

It is good practice to **prefix columns with the table name** (or table alias) in JOINs, especially when the same column name exists in more than one table.

**Example:**

```sql
SELECT Products.ProductID, Products.ProductName, Categories.CategoryName
FROM Products
INNER JOIN Categories ON Products.CategoryID = Categories.CategoryID;
```

- If you add **CategoryID** in the SELECT and do **not** specify the table (e.g. `Products.CategoryID` or `Categories.CategoryID`), the database cannot tell which table’s CategoryID you mean, and you may get an error. So for columns that appear in both tables, always use the table name (or alias).

---

## 5. JOIN vs INNER JOIN

**JOIN** and **INNER JOIN** return the same result. INNER is the default when you write JOIN.

**Example (equivalent):**

```sql
SELECT Products.ProductID, Products.ProductName, Categories.CategoryName
FROM Products
JOIN Categories ON Products.CategoryID = Categories.CategoryID;
```

---

## 6. Joining Multiple Tables

You can join **more than two tables** by chaining multiple **INNER JOIN** clauses.

**Example:** Orders with customer name and shipper name:

```sql
SELECT Orders.OrderID, Customers.CustomerName, Shippers.ShipperName
FROM Orders
INNER JOIN Customers ON Orders.CustomerID = Customers.CustomerID
INNER JOIN Shippers ON Orders.ShipperID = Shippers.ShipperID;
```

- First JOIN: Orders with Customers (on CustomerID).
- Second JOIN: result with Shippers (on ShipperID).

**Shippers table (sample):**

| ShipperID | ShipperName      | Phone           |
|-----------|------------------|-----------------|
| 1         | Speedy Express   | (503) 555-9831  |
| 2         | United Package  | (503) 555-3199  |
| 3         | Federal Shipping | (503) 555-9931  |

---

## Quick Reference

| Goal | Example |
|------|---------|
| Join two tables (match in both) | `FROM t1 INNER JOIN t2 ON t1.col = t2.col` |
| Same as INNER | Use `JOIN` instead of `INNER JOIN` |
| Avoid ambiguous columns | Use `table.column` (e.g. `Products.CategoryID`) |
| Join three (or more) tables | Add more `INNER JOIN ... ON ...` clauses |

**Remember:** INNER JOIN returns only rows that match in **both** (or all) tables. Use the table name when a column exists in more than one table.
