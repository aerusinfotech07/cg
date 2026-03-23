# Python File Writing

## Table of Contents
1. [Write Mode](#1-write-mode)
2. [write() Method](#2-write-method)
3. [writelines() Method](#3-writelines-method)
4. [with Statement](#4-with-statement)
5. [Overwrite Behavior](#5-overwrite-behavior)
6. [Creating New Files](#6-creating-new-files)
7. [Writing Different Types](#7-writing-different-types)

---

## 1. Write Mode

Use `"w"` to open for writing. Creates file if it doesn't exist. **Overwrites** if it does.

```python
with open("output.txt", "w") as f:
    f.write("Hello, World!\n")
```

---

## 2. write() Method

```python
with open("file.txt", "w") as f:
    f.write("Line 1\n")
    f.write("Line 2\n")
```

**Note:** `write()` does not add newlines automatically.

---

## 3. writelines() Method

Write a list of strings:

```python
lines = ["First\n", "Second\n", "Third\n"]
with open("file.txt", "w") as f:
    f.writelines(lines)
```

---

## 4. with Statement

Always use `with` for automatic closing:

```python
with open("file.txt", "w") as f:
    f.write("Content")
# File closed
```

---

## 5. Overwrite Behavior

`"w"` mode truncates (clears) the file. Use `"a"` to append instead.

---

## 6. Creating New Files

```python
# "w" creates file if not exists
with open("newfile.txt", "w") as f:
    f.write("New file content")
```

---

## 7. Writing Different Types

Convert to string before writing:

```python
with open("data.txt", "w") as f:
    f.write(str(42) + "\n")
    f.write(str(3.14) + "\n")
```

---

## Quick Reference

| Task | Code |
|------|------|
| Write | `f.write("text")` |
| Write lines | `f.writelines(list)` |
| Mode | `"w"` (overwrite), `"a"` (append) |

---

## Summary

You've completed the Python tutorial series from output to file handling. Keep practicing!
