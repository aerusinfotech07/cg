# Python Statements

## Table of Contents
1. [What Are Statements?](#1-what-are-statements)
2. [Many Statements](#2-many-statements)
3. [Semicolons (Optional, Rarely Used)](#3-semicolons-optional-rarely-used)
4. [Best Practices](#4-best-practices)

---

## 1. What Are Statements?

A **computer program** is a list of instructions to be executed by a computer.

In a programming language, these instructions are called **statements**.

### Example

```python
print("Python is fun!")
```

**Output:**
```
Python is fun!
```

### No Semicolons Needed

In Python, a statement usually **ends when the line ends**. You do **not** need a semicolon (`;`) like in Java, C, or JavaScript.

| Language | Statement End |
|----------|---------------|
| Python | New line |
| Java, C, JavaScript | Semicolon `;` |

---

## 2. Many Statements

Most Python programs contain **many statements**. They are executed **one by one**, in the **same order** as they are written.

```python
print("Hello World!")
print("Have a good day.")
print("Learning Python is fun!")
```

**Output:**
```
Hello World!
Have a good day.
Learning Python is fun!
```

### Execution Order

| Step | Statement | What Happens |
|------|-----------|--------------|
| 1 | `print("Hello World!")` | Prints "Hello World!" |
| 2 | `print("Have a good day.")` | Prints "Have a good day." |
| 3 | `print("Learning Python is fun!")` | Prints "Learning Python is fun!" |

### More Examples

```python
# Statements execute in order
x = 5
y = 10
total = x + y
print(total)   # Output: 15
```

---

## 3. Semicolons (Optional, Rarely Used)

Semicolons are **optional** in Python. You can put multiple statements on one line by separating them with `;`:

```python
print("Hello"); print("How are you?"); print("Bye bye!")
```

**Output:**
```
Hello
How are you?
Bye bye!
```

### Error: Missing Separator

If you put two statements on the **same line** without a separator (newline or `;`), Python gives an error:

```python
# WRONG - SyntaxError!
print("Python is fun!") print("Really!")
```

**Error:**
```
SyntaxError: invalid syntax
```

### When Semicolons Might Be Used

- Rarely in practice
- Sometimes in one-liner scripts
- Generally **avoid** for readability

---

## 4. Best Practices

| Practice | Why |
|----------|-----|
| **One statement per line** | Easy to read and debug |
| **Avoid semicolons** | Keeps code clean and Pythonic |
| **Use clear variable names** | Makes statements self-explanatory |

### Good

```python
print("Hello World!")
print("Have a good day.")
print("Learning Python is fun!")
```

### Avoid

```python
print("Hello"); print("How are you?"); print("Bye bye!")
```

---

## Quick Reference

| Topic | Key Point |
|-------|-----------|
| **Statement** | Single instruction to execute |
| **Line end** | Statement ends at new line (no `;` needed) |
| **Order** | Statements run top to bottom, one by one |
| **Semicolons** | Optional; use sparingly for readability |

---

## Next Steps

- Practice writing programs with multiple statements
- Proceed to **Python Variables** or **Data Types** tutorial
