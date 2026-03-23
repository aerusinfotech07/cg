# Python Constructors

## Table of Contents
1. [__init__ Method](#1-__init__-method)
2. [Parameters](#2-parameters)
3. [Default Values](#3-default-values)
4. [__new__ Method](#4-__new__-method)
5. [Class vs Instance Attributes](#5-class-vs-instance-attributes)

---

## 1. __init__ Method

`__init__` is the constructor. It initializes the object:

```python
class Person:
    def __init__(self, name, age):
        self.name = name
        self.age = age

p = Person("Alice", 25)
```

---

## 2. Parameters

```python
class Point:
    def __init__(self, x=0, y=0):
        self.x = x
        self.y = y

p1 = Point()
p2 = Point(3, 4)
```

---

## 3. Default Values

```python
class Car:
    def __init__(self, brand, color="white"):
        self.brand = brand
        self.color = color

c = Car("Toyota")
print(c.color)
```

---

## 4. __new__ Method

`__new__` creates the object; `__init__` initializes it. Rarely overridden:

```python
class Singleton:
    _instance = None

    def __new__(cls):
        if cls._instance is None:
            cls._instance = super().__new__(cls)
        return cls._instance
```

---

## 5. Class vs Instance Attributes

```python
class Dog:
    species = "Canis"  # Class attribute

    def __init__(self, name):
        self.name = name  # Instance attribute
```

---

## Quick Reference

```python
def __init__(self, param1, param2=default):
    self.attr1 = param1
    self.attr2 = param2
```

---

## Next Steps

- Proceed to **Methods** tutorial
