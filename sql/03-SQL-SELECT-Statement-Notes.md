# SQL SELECT Statement – Notes

## 1. What is the SELECT Statement?

The **SELECT** statement is used to **select (retrieve) data** from a database.

**Example:** Return data from the `Customers` table:

```sql
SELECT CustomerName, City FROM Customers;
```

---

## 2. Syntax

```sql
SELECT column1, column2, ...
FROM table_name;
```

| Part | Meaning |
|------|---------|
| **column1, column2, ...** | Names of the columns you want to get data from. |
| **table_name** | Name of the table you want to select data from. |

---

## 3. Demo Database: Customers Table

Selection from the **Customers** table used in the examples:

| CustomerID | CustomerName | ContactName | Address | City | PostalCode | Country |
|------------|--------------|-------------|---------|------|------------|---------|
| 1 | Alfreds Futterkiste | Maria Anders | Obere Str. 57 | Berlin | 12209 | Germany |
| 2 | Ana Trujillo Emparedados y helados | Ana Trujillo | Avda. de la Constitución 2222 | México D.F. | 05021 | Mexico |
| 3 | Antonio Moreno Taquería | Antonio Moreno | Mataderos 2312 | México D.F. | 05023 | Mexico |
| 4 | Around the Horn | Thomas Hardy | 120 Hanover Sq. | London | WA1 1DP | UK |
| 5 | Berglunds snabbköp | Christina Berglund | Berguvsvägen 8 | Luleå | S-958 22 | Sweden |

---

## 4. Select Specific Columns vs All Columns

### Select specific columns

- List the column names after `SELECT`, separated by commas.
- **Example:** Get only `CustomerName` and `City` from `Customers`:

```sql
SELECT CustomerName, City FROM Customers;
```

### Select ALL columns

- Use **`SELECT *`** to get every column without naming each one.
- **Example:** Select all columns from the `"Customers"` table:

```sql
SELECT * FROM Customers;
```

---

## Quick Reference

| Goal | Syntax |
|------|--------|
| Specific columns | `SELECT column1, column2, ... FROM table_name;` |
| All columns | `SELECT * FROM table_name;` |
