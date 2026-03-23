# Python Global vs Local Variables

## Table of Contents
1. [Local Variables](#1-local-variables)
2. [Global Variables](#2-global-variables)
3. [The global Keyword](#3-the-global-keyword)
4. [Variable Shadowing](#4-variable-shadowing)
5. [Best Practices](#5-best-practices)
6. [Nested Scopes](#6-nested-scopes)

---

## 1. Local Variables

Variables created **inside a function** are **local**. They exist only within that function:

```python
def my_func():
    x = 10  # Local variable
    print(x)

my_func()
# print(x)  # NameError: x is not defined
```

**Output:**
```
10
```

### Local Scope

```python
def greet():
    name = "Alice"  # Local
    print(f"Hello, {name}")

greet()
# print(name)  # Error - name doesn't exist outside
```

---

## 2. Global Variables

Variables created **outside any function** are **global**. They can be accessed anywhere:

```python
x = 10  # Global variable

def my_func():
    print(x)  # Can read global x

my_func()
print(x)
```

**Output:**
```
10
10
```

### Reading vs Writing

You can **read** a global variable inside a function without any keyword. But to **assign** to it, you need the `global` keyword:

```python
count = 0

def increment():
    # count = count + 1  # UnboundLocalError!
    global count
    count = count + 1

increment()
print(count)  # 1
```

---

## 3. The global Keyword

Use `global` to declare you want to modify a global variable:

```python
total = 0

def add(value):
    global total
    total = total + value

add(10)
add(20)
print(total)  # 30
```

### Without global

```python
total = 0

def add(value):
    total = total + value  # Creates LOCAL total, then error!

# add(10)  # UnboundLocalError
```

### Multiple Globals

```python
x, y = 1, 2

def swap():
    global x, y
    x, y = y, x

swap()
print(x, y)  # 2 1
```

---

## 4. Variable Shadowing

A local variable can **shadow** (hide) a global with the same name:

```python
x = 10  # Global

def demo():
    x = 5  # Local - shadows global
    print(x)  # 5

demo()
print(x)  # 10 - global unchanged
```

**Output:**
```
5
10
```

### Order of Lookup

Python looks for variables in this order:
1. Local scope
2. Enclosing scope (nested functions)
3. Global scope
4. Built-in names

---

## 5. Best Practices

| Practice | Reason |
|----------|--------|
| Minimize globals | Hard to track, can cause bugs |
| Pass as parameters | Clear data flow |
| Return values | Explicit output |
| Use constants | UPPERCASE for config values |

### Prefer Parameters and Return

```python
# Better
def add(a, b):
    return a + b

result = add(5, 3)

# Avoid when possible
total = 0
def add_to_total(x):
    global total
    total += x
```

### Constants Are OK

```python
MAX_SIZE = 100  # Global constant - fine

def check_size(n):
    if n > MAX_SIZE:
        return False
    return True
```

---

## 6. Nested Scopes

Inner functions can read outer (enclosing) variables:

```python
def outer():
    x = 10

    def inner():
        print(x)  # Reads outer's x

    inner()

outer()  # 10
```

### nonlocal Keyword

To modify a variable in an enclosing (non-global) scope, use `nonlocal`:

```python
def outer():
    x = 10

    def inner():
        nonlocal x
        x = 20

    inner()
    print(x)  # 20

outer()
```

---

## Quick Reference

| Scope | Where | Access |
|-------|-------|--------|
| Local | Inside function | Only in that function |
| Global | Module level | Everywhere (read) |
| Modify global | Use `global` | Inside function |
| Enclosing | Outer function | Use `nonlocal` to modify |

---

## Next Steps

- Practice with local and global variables
- Proceed to **Data Types** tutorial
