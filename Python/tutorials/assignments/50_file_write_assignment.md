# Assignment: File Writing

Practice writing to files.

---

## Exercise 1 (Easy)
Open a file in "w" mode. Write "Hello, File!". Close. Read back and verify.

---

## Exercise 2 (Easy)
Write three lines to a file using multiple write() calls. Each line with newline.

---

## Exercise 3 (Easy)
Use writelines to write ["Line 1\n", "Line 2\n", "Line 3\n"] to a file.

---

## Exercise 4 (Medium)
Write a list of numbers to a file, one per line. Convert each to string.

---

## Exercise 5 (Medium)
Write a dict to a file as "key: value" per line. Loop through items.

---

## Exercise 6 (Medium)
Create a CSV file: header "name,age,city" and row "Alice,25,NYC". Write both lines.

---

## Exercise 7 (Medium)
Use "w" to overwrite. Create file with "Original". Open again with "w", write "Replaced". Verify.

---

## Exercise 8 (Hard)
Write a function save_json(data, filename) that writes a dict to JSON file. Use json.dump.

---

## Exercise 9 (Hard)
Write a formatted report to file: header, rows of data, footer. Use f-strings.

---

## Exercise 10 (Hard)
Implement write_lines(filename, lines) that writes lines, creating parent directories if needed. Use Path.mkdir(parents=True).

---

## Solutions / Hints

<details>
<summary>Exercise 1 Hint</summary>
```python
with open("output.txt", "w") as f:
    f.write("Hello, File!")
```
</details>

<details>
<summary>Exercise 4 Hint</summary>
```python
nums = [1, 2, 3, 4, 5]
with open("nums.txt", "w") as f:
    for n in nums:
        f.write(str(n) + "\n")
```
</details>
