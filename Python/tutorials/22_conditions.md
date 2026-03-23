# Python Conditions

## Table of Contents
1. [if Statement](#1-if-statement)
2. [Indentation](#2-indentation)
3. [elif (else if)](#3-elif-else-if)
4. [else](#4-else)
5. [Nested if](#5-nested-if)
6. [Conditional Expressions](#6-conditional-expressions)
7. [Short-Hand if](#7-short-hand-if)
8. [pass Statement](#8-pass-statement)

---

## 1. if Statement

Use `if` to execute code only when a condition is True:

```python
x = 10
if x > 5:
    print("x is greater than 5")
```

**Output:**
```
x is greater than 5
```

---

## 2. Indentation

Python uses indentation to define blocks. Use 4 spaces (or consistent spaces):

```python
if True:
    print("Inside if")
    print("Still inside")
print("Outside if")
```

---

## 3. elif (else if)

Use `elif` for additional conditions:

```python
score = 85
if score >= 90:
    print("A")
elif score >= 80:
    print("B")
elif score >= 70:
    print("C")
else:
    print("F")
```

**Output:**
```
B
```

---

## 4. else

Use `else` for the default case when no condition matches:

```python
age = 17
if age >= 18:
    print("Adult")
else:
    print("Minor")
```

**Output:**
```
Minor
```

---

## 5. Nested if

You can nest `if` statements inside other `if` blocks:

```python
x = 10
y = 5
if x > 5:
    if y > 3:
        print("Both conditions met")
```

---

## 6. Conditional Expressions

Ternary operator: `value_if_true if condition else value_if_false`

```python
age = 20
status = "Adult" if age >= 18 else "Minor"
print(status)
```

**Output:**
```
Adult
```

---

## 7. Short-Hand if

Single statement can be on same line:

```python
if x > 5: print("x is large")
```

Use sparingly for readability.

---

## 8. pass Statement

Use `pass` when you need a placeholder (no-op):

```python
if x > 0:
    pass  # TODO: add logic later
```

---

## Quick Reference

| Statement | Use |
|-----------|-----|
| `if` | Single condition |
| `elif` | Additional conditions |
| `else` | Default case |
| `pass` | Placeholder |

---

## Next Steps

- Proceed to **match case** tutorial (Python 3.10+)
