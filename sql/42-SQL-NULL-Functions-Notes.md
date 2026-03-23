# SQL NULL Functions – Notes

## 1. Why Handle NULL?

Operations that involve **NULL** usually produce **NULL** (e.g. `10 + NULL` → NULL). So expressions like **Price * (InStock + InOrder)** return NULL whenever **InOrder** (or any part) is NULL.

SQL provides functions to **replace or work around NULL** so calculations and display behave as you want.

**Note:** NULL means “unknown or missing”; it is not a value but the absence of data.

---

## 2. Common NULL-Handling Functions

| Function | Description | Databases |
|----------|-------------|-----------|
| **COALESCE()** | Returns the **first non-NULL** value in a list | MySQL, SQL Server, Oracle (preferred standard) |
| **IFNULL()** | Replaces NULL with a specified value (two arguments) | MySQL |
| **ISNULL()** | Replaces NULL with a specified value (two arguments) | SQL Server |
| **NVL()** | Replaces NULL with a specified value (two arguments) | Oracle |
| **IsNull()** (MS Access) | Returns **TRUE** if expression is NULL, else FALSE | MS Access |
| **IIf()** (MS Access) | Returns one of two values based on a condition | MS Access (use with IsNull to replace NULL) |

---

## 3. Demo Database: Products

| PId | ProductName | Price | InStock | InOrder |
|-----|-------------|-------|---------|--------|
| 1 | Jarlsberg | 10.45 | 16 | 15 |
| 2 | Mascarpone | 32.56 | 23 | null |
| 3 | Gorgonzola | 15.67 | 9 | 20 |

**InOrder** may be NULL. Without handling NULL, this returns NULL for row 2:

```sql
SELECT ProductName, Price * (InStock + InOrder)
FROM Products;
```

---

## 4. COALESCE() — Preferred Standard

**COALESCE** returns the **first non-NULL** value in its argument list.

**Syntax:** `COALESCE(val1, val2, ..., val_n)`

**Replace NULL with 0** (so the calculation always has a number):

```sql
SELECT ProductName, Price * (InStock + COALESCE(InOrder, 0))
FROM Products;
```

Works in MySQL, SQL Server, and Oracle (not in MS Access).

---

## 5. IFNULL() — MySQL

Replaces NULL with a second argument (two arguments only).

**Syntax:** `IFNULL(expr, alt)`

```sql
SELECT ProductName, Price * (InStock + IFNULL(InOrder, 0))
FROM Products;
```

---

## 6. ISNULL() — SQL Server

Replaces NULL with a specified value (two arguments).

**Syntax:** `ISNULL(expr, alt)`

```sql
SELECT ProductName, Price * (InStock + ISNULL(InOrder, 0))
FROM Products;
```

---

## 7. NVL() — Oracle

Replaces NULL with a specified value (two arguments).

**Syntax:** `NVL(expr, alt)`

```sql
SELECT ProductName, Price * (InStock + NVL(InOrder, 0))
FROM Products;
```

---

## 8. MS Access: IsNull() and IIf()

**IsNull(expr)** — Returns **TRUE** if the expression is NULL, otherwise **FALSE**. It does **not** replace NULL by itself.

**IIf(expr, truepart, falsepart)** — Returns *truepart* if *expr* is TRUE, else *falsepart*.

**Replace NULL with 0 in a calculation:**

```sql
SELECT ProductName, Price * (InStock + IIf(IsNull(InOrder), 0, InOrder))
FROM Products;
```

- If **InOrder** is NULL, use 0; otherwise use InOrder.

---

## Quick Reference

| Goal | MySQL | SQL Server | Oracle | MS Access |
|------|--------|------------|--------|-----------|
| Replace NULL with 0 | `IFNULL(InOrder, 0)` or `COALESCE(InOrder, 0)` | `ISNULL(InOrder, 0)` or `COALESCE(InOrder, 0)` | `NVL(InOrder, 0)` or `COALESCE(InOrder, 0)` | `IIf(IsNull(InOrder), 0, InOrder)` |
| First non-NULL of several | `COALESCE(a, b, c)` | `COALESCE(a, b, c)` | `COALESCE(a, b, c)` | (no direct equivalent) |

**Remember:** Use COALESCE when you need “first non-NULL” and when writing portable SQL; use IFNULL/ISNULL/NVL/IIf when you only need “replace NULL with one value” in a specific database.
