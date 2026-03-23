# Python Getting Started

## Table of Contents
1. [Get Started With Python](#1-get-started-with-python)
2. [Python Install](#2-python-install)
3. [Python Quickstart](#3-python-quickstart)
4. [Running Your First Program](#4-running-your-first-program)

---

## 1. Get Started With Python

You can try Python **without installing anything** using online editors:

- **W3Schools Online Python Editor** – runs in your browser, shows code and result
- **Python.org** – official Python shell
- **Replit, Google Colab** – browser-based IDEs

### Try It Online

```python
print("Hello, World!")
```

**Output:**
```
Hello, World!
```

This editor approach is useful for quick experiments. For real development, install Python on your computer.

---

## 2. Python Install

### Check if Python is Installed

Many Windows PCs and Mac computers already have Python pre-installed.

#### On Windows
1. Search for **Python** in the Start menu, or
2. Open **Command Prompt** (cmd.exe) and run:

```cmd
python --version
```

#### On Linux or Mac
Open the **Terminal** and run:

```bash
python --version
```

**Example output:**
```
Python 3.12.0
```

### If Python is Not Installed

Download Python for free from the official website:

**https://www.python.org/downloads/**

| Platform | What to Do |
|----------|------------|
| **Windows** | Download installer, run it, check "Add Python to PATH" |
| **Mac** | Download .pkg installer or use `brew install python3` |
| **Linux** | Use package manager: `sudo apt install python3` (Ubuntu) |

---

## 3. Python Quickstart

Python is an **interpreted** language. You write `.py` files in a text editor and run them with the Python interpreter.

### Workflow

```
1. Write code in a .py file (text editor)
2. Save the file
3. Run: python filename.py
4. See the output
```

### Create Your First File: hello.py

Create a file named `hello.py` in any text editor (Notepad, VS Code, PyCharm, etc.):

```python
print("Hello, World!")
```

That's it. Save the file.

---

## 4. Running Your First Program

### Steps to Run

1. **Save** your file (e.g., `hello.py`)
2. **Open** Command Prompt (Windows) or Terminal (Mac/Linux)
3. **Navigate** to the folder where you saved the file:

```cmd
cd C:\Training\Python
```

4. **Run** the Python file:

```cmd
python hello.py
```

**Output:**
```
Hello, World!
```

### More Examples

#### Example 1: Run from different locations

```cmd
# If you're in C:\Training\Python
python hello.py

# If hello.py is in a subfolder
python tutorials/examples/01_hello_world.py
```

#### Example 2: Using full path (Windows)

```cmd
python "C:\Training\Python\hello.py"
```

#### Example 3: Interactive mode

You can also run Python interactively—type commands and see results immediately:

```cmd
python
```

Then in the Python shell:

```python
>>> print("Hello, World!")
Hello, World!
>>> 2 + 3
5
>>> exit()
```

### Common Issues

| Issue | Solution |
|-------|----------|
| `'python' is not recognized` | Add Python to PATH, or use `py hello.py` (Windows) |
| `No such file or directory` | Check you're in the correct folder with `cd` |
| Wrong Python version | Use `python3` instead of `python` on some systems |

---

## Quick Reference

| Action | Command |
|--------|---------|
| Check version | `python --version` |
| Run a file | `python filename.py` |
| Interactive mode | `python` (then type `exit()` to quit) |
| Windows alternative | `py filename.py` |

---

## Next Steps

- Ensure Python runs correctly with `hello.py`
- Try the examples in `tutorials/examples/`
- Proceed to **Variables and Data Types** tutorial
