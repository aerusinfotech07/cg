# Python math Module

## Table of Contents
1. [Import math](#1-import-math)
2. [Constants](#2-constants)
3. [Rounding Functions](#3-rounding-functions)
4. [Power and Logarithm](#4-power-and-logarithm)
5. [Trigonometric Functions](#5-trigonometric-functions)
6. [Other Functions](#6-other-functions)
7. [Built-in vs math](#7-built-in-vs-math)

---

## 1. Import math

```python
import math
```

---

## 2. Constants

```python
import math

print(math.pi)   # 3.141592653589793
print(math.e)    # 2.718281828459045
print(math.tau)  # 6.283185307179586 (2*pi)
print(math.inf) # inf
print(math.nan) # nan
```

---

## 3. Rounding Functions

```python
import math

print(math.ceil(3.2))   # 4
print(math.floor(3.8))  # 3
print(math.trunc(-3.7)) # -3
```

---

## 4. Power and Logarithm

```python
import math

print(math.sqrt(16))    # 4.0
print(math.pow(2, 10))  # 1024.0
print(math.exp(1))      # e^1
print(math.log(10))     # ln(10)
print(math.log10(100))  # 2.0
print(math.log2(8))     # 3.0
```

---

## 5. Trigonometric Functions

```python
import math

# Radians
print(math.sin(math.pi/2))  # 1.0
print(math.cos(0))
print(math.tan(math.pi/4))

# Convert
print(math.degrees(math.pi))   # 180.0
print(math.radians(180))       # 3.14159...
```

---

## 6. Other Functions

```python
import math

print(math.fabs(-5))     # 5.0
print(math.factorial(5)) # 120
print(math.gcd(48, 18))  # 6
print(math.isqrt(10))    # 3 (integer sqrt)
```

---

## 7. Built-in vs math

| Built-in | math Module |
|----------|-------------|
| `abs()` | `math.fabs()` |
| `round()` | `math.ceil()`, `floor()` |
| `pow()` | `math.pow()` |

---

## Quick Reference

| Function | Use |
|----------|-----|
| `math.pi` | Pi constant |
| `math.sqrt(x)` | Square root |
| `math.ceil(x)` | Round up |
| `math.floor(x)` | Round down |
| `math.log(x)` | Natural log |
| `math.gcd(a,b)` | GCD |

---

## Next Steps

- Proceed to **json** tutorial
