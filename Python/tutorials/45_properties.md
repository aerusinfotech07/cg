# Python Properties

## Table of Contents
1. [@property Decorator](#1-property-decorator)
2. [Setters](#2-setters)
3. [Deleters](#3-deleters)
4. [Read-Only Properties](#4-read-only-properties)
5. [Computed Properties](#5-computed-properties)
6. [property() Function](#6-property-function)

---

## 1. @property Decorator

Makes a method callable as an attribute:

```python
class Circle:
    def __init__(self, radius):
        self._radius = radius

    @property
    def radius(self):
        return self._radius

c = Circle(5)
print(c.radius)
```

---

## 2. Setters

```python
class Circle:
    @property
    def radius(self):
        return self._radius

    @radius.setter
    def radius(self, value):
        if value < 0:
            raise ValueError("Radius must be positive")
        self._radius = value
```

---

## 3. Deleters

```python
@radius.deleter
def radius(self):
    del self._radius
```

---

## 4. Read-Only Properties

No setter = read-only:

```python
class Person:
    def __init__(self, first, last):
        self._first = first
        self._last = last

    @property
    def full_name(self):
        return f"{self._first} {self._last}"
```

---

## 5. Computed Properties

```python
class Rectangle:
    def __init__(self, w, h):
        self.w = w
        self.h = h

    @property
    def area(self):
        return self.w * self.h
```

---

## 6. property() Function

```python
def get_x(self): return self._x
def set_x(self, value): self._x = value
x = property(get_x, set_x)
```

---

## Quick Reference

| Decorator | Use |
|-----------|-----|
| @property | Getter |
| @name.setter | Setter |
| @name.deleter | Deleter |

---

## Next Steps

- Proceed to **File Read** tutorial
