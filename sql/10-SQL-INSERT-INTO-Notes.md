# SQL INSERT INTO Statement – Notes

## 1. What is INSERT INTO?

The **INSERT INTO** statement is used to **insert new records** into a table.

You can write it in **two ways**: with column names, or without (values for all columns in table order).

---

## 2. Syntax

### Syntax 1: Specify column names and values

```sql
INSERT INTO table_name (column1, column2, column3, ...)
VALUES (value1, value2, value3, ...);
```

- List the columns you are filling, then the values in the **same order**.
- You can omit columns (e.g. auto-increment or nullable); those get default/NULL or auto-generated values.

### Syntax 2: Values for all columns (no column list)

```sql
INSERT INTO table_name
VALUES (value1, value2, value3, ...);
```

- **Omit** the column list only when you provide a value for **every** column.
- The order of values **must match** the order of columns in the table.

---

## 3. Demo Database: Customers Table (selection)

| CustomerID | CustomerName | ContactName | Address | City | PostalCode | Country |
|------------|--------------|-------------|---------|------|------------|---------|
| 89 | White Clover Markets | Karl Jablonski | 305 - 14th Ave. S. Suite 3B | Seattle | 98128 | USA |
| 90 | Wilman Kala | Matti Karttunen | Keskuskatu 45 | Helsinki | 21240 | Finland |
| 91 | Wolski | Zbyszek | ul. Filtrowa 68 | Walla | 01-012 | Poland |

---

## 4. INSERT INTO Example (all columns)

Insert values for **all** columns, so column names are **omitted**. Values must be in table column order.

```sql
INSERT INTO Customers
VALUES ('Cardinal', 'Tom B. Erichsen', 'Skagen 21', 'Stavanger', '4006', 'Norway');
```

**Note:** If the table has a **CustomerID** column that is **auto-increment**, you typically do **not** insert a value for it; the database generates it.

After the insert, the new row might look like:

| CustomerID | CustomerName | ContactName | Address | City | PostalCode | Country |
|------------|--------------|-------------|---------|------|------------|---------|
| 92 | Cardinal | Tom B. Erichsen | Skagen 21 | Stavanger | 4006 | Norway |

*(CustomerID 92 is auto-generated.)*

---

## 5. Insert Data Only in Specific Columns

List only the columns you want to fill; other columns get default values or NULL (if allowed).

**Example:** Insert only into **CustomerName**, **City**, and **Country** (CustomerID is auto-increment; ContactName, Address, PostalCode are omitted):

```sql
INSERT INTO Customers (CustomerName, City, Country)
VALUES ('Cardinal', 'Stavanger', 'Norway');
```

Result (other columns NULL or default):

| CustomerID | CustomerName | ContactName | Address | City | PostalCode | Country |
|------------|--------------|-------------|---------|------|------------|---------|
| 92 | Cardinal | null | null | Stavanger | null | Norway |

---

## 6. Insert Multiple Rows

Use one **INSERT INTO** with **multiple value sets**, separated by commas.

```sql
INSERT INTO Customers (CustomerName, ContactName, Address, City, PostalCode, Country)
VALUES
('Cardinal', 'Tom B. Erichsen', 'Skagen 21', 'Stavanger', '4006', 'Norway'),
('Greasy Burger', 'Per Olsen', 'Gateveien 15', 'Sandnes', '4306', 'Norway'),
('Tasty Tee', 'Finn Egan', 'Streetroad 19B', 'Liverpool', 'L1 0AA', 'UK');
```

**Note:** Separate each set of values with a comma **,**.

Result (example with auto-increment CustomerID):

| CustomerID | CustomerName | ContactName | Address | City | PostalCode | Country |
|------------|--------------|-------------|---------|------|------------|---------|
| 92 | Cardinal | Tom B. Erichsen | Skagen 21 | Stavanger | 4006 | Norway |
| 93 | Greasy Burger | Per Olsen | Gateveien 15 | Sandnes | 4306 | Norway |
| 94 | Tasty Tee | Finn Egan | Streetroad 19B | Liverpool | L1 0AA | UK |

---

## Quick Reference

| Goal | Example |
|------|---------|
| Insert with column names | `INSERT INTO t (col1, col2) VALUES (v1, v2);` |
| Insert all columns (no names) | `INSERT INTO t VALUES (v1, v2, v3, ...);` — order must match table |
| Insert only some columns | `INSERT INTO t (CustomerName, City, Country) VALUES ('X', 'Y', 'Z');` |
| Insert multiple rows | `INSERT INTO t (c1, c2) VALUES (a1, a2), (b1, b2), (c1, c2);` |
| Auto-increment | Omit that column (or use default); DB assigns the value |
