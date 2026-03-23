# Python Output

## Table of Contents
1. [The print() Function](#1-the-print-function)
2. [Printing Text](#2-printing-text)
3. [Printing Numbers](#3-printing-numbers)
4. [Multiple Arguments](#4-multiple-arguments)
5. [Separator and End](#5-separator-and-end)
6. [Printing Without Newline](#6-printing-without-newline)

---

## 1. The print() Function

The `print()` function displays output to the console. It is one of the most commonly used built-in functions in Python.

```python
print("Hello, World!")
```

**Output:**
```
Hello, World!
```

---

## 2. Printing Text

You can print strings using single or double quotes:

```python
print("Hello, World!")
print('Python is fun')
print("It's a great day")
```

**Output:**
```
Hello, World!
Python is fun
It's a great day
```

### Escape Sequences

Use backslash for special characters:

| Sequence | Meaning |
|----------|---------|
| `\n` | New line |
| `\t` | Tab |
| `\\` | Backslash |
| `\"` | Double quote |
| `\'` | Single quote |

```python
print("Line 1\nLine 2")
print("Name:\tAlice")
print("Path: C:\\Users\\Documents")
```

**Output:**
```
Line 1
Line 2
Name:	Alice
Path: C:\Users\Documents
```

---

## 3. Printing Numbers

You can print integers and floats directly:

```python
print(42)
print(3.14)
print(-100)
print(0)
```

**Output:**
```
42
3.14
-100
0
```

### Arithmetic in print()

Python evaluates expressions before printing:

```python
print(5 + 3)
print(10 - 4)
print(6 * 7)
print(20 / 4)
```

**Output:**
```
8
6
42
5.0
```

---

## 4. Multiple Arguments

Pass multiple items to `print()` separated by commas. They are printed with a space between them:

```python
print("Hello", "World")
print("Age:", 25)
print(1, 2, 3, 4, 5)
```

**Output:**
```
Hello World
Age: 25
1 2 3 4 5
```

---

## 5. Separator and End

### The sep Parameter

Control what appears between multiple arguments (default is space):

```python
print("a", "b", "c")
print("a", "b", "c", sep="-")
print("2024", "03", "10", sep="/")
print("Python", "Tutorial", sep=" | ")
```

**Output:**
```
a b c
a-b-c
2024/03/10
Python | Tutorial
```

### The end Parameter

Control what appears at the end (default is newline `\n`):

```python
print("Hello", end="")
print("World")
print("A", end=" ")
print("B", end=" ")
print("C")
```

**Output:**
```
HelloWorld
A B C
```

---

## 6. Printing Without Newline

Use `end=""` to print on the same line:

```python
for i in range(3):
    print(i, end=" ")
```

**Output:**
```
0 1 2
```

---

## Quick Reference

| Topic | Key Point |
|-------|-----------|
| **Basic** | `print("text")` or `print(42)` |
| **Multiple** | `print("a", "b")` → space between |
| **sep** | `print(1, 2, sep="-")` → `1-2` |
| **end** | `print("Hi", end="")` → no newline |
| **Escape** | `\n` newline, `\t` tab |

---

## Next Steps

- Practice printing different data types
- Proceed to **Comments** tutorial
