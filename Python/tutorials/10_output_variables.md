# Python Output Variables

## Table of Contents
1. [Printing Variables](#1-printing-variables)
2. [Combining Text and Variables](#2-combining-text-and-variables)
3. [Using + for Concatenation](#3-using--for-concatenation)
4. [Using Commas](#4-using-commas)
5. [f-Strings (Recommended)](#5-f-strings-recommended)
6. [format() Method](#6-format-method)

---

## 1. Printing Variables

Use `print()` with variable names to display their values:

```python
name = "Alice"
age = 25
print(name)
print(age)
```

**Output:**
```
Alice
25
```

### Multiple Variables

```python
x = 5
y = 10
print(x, y)
```

**Output:**
```
5 10
```

---

## 2. Combining Text and Variables

Display text alongside variable values:

```python
name = "Bob"
print("Hello, " + name)
```

**Output:**
```
Hello, Bob
```

---

## 3. Using + for Concatenation

The `+` operator joins strings. **All parts must be strings**:

```python
name = "Alice"
age = 25
print("Name: " + name)
# print("Age: " + age)  # ERROR! Can't concatenate str and int
print("Age: " + str(age))  # Convert int to string
```

**Output:**
```
Name: Alice
Age: 25
```

### Concatenation Rules

| Left | Right | Result |
|------|-------|--------|
| str | str | Concatenated string |
| str | int | TypeError |
| int | int | Sum (addition) |

---

## 4. Using Commas

Commas in `print()` add a space and handle different types automatically:

```python
name = "Alice"
age = 25
price = 19.99

print("Name:", name)
print("Age:", age)
print("Price:", price)
```

**Output:**
```
Name: Alice
Age: 25
Price: 19.99
```

### Advantages

- No type conversion needed
- Automatic spacing
- Simple and readable

---

## 5. f-Strings (Recommended)

**f-strings** (formatted string literals) embed expressions in `{}`:

```python
name = "Alice"
age = 25
print(f"My name is {name} and I am {age} years old.")
```

**Output:**
```
My name is Alice and I am 25 years old.
```

### Expressions in f-Strings

```python
x, y = 5, 10
print(f"Sum: {x + y}")
print(f"Double: {x * 2}")
```

**Output:**
```
Sum: 15
Double: 10
```

### Formatting Options

```python
pi = 3.14159
print(f"Pi: {pi:.2f}")      # 2 decimal places
print(f"Pi: {pi:.4f}")      # 4 decimal places

num = 42
print(f"Padded: {num:05d}")  # 00042
```

**Output:**
```
Pi: 3.14
Pi: 3.1416
Padded: 00042
```

---

## 6. format() Method

The `format()` method uses `{}` placeholders:

```python
name = "Alice"
age = 25
print("Name: {} Age: {}".format(name, age))
```

**Output:**
```
Name: Alice Age: 25
```

### Positional and Named Arguments

```python
print("{0} and {1}".format("Alice", "Bob"))
print("{1} and {0}".format("Alice", "Bob"))
print("{name} is {age}".format(name="Alice", age=25))
```

**Output:**
```
Alice and Bob
Bob and Alice
Alice is 25
```

---

## Quick Reference

| Method | Example |
|--------|---------|
| Comma | `print("Hi", name)` |
| + | `print("Hi " + name)` (strings only) |
| f-string | `print(f"Hi {name}")` |
| format() | `print("Hi {}".format(name))` |

---

## Next Steps

- Practice outputting variables with f-strings
- Proceed to **Global Variables** tutorial
