# Python File Append

## Table of Contents
1. [Append Mode](#1-append-mode)
2. [Writing to End](#2-writing-to-end)
3. [Append vs Write](#3-append-vs-write)
4. [Appending Lines](#4-appending-lines)
5. [Common Patterns](#5-common-patterns)

---

## 1. Append Mode

Use `"a"` mode to add to the end without overwriting:

```python
with open("log.txt", "a") as f:
    f.write("New log entry\n")
```

---

## 2. Writing to End

```python
with open("data.txt", "a") as f:
    f.write("Appended text\n")
```

---

## 3. Append vs Write

| Mode | Behavior |
|------|----------|
| `"w"` | Overwrites file |
| `"a"` | Adds to end |

---

## 4. Appending Lines

```python
lines = ["Line 1\n", "Line 2\n"]
with open("file.txt", "a") as f:
    f.writelines(lines)
```

---

## 5. Common Patterns

```python
# Logging
with open("app.log", "a") as f:
    f.write(f"{datetime.now()}: Event occurred\n")

# Append with newline
with open("file.txt", "a") as f:
    f.write("New line\n")
```

---

## Quick Reference

```python
with open("file.txt", "a") as f:
    f.write("text\n")
```

---

## Next Steps

- Proceed to **File Operations** tutorial
