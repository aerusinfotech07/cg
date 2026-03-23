# Python Functions

## Table of Contents
1. [Defining Functions](#1-defining-functions)
2. [Calling Functions](#2-calling-functions)
3. [Parameters and Arguments](#3-parameters-and-arguments)
4. [Return Values](#4-return-values)
5. [Default Parameters](#5-default-parameters)
6. [Keyword Arguments](#6-keyword-arguments)
7. [*args and **kwargs](#7-args-and-kwargs)
8. [Docstrings](#8-docstrings)
9. [Scope](#9-scope)

---

## 1. Defining Functions

Use `def` to define a function:

```python
def greet():
    print("Hello!")

greet()
```

---

## 2. Calling Functions

```python
def say_hello():
    print("Hello")

say_hello()
say_hello()
```

---

## 3. Parameters and Arguments

```python
def greet(name):
    print(f"Hello, {name}!")

greet("Alice")
greet("Bob")
```

**Output:**
```
Hello, Alice!
Hello, Bob!
```

### Multiple Parameters

```python
def add(a, b):
    return a + b

print(add(3, 5))
```

---

## 4. Return Values

Use `return` to send a value back:

```python
def square(x):
    return x * x

print(square(5))  # 25
```

### Multiple Return Values

```python
def min_max(lst):
    return min(lst), max(lst)

low, high = min_max([3, 1, 4])
```

---

## 5. Default Parameters

```python
def greet(name, greeting="Hello"):
    print(f"{greeting}, {name}!")

greet("Alice")
greet("Bob", "Hi")
```

---

## 6. Keyword Arguments

```python
def describe(name, age, city):
    print(f"{name}, {age}, {city}")

describe(age=25, city="NYC", name="Alice")
```

---

## 7. *args and **kwargs

### *args - Variable positional

```python
def add_all(*args):
    return sum(args)

print(add_all(1, 2, 3, 4))
```

### **kwargs - Variable keyword

```python
def print_info(**kwargs):
    for k, v in kwargs.items():
        print(f"{k}: {v}")

print_info(name="Alice", age=25)
```

---

## 8. Docstrings

```python
def add(a, b):
    """Add two numbers and return the result."""
    return a + b
```

---

## 9. Scope

```python
x = 10  # Global

def demo():
    y = 5   # Local
    print(x, y)

demo()
```

---

## Quick Reference

| Feature | Syntax |
|---------|--------|
| Define | `def name():` |
| Params | `def f(a, b):` |
| Default | `def f(a=1):` |
| Return | `return value` |
| *args | `def f(*args):` |
| **kwargs | `def f(**kwargs):` |

---

## Next Steps

- Proceed to **range()** tutorial
