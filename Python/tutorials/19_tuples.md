# Python Tuples

## Table of Contents
1. [What is a Tuple?](#1-what-is-a-tuple)
2. [Creating Tuples](#2-creating-tuples)
3. [Accessing Elements](#3-accessing-elements)
4. [Immutability](#4-immutability)
5. [Tuple Operations](#5-tuple-operations)
6. [Unpacking Tuples](#6-unpacking-tuples)
7. [When to Use Tuples](#7-when-to-use-tuples)
8. [Tuple Methods](#8-tuple-methods)

---

## 1. What is a Tuple?

A **tuple** is an ordered, **immutable** collection of items. Once created, it cannot be changed. Tuples use parentheses `()`.

```python
fruits = ("apple", "banana", "cherry")
point = (10, 20)
single = (1,)  # Note comma for single-element tuple
```

---

## 2. Creating Tuples

```python
# With parentheses
t1 = (1, 2, 3)

# Without parentheses (tuple packing)
t2 = 1, 2, 3

# Single element - comma required
t3 = (1,)   # Tuple
not_tuple = (1)  # Just int 1

# From iterable
t4 = tuple([1, 2, 3])
t5 = tuple("abc")  # ('a', 'b', 'c')

# Empty tuple
empty = ()
empty = tuple()
```

---

## 3. Accessing Elements

Same indexing as lists:

```python
fruits = ("apple", "banana", "cherry")
print(fruits[0])   # apple
print(fruits[1])   # banana
print(fruits[-1])  # cherry
```

### Slicing

```python
fruits = ("apple", "banana", "cherry", "date")
print(fruits[1:3])   # ('banana', 'cherry')
print(fruits[:2])    # ('apple', 'banana')
print(fruits[::2])   # ('apple', 'cherry')
```

---

## 4. Immutability

You **cannot** change, add, or remove elements:

```python
fruits = ("apple", "banana", "cherry")
# fruits[1] = "blueberry"  # TypeError!
# fruits.append("date")     # AttributeError!
# fruits.remove("banana")   # AttributeError!
```

### Workaround: Create New Tuple

```python
fruits = ("apple", "banana", "cherry")
# "Change" by creating new tuple
fruits = fruits[:1] + ("blueberry",) + fruits[2:]
print(fruits)  # ('apple', 'blueberry', 'cherry')
```

### Mutable Elements

If a tuple contains mutable objects (e.g., list), those can be modified:

```python
t = (1, [2, 3])
# t[0] = 10     # Error
t[1].append(4)   # OK - modifying inner list
print(t)        # (1, [2, 3, 4])
```

---

## 5. Tuple Operations

### Concatenation

```python
t1 = (1, 2)
t2 = (3, 4)
print(t1 + t2)  # (1, 2, 3, 4)
```

### Repetition

```python
t = (1, 2) * 3
print(t)  # (1, 2, 1, 2, 1, 2)
```

### Membership

```python
fruits = ("apple", "banana", "cherry")
print("banana" in fruits)   # True
print("date" not in fruits) # True
```

### Length

```python
fruits = ("apple", "banana", "cherry")
print(len(fruits))  # 3
```

---

## 6. Unpacking Tuples

Assign tuple elements to variables:

```python
point = (10, 20)
x, y = point
print(x, y)  # 10 20

# Swap
a, b = 5, 10
a, b = b, a
print(a, b)  # 10 5

# With *
first, *rest = (1, 2, 3, 4)
print(first, rest)  # 1 [2, 3, 4]
```

---

## 7. When to Use Tuples

| Use Tuples When | Use Lists When |
|-----------------|----------------|
| Data should not change | Data may change |
| Returning multiple values | Collecting items |
| Dictionary keys | Need append/remove |
| Heterogeneous data | Homogeneous data |
| Slightly faster, less memory | More flexible |

### Example: Function Return

```python
def get_min_max(nums):
    return min(nums), max(nums)

low, high = get_min_max([3, 1, 4, 1, 5])
```

### Example: Dictionary Keys

```python
locations = {(0, 0): "origin", (1, 0): "east"}
# Lists cannot be dict keys (mutable)
```

---

## 8. Tuple Methods

Tuples have only two methods (no add/remove):

### count(x)

```python
t = (1, 2, 2, 3, 2)
print(t.count(2))  # 3
```

### index(x)

```python
t = (1, 2, 3, 2)
print(t.index(2))   # 1 (first occurrence)
print(t.index(2, 2))  # 3 (start search at index 2)
```

---

## Quick Reference

| Topic | Key Point |
|-------|-----------|
| Syntax | `(1, 2, 3)` |
| Immutable | Cannot change after creation |
| Access | `t[0]`, `t[-1]` |
| Unpack | `x, y = point` |
| Methods | `count()`, `index()` |

---

## Next Steps

- Practice tuple creation and unpacking
- Proceed to **Sets** tutorial
