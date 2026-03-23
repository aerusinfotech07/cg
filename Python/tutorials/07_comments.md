# Python Comments

## Table of Contents
1. [Why Use Comments?](#1-why-use-comments)
2. [Single-Line Comments](#2-single-line-comments)
3. [Multi-Line Comments](#3-multi-line-comments)
4. [Docstrings](#4-docstrings)
5. [Comment Best Practices](#5-comment-best-practices)
6. [Comments vs Code](#6-comments-vs-code)

---

## 1. Why Use Comments?

**Comments** are notes in your code that Python ignores when executing. They help you and others understand what the code does.

### Benefits
- Explain complex logic
- Document function purpose
- Temporarily disable code
- Add section headers
- Leave TODO notes

---

## 2. Single-Line Comments

Start with `#`. Everything after `#` on that line is a comment:

```python
# This is a comment
print("Hello")  # Inline comment

# Calculate total
total = 10 + 20
```

**Output:**
```
Hello
```

### Inline Comments

Place comments at the end of a line:

```python
x = 5      # Initialize counter
y = x * 2  # Double the value
```

### Commenting Out Code

Use `#` to disable code without deleting it:

```python
# print("This won't run")
print("This will run")
```

---

## 3. Multi-Line Comments

Python has no dedicated multi-line comment syntax. Use `#` on each line:

```python
# This is a multi-line comment.
# It spans several lines.
# Each line needs its own # symbol.
print("Code continues here")
```

### Alternative: Triple Quotes

Triple quotes (`"""` or `'''`) create a string. If not assigned, it acts like a comment:

```python
"""
This is a multi-line string.
It is often used as a docstring
or informal multi-line comment.
"""
print("Hello")
```

**Note:** This creates a string literal that is not used. It works but `#` is preferred for comments.

---

## 4. Docstrings

**Docstrings** are triple-quoted strings that document modules, functions, classes, and methods. They are the standard way to document Python code:

```python
def greet(name):
    """Return a greeting message for the given name."""
    return f"Hello, {name}!"

print(greet.__doc__)  # Access the docstring
```

**Output:**
```
Return a greeting message for the given name.
```

### Multi-Line Docstring

```python
def calculate_total(items):
    """
    Calculate the total price of items.
    
    Args:
        items: List of (name, price) tuples
        
    Returns:
        Total price as float
    """
    return sum(price for _, price in items)
```

---

## 5. Comment Best Practices

| Practice | Good | Avoid |
|----------|------|-------|
| Explain why | `# Use int for whole numbers` | `# set x to 5` |
| Be concise | `# Validate input` | Long paragraphs |
| Update with code | Keep in sync | Stale comments |
| Section headers | `# --- Config ---` | No structure |
| TODO notes | `# TODO: Add validation` | Forgotten tasks |

### Good Examples

```python
# Convert user input to integer for comparison
age = int(input("Age: "))

# --- Database Connection ---
# Retry up to 3 times on connection failure

# TODO: Implement error handling for edge cases
```

---

## 6. Comments vs Code

- **Comments** are ignored by Python
- **Docstrings** are stored and accessible via `__doc__`
- **Code** is executed

```python
# This comment does nothing at runtime
"""This docstring is stored but not executed"""
print("Only this runs")
```

---

## Quick Reference

| Type | Syntax | Use |
|------|--------|-----|
| Single-line | `# comment` | Short notes |
| Multi-line | `#` on each line | Longer explanations |
| Docstring | `"""text"""` | Function/class docs |
| Inline | `code  # note` | End-of-line notes |

---

## Next Steps

- Add comments to your existing code
- Proceed to **Variable Naming** tutorial
