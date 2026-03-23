# Python None

## Table of Contents
1. [What is None?](#1-what-is-none)
2. [Checking for None](#2-checking-for-none)
3. [Default Return Value](#3-default-return-value)
4. [Optional Parameters](#4-optional-parameters)
5. [None vs Empty](#5-none-vs-empty)
6. [Common Patterns](#6-common-patterns)

---

## 1. What is None?

`None` is a special constant representing the absence of a value. It is the only instance of `NoneType`.

```python
x = None
print(x)
print(type(x))
```

**Output:**
```
None
<class 'NoneType'>
```

---

## 2. Checking for None

```python
value = None
if value is None:
    print("No value")

# Prefer: value is None
# Avoid: value == None (works but less clear)
```

---

## 3. Default Return Value

Functions without explicit return return None:

```python
def do_nothing():
    pass

print(do_nothing())  # None
```

---

## 4. Optional Parameters

```python
def greet(name=None):
    if name is None:
        return "Hello!"
    return f"Hello, {name}!"

print(greet())
print(greet("Alice"))
```

---

## 5. None vs Empty

| Value | Meaning |
|-------|---------|
| `None` | No value |
| `""` | Empty string |
| `[]` | Empty list |
| `{}` | Empty dict |

```python
# Different
x = None   # No value
y = []     # Empty list
```

---

## 6. Common Patterns

```python
# Optional return
def find_item(items, target):
    for item in items:
        if item == target:
            return item
    return None

# Dict get default
d = {"a": 1}
print(d.get("b"))  # None
```

---

## Quick Reference

| Topic | Key Point |
|-------|-----------|
| Type | NoneType |
| Check | `x is None` |
| Return | Default for functions |
| Use | Represent "no value" |

---

## Next Steps

- Proceed to **User Input** tutorial
