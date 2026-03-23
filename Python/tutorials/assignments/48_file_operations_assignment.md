# Assignment: File Operations

Practice file and directory operations.

---

## Exercise 1 (Easy)
Use os.path.exists to check if a file exists. Test with existing and non-existing path.

---

## Exercise 2 (Easy)
Use os.path.getsize to get file size in bytes. Print it.

---

## Exercise 3 (Easy)
Use os.listdir(".") to list files in current directory. Print the list.

---

## Exercise 4 (Medium)
Use os.path.isfile and os.path.isdir to classify paths. Test with a file and a directory.

---

## Exercise 5 (Medium)
Use os.rename to rename a file. Create a file first, then rename it.

---

## Exercise 6 (Medium)
Use pathlib.Path to check if path exists, get name, get suffix. Test with "folder/file.txt".

---

## Exercise 7 (Medium)
Use os.mkdir to create a directory. Use os.rmdir to remove it (must be empty).

---

## Exercise 8 (Hard)
Use pathlib to create a file, write to it, read from it. Use Path.write_text and Path.read_text.

---

## Exercise 9 (Hard)
List all .txt files in current directory. Use os.listdir or pathlib and filter.

---

## Exercise 10 (Hard)
Create a function that deletes a file only if it exists. Use os.path.exists and os.remove.

---

## Solutions / Hints

<details>
<summary>Exercise 1 Hint</summary>
```python
import os
print(os.path.exists("file.txt"))
```
</details>
