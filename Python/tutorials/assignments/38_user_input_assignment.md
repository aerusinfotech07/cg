# Assignment: User Input

Practice using input() and handling user input.

---

## Exercise 1 (Easy)
Prompt "Enter your name: ", read with input(), and print "Hello, [name]!".

---

## Exercise 2 (Easy)
Read age as string, convert to int, and print "You are [age] years old."

---

## Exercise 3 (Easy)
Read two numbers (one per input), add them, and print the sum.

---

## Exercise 4 (Medium)
Read a number. Use try/except to handle invalid input. Retry until valid.

---

## Exercise 5 (Medium)
Read "Enter name and age: " (e.g., "Alice 25"). Split and unpack. Print both.

---

## Exercise 6 (Medium)
Read a float for price. Format and print "Price: $X.XX".

---

## Exercise 7 (Medium)
Prompt "Continue? (y/n): ". If y or yes (case-insensitive), print "Continuing", else "Stopping".

---

## Exercise 8 (Hard)
Read numbers until user enters "done". Sum all valid numbers. Handle invalid input.

---

## Exercise 9 (Hard)
Read a list of comma-separated values. Split, strip each, convert to appropriate types. Print the list.

---

## Exercise 10 (Hard)
Create a simple menu: 1=Add, 2=Subtract, 3=Quit. Loop until quit. Read two numbers for add/subtract.

---

## Solutions / Hints

<details>
<summary>Exercise 5 Hint</summary>
```python
data = input("Enter name and age: ").split()
name, age = data[0], int(data[1])
```
</details>
