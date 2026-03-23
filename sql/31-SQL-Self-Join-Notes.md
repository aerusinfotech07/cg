# SQL Self Join – Notes

## 1. What Is a Self Join?

A **self join** is a join in which a **table is joined with itself**.

- You use the same table twice in the query and give it **different aliases** (e.g. T1 and T2) so you can compare or relate rows within that table.
- Self joins are useful for comparing rows (e.g. same city, same manager, hierarchical data).

---

## 2. Syntax

**Using comma and WHERE (old style):**

```sql
SELECT column_name(s)
FROM table1 T1, table1 T2
WHERE condition;
```

**Using JOIN (recommended):**

```sql
SELECT column_name(s)
FROM table1 T1
JOIN table1 T2 ON condition;
```

**T1** and **T2** are **aliases** for the same table so you can reference it twice and write the join condition (e.g. same city, different customer).

---

## 3. Demo Database: Customers Table (selection)

| CustomerID | CustomerName | ContactName | Address | City | PostalCode | Country |
|------------|--------------|-------------|---------|------|------------|---------|
| 1 | Alfreds Futterkiste | Maria Anders | Obere Str. 57 | Berlin | 12209 | Germany |
| 2 | Ana Trujillo Emparedados y helados | Ana Trujillo | Avda. de la Constitución 2222 | México D.F. | 05021 | Mexico |
| 3 | Antonio Moreno Taquería | Antonio Moreno | Mataderos 2312 | México D.F. | 05023 | Mexico |

---

## 4. Self Join Example: Customers in the Same City

Find **pairs of customers** that are from the **same city**. Use two aliases (A and B) for Customers and ensure you don’t match a row to itself and avoid duplicate pairs (A–B vs B–A) if desired.

**Using comma and WHERE:**

```sql
SELECT A.CustomerName AS CustomerName1, B.CustomerName AS CustomerName2, A.City
FROM Customers A, Customers B
WHERE A.CustomerID <> B.CustomerID
  AND A.City = B.City
ORDER BY A.City;
```

- **A** and **B** are two “copies” of the Customers table.
- **A.City = B.City** — same city.
- **A.CustomerID <> B.CustomerID** — different customers (exclude same row and avoid pairing a row with itself).

**Using JOIN (same logic):**

```sql
SELECT A.CustomerName AS CustomerName1, B.CustomerName AS CustomerName2, A.City
FROM Customers A
JOIN Customers B ON A.City = B.City AND A.CustomerID <> B.CustomerID
ORDER BY A.City;
```

---

## Quick Reference

| Goal | Approach |
|------|----------|
| Table joined with itself | Use two aliases (e.g. T1, T2 or A, B) for the same table |
| Compare rows in same table | Self join with ON / WHERE (e.g. same city, same manager) |
| Exclude same row | Add condition like `T1.ID <> T2.ID` |
| Avoid duplicate pairs (A–B and B–A) | Often use `T1.ID < T2.ID` (or similar) so each pair appears once |

**Remember:** A self join is one table given two aliases and then joined on a condition that relates rows within that table.
