# Python File Paths

## Table of Contents
1. [Path Separators](#1-path-separators)
2. [os.path](#2-ospath)
3. [pathlib.Path](#3-pathlibpath)
4. [Absolute vs Relative](#4-absolute-vs-relative)
5. [Joining Paths](#5-joining-paths)
6. [Path Components](#6-path-components)

---

## 1. Path Separators

- Windows: `\`
- Unix: `/`
- Use `os.path.join()` or `pathlib` for portability

---

## 2. os.path

```python
import os

path = os.path.join("folder", "subfolder", "file.txt")
print(os.path.abspath(path))
print(os.path.dirname(path))
print(os.path.basename(path))
print(os.path.split(path))
```

---

## 3. pathlib.Path

```python
from pathlib import Path

p = Path("folder/subfolder/file.txt")
print(p.absolute())
print(p.parent)
print(p.name)
print(p.stem)
print(p.suffix)
```

---

## 4. Absolute vs Relative

```python
import os

print(os.path.abspath("file.txt"))
print(os.getcwd())
```

---

## 5. Joining Paths

```python
import os
from pathlib import Path

# os
path = os.path.join("a", "b", "c.txt")

# pathlib
p = Path("a") / "b" / "c.txt"
```

---

## 6. Path Components

```python
from pathlib import Path

p = Path("/home/user/file.txt")
print(p.parent)   # /home/user
print(p.name)    # file.txt
print(p.stem)    # file
print(p.suffix)  # .txt
```

---

## Quick Reference

| Task | Code |
|------|------|
| Join | `os.path.join(a, b)` or `Path(a) / b` |
| Absolute | `os.path.abspath(p)` |
| Parent | `Path(p).parent` |

---

## Next Steps

- Proceed to **File Write** tutorial
