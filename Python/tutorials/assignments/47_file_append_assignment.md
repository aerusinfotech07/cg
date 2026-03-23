# Assignment: File Append

Practice appending to files.

---

## Exercise 1 (Easy)
Open a file in "a" mode. Write "Appended line\n". Close. Read file and verify.

---

## Exercise 2 (Easy)
Append current date/time to a log file. Use datetime.now() and write.

---

## Exercise 3 (Medium)
Create a function log(message) that appends "[timestamp] message" to log.txt.

---

## Exercise 4 (Medium)
Append multiple lines using writelines. Use a list of strings with newlines.

---

## Exercise 5 (Medium)
Open file in "a", write 3 lines in a loop. Verify all 3 are appended.

---

## Exercise 6 (Medium)
Compare: create file with "w", write "Line 1". Open with "a", write "Line 2". Read and verify both lines.

---

## Exercise 7 (Hard)
Implement append_to_json_list(file, new_item): read JSON list, append item, write back.

---

## Exercise 8 (Hard)
Append with flush: use f.flush() after write to ensure data is written immediately.

---

## Exercise 9 (Hard)
Create a simple audit log: each append includes timestamp, user, action. Format: "2024-03-10 14:30 | user1 | login"

---

## Exercise 10 (Hard)
Append to file only if a condition is met. E.g., append "ERROR" lines from a list of log entries.

---

## Solutions / Hints

<details>
<summary>Exercise 3 Hint</summary>
```python
from datetime import datetime
def log(msg):
    with open("log.txt", "a") as f:
        f.write(f"[{datetime.now()}] {msg}\n")
```
</details>
