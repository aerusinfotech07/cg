# Python Variable Names

## Table of Contents
1. [Naming Rules](#1-naming-rules)
2. [Valid vs Invalid Names](#2-valid-vs-invalid-names)
3. [Naming Conventions](#3-naming-conventions)
4. [Reserved Keywords](#4-reserved-keywords)
5. [Style Guidelines (PEP 8)](#5-style-guidelines-pep-8)

---

## 1. Naming Rules

Python variable names must follow these **rules**:

| Rule | Description |
|------|-------------|
| **Characters** | Letters (a-z, A-Z), digits (0-9), underscore (_) |
| **First character** | Must be letter or underscore, NOT a digit |
| **Case-sensitive** | `name` and `Name` are different variables |

---

## 2. Valid vs Invalid Names

### Valid Names

```python
name = "Alice"
_name = "private"
name2 = "with number"
user_name = "snake_case"
userName = "camelCase"
MAX_SIZE = 100  # Constants often in UPPER
```

### Invalid Names

```python
# 2name = "invalid"      # Cannot start with digit
# my-name = "invalid"    # Hyphen not allowed
# my name = "invalid"    # No spaces
# class = "invalid"      # Reserved keyword
```

---

## 3. Naming Conventions

### Snake Case (Recommended for Python)

Use lowercase with underscores for variables and functions:

```python
user_name = "Alice"
total_count = 42
is_valid = True
```

### Camel Case

Sometimes used, but snake_case is Python standard:

```python
userName = "Alice"
totalCount = 42
```

### Constants

Use UPPERCASE with underscores for constants:

```python
MAX_CONNECTIONS = 100
PI = 3.14159
DEFAULT_TIMEOUT = 30
```

### Class Names

Use PascalCase (Capitalize each word):

```python
class UserProfile:
    pass

class BankAccount:
    pass
```

---

## 4. Reserved Keywords

These words cannot be used as variable names:

| Keywords | |
|----------|--|
| `False` | `None` | `True` | `and` | `as` |
| `assert` | `async` | `await` | `break` | `class` |
| `continue` | `def` | `del` | `elif` | `else` |
| `except` | `finally` | `for` | `from` | `global` |
| `if` | `import` | `in` | `is` | `lambda` |
| `nonlocal` | `not` | `or` | `pass` | `raise` |
| `return` | `try` | `while` | `with` | `yield` |

### Check Keywords

```python
import keyword
print(keyword.kwlist)
```

---

## 5. Style Guidelines (PEP 8)

PEP 8 is Python's style guide. Key naming points:

| Element | Convention | Example |
|---------|------------|---------|
| Variables | snake_case | `user_count` |
| Functions | snake_case | `get_total()` |
| Constants | UPPER_SNAKE | `MAX_SIZE` |
| Classes | PascalCase | `UserAccount` |
| Private | Leading underscore | `_internal` |

### Descriptive Names

```python
# Good - descriptive
student_count = 25
total_price = 99.99
is_logged_in = False

# Avoid - unclear
x = 25
tp = 99.99
flag = False
```

### Avoid Single Letters (Except Loop Variables)

```python
# Acceptable in short loops
for i in range(5):
    print(i)

# Prefer descriptive names elsewhere
for index in range(len(items)):
    process(items[index])
```

---

## Quick Reference

| Topic | Key Point |
|-------|-----------|
| **Rules** | Letters, digits, underscore; no leading digit |
| **Style** | snake_case for variables |
| **Constants** | UPPER_SNAKE_CASE |
| **Keywords** | Cannot use `if`, `class`, etc. as names |
| **Descriptive** | Use meaningful names |

---

## Next Steps

- Practice creating variables with proper names
- Proceed to **Multiple Assignment** tutorial
