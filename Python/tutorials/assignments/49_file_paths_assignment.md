# Assignment: File Paths

Practice working with file paths.

---

## Exercise 1 (Easy)
Use os.path.join("folder", "sub", "file.txt") to create a path. Print it.

---

## Exercise 2 (Easy)
Use os.path.abspath("file.txt") to get absolute path. Print it.

---

## Exercise 3 (Easy)
Use pathlib: Path("a/b/c.txt"). Print .parent, .name, .stem, .suffix.

---

## Exercise 4 (Medium)
Use os.path.dirname and os.path.basename on a path. Print both.

---

## Exercise 5 (Medium)
Use Path to join: Path("folder") / "sub" / "file.txt". Print the result.

---

## Exercise 6 (Medium)
Get current working directory with os.getcwd(). Change with os.chdir(). Restore.

---

## Exercise 7 (Medium)
Create a path, check if it's absolute with os.path.isabs() or Path.is_absolute().

---

## Exercise 8 (Hard)
Given "C:/Users/Alice/file.txt", extract "file" (stem) and "txt" (suffix without dot).

---

## Exercise 9 (Hard)
Build a path from user input. Validate it doesn't escape (e.g., no ".." in wrong places).

---

## Exercise 10 (Hard)
Use pathlib to get all .py files in a directory recursively. Path.rglob("*.py").

---

## Solutions / Hints

<details>
<summary>Exercise 3 Hint</summary>
```python
from pathlib import Path
p = Path("a/b/c.txt")
print(p.parent, p.name, p.stem, p.suffix)
```
</details>
