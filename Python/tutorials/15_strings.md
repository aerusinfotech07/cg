# Python Strings

## Table of Contents
1. [String Basics](#1-string-basics)
2. [String Indexing](#2-string-indexing)
3. [String Slicing](#3-string-slicing)
4. [String Methods](#4-string-methods)
5. [String Concatenation](#5-string-concatenation)
6. [Escape Characters](#6-escape-characters)
7. [Multiline Strings](#7-multiline-strings)

---

## 1. String Basics

Strings are sequences of characters enclosed in single or double quotes. They are **immutable**.

```python
s1 = "Hello"
s2 = 'World'
s3 = """Multi-line
string"""
```

### Empty String

```python
empty = ""
```

---

## 2. String Indexing

Access individual characters by index. Indexing starts at 0:

```python
s = "Python"
print(s[0])   # P
print(s[1])   # y
print(s[5])   # n
```

### Negative Indexing

Count from the end. -1 is the last character:

```python
s = "Python"
print(s[-1])   # n (last)
print(s[-2])   # o (second to last)
print(s[-6])   # P (first)
```

---

## 3. String Slicing

Get a substring with `[start:stop:step]`:

```python
s = "Hello, World!"

print(s[0:5])    # Hello (indices 0-4)
print(s[7:12])   # World
print(s[:5])     # Hello (start defaults to 0)
print(s[7:])     # World! (end defaults to len)
print(s[-6:-1])  # World (negative indices)
```

### Step

```python
s = "Python"
print(s[::2])    # Pto (every 2nd char)
print(s[::-1])   # nohtyP (reversed)
print(s[1:5:2])  # yh (from 1 to 5, step 2)
```

### Slice Syntax Summary

| Syntax | Meaning |
|--------|---------|
| `s[i]` | Character at index i |
| `s[i:j]` | From i to j-1 |
| `s[i:j:k]` | From i to j-1, step k |
| `s[:j]` | From start to j-1 |
| `s[i:]` | From i to end |
| `s[::-1]` | Reversed |

---

## 4. String Methods

### Case Conversion

```python
s = "Hello, World!"
print(s.upper())   # HELLO, WORLD!
print(s.lower())   # hello, world!
print(s.title())   # Hello, World!
print(s.capitalize())  # Hello, world!
```

### Search and Replace

```python
s = "hello world"
print(s.find("world"))      # 6
print(s.find("xyz"))       # -1 (not found)
print(s.replace("world", "Python"))  # hello Python
```

### Strip and Split

```python
s = "  hello world  "
print(s.strip())   # "hello world"
print(s.lstrip())  # "hello world  "
print(s.rstrip())  #  hello world

s = "a,b,c"
print(s.split(","))   # ['a', 'b', 'c']
print(" ".join(["a", "b", "c"]))  # a b c
```

### Check Content

```python
s = "Hello123"
print(s.isalpha())   # False (has digits)
print(s.isdigit())   # False
print(s.isalnum())   # True
print("123".isdigit())  # True
print("hello".startswith("he"))  # True
print("hello".endswith("lo"))    # True
```

### Length

```python
s = "Python"
print(len(s))  # 6
```

---

## 5. String Concatenation

### Using +

```python
a = "Hello"
b = "World"
print(a + " " + b)  # Hello World
```

### Using * (Repetition)

```python
print("Ha" * 3)  # HaHaHa
```

---

## 6. Escape Characters

| Escape | Meaning |
|--------|---------|
| `\n` | Newline |
| `\t` | Tab |
| `\\` | Backslash |
| `\"` | Double quote |
| `\'` | Single quote |
| `\r` | Carriage return |

```python
print("Line 1\nLine 2")
print("Name:\tAlice")
print("He said \"Hi\"")
```

---

## 7. Multiline Strings

Use triple quotes for multiline strings:

```python
text = """Line 1
Line 2
Line 3"""
```

---

## Quick Reference

| Operation | Example |
|-----------|---------|
| Index | `s[0]`, `s[-1]` |
| Slice | `s[1:4]`, `s[::-1]` |
| Length | `len(s)` |
| Upper | `s.upper()` |
| Replace | `s.replace("a", "b")` |
| Split | `s.split(",")` |
| Join | `" ".join(list)` |

---

## Next Steps

- Practice slicing and string methods
- Proceed to **Booleans** tutorial
