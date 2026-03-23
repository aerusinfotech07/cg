# SQL Operators – Notes

## 1. SQL Arithmetic Operators

| Operator | Description | Example use |
|----------|-------------|-------------|
| **+** | Add | `Price + Tax` |
| **-** | Subtract | `Quantity - 1` |
| **\*** | Multiply | `Price * Quantity` |
| **/** | Divide | `Total / Count` |
| **%** | Modulo (remainder) | `Quantity % 10` |

*(Modulo is **%** in many databases; some use **MOD()**.)*

---

## 2. SQL Bitwise Operators

| Operator | Description |
|----------|-------------|
| **&** | Bitwise AND |
| **\|** | Bitwise OR |
| **^** | Bitwise exclusive OR |

*Support and syntax vary by database (e.g. SQL Server, MySQL).*

---

## 3. SQL Comparison Operators

| Operator | Description | Example use |
|----------|-------------|-------------|
| **=** | Equal to | `WHERE Country = 'USA'` |
| **>** | Greater than | `WHERE Price > 10` |
| **<** | Less than | `WHERE Quantity < 100` |
| **>=** | Greater than or equal to | `WHERE Price >= 20` |
| **<=** | Less than or equal to | `WHERE Quantity <= 50` |
| **<>** | Not equal to | `WHERE Status <> 'Done'` |

*In some databases **!=** is also used for “not equal.”*

---

## 4. SQL Compound Operators

Compound operators **combine an operation with assignment** (e.g. “add then assign”). Used in **SET** clauses (e.g. UPDATE) or in variable assignment, depending on the database.

| Operator | Description |
|----------|-------------|
| **+=** | Add equals |
| **-=** | Subtract equals |
| **\*=** | Multiply equals |
| **/=** | Divide equals |
| **%=** | Modulo equals |
| **&=** | Bitwise AND equals |
| **^=** | Bitwise exclusive OR equals |
| **\|*=** | Bitwise OR equals |

*Support varies (e.g. common in SQL Server T-SQL; not all databases have these).*

---

## 5. SQL Logical Operators

Used in **WHERE**, **HAVING**, and similar clauses to combine or negate conditions.

| Operator | Description | Example use |
|----------|-------------|-------------|
| **ALL** | TRUE if the condition holds for **all** subquery values | `WHERE Price > ALL (SELECT ...)` |
| **AND** | TRUE if **every** condition is TRUE | `WHERE A AND B` |
| **ANY** | TRUE if the condition holds for **any** subquery value | `WHERE Price = ANY (SELECT ...)` |
| **BETWEEN** | TRUE if value is **in** the given range (inclusive) | `WHERE Price BETWEEN 10 AND 20` |
| **EXISTS** | TRUE if the subquery returns **one or more** rows | `WHERE EXISTS (SELECT ...)` |
| **IN** | TRUE if value equals **one of** a list or subquery | `WHERE Country IN ('A','B')` |
| **LIKE** | TRUE if value **matches** a pattern (%, _) | `WHERE Name LIKE 'A%'` |
| **NOT** | TRUE when the condition is **FALSE** | `WHERE NOT Country = 'X'` |
| **OR** | TRUE if **any** condition is TRUE | `WHERE A OR B` |
| **SOME** | TRUE if the condition holds for **some** subquery value (like ANY) | `WHERE Price > SOME (SELECT ...)` |

---

## Quick Reference

| Category | Typical use |
|----------|-------------|
| **Arithmetic** | Calculations in SELECT, SET, WHERE (+, -, *, /, %) |
| **Bitwise** | Low-level bit operations (&, \|, ^) — database-specific |
| **Comparison** | Comparisons in WHERE, JOIN ON, HAVING (=, <>, >, <, >=, <=) |
| **Compound** | Short form for “compute and assign” (e.g. +=) — mainly in T-SQL |
| **Logical** | Combine or negate conditions (AND, OR, NOT, IN, LIKE, BETWEEN, EXISTS, ALL, ANY, SOME) |

**Remember:** Operator support and exact syntax can differ by database (e.g. modulo, bitwise, compound operators). See your database’s documentation for details.
