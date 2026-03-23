# Python File Operations

## Table of Contents
1. [os Module](#1-os-module)
2. [Checking Existence](#2-checking-existence)
3. [File Info](#3-file-info)
4. [Renaming and Removing](#4-renaming-and-removing)
5. [Directories](#5-directories)
6. [pathlib Module](#6-pathlib-module)

---

## 1. os Module

```python
import os
```

---

## 2. Checking Existence

```python
import os

print(os.path.exists("file.txt"))
print(os.path.isfile("file.txt"))
print(os.path.isdir("folder"))
```

---

## 3. File Info

```python
import os

size = os.path.getsize("file.txt")
print(size)
```

---

## 4. Renaming and Removing

```python
import os

os.rename("old.txt", "new.txt")
os.remove("file.txt")
```

---

## 5. Directories

```python
import os

os.mkdir("newdir")
os.rmdir("newdir")
print(os.listdir("."))
print(os.getcwd())
```

---

## 6. pathlib Module

```python
from pathlib import Path

p = Path("file.txt")
print(p.exists())
print(p.name)
print(p.suffix)
p.write_text("content")
print(p.read_text())
```

---

## Quick Reference

| Task | os | pathlib |
|------|-----|---------|
| Exists | `os.path.exists()` | `Path().exists()` |
| List dir | `os.listdir()` | `Path().iterdir()` |
| Remove | `os.remove()` | `Path().unlink()` |

---

## Next Steps

- Proceed to **File Paths** tutorial
