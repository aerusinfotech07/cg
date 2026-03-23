# Python Dictionaries

## Table of Contents
1. [What is a Dictionary?](#1-what-is-a-dictionary)
2. [Creating Dictionaries](#2-creating-dictionaries)
3. [Accessing Values](#3-accessing-values)
4. [Adding and Changing](#4-adding-and-changing)
5. [Removing Items](#5-removing-items)
6. [Looping Through Dictionaries](#6-looping-through-dictionaries)
7. [Dictionary Methods](#7-dictionary-methods)
8. [Nested Dictionaries](#8-nested-dictionaries)
9. [Dictionary Comprehension](#9-dictionary-comprehension)
10. [Copying Dictionaries](#10-copying-dictionaries)

---

## 1. What is a Dictionary?

A **dictionary** stores key-value pairs. Keys must be unique and immutable (e.g., str, int, tuple). Values can be anything.

```python
person = {"name": "Alice", "age": 25, "city": "NYC"}
scores = {"math": 90, "science": 85, "english": 88}
```

---

## 2. Creating Dictionaries

```python
# Literal with {}
d1 = {"a": 1, "b": 2, "c": 3}

# dict() constructor
d2 = dict(a=1, b=2, c=3)
d3 = dict([("a", 1), ("b", 2)])

# From keys with default value
d4 = dict.fromkeys(["a", "b", "c"], 0)
# {'a': 0, 'b': 0, 'c': 0}

# Empty
empty = {}
empty = dict()
```

---

## 3. Accessing Values

### By Key

```python
person = {"name": "Alice", "age": 25}
print(person["name"])   # Alice
print(person["age"])    # 25
# print(person["city"])  # KeyError if missing
```

### get() - Safe Access

```python
person = {"name": "Alice", "age": 25}
print(person.get("name"))      # Alice
print(person.get("city"))      # None (no error)
print(person.get("city", "N/A"))  # N/A (default)
```

---

## 4. Adding and Changing

### Add or Update

```python
person = {"name": "Alice"}
person["age"] = 25        # Add new key
person["name"] = "Bob"   # Update existing
print(person)  # {'name': 'Bob', 'age': 25}
```

### update()

```python
person = {"name": "Alice"}
person.update({"age": 25, "city": "NYC"})
# Or: person.update(age=25, city="NYC")
```

---

## 5. Removing Items

### del Statement

```python
person = {"name": "Alice", "age": 25}
del person["age"]
```

### pop() - Remove and Return

```python
person = {"name": "Alice", "age": 25}
age = person.pop("age")
# person.pop("city")  # KeyError if missing
age = person.pop("city", 0)  # Default if missing
```

### popitem() - Remove Last (Python 3.7+)

```python
person = {"name": "Alice", "age": 25}
key, value = person.popitem()
```

### clear()

```python
person.clear()
```

---

## 6. Looping Through Dictionaries

### Keys (default)

```python
person = {"name": "Alice", "age": 25}
for key in person:
    print(key, person[key])

for key in person.keys():
    print(key)
```

### Values

```python
for value in person.values():
    print(value)
```

### Key-Value Pairs

```python
for key, value in person.items():
    print(f"{key}: {value}")
```

---

## 7. Dictionary Methods

| Method | Description |
|--------|-------------|
| `get(key, default)` | Get value, default if missing |
| `keys()` | View of keys |
| `values()` | View of values |
| `items()` | View of (key, value) pairs |
| `update(d)` | Merge dictionary d |
| `pop(key, default)` | Remove and return value |
| `popitem()` | Remove and return last pair |
| `clear()` | Remove all |
| `setdefault(key, default)` | Get or set default |

### setdefault()

```python
d = {"a": 1}
print(d.setdefault("b", 0))  # 0, adds "b": 0
print(d.setdefault("a", 99)) # 1, already exists
```

---

## 8. Nested Dictionaries

Dictionaries can contain other dictionaries:

```python
users = {
    "alice": {"age": 25, "city": "NYC"},
    "bob": {"age": 30, "city": "LA"}
}
print(users["alice"]["city"])  # NYC
users["alice"]["email"] = "alice@example.com"
```

---

## 9. Dictionary Comprehension

Create dictionaries concisely:

```python
# From list
squares = {x: x**2 for x in range(5)}
# {0: 0, 1: 1, 2: 4, 3: 9, 4: 16}

# With condition
evens = {x: x*2 for x in range(10) if x % 2 == 0}

# From two lists
keys = ["a", "b", "c"]
values = [1, 2, 3]
d = {k: v for k, v in zip(keys, values)}
```

---

## 10. Copying Dictionaries

### Shallow Copy

```python
original = {"a": 1, "b": [2, 3]}
copy = original.copy()
# Or: copy = dict(original)
```

### Deep Copy (nested structures)

```python
import copy
original = {"a": {"nested": 1}}
deep = copy.deepcopy(original)
```

---

## Quick Reference

| Operation | Example |
|-----------|---------|
| Access | `d["key"]`, `d.get("key")` |
| Add/Update | `d["key"] = value` |
| Remove | `del d["key"]`, `pop()`, `clear()` |
| Loop | `for k, v in d.items():` |
| Keys | Must be immutable |
| Order | Preserved (Python 3.7+) |

---

## Next Steps

- Practice dictionary operations
- Proceed to **Conditions** tutorial
