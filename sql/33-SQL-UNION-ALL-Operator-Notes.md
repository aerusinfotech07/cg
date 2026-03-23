# SQL UNION ALL Operator – Notes

## 1. What Is UNION ALL?

The **UNION ALL** operator **combines the result sets** of two or more **SELECT** statements into a single result set.

- **UNION ALL** includes **every row** from each SELECT, **including duplicates**.
- Unlike **UNION**, it does **not** remove duplicate rows, so it is typically faster when you know duplicates are acceptable or desired.

---

## 2. Requirements for UNION ALL

- Each SELECT must have the **same number of columns**.
- Corresponding columns must have **compatible (similar) data types**.
- Columns in each SELECT must be in the **same order**.

These are the same as for **UNION**; only duplicate handling differs.

---

## 3. Syntax

```sql
SELECT column_name(s) FROM table1
UNION ALL
SELECT column_name(s) FROM table2;
```

You can chain more SELECTs with additional **UNION ALL** keywords.

**Note:** The column names in the result are usually taken from the **first** SELECT.

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

## 5. UNION ALL Example: All Countries (Including Duplicates)

Return **all** countries from both Customers and Suppliers; if a country appears in both tables (or multiple times in one), it appears multiple times in the result:

```sql
SELECT Country FROM Customers
UNION ALL
SELECT Country FROM Suppliers
ORDER BY Country;
```

---

## 6. UNION ALL with WHERE

Add **WHERE** in each SELECT to filter before combining. Example: all German cities from both tables (duplicates kept):

```sql
SELECT City, Country FROM Customers
WHERE Country = 'Germany'
UNION ALL
SELECT City, Country FROM Suppliers
WHERE Country = 'Germany'
ORDER BY City;
```

---

## UNION vs UNION ALL

| Operator    | Duplicates in result     | Typical use                    |
|------------|---------------------------|---------------------------------|
| **UNION**  | Removed (distinct rows)   | When you want unique values    |
| **UNION ALL** | Kept (all rows)       | When duplicates are OK or needed; often faster |

**Remember:** UNION ALL keeps every row from each SELECT; use it when you need all rows or when you know duplicate removal is unnecessary.
