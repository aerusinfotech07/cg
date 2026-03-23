# Assignment: Casting

Practice type conversion with str(), int(), and float().

---

## Exercise 1 (Easy)
Convert the integer 42 to a string and the string "42" to an integer. Print both with their types.

---

## Exercise 2 (Easy)
Convert 3.14 to int (what value do you get?) and to str. Print both.

**Expected Output:**
```
3 3.14
```

---

## Exercise 3 (Easy)
Create `age = "25"`. Convert to int and add 5. Print the result.

**Expected Output:**
```
30
```

---

## Exercise 4 (Medium)
Convert the string "19.99" to float. Multiply by 2 and print the result with 2 decimal places.

**Expected Output:**
```
39.98
```

---

## Exercise 5 (Medium)
Use `int("1010", 2)` to convert binary "1010" to decimal. Use `int("FF", 16)` to convert hex "FF" to decimal. Print both.

**Expected Output:**
```
10 255
```

---

## Exercise 6 (Medium)
Write a line that concatenates the string "Total: " with the number 100. (Hint: cast the number.)

**Expected Output:**
```
Total: 100
```

---

## Exercise 7 (Medium)
What happens when you run `int("3.14")`? Why? Write the correct way to get integer 3 from "3.14".

---

## Exercise 8 (Hard)
Write a function `safe_float(value, default=0.0)` that returns the float conversion of value, or default if conversion fails.

**Expected behavior:**
```python
print(safe_float("3.14"))   # 3.14
print(safe_float("abc"))    # 0.0
```

---

## Exercise 9 (Hard)
Simulate user input: `user_input = "  42  "`. Strip whitespace and convert to int. Print the result.

**Expected Output:**
```
42
```

---

## Exercise 10 (Hard)
Convert a list of strings `["1", "2", "3", "4", "5"]` to a list of integers. Print the list and its sum.

**Expected Output:**
```
[1, 2, 3, 4, 5]
15
```

---

## Solutions / Hints

<details>
<summary>Exercise 1 Hint</summary>
```python
a = str(42)
b = int("42")
print(a, type(a))
print(b, type(b))
```
</details>

<details>
<summary>Exercise 7 Hint</summary>
`int("3.14")` raises ValueError. Use `int(float("3.14"))` to get 3.
</details>

<details>
<summary>Exercise 10 Hint</summary>
```python
lst = ["1", "2", "3", "4", "5"]
nums = [int(x) for x in lst]
print(nums)
print(sum(nums))
```
</details>
