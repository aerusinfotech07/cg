# Python Numbers

## Table of Contents
1. [Integer (int)](#1-integer-int)
2. [Float (float)](#2-float-float)
3. [Complex (complex)](#3-complex-complex)
4. [Type Conversion](#4-type-conversion)
5. [Random Numbers](#5-random-numbers)
6. [Number Operations](#6-number-operations)

---

## 1. Integer (int)

**Integers** are whole numbers, positive or negative, with no decimal point.

```python
x = 1
y = 356
z = -3255522
```

### Arbitrary Precision

Python integers can be arbitrarily large (limited only by memory):

```python
big = 123456789012345678901234567890
print(big)
```

### Integer Literals

```python
decimal = 42
binary = 0b1010   # 10 in decimal
octal = 0o12      # 10 in decimal
hexadecimal = 0xFF  # 255 in decimal
```

---

## 2. Float (float)

**Floats** are numbers with a decimal point. They represent real numbers.

```python
x = 1.10
y = 1.0
z = -35.59
```

### Scientific Notation

```python
a = 35e3   # 35000.0
b = 12e4   # 120000.0
c = -87.7e100
```

### Float Precision

Floats have limited precision. Be aware of rounding:

```python
print(0.1 + 0.2)  # 0.30000000000000004
```

Use `round()` when needed:

```python
print(round(0.1 + 0.2, 2))  # 0.3
```

---

## 3. Complex (complex)

**Complex numbers** have a real and imaginary part. The imaginary part uses `j`:

```python
x = 3 + 5j
y = 5j
z = -5j
```

### Accessing Parts

```python
c = 3 + 4j
print(c.real)  # 3.0
print(c.imag)  # 4.0
```

### Complex Operations

```python
a = 1 + 2j
b = 2 + 3j
print(a + b)   # (3+5j)
print(a * b)   # (-4+7j)
```

---

## 4. Type Conversion

Convert between numeric types:

```python
x = 1    # int
y = 2.8  # float
z = 1j   # complex

# Convert float to int (truncates)
a = int(y)   # 2

# Convert int to float
b = float(x)  # 1.0

# Cannot convert complex to int or float
# int(z)  # TypeError
```

---

## 5. Random Numbers

Use the `random` module:

```python
import random

print(random.randrange(1, 10))  # Random int from 1 to 9
print(random.randint(1, 10))    # Random int from 1 to 10
print(random.random())          # Random float 0.0 to 1.0
print(random.uniform(1, 10))    # Random float 1 to 10
```

---

## 6. Number Operations

### Arithmetic

```python
print(10 + 3)   # 13
print(10 - 3)   # 7
print(10 * 3)   # 30
print(10 / 3)   # 3.333... (float)
print(10 // 3)  # 3 (floor division)
print(10 % 3)   # 1 (modulus)
print(10 ** 3)  # 1000 (exponentiation)
```

### Built-in Functions

```python
print(abs(-5))      # 5
print(pow(2, 3))    # 8
print(round(3.7))   # 4
print(min(1, 2, 3)) # 1
print(max(1, 2, 3)) # 3
```

---

## Quick Reference

| Type | Example | Notes |
|------|---------|-------|
| int | `42` | Whole numbers |
| float | `3.14` | Decimal numbers |
| complex | `3+4j` | Real + imaginary |
| Convert | `int()`, `float()` | Type conversion |

---

## Next Steps

- Practice numeric operations
- Proceed to **Casting** tutorial
