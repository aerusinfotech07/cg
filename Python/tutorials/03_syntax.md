# Python Syntax

## Table of Contents
1. [Execute Python Syntax](#1-execute-python-syntax)
2. [Python Indentation](#2-python-indentation)
3. [Python Variables](#3-python-variables)
4. [Comments](#4-comments)

---

## 1. Execute Python Syntax

Python syntax can be executed in two ways:

### Option A: Command Line (Interactive Mode)

Type directly in the Python interpreter:

```python
>>> print("Hello, World!")
Hello, World!
```

### Option B: Python File (.py)

Create a file with the `.py` extension and run it:

```cmd
C:\Users\Your Name>python myfile.py
```

**Example:** If your file is `hello.py`:

```cmd
python hello.py
```

---

## 2. Python Indentation

**Indentation** = spaces at the beginning of a code line.

In many languages, indentation is only for readability. In Python, **indentation defines code blocks** and is required.

### Correct Indentation

```python
if 5 > 2:
    print("Five is greater than two!")
```

**Output:**
```
Five is greater than two!
```

### Syntax Error: Missing Indentation

```python
if 5 > 2:
print("Five is greater than two!")   # ERROR!
```

**Error:**
```
IndentationError: expected an indented block
```

### How Many Spaces?

- **Minimum:** At least 1 space
- **Common:** 4 spaces (recommended by PEP 8)
- **Consistency:** Use the same number in the same block

**Both valid:**

```python
if 5 > 2:
 print("Five is greater than two!")   # 1 space

if 5 > 2:
        print("Five is greater than two!")   # 8 spaces
```

### Error: Inconsistent Indentation

All lines in the **same block** must use the **same** indentation:

```python
# WRONG - will cause error
if 5 > 2:
 print("Five is greater than two!")
        print("Five is greater than two!")   # Different spaces!
```

**Error:**
```
IndentationError: unexpected indent
```

### Indentation Rules Summary

| Rule | Description |
|------|-------------|
| Required | Indent code inside `if`, `for`, `while`, `def`, `class` |
| Consistent | Same block = same number of spaces |
| Minimum | At least 1 space |
| Recommended | 4 spaces (PEP 8 style guide) |

---

## 3. Python Variables

Variables are **created when you assign a value**. No separate declaration is needed.

```python
x = 5
y = "Hello, World!"
```

Python has **no command for declaring** a variable. The variable exists as soon as you assign to it.

### Examples

```python
# Numbers
age = 25
price = 19.99

# Strings
name = "Alice"
greeting = 'Hello'

# Multiple assignment
a = b = c = 10
x, y = 5, 10
```

You will learn more about variables in the **Python Variables** chapter.

---

## 4. Comments

Comments document your code. Python ignores them when running.

### Single-Line Comments

Start with `#`. The rest of the line is a comment:

```python
# This is a comment.
print("Hello, World!")

print("Hello, World!")  # This is also a comment
```

### Multi-Line Comments

Use `#` on each line, or triple quotes for docstrings:

```python
# This is a
# multi-line
# comment

"""
This is a multi-line string
often used as a docstring or comment.
"""
```

### Comment Best Practices

| Use | Example |
|-----|---------|
| Explain why | `# Convert to int for comparison` |
| Disable code | `# print("debug")` |
| Section headers | `# --- User Input ---` |

---

## Quick Reference

| Topic | Key Point |
|-------|-----------|
| **Execution** | Command line or `python file.py` |
| **Indentation** | Required for blocks; use 4 spaces |
| **Variables** | Created by assignment; no declaration |
| **Comments** | Start with `#` |

---

## Next Steps

- Practice indentation with `if` and `for` blocks
- Proceed to **Python Variables** tutorial for more on variables
