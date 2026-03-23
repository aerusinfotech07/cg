# Python Inheritance

## Table of Contents
1. [What is Inheritance?](#1-what-is-inheritance)
2. [Parent and Child Classes](#2-parent-and-child-classes)
3. [super() Function](#3-super-function)
4. [Overriding Methods](#4-overriding-methods)
5. [Multiple Inheritance](#5-multiple-inheritance)
6. [isinstance() and issubclass()](#6-isinstance-and-issubclass)

---

## 1. What is Inheritance?

**Inheritance** allows a child class to inherit attributes and methods from a parent class.

```python
class Animal:
    def speak(self):
        return "Some sound"

class Dog(Animal):
    pass

d = Dog()
print(d.speak())
```

---

## 2. Parent and Child Classes

```python
class Animal:
    def __init__(self, name):
        self.name = name

class Dog(Animal):
    def __init__(self, name, breed):
        super().__init__(name)
        self.breed = breed

d = Dog("Rex", "Labrador")
print(d.name, d.breed)
```

---

## 3. super() Function

`super()` calls the parent class's method:

```python
class Animal:
    def __init__(self, name):
        self.name = name

class Dog(Animal):
    def __init__(self, name, breed):
        super().__init__(name)
        self.breed = breed
```

---

## 4. Overriding Methods

Child can override parent methods:

```python
class Animal:
    def speak(self):
        return "Sound"

class Dog(Animal):
    def speak(self):
        return "Woof!"

d = Dog()
print(d.speak())
```

---

## 5. Multiple Inheritance

```python
class A:
    pass

class B:
    pass

class C(A, B):
    pass
```

---

## 6. isinstance() and issubclass()

```python
d = Dog("Rex", "Lab")
print(isinstance(d, Dog))
print(isinstance(d, Animal))
print(issubclass(Dog, Animal))
```

---

## Quick Reference

| Concept | Syntax |
|---------|--------|
| Inherit | `class Child(Parent):` |
| Call parent | `super().__init__(...)` |
| Override | Define same method in child |

---

## Next Steps

- Proceed to **Polymorphism** tutorial
