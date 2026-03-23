# SQL HAVING Clause – Notes

## 1. What Is HAVING?

The **HAVING** clause filters the **results of a GROUP BY** query based on **aggregate** values (e.g. counts, sums).

- **WHERE** filters **individual rows before** grouping.
- **HAVING** filters **groups after** aggregation (e.g. “only groups where COUNT > 5”).

So: **WHERE** → which rows go into groups; **HAVING** → which groups stay in the result.

---

## 2. Syntax

```sql
SELECT column1, aggregate_function(column2), column3, ...
FROM table_name
WHERE condition
GROUP BY column1, column3
HAVING condition   -- condition on grouped/aggregate data
ORDER BY column_name;
```

- **HAVING** conditions usually use **aggregate functions** (COUNT, SUM, AVG, etc.) or columns that are in GROUP BY.

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

## 4. HAVING Examples: Customers per Country

**Number of customers per country, only for countries with more than 5 customers:**

```sql
SELECT Country, COUNT(CustomerID) AS [Number of Customers]
FROM Customers
GROUP BY Country
HAVING COUNT(CustomerID) > 5;
```

**Same, sorted from high to low by count:**

```sql
SELECT Country, COUNT(CustomerID) AS [Number of Customers]
FROM Customers
GROUP BY Country
HAVING COUNT(CustomerID) > 5
ORDER BY COUNT(CustomerID) DESC;
```

---

## 5. Demo Database: Orders and Employees (selection)

**Orders**

| OrderID | CustomerID | EmployeeID | OrderDate | ShipperID |
|---------|------------|------------|-----------|-----------|
| 10248 | 90 | 5 | 1996-07-04 | 3 |
| 10249 | 81 | 6 | 1996-07-05 | 1 |
| 10250 | 34 | 4 | 1996-07-08 | 2 |

**Employees**

| EmployeeID | LastName | FirstName | BirthDate | Photo | Notes |
|------------|----------|-----------|-----------|-------|-------|
| 1 | Davolio | Nancy | 1968-12-08 | EmpID1.pic | Education includes a BA.... |
| 2 | Fuller | Andrew | 1952-02-19 | EmpID2.pic | Andrew received his BTS.... |
| 3 | Leverling | Janet | 1963-08-30 | EmpID3.pic | Janet has a BS degree.... |

---

## 6. HAVING with JOIN: Orders per Employee

**Employees who have more than 10 orders:**

```sql
SELECT Employees.LastName, COUNT(Orders.OrderID) AS NumberOfOrders
FROM Orders
INNER JOIN Employees ON Orders.EmployeeID = Employees.EmployeeID
GROUP BY Employees.LastName
HAVING COUNT(Orders.OrderID) > 10;
```

---

## 7. Combining WHERE and HAVING

**WHERE** limits which rows are grouped; **HAVING** limits which groups are returned.

**Example:** For employees “Davolio” or “Fuller” only, show those who have more than 25 orders:

```sql
SELECT Employees.LastName, COUNT(Orders.OrderID) AS NumberOfOrders
FROM Orders
INNER JOIN Employees ON Orders.EmployeeID = Employees.EmployeeID
WHERE LastName = 'Davolio' OR LastName = 'Fuller'
GROUP BY LastName
HAVING COUNT(Orders.OrderID) > 25;
```

- **WHERE** restricts to rows for Davolio or Fuller before grouping.
- **HAVING** keeps only groups (here, employees) with order count greater than 25.

---

## Quick Reference

| Goal | Use |
|------|-----|
| Filter by aggregate (e.g. count, sum) | `HAVING aggregate_function(...) condition` |
| Filter rows before grouping | `WHERE` before `GROUP BY` |
| Filter groups after grouping | `HAVING` after `GROUP BY` |
| Both row and group filter | `WHERE ... GROUP BY ... HAVING ...` |

**Remember:** WHERE applies to rows **before** grouping; HAVING applies to **groups** (and usually to aggregate values).
