# Python Classes

## Table of Contents
1. [What is a Class?](#1-what-is-a-class)
2. [Creating a Class](#2-creating-a-class)
3. [The __init__ Method](#3-the-__init__-method)
4. [Instance Attributes](#4-instance-attributes)
5. [Instance Methods](#5-instance-methods)
6. [self Parameter](#6-self-parameter)
7. [Creating Objects](#7-creating-objects)
8. [Modifying Attributes](#8-modifying-attributes)

---

## 1. What is a Class?

A **class** is a blueprint for creating objects. It defines attributes and methods.

```python
class Dog:
    pass

my_dog = Dog()
```

---

## 2. Creating a Class

```python
class Person:
    pass

p = Person()
```

---

## 3. The __init__ Method

`__init__` is the constructor. It runs when an object is created:

```python
class Person:
    def __init__(self, name, age):
        self.name = name
        self.age = age

p = Person("Alice", 25)
```

---

## 4. Instance Attributes

Attributes belong to each instance:

```python
class Person:
    def __init__(self, name, age):
        self.name = name
        self.age = age

p = Person("Alice", 25)
print(p.name, p.age)
```

---

## 5. Instance Methods

Methods are functions defined inside a class:

```python
class Person:
    def __init__(self, name, age):
        self.name = name
        self.age = age

    def greet(self):
        return f"Hello, I'm {self.name}"

p = Person("Alice", 25)
print(p.greet())
```

---

## 6. self Parameter

`self` refers to the current instance. It must be the first parameter:

```python
class Person:
    def __init__(self, name):
        self.name = name

    def get_name(self):
        return self.name
```

---

## 7. Creating Objects

```python
p1 = Person("Alice", 25)
p2 = Person("Bob", 30)
```

---

## 8. Modifying Attributes

```python
p = Person("Alice", 25)
p.age = 26
p.city = "NYC"  # Add new attribute
```

---

## Quick Reference

```python
class ClassName:
    def __init__(self, param):
        self.attr = param

    def method(self):
        return self.attr
```

---

## Next Steps

- Proceed to **Inheritance** tutorial
