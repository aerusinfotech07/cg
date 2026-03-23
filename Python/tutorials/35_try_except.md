# Python try except

## Table of Contents
1. [Basic try except](#1-basic-try-except)
2. [Catching Specific Exceptions](#2-catching-specific-exceptions)
3. [Multiple except Blocks](#3-multiple-except-blocks)
4. [else and finally](#4-else-and-finally)
5. [raise Statement](#5-raise-statement)
6. [Common Exceptions](#6-common-exceptions)
7. [Best Practices](#7-best-practices)

---

## 1. Basic try except

```python
try:
    result = 10 / 0
except:
    print("An error occurred")
```

---

## 2. Catching Specific Exceptions

```python
try:
    result = int("abc")
except ValueError:
    print("Invalid conversion")

try:
    result = 10 / 0
except ZeroDivisionError:
    print("Division by zero")
```

---

## 3. Multiple except Blocks

```python
try:
    # risky code
    pass
except ValueError:
    print("Value error")
except ZeroDivisionError:
    print("Division by zero")
except Exception as e:
    print(f"Other error: {e}")
```

---

## 4. else and finally

```python
try:
    result = 10 / 2
except ZeroDivisionError:
    print("Error")
else:
    print("Success:", result)
finally:
    print("Always runs")
```

---

## 5. raise Statement

```python
def set_age(age):
    if age < 0 or age > 120:
        raise ValueError("Age must be 0-120")
    return age

try:
    set_age(150)
except ValueError as e:
    print(e)
```

---

## 6. Common Exceptions

| Exception | When |
|-----------|------|
| `ValueError` | Invalid value |
| `TypeError` | Wrong type |
| `IndexError` | Index out of range |
| `KeyError` | Missing dict key |
| `ZeroDivisionError` | Division by zero |
| `FileNotFoundError` | File not found |

---

## 7. Best Practices

- Catch specific exceptions
- Use `except Exception as e` to print/log
- Don't use bare `except:`
- Use `finally` for cleanup

---

## Quick Reference

```python
try:
    # code
except SpecificError:
    # handle
except Exception as e:
    # handle other
else:
    # no error
finally:
    # always
```

---

## Next Steps

- Proceed to **String Formatting** tutorial
