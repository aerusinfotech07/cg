# Python Modules

## Table of Contents
1. [What is a Module?](#1-what-is-a-module)
2. [import Statement](#2-import-statement)
3. [from import](#3-from-import)
4. [Creating Modules](#4-creating-modules)
5. [__name__ and __main__](#5-__name__-and-__main__)
6. [Module Search Path](#6-module-search-path)
7. [dir() Function](#7-dir-function)
8. [Packages](#8-packages)

---

## 1. What is a Module?

A **module** is a file containing Python definitions and statements. Use `.py` extension.

---

## 2. import Statement

```python
import math
print(math.pi)
print(math.sqrt(16))
```

---

## 3. from import

```python
from math import pi, sqrt
print(pi)
print(sqrt(16))

# Import all (avoid in production)
from math import *
```

---

## 4. Creating Modules

Create `mymodule.py`:

```python
def greet(name):
    return f"Hello, {name}!"

PI = 3.14159
```

Use it:

```python
import mymodule
print(mymodule.greet("Alice"))
print(mymodule.PI)
```

---

## 5. __name__ and __main__

When a file is run directly, `__name__` is `"__main__"`. When imported, it's the module name:

```python
# mymodule.py
def greet(name):
    return f"Hello, {name}!"

if __name__ == "__main__":
    print("Running as script")
    print(greet("World"))
```

---

## 6. Module Search Path

Python searches:

1. Current directory
2. PYTHONPATH
3. Standard library
4. site-packages

---

## 7. dir() Function

List names in a module:

```python
import math
print(dir(math))
```

---

## 8. Packages

A **package** is a directory with `__init__.py`:

```
mypackage/
  __init__.py
  module1.py
  module2.py
```

```python
from mypackage import module1
from mypackage.module1 import some_function
```

---

## Quick Reference

| Syntax | Use |
|--------|-----|
| `import m` | Import module m |
| `from m import x` | Import x from m |
| `from m import *` | Import all (avoid) |
| `m.x` | Access attribute |
| `__name__` | Script vs module |

---

## Next Steps

- Proceed to **datetime** tutorial
