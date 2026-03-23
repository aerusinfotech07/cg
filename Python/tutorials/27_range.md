# Python range()

## Table of Contents
1. [range() Basics](#1-range-basics)
2. [One Argument](#2-one-argument)
3. [Two Arguments](#3-two-arguments)
4. [Three Arguments (Step)](#4-three-arguments-step)
5. [Negative Step](#5-negative-step)
6. [range vs List](#6-range-vs-list)
7. [Common Use Cases](#7-common-use-cases)

---

## 1. range() Basics

`range()` returns an immutable sequence of numbers. It does not create a list in memory—it generates values on demand.

```python
r = range(5)
print(list(r))  # [0, 1, 2, 3, 4]
```

---

## 2. One Argument

`range(stop)` — from 0 to stop-1:

```python
for i in range(5):
    print(i)  # 0, 1, 2, 3, 4
```

---

## 3. Two Arguments

`range(start, stop)` — from start to stop-1:

```python
for i in range(2, 6):
    print(i)  # 2, 3, 4, 5
```

---

## 4. Three Arguments (Step)

`range(start, stop, step)`:

```python
for i in range(0, 10, 2):
    print(i)  # 0, 2, 4, 6, 8
```

---

## 5. Negative Step

Count backwards:

```python
for i in range(5, 0, -1):
    print(i)  # 5, 4, 3, 2, 1

for i in range(10, 0, -2):
    print(i)  # 10, 8, 6, 4, 2
```

---

## 6. range vs List

```python
# range is memory-efficient
r = range(1000000)  # Doesn't create 1M numbers
# list(r) would create them

# Check membership
print(5 in range(10))  # True
```

---

## 7. Common Use Cases

### Loop with index

```python
for i in range(len(items)):
    print(i, items[i])
```

### Countdown

```python
for i in range(5, 0, -1):
    print(i)
print("Go!")
```

### Even numbers

```python
for i in range(0, 10, 2):
    print(i)
```

---

## Quick Reference

| Syntax | Result |
|--------|--------|
| `range(5)` | 0, 1, 2, 3, 4 |
| `range(2, 6)` | 2, 3, 4, 5 |
| `range(0, 10, 2)` | 0, 2, 4, 6, 8 |
| `range(5, 0, -1)` | 5, 4, 3, 2, 1 |

---

## Next Steps

- Proceed to **Arrays** tutorial
