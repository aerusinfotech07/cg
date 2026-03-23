# Assignment: try except

Practice exception handling.

---

## Exercise 1 (Easy)
Wrap int("abc") in try/except ValueError. Print "Invalid number" on error.

---

## Exercise 2 (Easy)
Wrap 10/0 in try/except ZeroDivisionError. Print "Division by zero".

---

## Exercise 3 (Easy)
Use try/except/else. In try: x=10/2. In else: print("Success:", x). In except: print("Error").

---

## Exercise 4 (Medium)
Use try/except/finally. In finally print "Cleanup". Verify it runs after both success and error.

---

## Exercise 5 (Medium)
Catch both ValueError and ZeroDivisionError in one try. Test both.

---

## Exercise 6 (Medium)
Use except Exception as e: and print the error message. Test with int("x").

---

## Exercise 7 (Medium)
Write a function that raises ValueError if age < 0 or age > 120. Call with 150 and catch.

---

## Exercise 8 (Hard)
Create a function safe_divide(a, b) that returns a/b or None if b is 0. Use try/except.

---

## Exercise 9 (Hard)
Use try/except to handle FileNotFoundError when opening a non-existent file.

---

## Exercise 10 (Hard)
Re-raise an exception: catch it, log it, then raise again. Use 'raise' with no arguments.

---

## Solutions / Hints

<details>
<summary>Exercise 1 Hint</summary>
```python
try:
    int("abc")
except ValueError:
    print("Invalid number")
```
</details>
