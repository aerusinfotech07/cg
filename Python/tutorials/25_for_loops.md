# Python for Loops

## Table of Contents
1. [for Loop Basics](#1-for-loop-basics)
2. [Looping Through Sequences](#2-looping-through-sequences)
3. [range() in for](#3-range-in-for)
4. [break and continue](#4-break-and-continue)
5. [else with for](#5-else-with-for)
6. [Nested Loops](#6-nested-loops)
7. [enumerate()](#7-enumerate)
8. [zip()](#8-zip)

---

## 1. for Loop Basics

Iterate over a sequence (list, string, tuple, etc.):

```python
fruits = ["apple", "banana", "cherry"]
for fruit in fruits:
    print(fruit)
```

**Output:**
```
apple
banana
cherry
```

---

## 2. Looping Through Sequences

### String

```python
for char in "Python":
    print(char)
```

### Tuple

```python
for item in (1, 2, 3):
    print(item)
```

### Dictionary

```python
d = {"a": 1, "b": 2}
for key in d:
    print(key, d[key])
for key, value in d.items():
    print(key, value)
```

---

## 3. range() in for

```python
for i in range(5):
    print(i)  # 0, 1, 2, 3, 4

for i in range(2, 6):
    print(i)  # 2, 3, 4, 5

for i in range(0, 10, 2):
    print(i)  # 0, 2, 4, 6, 8
```

---

## 4. break and continue

```python
for i in range(5):
    if i == 3:
        break
    print(i)  # 0, 1, 2

for i in range(5):
    if i == 2:
        continue
    print(i)  # 0, 1, 3, 4
```

---

## 5. else with for

Runs if loop completes without break:

```python
for i in range(3):
    print(i)
else:
    print("Done")
```

---

## 6. Nested Loops

```python
for i in range(3):
    for j in range(2):
        print(i, j)
```

---

## 7. enumerate()

Get index and value:

```python
fruits = ["apple", "banana", "cherry"]
for index, fruit in enumerate(fruits):
    print(index, fruit)
```

---

## 8. zip()

Loop over multiple sequences:

```python
names = ["Alice", "Bob"]
ages = [25, 30]
for name, age in zip(names, ages):
    print(name, age)
```

---

## Quick Reference

| Pattern | Example |
|---------|---------|
| Sequence | `for x in lst:` |
| range | `for i in range(5):` |
| enumerate | `for i, x in enumerate(lst):` |
| items | `for k, v in d.items():` |

---

## Next Steps

- Proceed to **Functions** tutorial
