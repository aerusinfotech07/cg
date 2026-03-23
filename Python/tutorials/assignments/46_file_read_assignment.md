# Assignment: File Reading

Practice reading files in Python.

---

## Exercise 1 (Easy)
Create a file "test.txt" with "Hello, World!". Read and print its contents using open and read().

---

## Exercise 2 (Easy)
Read a file using `with open(...)`. Print each line with strip().

---

## Exercise 3 (Easy)
Use readlines() to get a list of lines. Print the number of lines.

---

## Exercise 4 (Medium)
Read a file and print lines that start with "#" (comments). Skip others.

---

## Exercise 5 (Medium)
Read a file and count the number of words (split by whitespace). Print the count.

---

## Exercise 6 (Medium)
Read a CSV-like file "a,b,c" per line. Split each line and print as list of lists.

---

## Exercise 7 (Medium)
Read file with encoding="utf-8". Handle FileNotFoundError. Print "File not found" if missing.

---

## Exercise 8 (Hard)
Read a file and print the longest line (by character count).

---

## Exercise 9 (Hard)
Read a file, reverse the order of lines, and print.

---

## Exercise 10 (Hard)
Read a JSON file using json.load. Extract and print a specific key.

---

## Solutions / Hints

<details>
<summary>Exercise 1 Hint</summary>
```python
with open("test.txt", "r") as f:
    content = f.read()
print(content)
```
</details>
