# Assignment: re Module (Regular Expressions)

Practice regular expressions with the re module.

---

## Exercise 1 (Easy)
Use re.search to find "Python" in "I love Python programming". Print the match.

---

## Exercise 2 (Easy)
Use re.findall(r'\d+', "Prices: 10, 20, 30") to extract numbers. Print the list.

---

## Exercise 3 (Easy)
Use re.sub to replace "cat" with "dog" in "I have a cat".

---

## Exercise 4 (Medium)
Write a pattern to match email-like strings (e.g., user@domain.com). Use re.search.

---

## Exercise 5 (Medium)
Use re.findall to extract all words from "Hello, World! How are you?" (words = \w+).

---

## Exercise 6 (Medium)
Match a date format YYYY-MM-DD. Use re.search on "Date: 2024-03-10".

---

## Exercise 7 (Medium)
Use re.split(r'\s+', "a   b   c") to split by whitespace. Print the result.

---

## Exercise 8 (Hard)
Extract groups from a match. Pattern for "Name: Alice, Age: 25". Capture name and age.

---

## Exercise 9 (Hard)
Use re.compile to create a pattern. Use it to findall digits in a string.

---

## Exercise 10 (Hard)
Validate a simple phone number format: XXX-XXX-XXXX. Use re.match. Return True/False.

---

## Solutions / Hints

<details>
<summary>Exercise 2 Hint</summary>
```python
import re
nums = re.findall(r'\d+', "Prices: 10, 20, 30")
print(nums)
```
</details>
