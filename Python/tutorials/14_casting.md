# Python Casting

## Table of Contents
1. [What is Casting?](#1-what-is-casting)
2. [str() - String Conversion](#2-str---string-conversion)
3. [int() - Integer Conversion](#3-int---integer-conversion)
4. [float() - Float Conversion](#4-float---float-conversion)
5. [Common Use Cases](#5-common-use-cases)
6. [Handling Invalid Conversions](#6-handling-invalid-conversions)

---

## 1. What is Casting?

**Casting** (or type conversion) means converting a value from one data type to another. Python provides built-in functions for this.

| Function | Converts To | Example |
|----------|-------------|---------|
| `str()` | String | `str(42)` → `'42'` |
| `int()` | Integer | `int("42")` → `42` |
| `float()` | Float | `float("3.14")` → `3.14` |

---

## 2. str() - String Conversion

Convert any value to a string:

```python
x = str(3)      # '3'
y = str(3.14)   # '3.14'
z = str(True)   # 'True'

print(x, type(x))
print(y, type(y))
print(z, type(z))
```

**Output:**
```
3 <class 'str'>
3.14 <class 'str'>
True <class 'str'>
```

### When to Use

- Concatenating numbers with strings
- Displaying numbers in messages
- Writing to files

```python
age = 25
print("I am " + str(age) + " years old.")
```

---

## 3. int() - Integer Conversion

Convert to integer. Truncates decimals (does not round):

```python
x = int(3.9)     # 3 (truncates)
y = int("42")    # 42
z = int(True)    # 1

print(x, y, z)
```

**Output:**
```
3 42 1
```

### Base Conversion

`int()` can parse strings in different bases:

```python
print(int("10"))      # 10 (decimal)
print(int("10", 2))   # 2 (binary)
print(int("10", 8))   # 8 (octal)
print(int("10", 16))  # 16 (hexadecimal)
print(int("FF", 16))  # 255
```

---

## 4. float() - Float Conversion

Convert to floating-point number:

```python
x = float(3)       # 3.0
y = float("3.14")  # 3.14
z = float("  4.5  ")  # 4.5 (whitespace trimmed)

print(x, y, z)
```

**Output:**
```
3.0 3.14 4.5
```

### Special Values

```python
print(float("inf"))   # infinity
print(float("-inf"))  # negative infinity
print(float("nan"))   # Not a Number
```

---

## 5. Common Use Cases

### User Input

```python
# input() always returns string
age_str = input("Enter your age: ")
age = int(age_str)

price_str = input("Enter price: ")
price = float(price_str)
```

### Calculations

```python
# Ensure float division
a, b = 5, 2
result = float(a) / b  # 2.5
```

### Display Formatting

```python
pi = 3.14159
# Format then convert if needed
display = str(round(pi, 2))  # "3.14"
```

---

## 6. Handling Invalid Conversions

Invalid conversions raise `ValueError`:

```python
# int("hello")   # ValueError
# int("3.14")    # ValueError (use float first)
# float("abc")   # ValueError
```

### Safe Conversion

```python
def safe_int(value, default=0):
    try:
        return int(value)
    except (ValueError, TypeError):
        return default

print(safe_int("42"))    # 42
print(safe_int("abc"))   # 0
print(safe_int("3.14"))  # 0 (int can't parse decimal string directly)
```

### Float to Int

```python
# For "3.14" string: convert to float first, then int
s = "3.14"
n = int(float(s))  # 3
```

---

## Quick Reference

| From | To | Function |
|------|-----|----------|
| int/float | str | `str(42)` |
| str/float | int | `int("42")` |
| str/int | float | `float("3.14")` |
| Truncate | int | `int(3.9)` → 3 |
| Round first | int | `int(round(3.9))` → 4 |

---

## Next Steps

- Practice casting with user input
- Proceed to **Strings** tutorial
