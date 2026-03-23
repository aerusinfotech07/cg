# Python User Input

## Table of Contents
1. [input() Function](#1-input-function)
2. [Return Type](#2-return-type)
3. [Converting Input](#3-converting-input)
4. [Prompt Message](#4-prompt-message)
5. [Input Validation](#5-input-validation)
6. [Multiple Inputs](#6-multiple-inputs)
7. [Common Patterns](#7-common-patterns)

---

## 1. input() Function

`input()` reads a line from the user and returns it as a string:

```python
name = input("Enter your name: ")
print(f"Hello, {name}!")
```

---

## 2. Return Type

`input()` always returns a string:

```python
age = input("Enter age: ")
print(type(age))  # <class 'str'>
# age + 1  # TypeError!
```

---

## 3. Converting Input

```python
age = int(input("Enter age: "))
price = float(input("Enter price: "))
```

---

## 4. Prompt Message

```python
name = input("What is your name? ")
print(f"Hello, {name}!")
```

---

## 5. Input Validation

```python
while True:
    try:
        age = int(input("Enter age (0-120): "))
        if 0 <= age <= 120:
            break
    except ValueError:
        pass
    print("Invalid. Try again.")
print(f"Age: {age}")
```

---

## 6. Multiple Inputs

```python
# Split by space
parts = input("Enter name and age: ").split()
name, age = parts[0], int(parts[1])

# Or
name, age = input("Enter name and age: ").split()
age = int(age)
```

---

## 7. Common Patterns

```python
# Yes/No
response = input("Continue? (y/n): ").lower()
if response in ('y', 'yes'):
    print("Continuing")

# With default
name = input("Name [default]: ").strip() or "default"
```

---

## Quick Reference

| Task | Code |
|------|------|
| Read string | `input("Prompt: ")` |
| Convert to int | `int(input(...))` |
| Convert to float | `float(input(...))` |
| Split | `input().split()` |

---

## Next Steps

- Proceed to **Classes** tutorial
