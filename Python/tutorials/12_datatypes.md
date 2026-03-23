# Python Data Types

## Table of Contents
1. [Built-in Data Types](#1-built-in-data-types)
2. [Getting the Type](#2-getting-the-type)
3. [Numeric Types](#3-numeric-types)
4. [Sequence Types](#4-sequence-types)
5. [Mapping Type](#5-mapping-type)
6. [Set Type](#6-set-type)
7. [Boolean Type](#7-boolean-type)
8. [None Type](#8-none-type)

---

## 1. Built-in Data Types

Python has several built-in data types. Variables get their type from the value assigned:

| Category | Type | Example |
|----------|------|---------|
| Numeric | `int` | `42` |
| Numeric | `float` | `3.14` |
| Numeric | `complex` | `3+4j` |
| Sequence | `str` | `"hello"` |
| Sequence | `list` | `[1, 2, 3]` |
| Sequence | `tuple` | `(1, 2, 3)` |
| Mapping | `dict` | `{"a": 1}` |
| Set | `set` | `{1, 2, 3}` |
| Boolean | `bool` | `True`, `False` |
| None | `NoneType` | `None` |

---

## 2. Getting the Type

Use `type()` to check a variable's type:

```python
x = 5
y = "hello"
z = [1, 2, 3]

print(type(x))  # <class 'int'>
print(type(y))  # <class 'str'>
print(type(z))  # <class 'list'>
```

---

## 3. Numeric Types

### int (Integer)

Whole numbers, no decimal point:

```python
age = 25
count = -100
big = 1000000
```

### float (Floating Point)

Numbers with decimal point:

```python
price = 19.99
pi = 3.14159
temp = -5.5
```

### complex

Complex numbers with real and imaginary parts:

```python
z = 3 + 4j
print(z.real)  # 3.0
print(z.imag)  # 4.0
```

---

## 4. Sequence Types

### str (String)

Ordered, immutable sequence of characters:

```python
name = "Alice"
greeting = 'Hello'
```

### list

Ordered, mutable sequence:

```python
fruits = ["apple", "banana", "cherry"]
numbers = [1, 2, 3, 4, 5]
```

### tuple

Ordered, immutable sequence:

```python
point = (10, 20)
colors = ("red", "green", "blue")
```

---

## 5. Mapping Type

### dict (Dictionary)

Key-value pairs, unordered (Python 3.7+ preserves insertion order):

```python
person = {"name": "Alice", "age": 25}
scores = {"math": 90, "science": 85}
```

---

## 6. Set Type

### set

Unordered collection of unique elements, mutable:

```python
unique_nums = {1, 2, 3, 3, 2}  # {1, 2, 3}
vowels = {"a", "e", "i", "o", "u"}
```

### frozenset

Immutable version of set:

```python
frozen = frozenset([1, 2, 3])
```

---

## 7. Boolean Type

### bool

Logical values: `True` or `False`:

```python
is_active = True
is_empty = False
```

---

## 8. None Type

### None

Represents absence of value:

```python
result = None
value = None
```

---

## Type Summary Table

| Type | Mutable | Ordered | Duplicates |
|------|---------|---------|------------|
| int | N/A | N/A | N/A |
| float | N/A | N/A | N/A |
| str | No | Yes | Yes |
| list | Yes | Yes | Yes |
| tuple | No | Yes | Yes |
| dict | Yes | Yes* | Keys: No |
| set | Yes | No | No |

*Dict preserves order in Python 3.7+

---

## Quick Reference

| Type | Example |
|------|---------|
| int | `42` |
| float | `3.14` |
| str | `"hello"` |
| list | `[1, 2, 3]` |
| tuple | `(1, 2, 3)` |
| dict | `{"a": 1}` |
| set | `{1, 2, 3}` |
| bool | `True`, `False` |
| None | `None` |

---

## Next Steps

- Use `type()` to explore different values
- Proceed to **Numbers** tutorial for numeric details
