# SQL Stored Procedures – Notes

## 1. What Is a Stored Procedure?

A **stored procedure** is **precompiled SQL** that is **saved in the database** and can be **run repeatedly** by name.

- Instead of sending the same long query every time, you save it as a procedure and **call** it (e.g. `EXEC procedure_name`).
- Procedures can take **parameters**, so one procedure can behave differently based on the values passed (e.g. city, date range).

---

## 2. Benefits of Stored Procedures

| Benefit | Description |
|---------|-------------|
| **Code reusability** | The same procedure can be called from many applications or scripts. |
| **Performance** | Stored procedures are precompiled and often execute faster; less network traffic. |
| **Security** | You can grant execute permission on a procedure without giving direct access to tables. |
| **Maintenance** | Change the procedure once; every caller gets the update automatically. |

---

## 3. Stored Procedure Syntax (SQL Server Style)

```sql
CREATE PROCEDURE procedure_name
  @param1 datatype,
  @param2 datatype
AS
BEGIN
  -- SQL statements to be executed
  SELECT column1, column2
  FROM table_name
  WHERE columnN = @paramN;
END;
```

- **@param1, @param2** — parameters (name and data type).
- **AS BEGIN ... END** — body of the procedure (one or more SQL statements).

**Execute a stored procedure:**

```sql
EXEC procedure_name @param1 = 'value1', @param2 = 'value2';
```

Or: `EXECUTE procedure_name @param1 = 'value1', @param2 = 'value2';`

---

## 4. Demo Database: Customers (selection)

| CustomerID | CustomerName | ContactName | Address | City | PostalCode | Country |
|------------|--------------|-------------|---------|------|------------|---------|
| 1 | Alfreds Futterkiste | Maria Anders | Obere Str. 57 | Berlin | 12209 | Germany |
| 2 | Ana Trujillo Emparedados y helados | Ana Trujillo | Avda. de la Constitución 2222 | México D.F. | 05021 | Mexico |
| 3 | Antonio Moreno Taquería | Antonio Moreno | Mataderos 2312 | México D.F. | 05023 | Mexico |
| 4 | Around the Horn | Thomas Hardy | 120 Hanover Sq. | London | WA1 1DP | UK |

---

## 5. Stored Procedure Example: Single Parameter

**Create** a procedure that returns customers from a given city:

```sql
CREATE PROCEDURE GetCustomersByCity
  @City nvarchar(50)
AS
BEGIN
  SELECT * FROM Customers
  WHERE City = @City;
END;
```

**Execute** it (e.g. customers in London):

```sql
EXEC GetCustomersByCity @City = 'London';
```

---

## 6. Stored Procedure with Multiple Parameters

List parameters separated by commas. Example: customers by city **and** postal code:

```sql
CREATE PROCEDURE GetCustomersByCityAndPostalCode
  @City nvarchar(50),
  @PostalCode nvarchar(10)
AS
BEGIN
  SELECT * FROM Customers
  WHERE City = @City AND PostalCode = @PostalCode;
END;
```

**Execute:**

```sql
EXEC GetCustomersByCityAndPostalCode @City = 'London', @PostalCode = 'WA1 1DP';
```

*(If you keep the name GetCustomersByCity, you would replace the previous procedure or use a different name like GetCustomersByCityAndPostalCode.)*

---

## 7. Database Differences

- **SQL Server** — Uses `CREATE PROCEDURE`, `@param` style, `AS BEGIN ... END`, `EXEC`.
- **MySQL** — Uses `CREATE PROCEDURE name(IN param type, ...) BEGIN ... END` and often `DELIMITER` when defining the procedure.
- **Oracle** — Uses `CREATE OR REPLACE PROCEDURE name(param IN type, ...) AS BEGIN ... END`.
- **MS Access** — Queries can be saved; parameterized queries use `[param]` in the SQL.

The examples above follow **SQL Server** syntax.

---

## Quick Reference

| Goal | Example |
|------|---------|
| Create procedure | `CREATE PROCEDURE name @p1 type, @p2 type AS BEGIN ... END` |
| Run procedure | `EXEC name @p1 = 'value1', @p2 = 'value2'` |
| Single parameter | One `@param type`; use it in the WHERE (or other) clause. |
| Multiple parameters | `@p1 type, @p2 type`; use all in the procedure body. |

**Remember:** Stored procedures are saved, reusable, and can take parameters; syntax for creating and calling them varies by database.
