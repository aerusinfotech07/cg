# Assignment: Python Modules

Practice creating and using modules.

---

## Exercise 1 (Easy)
Import math and print math.pi and math.sqrt(16).

---

## Exercise 2 (Easy)
Create a file myutils.py with a function add(a,b). Import it and call add(3,5).

---

## Exercise 3 (Easy)
Use from math import sqrt, pi. Print sqrt(9) and pi without the math. prefix.

---

## Exercise 4 (Medium)
Create a module with a constant MAX_SIZE=100. Import and print it.

---

## Exercise 5 (Medium)
Add if __name__ == "__main__": to a module. Put test code there. Run as script vs import.

---

## Exercise 6 (Medium)
Use dir(math) to list math module contents. Print first 5 names.

---

## Exercise 7 (Medium)
Create a package (folder with __init__.py). Add a module inside. Import from package.

---

## Exercise 8 (Hard)
Create module with both functions and a main block. When imported, only definitions load. When run, main executes.

---

## Exercise 9 (Hard)
Import a module with an alias: import datetime as dt. Use dt.datetime.now().

---

## Exercise 10 (Hard)
Create a module that defines __all__ = ["public_func"]. Define public_func and _private_func. Import * and verify what's available.

---

## Solutions / Hints

<details>
<summary>Exercise 2 Hint</summary>
Create myutils.py: `def add(a,b): return a+b`
In main: `import myutils` then `myutils.add(3,5)`
</details>
