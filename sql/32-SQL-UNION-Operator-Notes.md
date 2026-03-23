# SQL UNION Operator – Notes

## 1. What Is UNION?

The **UNION** operator **combines the result sets** of two or more **SELECT** statements into a single result set.

- **UNION** automatically **removes duplicate rows** from the combined result.
- To keep duplicates, use **UNION ALL** instead.

---

## 2. Requirements for UNION

- Each SELECT in the UNION must have the **same number of columns**.
- Corresponding columns must have **compatible (similar) data types**.
- Columns in each SELECT must be in the **same order** (first column with first column, etc.).

---

## 3. Syntax

```sql
SELECT column_name(s) FROM table1
UNION
SELECT column_name(s) FROM table2;
```

You can chain more SELECTs with additional **UNION** (or **UNION ALL**) keywords.

**Note:** The column names in the final result are usually taken from the **first** SELECT. Aliases in the first SELECT apply to the combined result.

---

## 4. Demo Database (selection)

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

## 5. UNION Example: Unique Countries

Return **distinct** countries from both Customers and Suppliers (each country listed once):

```sql
SELECT Country FROM Customers
UNION
SELECT Country FROM Suppliers
ORDER BY Country;
```

**Note:** If the same country appears in both tables, it still appears only once, because UNION removes duplicates. Use **UNION ALL** if you want to keep duplicate rows.

---

## 6. UNION with WHERE

Add **WHERE** in each SELECT to filter before combining. Example: unique German cities from both tables:

```sql
SELECT City, Country FROM Customers
WHERE Country = 'Germany'
UNION
SELECT City, Country FROM Suppliers
WHERE Country = 'Germany'
ORDER BY City;
```

---

## 7. UNION with Alias: Customers and Suppliers List

List all customers and suppliers in one result, with a column indicating type. Use a literal (and alias) in the first column:

```sql
SELECT 'Customer' AS Type, ContactName, City, Country
FROM Customers
UNION
SELECT 'Supplier', ContactName, City, Country
FROM Suppliers;
```

- **'Customer' AS Type** in the first SELECT creates a temporary column **Type** with value `'Customer'` for customer rows.
- The second SELECT supplies **'Supplier'** for that position (same order and type). The alias **Type** from the first SELECT names the column in the result.

---

## Quick Reference

| Goal | Example |
|------|---------|
| Combine two result sets, no duplicates | `SELECT ... UNION SELECT ...` |
| Combine and keep duplicates | `SELECT ... UNION ALL SELECT ...` |
| Same number and order of columns | Each SELECT must match in column count and order |
| Filter each part | Add WHERE in each SELECT before UNION |
| Add a “type” column | Use a literal and alias in first SELECT, same literal position in others |

**Remember:** UNION requires matching column count and types; it removes duplicates. Use UNION ALL to keep duplicates.
