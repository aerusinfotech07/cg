# Python Variables

## Table of Contents
1. [What Are Variables?](#1-what-are-variables)
2. [Creating Variables](#2-creating-variables)
3. [Casting](#3-casting)
4. [Get the Type](#4-get-the-type)
5. [Single or Double Quotes?](#5-single-or-double-quotes)
6. [Case-Sensitive](#6-case-sensitive)

---

## 1. What Are Variables?

**Variables** are containers for storing data values.

Think of them as labeled boxes: you put a value in, and you can use the label (variable name) to access it later.

---

## 2. Creating Variables

Python has **no command for declaring** a variable. A variable is created the moment you first assign a value to it.

```python
x = 5
y = "John"
print(x)
print(y)
```

**Output:**
```
5
John
```

### Variables Can Change Type

Variables do **not** need a fixed type. They can change type after being set:

```python
x = 4      # x is of type int
x = "Sally" # x is now of type str
print(x)
```

**Output:**
```
Sally
```

---

## 3. Casting

If you want to specify the data type of a variable, use **casting**:

| Function | Converts To | Example |
|----------|-------------|---------|
| `str()` | String | `str(3)` → `'3'` |
| `int()` | Integer | `int(3)` → `3` |
| `float()` | Float | `float(3)` → `3.0` |

```python
x = str(3)    # x will be '3'
y = int(3)    # y will be 3
z = float(3)  # z will be 3.0

print(x, type(x))  # 3 <class 'str'>
print(y, type(y))  # 3 <class 'int'>
print(z, type(z))  # 3.0 <class 'float'>
```

### Common Casting Examples

```python
# String to int
age = int("25")

# Int to string
score = str(100)

# String to float
price = float("19.99")
```

---

## 4. Get the Type

Use the `type()` function to get the data type of a variable:

```python
x = 5
y = "John"
print(type(x))
print(type(y))
```

**Output:**
```
<class 'int'>
<class 'str'>
```

---

## 5. Single or Double Quotes?

String variables can use **single** or **double** quotes. Both work the same:

```python
x = "John"
# is the same as
x = 'John'
```

### When to Use Which?

| Use | Example |
|-----|---------|
| Double quotes | `"Hello, World!"` |
| Single quotes | `'Hello'` or when string contains `"` |
| Avoid escaping | `"It's easy"` or `'He said "Hi"'` |

```python
# Both are equivalent
name1 = "Alice"
name2 = 'Alice'

# Use the other quote when one appears in the string
msg = "It's a nice day"
quote = 'He said "Hello"'
```

---

## 6. Case-Sensitive

Variable names are **case-sensitive**. `a` and `A` are different variables:

```python
a = 4
A = "Sally"

print(a)   # Output: 4
print(A)   # Output: Sally
# A will not overwrite a
```

### Examples

```python
name = "John"
Name = "Jane"
NAME = "Bob"

print(name)   # John
print(Name)   # Jane
print(NAME)   # Bob
```

---

## Quick Reference

| Topic | Key Point |
|-------|-----------|
| **Creation** | Assign a value; no declaration needed |
| **Type** | Can change; use `type()` to check |
| **Casting** | `str()`, `int()`, `float()` |
| **Quotes** | Single `'` or double `"` for strings |
| **Case** | `name` and `Name` are different |

---

## Next Steps

- Practice creating variables and using `type()`
- Proceed to **Python Data Types** tutorial
