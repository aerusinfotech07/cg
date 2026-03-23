# SQL GROUP BY Statement – Notes

## 1. What Is GROUP BY?

The **GROUP BY** statement groups rows that have the **same values** in specified columns into **summary rows**.

- Typical use: “Find the number of customers in each country,” “Total sales per product,” etc.
- **GROUP BY** is almost always used with **aggregate functions** such as **COUNT()**, **MAX()**, **MIN()**, **SUM()**, **AVG()**, which are computed **per group**.

---

## 2. Syntax

```sql
SELECT column1, aggregate_function(column2), column3, ...
FROM table_name
WHERE condition
GROUP BY column1, column3
ORDER BY column_name;
```

- **GROUP BY** lists the columns (or expressions) that define each group. Non-aggregated columns in the SELECT list must appear in GROUP BY (in standard SQL).
- **WHERE** filters rows **before** grouping.
- **ORDER BY** sorts the final result.

---

## 3. Demo Database: Customers (selection)

| CustomerID | CustomerName | ContactName | Address | City | PostalCode | Country |
|------------|--------------|-------------|---------|------|------------|---------|
| 1 | Alfreds Futterkiste | Maria Anders | Obere Str. 57 | Berlin | 12209 | Germany |
| 2 | Ana Trujillo Emparedados y helados | Ana Trujillo | Avda. de la Constitución 2222 | México D.F. | 05021 | Mexico |
| 3 | Antonio Moreno Taquería | Antonio Moreno | Mataderos 2312 | México D.F. | 05023 | Mexico |
| 4 | Around the Horn | Thomas Hardy | 120 Hanover Sq. | London | WA1 1DP | UK |
| 5 | Berglunds snabbköp | Christina Berglund | Berguvsvägen 8 | Luleå | S-958 22 | Sweden |

---

## 4. GROUP BY Examples: Customers per Country

**Number of customers in each country:**

```sql
SELECT Country, COUNT(CustomerID) AS [Number of Customers]
FROM Customers
GROUP BY Country;
```

**Same, sorted from high to low by count:**

```sql
SELECT Country, COUNT(CustomerID) AS [Number of Customers]
FROM Customers
GROUP BY Country
ORDER BY COUNT(CustomerID) DESC;
```

---

## 5. Demo Database: Orders and Shippers (selection)

**Orders**

| OrderID | CustomerID | EmployeeID | OrderDate | ShipperID |
|---------|------------|------------|-----------|-----------|
| 10248 | 90 | 5 | 1996-07-04 | 3 |
| 10249 | 81 | 6 | 1996-07-05 | 1 |
| 10250 | 34 | 4 | 1996-07-08 | 2 |

**Shippers**

| ShipperID | ShipperName |
|-----------|-------------|
| 1 | Speedy Express |
| 2 | United Package |
| 3 | Federal Shipping |

---

## 6. GROUP BY with JOIN

Use **GROUP BY** after joining tables to aggregate per related dimension (e.g. per shipper).

**Example:** Number of orders sent by each shipper:

```sql
SELECT Shippers.ShipperName, COUNT(Orders.OrderID) AS NumberOfOrders
FROM Orders
LEFT JOIN Shippers ON Orders.ShipperID = Shippers.ShipperID
GROUP BY Shippers.ShipperName;
```

- **LEFT JOIN** keeps all orders even if ShipperID has no match in Shippers (those would show NULL ShipperName and be grouped together if any exist).
- **GROUP BY ShipperName** produces one row per shipper with the count of orders.

---

## Quick Reference

| Goal | Approach |
|------|----------|
| One row per group | `GROUP BY column1, column2, ...` |
| Count per group | `SELECT col, COUNT(*) FROM t GROUP BY col` |
| Sort by aggregate | `GROUP BY ... ORDER BY aggregate_function(...) DESC` |
| Group after join | Join first, then `GROUP BY` on the dimension column(s) |

**Remember:** Non-aggregated columns in SELECT must appear in GROUP BY. Use aggregates (COUNT, SUM, etc.) for values that are computed per group.
