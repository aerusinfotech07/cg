# Python Sets

## Table of Contents
1. [What is a Set?](#1-what-is-a-set)
2. [Creating Sets](#2-creating-sets)
3. [Unique Elements](#3-unique-elements)
4. [Unordered Nature](#4-unordered-nature)
5. [Adding and Removing](#5-adding-and-removing)
6. [Set Operations](#6-set-operations)
7. [Set Methods](#7-set-methods)
8. [Frozen Sets](#8-frozen-sets)
9. [When to Use Sets](#9-when-to-use-sets)

---

## 1. What is a Set?

A **set** is an unordered collection of **unique** elements. No duplicates. Sets use curly braces `{}` or `set()`.

```python
fruits = {"apple", "banana", "cherry"}
numbers = {1, 2, 3, 3, 2, 1}
print(numbers)  # {1, 2, 3} - duplicates removed
```

---

## 2. Creating Sets

```python
# With curly braces
s1 = {1, 2, 3}

# From list (removes duplicates)
s2 = set([1, 2, 2, 3, 3, 3])
# {1, 2, 3}

# From string (unique characters)
s3 = set("hello")
# {'h', 'e', 'l', 'o'}

# Empty set - must use set(), not {}
empty = set()
# {} would create empty dict!
```

---

## 3. Unique Elements

Sets automatically remove duplicates:

```python
numbers = [1, 2, 2, 3, 3, 3, 4]
unique = set(numbers)
print(unique)  # {1, 2, 3, 4}

# Remove duplicates from list (order not preserved)
lst = list(set([1, 2, 2, 3]))
```

---

## 4. Unordered Nature

Sets have no index. Order is not guaranteed:

```python
s = {"apple", "banana", "cherry"}
# No s[0] - TypeError!
# Iteration order may vary
for item in s:
    print(item)
```

---

## 5. Adding and Removing

### add() - Add One Element

```python
fruits = {"apple", "banana"}
fruits.add("cherry")
fruits.add("apple")  # No effect - already exists
print(fruits)
```

### update() - Add Multiple

```python
fruits = {"apple", "banana"}
fruits.update(["cherry", "date"])
fruits.update({"elderberry", "fig"})
print(fruits)
```

### remove() / discard()

```python
fruits = {"apple", "banana", "cherry"}
fruits.remove("banana")   # Removes, KeyError if missing
fruits.discard("date")    # Removes if exists, no error if missing
```

### pop() - Remove Arbitrary Element

```python
fruits = {"apple", "banana", "cherry"}
item = fruits.pop()  # Removes and returns one element
```

### clear()

```python
fruits.clear()
```

---

## 6. Set Operations

### Union (| or union())

```python
a = {1, 2, 3}
b = {3, 4, 5}
print(a | b)         # {1, 2, 3, 4, 5}
print(a.union(b))    # Same
```

### Intersection (& or intersection())

```python
a = {1, 2, 3}
b = {3, 4, 5}
print(a & b)              # {3}
print(a.intersection(b))   # Same
```

### Difference (- or difference())

```python
a = {1, 2, 3}
b = {3, 4, 5}
print(a - b)           # {1, 2}
print(b - a)           # {4, 5}
print(a.difference(b)) # Same as a - b
```

### Symmetric Difference (^ or symmetric_difference())

```python
a = {1, 2, 3}
b = {3, 4, 5}
print(a ^ b)  # {1, 2, 4, 5} - in one but not both
```

### Membership

```python
s = {1, 2, 3}
print(2 in s)    # True
print(5 not in s)  # True
```

---

## 7. Set Methods

| Method | Description |
|--------|-------------|
| `add(x)` | Add x |
| `update(iterable)` | Add all from iterable |
| `remove(x)` | Remove x (KeyError if missing) |
| `discard(x)` | Remove x (no error if missing) |
| `pop()` | Remove and return arbitrary element |
| `clear()` | Remove all |
| `union(s)` | All elements from both |
| `intersection(s)` | Common elements |
| `difference(s)` | In self, not in s |
| `symmetric_difference(s)` | In one, not both |
| `issubset(s)` | All elements in s? |
| `issuperset(s)` | Contains all of s? |
| `isdisjoint(s)` | No common elements? |

```python
a = {1, 2, 3}
b = {2, 3, 4}
print(a.issubset({1, 2, 3, 4}))   # True
print(a.isdisjoint({5, 6}))       # True
```

---

## 8. Frozen Sets

**frozenset** is an immutable set. Cannot add or remove:

```python
fs = frozenset([1, 2, 3])
# fs.add(4)  # AttributeError!
# Can be used as dict key
d = {fs: "value"}
```

---

## 9. When to Use Sets

| Use Sets For | Avoid Sets When |
|--------------|-----------------|
| Removing duplicates | Need order |
| Fast membership test | Need indexing |
| Set math (union, etc.) | Need duplicates |
| Unique collection | Need mutable elements as items |

### Fast Lookup

```python
# O(1) lookup vs O(n) for list
valid = {1, 2, 3, 4, 5}
if 3 in valid:  # Very fast
    print("Valid")
```

---

## Quick Reference

| Topic | Key Point |
|-------|-----------|
| Unique | No duplicates |
| Unordered | No index |
| Create | `{1, 2, 3}` or `set([1,2,3])` |
| Add | `add()`, `update()` |
| Remove | `remove()`, `discard()`, `pop()` |
| Operations | `|`, `&`, `-`, `^` |

---

## Next Steps

- Practice set operations
- Proceed to **Dictionaries** tutorial
