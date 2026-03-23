# Assignment: Python Output

Practice using the `print()` function to display text and numbers.

---

## Exercise 1 (Easy)
Print the text "Hello, Python!" to the console.

**Expected Output:**
```
Hello, Python!
```

---

## Exercise 2 (Easy)
Print three numbers on separate lines: 10, 20, and 30.

**Expected Output:**
```
10
20
30
```

---

## Exercise 3 (Easy)
Print the result of the expression `5 + 3 * 2` (let Python evaluate it).

**Expected Output:**
```
11
```

---

## Exercise 4 (Medium)
Print "Name:", "Age:", and "Score:" on one line, each separated by a tab (`\t`). Then print "Alice", "25", and "95" on the next line, also tab-separated.

**Expected Output:**
```
Name:	Age:	Score:
Alice	25	95
```

---

## Exercise 5 (Medium)
Print the numbers 1 through 5 on a single line with spaces between them. Use the `sep` parameter.

**Expected Output:**
```
1 2 3 4 5
```

---

## Exercise 6 (Medium)
Print "Python" and "Programming" on the same line with " | " between them. Use the `sep` parameter.

**Expected Output:**
```
Python | Programming
```

---

## Exercise 7 (Medium)
Print "Hello" and "World" so they appear on the same line with no space between them. Use the `end` parameter.

**Expected Output:**
```
HelloWorld
```

---

## Exercise 8 (Hard)
Print a 3x3 grid of asterisks. Each row should have 3 asterisks separated by spaces. Use multiple `print()` calls and the `sep` parameter.

**Expected Output:**
```
* * *
* * *
* * *
```

---

## Exercise 9 (Hard)
Print a formatted address block:
- Line 1: "123 Main Street"
- Line 2: "New York, NY 10001"
- Line 3: "USA"

Use escape sequences or multiple print statements.

**Expected Output:**
```
123 Main Street
New York, NY 10001
USA
```

---

## Exercise 10 (Hard)
Print the date in format `YYYY/MM/DD` using the values 2024, 3, and 10. Use the `sep` parameter.

**Expected Output:**
```
2024/3/10
```

---

## Solutions / Hints

<details>
<summary>Exercise 1 Hint</summary>
`print("Hello, Python!")`
</details>

<details>
<summary>Exercise 4 Hint</summary>
Use `\t` in the string for tab. Example: `print("Name:\tAge:\tScore:")`
</details>

<details>
<summary>Exercise 5 Hint</summary>
`print(1, 2, 3, 4, 5, sep=" ")`
</details>

<details>
<summary>Exercise 7 Hint</summary>
`print("Hello", end="")` then `print("World")`
</details>
