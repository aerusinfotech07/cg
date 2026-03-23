# Assignment: Python Booleans

Practice boolean values, comparisons, and logical operators.

---

## Exercise 1 (Easy)
Print the result of: `5 == 5`, `5 != 3`, `5 > 3`, `5 < 3`.

**Expected Output:**
```
True True True False
```

---

## Exercise 2 (Easy)
Print the result of: `True and False`, `True or False`, `not True`.

**Expected Output:**
```
False True False
```

---

## Exercise 3 (Easy)
Use `bool()` to convert: 0, 1, "", "hello", [], [1,2]. Print the results.

**Expected Output:**
```
False True False True False True
```

---

## Exercise 4 (Medium)
Write an expression that is True only if x is between 10 and 20 (inclusive). Test with x=15 and x=25.

---

## Exercise 5 (Medium)
Predict: What does `bool("False")` return? Why? Run and verify.

---

## Exercise 6 (Medium)
Write a single boolean expression: "x is positive and even". Test with x=4 and x=-4.

---

## Exercise 7 (Medium)
Use chained comparison: check if 5 is between 1 and 10. Print the result.

**Expected Output:**
```
True
```

---

## Exercise 8 (Hard)
Which values are falsy in Python? Write a loop that prints all falsy built-in values you can think of.

---

## Exercise 9 (Hard)
Simplify: `not (a and b)` using De Morgan's law. Write equivalent expressions for `not (a or b)`.

---

## Exercise 10 (Hard)
Given `age = 25` and `has_ticket = True`, write an expression that is True if age >= 18 AND has_ticket. Print for the given values. Then change has_ticket to False and print again.

**Expected Output:**
```
True
False
```

---

## Solutions / Hints

<details>
<summary>Exercise 4 Hint</summary>
```python
x = 15
print(10 <= x <= 20)  # True
x = 25
print(10 <= x <= 20)  # False
```
</details>

<details>
<summary>Exercise 5 Hint</summary>
`bool("False")` is True because any non-empty string is truthy.
</details>

<details>
<summary>Exercise 9 Hint</summary>
De Morgan: `not (a and b)` = `(not a) or (not b)`
`not (a or b)` = `(not a) and (not b)`
</details>
