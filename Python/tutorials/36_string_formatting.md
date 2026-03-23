# Python String Formatting

## Table of Contents
1. [f-Strings (Recommended)](#1-f-strings-recommended)
2. [format() Method](#2-format-method)
3. [% Formatting (Legacy)](#3--formatting-legacy)
4. [Format Specifiers](#4-format-specifiers)
5. [Alignment and Padding](#5-alignment-and-padding)
6. [Number Formatting](#6-number-formatting)

---

## 1. f-Strings (Recommended)

```python
name = "Alice"
age = 25
print(f"My name is {name} and I am {age} years old.")

# Expressions
print(f"Next year: {age + 1}")

# Format spec
print(f"Pi: {3.14159:.2f}")
```

---

## 2. format() Method

```python
name = "Alice"
age = 25
print("Name: {} Age: {}".format(name, age))
print("Name: {0} Age: {1}".format(name, age))
print("Name: {name} Age: {age}".format(name=name, age=age))
```

---

## 3. % Formatting (Legacy)

```python
name = "Alice"
age = 25
print("Name: %s Age: %d" % (name, age))
```

---

## 4. Format Specifiers

| Spec | Meaning |
|------|---------|
| `:.2f` | 2 decimal places |
| `:d` | Integer |
| `:s` | String |
| `:x` | Hex |
| `:b` | Binary |
| `:05d` | Pad to 5 with zeros |

---

## 5. Alignment and Padding

```python
print(f"{'left':<10}")   # left-aligned, width 10
print(f"{'right':>10}")   # right-aligned
print(f"{'center':^10}")  # centered
print(f"{42:05d}")        # 00042
```

---

## 6. Number Formatting

```python
pi = 3.14159
print(f"{pi:.2f}")    # 3.14
print(f"{pi:.4f}")    # 3.1416
print(f"{1000:,}")    # 1,000
print(f"{42:05d}")    # 00042
print(f"{10:5d}")     # "   10"
```

---

## Quick Reference

| Method | Example |
|--------|---------|
| f-string | `f"{x}"` |
| format() | `"{}".format(x)` |
| % | `"%s" % x` |

---

## Next Steps

- Proceed to **None** tutorial
