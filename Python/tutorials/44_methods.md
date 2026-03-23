# Python Methods

## Table of Contents
1. [Instance Methods](#1-instance-methods)
2. [Class Methods](#2-class-methods)
3. [Static Methods](#3-static-methods)
4. [Special Methods](#4-special-methods)
5. [Method Types Comparison](#5-method-types-comparison)

---

## 1. Instance Methods

Take `self` as first parameter. Operate on instance:

```python
class Person:
    def __init__(self, name):
        self.name = name

    def greet(self):
        return f"Hello, {self.name}"
```

---

## 2. Class Methods

Use `@classmethod`. First parameter is `cls`:

```python
class Person:
    count = 0

    def __init__(self, name):
        self.name = name
        Person.count += 1

    @classmethod
    def get_count(cls):
        return cls.count
```

---

## 3. Static Methods

Use `@staticmethod`. No `self` or `cls`:

```python
class MathUtils:
    @staticmethod
    def add(a, b):
        return a + b

print(MathUtils.add(3, 5))
```

---

## 4. Special Methods

| Method | Use |
|--------|-----|
| `__init__` | Constructor |
| `__str__` | str(obj) |
| `__repr__` | repr(obj) |
| `__len__` | len(obj) |
| `__add__` | obj + other |
| `__eq__` | obj == other |

```python
class Point:
    def __init__(self, x, y):
        self.x, self.y = x, y

    def __str__(self):
        return f"({self.x}, {self.y})"
```

---

## 5. Method Types Comparison

| Type | Decorator | First param |
|------|-----------|-------------|
| Instance | None | self |
| Class | @classmethod | cls |
| Static | @staticmethod | None |

---

## Quick Reference

```python
def instance_method(self): ...
@classmethod
def class_method(cls): ...
@staticmethod
def static_method(): ...
```

---

## Next Steps

- Proceed to **Properties** tutorial
