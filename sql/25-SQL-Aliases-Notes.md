# SQL Aliases – Notes

## 1. What Are SQL Aliases?

**Aliases** are temporary names you give to a **column** or a **table** in a query.

- They make column (and table) names **easier to read** in the result or in the query.
- An alias **exists only for the duration of that query**; it does not change the database.
- Aliases are created with the **AS** keyword.

---

## 2. Alias for Columns

Use **AS** to give a column a different name in the result set.

**Syntax:**

```sql
SELECT column_name AS alias_name
FROM table_name;
```

**Example:** Two column aliases—CustomerID as "ID", CustomerName as "Customer":

```sql
SELECT CustomerID AS ID, CustomerName AS Customer
FROM Customers;
```

---

## 3. Alias for Tables

Use **AS** to give a table a short or clearer name in the query (often used in JOINs).

**Syntax:**

```sql
SELECT column_name(s)
FROM table_name AS alias_name;
```

**Example:** Refer to the Customers table as "Persons":

```sql
SELECT * FROM Customers AS Persons;
```

---

## 4. Demo Database (selection)

**Customers**

| CustomerID | CustomerName | ContactName | Address | City | PostalCode | Country |
|------------|--------------|-------------|---------|------|------------|---------|
| 1 | Alfreds Futterkiste | Maria Anders | Obere Str. 57 | Berlin | 12209 | Germany |
| 2 | Ana Trujillo Emparedados y helados | Ana Trujillo | Avda. de la Constitución 2222 | México D.F. | 05021 | Mexico |
| 3 | Antonio Moreno Taquería | Antonio Moreno | Mataderos 2312 | México D.F. | 05023 | Mexico |

**Orders**

| OrderID | CustomerID | EmployeeID | OrderDate | ShipperID |
|---------|------------|------------|-----------|-----------|
| 10248 | 90 | 5 | 1996-07-04 | 3 |
| 10249 | 81 | 6 | 1996-07-05 | 1 |
| 10250 | 34 | 4 | 1996-07-08 | 2 |

---

## 5. Aliases with Spaces

If the alias contains **spaces** (e.g. "My Great Products"), wrap it in **square brackets** or **double quotes** (syntax depends on the database).

**Example (square brackets):**

```sql
SELECT ProductName AS [My Great Products]
FROM Products;
```

**Example (double quotes):**

```sql
SELECT ProductName AS "My Great Products"
FROM Products;
```

**Note:** Support for `[]` and `"` varies by database; use the form your system allows.

---

## 6. Concatenate Columns (with Alias)

You can build a single result column from several columns and give it an alias (e.g. a full address).

**SQL Server** (using **+**):

```sql
SELECT CustomerName, Address + ', ' + PostalCode + ' ' + City + ', ' + Country AS Address
FROM Customers;
```

**MySQL** (using **CONCAT**):

```sql
SELECT CustomerName, CONCAT(Address, ', ', PostalCode, ' ', City, ', ', Country) AS Address
FROM Customers;
```

**Oracle** (using **||**):

```sql
SELECT CustomerName, (Address || ', ' || PostalCode || ' ' || City || ', ' || Country) AS Address
FROM Customers;
```

---

## 7. Table Aliases in JOINs

Table aliases are especially useful in **JOINs**: they shorten the query and avoid ambiguity when the same column name appears in more than one table.

**Example:** **c** for Customers, **o** for Orders:

```sql
SELECT c.CustomerName, o.OrderID
FROM Customers AS c
JOIN Orders AS o ON c.CustomerID = o.CustomerID;
```

Without aliases you would repeat the full table names. With **c** and **o**, the query is shorter and easier to read.

---

## Quick Reference

| Goal | Example |
|------|---------|
| Column alias | `SELECT CustomerID AS ID, CustomerName AS Customer FROM Customers;` |
| Table alias | `SELECT * FROM Customers AS c;` |
| Alias with spaces | `SELECT ProductName AS [My Great Products] FROM Products;` |
| Concatenate + alias (MySQL) | `SELECT CONCAT(Address, ', ', City) AS Address FROM Customers;` |
| Table aliases in JOIN | `SELECT c.CustomerName, o.OrderID FROM Customers AS c JOIN Orders AS o ON c.CustomerID = o.CustomerID;` |

**Remember:** Aliases are temporary names for the query only; they are created with **AS**.
