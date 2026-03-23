# Python Iterators

## Table of Contents
1. [What is an Iterator?](#1-what-is-an-iterator)
2. [iter() and next()](#2-iter-and-next)
3. [Creating Iterators](#3-creating-iterators)
4. [StopIteration](#4-stopiteration)
5. [Iterable vs Iterator](#5-iterable-vs-iterator)
6. [Built-in Iterables](#6-built-in-iterables)

---

## 1. What is an Iterator?

An **iterator** is an object that produces values one at a time. It implements `__iter__()` and `__next__()`.

---

## 2. iter() and next()

```python
fruits = ["apple", "banana", "cherry"]
it = iter(fruits)

print(next(it))  # apple
print(next(it))  # banana
print(next(it))  # cherry
# print(next(it))  # StopIteration
```

---

## 3. Creating Iterators

```python
class CountDown:
    def __init__(self, start):
        self.current = start

    def __iter__(self):
        return self

    def __next__(self):
        if self.current <= 0:
            raise StopIteration
        self.current -= 1
        return self.current + 1

for i in CountDown(3):
    print(i)  # 3, 2, 1
```

---

## 4. StopIteration

When no more items, `__next__()` should raise `StopIteration`:

```python
class SimpleIterator:
    def __init__(self, data):
        self.data = data
        self.index = 0

    def __iter__(self):
        return self

    def __next__(self):
        if self.index >= len(self.data):
            raise StopIteration
        value = self.data[self.index]
        self.index += 1
        return value
```

---

## 5. Iterable vs Iterator

| Iterable | Iterator |
|----------|----------|
| Has `__iter__()` | Has `__iter__()` and `__next__()` |
| Can be looped | Produces values |

- **Iterable**: list, str, dict, range
- **Iterator**: result of `iter()`, generator

---

## 6. Built-in Iterables

```python
# All support iter()
for x in [1, 2, 3]: pass
for c in "abc": pass
for k in {"a": 1}: pass
for i in range(5): pass
```

---

## Quick Reference

| Function | Use |
|----------|-----|
| `iter(obj)` | Get iterator from iterable |
| `next(it)` | Get next value |
| `StopIteration` | Signal end of iteration |

---

## Next Steps

- Proceed to **Modules** tutorial
