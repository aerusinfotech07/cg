# Python Lists

## Table of Contents
1. [What is a List?](#1-what-is-a-list)
2. [Accessing Elements](#2-accessing-elements)
3. [Changing Elements](#3-changing-elements)
4. [Adding Elements](#4-adding-elements)
5. [Removing Elements](#5-removing-elements)
6. [Looping Through Lists](#6-looping-through-lists)
7. [List Methods](#7-list-methods)
8. [List Slicing](#8-list-slicing)
9. [List Comprehension](#9-list-comprehension)

---

## 1. What is a List?

A **list** is an ordered, mutable collection of items. Items can be of any type. Lists use square brackets `[]`.

```python
fruits = ["apple", "banana", "cherry"]
numbers = [1, 2, 3, 4, 5]
mixed = [1, "hello", 3.14, True]
empty = []
```

### Creating Lists

```python
# Literal
lst = [1, 2, 3]

# list() constructor
lst = list((1, 2, 3))
lst = list("abc")  # ['a', 'b', 'c']

# Repetition
lst = [0] * 5  # [0, 0, 0, 0, 0]
```

---

## 2. Accessing Elements

Use index (0-based) to access elements:

```python
fruits = ["apple", "banana", "cherry"]
print(fruits[0])   # apple
print(fruits[1])   # banana
print(fruits[-1])  # cherry (last)
print(fruits[-2])  # banana (second to last)
```

### Negative Indexing

- `-1` = last item
- `-2` = second to last
- etc.

---

## 3. Changing Elements

Lists are **mutable**. Change elements by assignment:

```python
fruits = ["apple", "banana", "cherry"]
fruits[1] = "blueberry"
print(fruits)  # ['apple', 'blueberry', 'cherry']

# Change a range with slicing
fruits[0:2] = ["apricot", "blackberry"]
```

---

## 4. Adding Elements

### append() - Add to End

```python
fruits = ["apple", "banana"]
fruits.append("cherry")
print(fruits)  # ['apple', 'banana', 'cherry']
```

### insert() - Add at Position

```python
fruits = ["apple", "cherry"]
fruits.insert(1, "banana")
print(fruits)  # ['apple', 'banana', 'cherry']
```

### extend() - Add Multiple

```python
fruits = ["apple", "banana"]
fruits.extend(["cherry", "date"])
print(fruits)  # ['apple', 'banana', 'cherry', 'date']

# Or use +
fruits = fruits + ["elderberry"]
```

---

## 5. Removing Elements

### remove() - Remove by Value

```python
fruits = ["apple", "banana", "cherry"]
fruits.remove("banana")
print(fruits)  # ['apple', 'cherry']
```

### pop() - Remove by Index

```python
fruits = ["apple", "banana", "cherry"]
item = fruits.pop(1)   # Removes and returns "banana"
print(fruits)  # ['apple', 'cherry']
print(item)    # banana

fruits.pop()   # Removes last if no index given
```

### clear() - Remove All

```python
fruits = ["apple", "banana"]
fruits.clear()
print(fruits)  # []
```

### del Statement

```python
fruits = ["apple", "banana", "cherry"]
del fruits[1]      # Remove index 1
del fruits[0:2]    # Remove slice
```

---

## 6. Looping Through Lists

### for Loop

```python
fruits = ["apple", "banana", "cherry"]
for fruit in fruits:
    print(fruit)
```

### with enumerate()

```python
fruits = ["apple", "banana", "cherry"]
for index, fruit in enumerate(fruits):
    print(f"{index}: {fruit}")
```

### with range()

```python
fruits = ["apple", "banana", "cherry"]
for i in range(len(fruits)):
    print(f"{i}: {fruits[i]}")
```

---

## 7. List Methods

| Method | Description |
|--------|-------------|
| `append(x)` | Add x to end |
| `insert(i, x)` | Insert x at index i |
| `extend(iterable)` | Add all items |
| `remove(x)` | Remove first x |
| `pop([i])` | Remove and return at i |
| `clear()` | Remove all |
| `index(x)` | Index of first x |
| `count(x)` | Count of x |
| `sort()` | Sort in place |
| `reverse()` | Reverse in place |
| `copy()` | Shallow copy |

```python
nums = [3, 1, 4, 1, 5]
print(nums.index(4))   # 2
print(nums.count(1))   # 2
nums.sort()
print(nums)            # [1, 1, 3, 4, 5]
nums.reverse()
print(nums)            # [5, 4, 3, 1, 1]
```

---

## 8. List Slicing

Same syntax as string slicing:

```python
fruits = ["apple", "banana", "cherry", "date", "elderberry"]
print(fruits[1:4])   # ['banana', 'cherry', 'date']
print(fruits[:3])    # ['apple', 'banana', 'cherry']
print(fruits[2:])    # ['cherry', 'date', 'elderberry']
print(fruits[-2:])   # ['date', 'elderberry']
print(fruits[::2])   # ['apple', 'cherry', 'elderberry']
print(fruits[::-1])  # Reversed
```

---

## 9. List Comprehension

Create lists concisely:

```python
# Squares
squares = [x**2 for x in range(5)]
# [0, 1, 4, 9, 16]

# With condition
evens = [x for x in range(10) if x % 2 == 0]
# [0, 2, 4, 6, 8]

# Transform
upper = [s.upper() for s in ["a", "b", "c"]]
# ['A', 'B', 'C']
```

---

## Quick Reference

| Operation | Example |
|-----------|---------|
| Access | `lst[0]`, `lst[-1]` |
| Slice | `lst[1:4]` |
| Add | `append()`, `insert()`, `extend()` |
| Remove | `remove()`, `pop()`, `clear()` |
| Loop | `for x in lst:` |
| Length | `len(lst)` |

---

## Next Steps

- Practice list operations
- Proceed to **Tuples** tutorial
