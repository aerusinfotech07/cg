# Python Polymorphism

## Table of Contents
1. [What is Polymorphism?](#1-what-is-polymorphism)
2. [Method Overriding](#2-method-overriding)
3. [Duck Typing](#3-duck-typing)
4. [Operator Overloading](#4-operator-overloading)
5. [Polymorphic Functions](#5-polymorphic-functions)

---

## 1. What is Polymorphism?

**Polymorphism** means "many forms"—the same interface can behave differently for different types.

```python
class Dog:
    def speak(self):
        return "Woof!"

class Cat:
    def speak(self):
        return "Meow!"

def animal_sound(animal):
    print(animal.speak())

animal_sound(Dog())
animal_sound(Cat())
```

---

## 2. Method Overriding

Child classes override parent methods:

```python
class Shape:
    def area(self):
        return 0

class Rectangle(Shape):
    def __init__(self, w, h):
        self.w, self.h = w, h
    def area(self):
        return self.w * self.h
```

---

## 3. Duck Typing

"If it walks like a duck and quacks like a duck, it's a duck." Python uses duck typing—we care about behavior, not type:

```python
def process(obj):
    obj.do_something()  # Works if obj has do_something
```

---

## 4. Operator Overloading

Override operators with special methods:

```python
class Point:
    def __init__(self, x, y):
        self.x, self.y = x, y

    def __add__(self, other):
        return Point(self.x + other.x, self.y + other.y)

    def __str__(self):
        return f"({self.x}, {self.y})"
```

---

## 5. Polymorphic Functions

```python
print(len("hello"))
print(len([1, 2, 3]))
print(len({"a": 1, "b": 2}))
# len() works with different types
```

---

## Quick Reference

| Concept | Example |
|---------|---------|
| Override | Same method, different classes |
| Duck typing | Same interface, different types |
| Overload | `__add__`, `__str__`, etc. |

---

## Next Steps

- Proceed to **Encapsulation** tutorial
