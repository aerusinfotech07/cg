# Python match case (Python 3.10+)

## Table of Contents
1. [What is match?](#1-what-is-match)
2. [Basic Syntax](#2-basic-syntax)
3. [Matching Literals](#3-matching-literals)
4. [Matching Patterns](#4-matching-patterns)
5. [Using _ (Wildcard)](#5-using-_-wildcard)
6. [Multiple Values](#6-multiple-values)
7. [match vs if-elif](#7-match-vs-if-elif)

---

## 1. What is match?

The `match` statement (Python 3.10+) provides pattern matching, similar to switch in other languages but more powerful.

---

## 2. Basic Syntax

```python
def http_status(code):
    match code:
        case 200:
            return "OK"
        case 404:
            return "Not Found"
        case 500:
            return "Server Error"
        case _:
            return "Unknown"

print(http_status(200))
```

**Output:**
```
OK
```

---

## 3. Matching Literals

Match exact values:

```python
command = "quit"
match command:
    case "start":
        print("Starting...")
    case "stop":
        print("Stopping...")
    case "quit":
        print("Quitting...")
    case _:
        print("Unknown command")
```

---

## 4. Matching Patterns

Match tuples, lists, and more:

```python
def process_point(point):
    match point:
        case (0, 0):
            return "Origin"
        case (x, 0):
            return f"On x-axis at {x}"
        case (0, y):
            return f"On y-axis at {y}"
        case (x, y):
            return f"Point at ({x}, {y})"

print(process_point((0, 4)))
```

**Output:**
```
Point at (3, 4)
```

---

## 5. Using _ (Wildcard)

`_` matches anything (like default):

```python
value = 42
match value:
    case 0:
        print("Zero")
    case 1:
        print("One")
    case _:
        print("Something else")
```

---

## 6. Multiple Values

Use `|` for multiple options:

```python
match status:
    case "active" | "running":
        print("OK")
    case "error" | "failed":
        print("Problem")
```

---

## 7. match vs if-elif

| match | if-elif |
|-------|---------|
| Pattern matching | Boolean conditions |
| Clean for many literals | More flexible |
| Python 3.10+ | All versions |

---

## Quick Reference

| Pattern | Example |
|---------|---------|
| Literal | `case 200:` |
| Multiple | `case 1 \| 2 \| 3:` |
| Wildcard | `case _:` |
| Tuple | `case (x, y):` |

---

## Next Steps

- Proceed to **while Loops** tutorial
