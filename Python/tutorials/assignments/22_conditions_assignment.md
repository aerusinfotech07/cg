# Assignment: Python Conditions

Practice if, elif, else, and conditional logic.

---

## Exercise 1 (Easy)
Write an if statement that prints "Positive" if x is greater than 0. Test with x=5 and x=-3.

---

## Exercise 2 (Easy)
Write if-elif-else to classify age: under 13="Child", 13-19="Teen", 20+= "Adult". Test with 10, 15, 25.

---

## Exercise 3 (Easy)
Use a conditional expression to set `result = "Even"` if n is even, else `"Odd"`. Test with n=4 and n=7.

---

## Exercise 4 (Medium)
Write nested if: if x > 0, then if y > 0 print "Both positive", else print "x positive, y not". Handle x <= 0.

---

## Exercise 5 (Medium)
Given score 0-100, print grade: 90+="A", 80-89="B", 70-79="C", 60-69="D", below 60="F". Test with 85.

---

## Exercise 6 (Medium)
Check if a year is a leap year. Leap if divisible by 4, but not by 100 unless also by 400. Test 2024, 1900, 2000.

---

## Exercise 7 (Medium)
Given username and password variables, print "Logged in" if both match expected values, else "Invalid".

---

## Exercise 8 (Hard)
Write a program that checks if a triangle is valid (sum of any two sides > third). Sides: a=3, b=4, c=5.

---

## Exercise 9 (Hard)
Given three numbers, print the largest using only if-elif-else (no max()).

---

## Exercise 10 (Hard)
Classify a character: "digit", "letter", or "other". Use string methods isdigit(), isalpha().

---

## Solutions / Hints

<details>
<summary>Exercise 2 Hint</summary>
```python
if age < 13: ...
elif age <= 19: ...
else: ...
```
</details>

<details>
<summary>Exercise 6 Hint</summary>
```python
(year % 4 == 0 and year % 100 != 0) or (year % 400 == 0)
```
</details>
