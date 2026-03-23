# SQL LIKE Operator – Notes

## 1. What Is LIKE?

The **LIKE** operator is used in a **WHERE** clause to search for a **specified pattern** in a column’s text data.

Two wildcards are commonly used with LIKE:

| Wildcard | Meaning |
|----------|---------|
| **%** | Zero, one, or **multiple** characters |
| **_**(underscore) | Exactly **one** character |

**Example:** All customers whose name starts with "a":

```sql
SELECT * FROM Customers
WHERE CustomerName LIKE 'a%';
```

---

## 2. Syntax

```sql
SELECT column1, column2, ...
FROM table_name
WHERE columnN LIKE pattern;
```

Patterns are usually string literals containing **%** and/or **_**.

---

## 3. Demo Database: Customers Table (selection)

| CustomerID | CustomerName | ContactName | Address | City | PostalCode | Country |
|------------|--------------|-------------|---------|------|------------|---------|
| 1 | Alfreds Futterkiste | Maria Anders | Obere Str. 57 | Berlin | 12209 | Germany |
| 2 | Ana Trujillo Emparedados y helados | Ana Trujillo | Avda. de la Constitución 2222 | México D.F. | 05021 | Mexico |
| 3 | Antonio Moreno Taquería | Antonio Moreno | Mataderos 2312 | México D.F. | 05023 | Mexico |
| 4 | Around the Horn | Thomas Hardy | 120 Hanover Sq. | London | WA1 1DP | UK |
| 5 | Berglunds snabbköp | Christina Berglund | Berguvsvägen 8 | Luleå | S-958 22 | Sweden |

---

## 4. The % Wildcard

**%** stands for **any sequence of characters** (including none).

**Example:** Cities that **contain** the sequence 'on':

```sql
SELECT * FROM Customers
WHERE City LIKE '%on%';
```

(Matches e.g. London, Lyon, etc.)

---

## 5. The _ Wildcard

**_**(underscore) stands for **exactly one** character (any character).

**Example:** Cities that start with 'l', then one character, then 'nd', then two characters (e.g. "London"):

```sql
SELECT * FROM Customers
WHERE City LIKE 'l_nd__';
```

Each **_ ** is one character; **%** would mean “any number of characters.”

---

## 6. Starts With

Put **%** only **after** the text to match values that **start with** that text.

**Example:** CustomerName starts with 'La':

```sql
SELECT * FROM Customers
WHERE CustomerName LIKE 'La%';
```

**Tip:** Combine conditions with AND or OR:

**Example:** CustomerName starts with 'a' **or** 'b':

```sql
SELECT * FROM Customers
WHERE CustomerName LIKE 'a%' OR CustomerName LIKE 'b%';
```

---

## 7. Ends With

Put **%** only **before** the text to match values that **end with** that text.

**Example:** CustomerName ends with 'a':

```sql
SELECT * FROM Customers
WHERE CustomerName LIKE '%a';
```

**Starts with and ends with:** Use **%** only in the middle.

**Example:** CustomerName starts with 'b' and ends with 's':

```sql
SELECT * FROM Customers
WHERE CustomerName LIKE 'b%s';
```

---

## 8. Contains

Put **%** **before and after** the text to match values that **contain** that text anywhere.

**Example:** CustomerName contains the phrase 'or':

```sql
SELECT * FROM Customers
WHERE CustomerName LIKE '%or%';
```

---

## 9. Combining Wildcards

Use **%** and **_ ** together in one pattern.

**Example:** CustomerName starts with 'a' and has at least 3 characters ('a' + at least 2 more):

```sql
SELECT * FROM Customers
WHERE CustomerName LIKE 'a__%';
```

**Example:** CustomerName has 'r' in the **second** position (one character, then 'r', then anything):

```sql
SELECT * FROM Customers
WHERE CustomerName LIKE '_r%';
```

---

## 10. Without Wildcards

If the pattern has **no** wildcards, LIKE behaves like an **exact match** (subject to collation/case rules).

**Example:** Country is exactly 'Spain':

```sql
SELECT * FROM Customers
WHERE Country LIKE 'Spain';
```

For simple equality, `WHERE Country = 'Spain'` is equivalent and often preferred.

---

## Quick Reference

| Pattern | Meaning | Example |
|---------|---------|---------|
| `'a%'` | Starts with a | `WHERE CustomerName LIKE 'a%'` |
| `'%a'` | Ends with a | `WHERE CustomerName LIKE '%a'` |
| `'%or%'` | Contains "or" | `WHERE CustomerName LIKE '%or%'` |
| `'a__%'` | Starts with a, at least 3 chars | `WHERE CustomerName LIKE 'a__%'` |
| `'_r%'` | Second character is r | `WHERE CustomerName LIKE '_r%'` |
| `'b%s'` | Starts with b, ends with s | `WHERE CustomerName LIKE 'b%s'` |
| `'Spain'` | Exact match | `WHERE Country LIKE 'Spain'` |

**Remember:** **%** = any number of characters; **_ ** = exactly one character.
