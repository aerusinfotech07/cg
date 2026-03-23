# Assignment: Python Numbers

Practice working with int, float, and complex numbers.

---

## Exercise 1 (Easy)
Print the result of: 10 + 5, 10 - 5, 10 * 5, 10 / 5, 10 // 3, 10 % 3, 2 ** 10.

**Expected Output:**
```
15 5 50 2.0 3 1 1024
```

---

## Exercise 2 (Easy)
Create `x = 3.14159`. Use `round()` to round to 2 decimal places. Print the result.

**Expected Output:**
```
3.14
```

---

## Exercise 3 (Easy)
Print the absolute value of -42 and the result of `pow(2, 8)`.

**Expected Output:**
```
42 256
```

---

## Exercise 4 (Medium)
Convert the binary number `0b1101` to decimal. Print it. Convert the hex `0xFF` to decimal. Print it.

**Expected Output:**
```
13 255
```

---

## Exercise 5 (Medium)
What is the result of `0.1 + 0.2` in Python? Print it. Then use `round()` to get 0.3.

---

## Exercise 6 (Medium)
Create complex numbers `a = 1+2j` and `b = 3+4j`. Print a+b and a*b.

**Expected Output:**
```
(4+6j) (-5+10j)
```

---

## Exercise 7 (Medium)
Use `random.randint(1, 100)` to generate 3 random integers. Print them. (Import random first.)

---

## Exercise 8 (Hard)
Given `int("3.14")` raises ValueError, write a one-liner to convert the string "3.14" to integer 3 (truncate).

---

## Exercise 9 (Hard)
Print `min(3, 1, 4, 1, 5)` and `max(3, 1, 4, 1, 5)`. Then print the sum of the list `[3, 1, 4, 1, 5]`.

**Expected Output:**
```
1 5 14
```

---

## Exercise 10 (Hard)
Calculate and print: floor of 7/2, ceiling of 7/2 (use `import math` and `math.ceil`), and 7/2 as float.

**Expected Output:**
```
3 4 3.5
```

---

## Solutions / Hints

<details>
<summary>Exercise 5 Hint</summary>
```python
print(0.1 + 0.2)  # 0.30000000000000004
print(round(0.1 + 0.2, 1))  # 0.3
```
</details>

<details>
<summary>Exercise 8 Hint</summary>
```python
int(float("3.14"))
```
</details>
