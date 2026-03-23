# Python Operators

## Table of Contents
1. [Arithmetic Operators](#1-arithmetic-operators)
2. [Assignment Operators](#2-assignment-operators)
3. [Comparison Operators](#3-comparison-operators)
4. [Logical Operators](#4-logical-operators)
5. [Identity Operators](#5-identity-operators)
6. [Membership Operators](#6-membership-operators)
7. [Bitwise Operators](#7-bitwise-operators)
8. [Operator Precedence](#8-operator-precedence)

---

## 1. Arithmetic Operators

| Operator | Name | Example |
|----------|------|---------|
| `+` | Addition | `5 + 3` → 8 |
| `-` | Subtraction | `5 - 3` → 2 |
| `*` | Multiplication | `5 * 3` → 15 |
| `/` | Division | `5 / 2` → 2.5 |
| `//` | Floor division | `5 // 2` → 2 |
| `%` | Modulus | `5 % 2` → 1 |
| `**` | Exponentiation | `5 ** 2` → 25 |

```python
print(10 + 3)   # 13
print(10 - 3)   # 7
print(10 * 3)   # 30
print(10 / 3)   # 3.333...
print(10 // 3)  # 3
print(10 % 3)   # 1
print(2 ** 10)  # 1024
```

### String/List Repetition

```python
print("Ha" * 3)     # HaHaHa
print([0] * 5)      # [0, 0, 0, 0, 0]
```

---

## 2. Assignment Operators

| Operator | Example | Equivalent |
|----------|---------|------------|
| `=` | `x = 5` | Assign |
| `+=` | `x += 3` | `x = x + 3` |
| `-=` | `x -= 3` | `x = x - 3` |
| `*=` | `x *= 3` | `x = x * 3` |
| `/=` | `x /= 3` | `x = x / 3` |
| `//=` | `x //= 3` | `x = x // 3` |
| `%=` | `x %= 3` | `x = x % 3` |
| `**=` | `x **= 2` | `x = x ** 2` |

```python
x = 10
x += 5
print(x)  # 15

x *= 2
print(x)  # 30
```

---

## 3. Comparison Operators

Return `True` or `False`:

| Operator | Meaning |
|----------|---------|
| `==` | Equal |
| `!=` | Not equal |
| `>` | Greater than |
| `<` | Less than |
| `>=` | Greater or equal |
| `<=` | Less or equal |

```python
print(5 == 5)   # True
print(5 != 3)   # True
print(5 > 3)    # True
```

---

## 4. Logical Operators

| Operator | Meaning |
|----------|---------|
| `and` | Both True |
| `or` | At least one True |
| `not` | Negation |

```python
print(True and False)  # False
print(True or False)   # True
print(not True)        # False
```

---

## 5. Identity Operators

Compare object identity (same object in memory):

| Operator | Meaning |
|----------|---------|
| `is` | Same object |
| `is not` | Different object |

```python
a = [1, 2, 3]
b = [1, 2, 3]
c = a

print(a is b)    # False (different objects)
print(a is c)    # True (same object)
print(a == b)    # True (same value)

# Use for None
x = None
print(x is None)  # True
```

---

## 6. Membership Operators

Test if value is in sequence:

| Operator | Meaning |
|----------|---------|
| `in` | Value in sequence |
| `not in` | Value not in sequence |

```python
print("a" in "abc")     # True
print("d" not in "abc") # True
print(3 in [1, 2, 3])   # True
print("x" not in {"a", "b"})  # True
```

---

## 7. Bitwise Operators

| Operator | Name | Example |
|----------|------|---------|
| `&` | AND | `5 & 3` → 1 |
| `\|` | OR | `5 \| 3` → 7 |
| `^` | XOR | `5 ^ 3` → 6 |
| `~` | NOT | `~5` → -6 |
| `<<` | Left shift | `5 << 1` → 10 |
| `>>` | Right shift | `5 >> 1` → 2 |

```python
print(5 & 3)   # 1
print(5 | 3)   # 7
print(5 ^ 3)   # 6
print(5 << 1)  # 10
print(5 >> 1)  # 2
```

---

## 8. Operator Precedence

From highest to lowest (simplified):

1. `**` (exponentiation)
2. `+x`, `-x`, `~x` (unary)
3. `*`, `/`, `//`, `%`
4. `+`, `-`
5. `<<`, `>>`
6. `&`
7. `^`
8. `|`
9. `==`, `!=`, `>`, `<`, `>=`, `<=`
10. `not`
11. `and`
12. `or`

Use parentheses to clarify:

```python
print(2 + 3 * 4)    # 14 (not 20)
print((2 + 3) * 4)  # 20
```

---

## Quick Reference

| Category | Operators |
|----------|-----------|
| Arithmetic | `+`, `-`, `*`, `/`, `//`, `%`, `**` |
| Assignment | `=`, `+=`, `-=`, etc. |
| Comparison | `==`, `!=`, `>`, `<`, `>=`, `<=` |
| Logical | `and`, `or`, `not` |
| Identity | `is`, `is not` |
| Membership | `in`, `not in` |

---

## Next Steps

- Practice operator combinations
- Proceed to **Lists** tutorial
