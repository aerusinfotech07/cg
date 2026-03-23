# Python Multiple Assignment

## Table of Contents
1. [Assigning Multiple Variables](#1-assigning-multiple-variables)
2. [Same Value to Multiple Variables](#2-same-value-to-multiple-variables)
3. [Unpacking Sequences](#3-unpacking-sequences)
4. [Swapping Variables](#4-swapping-variables)
5. [Unpacking with *](#5-unpacking-with-)
6. [Common Patterns](#6-common-patterns)

---

## 1. Assigning Multiple Variables

You can assign values to multiple variables in one line:

```python
x, y, z = 1, 2, 3
print(x, y, z)
```

**Output:**
```
1 2 3
```

### Order Matters

Values are assigned left to right in order:

```python
a, b, c = 10, 20, 30
# a=10, b=20, c=30
```

---

## 2. Same Value to Multiple Variables

Assign the same value to several variables at once:

```python
a = b = c = 0
print(a, b, c)
```

**Output:**
```
0 0 0
```

### With Different Types

```python
x = y = z = "Python"
print(x, y, z)
```

**Output:**
```
Python Python Python
```

### Be Careful with Mutable Objects

```python
# All point to the SAME list
a = b = c = []
a.append(1)
print(b)  # [1] - b and c also changed!
```

**Safer approach:**
```python
a = b = c = []  # Same reference
# Better:
a, b, c = [], [], []  # Three separate lists
```

---

## 3. Unpacking Sequences

Assign elements from a sequence to variables:

```python
fruits = ["apple", "banana", "cherry"]
x, y, z = fruits
print(x, y, z)
```

**Output:**
```
apple banana cherry
```

### With Tuples

```python
point = (10, 20)
x, y = point
print(x, y)
```

**Output:**
```
10 20
```

### With Strings

```python
a, b, c = "XYZ"
print(a, b, c)
```

**Output:**
```
X Y Z
```

---

## 4. Swapping Variables

Multiple assignment makes swapping easy—no temporary variable needed:

```python
a, b = 5, 10
a, b = b, a
print(a, b)
```

**Output:**
```
10 5
```

### Traditional Way (Other Languages)

```python
a, b = 5, 10
temp = a
a = b
b = temp
```

Python's way is cleaner and more Pythonic.

---

## 5. Unpacking with *

Use `*` to capture remaining elements:

```python
first, *rest = [1, 2, 3, 4, 5]
print(first)   # 1
print(rest)   # [2, 3, 4, 5]
```

### First and Last

```python
*middle, last = [1, 2, 3, 4, 5]
print(middle)  # [1, 2, 3, 4]
print(last)    # 5
```

### Multiple Unpacking

```python
first, *middle, last = [1, 2, 3, 4, 5]
print(first)   # 1
print(middle)  # [2, 3, 4]
print(last)    # 5
```

---

## 6. Common Patterns

### Function Return Values

```python
def get_min_max(numbers):
    return min(numbers), max(numbers)

low, high = get_min_max([3, 1, 4, 1, 5])
print(low, high)  # 1 5
```

### Dictionary Items

```python
for key, value in {"a": 1, "b": 2}.items():
    print(f"{key}: {value}")
```

### Enumerate

```python
for index, item in enumerate(["a", "b", "c"]):
    print(index, item)
```

---

## Quick Reference

| Pattern | Example |
|---------|---------|
| Multiple | `x, y = 1, 2` |
| Same value | `a = b = c = 0` |
| Unpack list | `x, y, z = [1, 2, 3]` |
| Swap | `a, b = b, a` |
| Rest | `first, *rest = items` |

---

## Next Steps

- Practice unpacking with lists and tuples
- Proceed to **Output Variables** tutorial
