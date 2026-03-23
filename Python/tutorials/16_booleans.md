# Python Booleans

## Table of Contents
1. [Boolean Values](#1-boolean-values)
2. [bool() Function](#2-bool-function)
3. [Comparison Operators](#3-comparison-operators)
4. [Logical Operators](#4-logical-operators)
5. [Truthiness](#5-truthiness)
6. [Boolean in Conditions](#6-boolean-in-conditions)

---

## 1. Boolean Values

Python has two boolean values: `True` and `False`. Note the capital letters.

```python
is_active = True
is_empty = False

print(is_active)
print(is_empty)
print(type(True))
```

**Output:**
```
True
False
<class 'bool'>
```

---

## 2. bool() Function

Convert values to boolean using `bool()`:

```python
print(bool("Hello"))   # True (non-empty string)
print(bool(""))        # False (empty string)
print(bool(15))        # True (non-zero number)
print(bool(0))         # False (zero)
print(bool([1, 2]))    # True (non-empty list)
print(bool([]))        # False (empty list)
print(bool(None))      # False
```

---

## 3. Comparison Operators

Comparisons return boolean values:

| Operator | Meaning | Example |
|----------|---------|---------|
| `==` | Equal | `5 == 5` → True |
| `!=` | Not equal | `5 != 3` → True |
| `>` | Greater than | `5 > 3` → True |
| `<` | Less than | `5 < 3` → False |
| `>=` | Greater or equal | `5 >= 5` → True |
| `<=` | Less or equal | `3 <= 5` → True |

```python
print(5 == 5)   # True
print(5 != 3)   # True
print(5 > 3)    # True
print(5 < 3)    # False
print(5 >= 5)   # True
```

### Chained Comparisons

```python
x = 5
print(1 < x < 10)   # True
print(1 < x < 3)    # False
```

---

## 4. Logical Operators

| Operator | Meaning | Example |
|----------|---------|---------|
| `and` | Both must be True | `True and False` → False |
| `or` | At least one True | `True or False` → True |
| `not` | Negation | `not True` → False |

```python
print(True and True)   # True
print(True and False)  # False
print(True or False)   # True
print(False or False)  # False
print(not True)        # False
print(not False)       # True
```

### Short-Circuit Evaluation

```python
# and: stops at first False
# or: stops at first True
print(False and (1/0))  # False, no error (1/0 not evaluated)
print(True or (1/0))    # True, no error
```

---

## 5. Truthiness

Values that evaluate to `False` in boolean context:

- `False`
- `None`
- `0` (int)
- `0.0` (float)
- `""` (empty string)
- `[]` (empty list)
- `()` (empty tuple)
- `{}` (empty dict)
- `set()` (empty set)

All other values are truthy:

```python
if "":
    print("Yes")
else:
    print("No")  # No

if "hello":
    print("Yes")  # Yes
```

---

## 6. Boolean in Conditions

Booleans are used in `if`, `while`, and logical expressions:

```python
flag = True
if flag:
    print("Flag is True")

x = 10
if x > 5 and x < 20:
    print("x is between 5 and 20")

# Using bool() explicitly
value = "hello"
if bool(value):
    print("Value is truthy")
```

---

## Quick Reference

| Topic | Key Point |
|-------|-----------|
| Values | `True`, `False` |
| Convert | `bool(value)` |
| Compare | `==`, `!=`, `>`, `<`, `>=`, `<=` |
| Logic | `and`, `or`, `not` |
| Falsy | `False`, `0`, `""`, `[]`, `None` |

---

## Next Steps

- Practice comparison and logical operators
- Proceed to **Operators** tutorial
