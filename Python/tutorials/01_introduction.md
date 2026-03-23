# Python Introduction Tutorial

## Table of Contents
1. [What is Python?](#1-what-is-python)
2. [What can Python do?](#2-what-can-python-do)
3. [Why Python?](#3-why-python)
4. [Good to Know](#4-good-to-know)
5. [Python Syntax Compared to Other Languages](#5-python-syntax-compared-to-other-languages)
6. [Your First Python Program](#6-your-first-python-program)

---

## 1. What is Python?

Python is a popular, high-level programming language. It was created by **Guido van Rossum** and released in **1991**.

### Key Facts
- **Creator:** Guido van Rossum
- **Release Year:** 1991
- **Type:** Interpreted, high-level, general-purpose programming language

### Python is Used For
| Domain | Description |
|--------|-------------|
| **Web Development** | Server-side scripting (Django, Flask, FastAPI) |
| **Software Development** | Desktop apps, automation tools |
| **Mathematics** | Scientific computing, data analysis (NumPy, SciPy) |
| **System Scripting** | Automating tasks, file operations |

---

## 2. What can Python do?

### Web Applications
Python can run on a server to create dynamic web applications, APIs, and REST services.

### Workflow Automation
Python integrates with software like Excel, databases, and cloud services to create automated workflows.

### Database Connectivity
Python can connect to MySQL, PostgreSQL, SQLite, MongoDB, and other databases to read and modify data.

### File Operations
Python can read, write, create, and modify files on your system.

### Big Data & Mathematics
Python handles large datasets and performs complex mathematical operations with libraries like Pandas and NumPy.

### Rapid Prototyping
Python's simplicity allows quick prototyping and production-ready software development.

---

## 3. Why Python?

| Advantage | Explanation |
|-----------|-------------|
| **Cross-Platform** | Works on Windows, Mac, Linux, Raspberry Pi, and more |
| **Readable Syntax** | Similar to English; easy to read and write |
| **Fewer Lines** | Accomplishes more with less code than many languages |
| **Interpreted** | Code runs immediately—no separate compilation step |
| **Multi-Paradigm** | Supports procedural, object-oriented, and functional styles |

### Example: Python vs Other Languages

**Python (concise):**
```python
# Print numbers 1 to 5
for i in range(1, 6):
    print(i)
```

**Equivalent in some other languages requires more boilerplate (variable declaration, semicolons, braces).**

---

## 4. Good to Know

- **Current Version:** Python 3 is the standard. We use Python 3 in this tutorial.
- **Editors:** You can write Python in:
  - Text editors (Notepad++, VS Code, Sublime)
  - IDEs: Thonny, PyCharm, NetBeans, Eclipse
  - Jupyter Notebook for interactive learning

---

## 5. Python Syntax Compared to Other Languages

### New Lines Instead of Semicolons
Python uses **new lines** to end statements. No semicolons needed.

```python
x = 5
y = 10
print(x + y)
```

### Indentation Defines Scope
Python uses **whitespace (indentation)** to define blocks of code. No curly braces `{}`.

```python
if x > 0:
    print("Positive number")   # Indented = inside the if block
    print("Still inside if")
print("Outside if")            # Not indented = outside the block
```

### Readability First
Python prioritizes clean, readable code that resembles natural language.

---

## 6. Your First Python Program

### Hello, World!

The simplest Python program:

```python
print("Hello, World!")
```

**Output:**
```
Hello, World!
```

### More Examples

#### Example 1: Multiple print statements
```python
print("Hello, World!")
print("Welcome to Python")
print("Let's learn together")
```

#### Example 2: Print with variables
```python
name = "Python Learner"
print("Hello,", name)
```

#### Example 3: Print numbers and expressions
```python
print(2 + 3)           # Output: 5
print("2 + 3 =", 2 + 3)  # Output: 2 + 3 = 5
```

#### Example 4: Print with formatting
```python
age = 25
print(f"I am {age} years old")  # f-string (Python 3.6+)
```

---

## Next Steps

- Run the example files in the `examples` folder
- Practice modifying the code and observe the output
- Proceed to **Variables and Data Types** tutorial
