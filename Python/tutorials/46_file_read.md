# Python File Reading

## Table of Contents
1. [open() Function](#1-open-function)
2. [Reading Entire File](#2-reading-entire-file)
3. [Reading Line by Line](#3-reading-line-by-line)
4. [readline() and readlines()](#4-readline-and-readlines)
5. [with Statement](#5-with-statement)
6. [File Modes](#6-file-modes)
7. [Encoding](#7-encoding)

---

## 1. open() Function

```python
f = open("file.txt", "r")
content = f.read()
f.close()
```

---

## 2. Reading Entire File

```python
with open("file.txt", "r") as f:
    content = f.read()
print(content)
```

---

## 3. Reading Line by Line

```python
with open("file.txt", "r") as f:
    for line in f:
        print(line.strip())
```

---

## 4. readline() and readlines()

```python
with open("file.txt", "r") as f:
    line = f.readline()
    lines = f.readlines()
```

---

## 5. with Statement

`with` automatically closes the file:

```python
with open("file.txt", "r") as f:
    content = f.read()
# File closed here
```

---

## 6. File Modes

| Mode | Meaning |
|------|---------|
| `"r"` | Read (default) |
| `"w"` | Write (overwrite) |
| `"a"` | Append |
| `"r+"` | Read and write |
| `"b"` | Binary (e.g., "rb") |

---

## 7. Encoding

```python
with open("file.txt", "r", encoding="utf-8") as f:
    content = f.read()
```

---

## Quick Reference

```python
with open("file.txt", "r") as f:
    content = f.read()
    # or: for line in f:
```

---

## Next Steps

- Proceed to **File Append** tutorial
