# Assignment: Python Strings

Practice string indexing, slicing, and methods.

---

## Exercise 1 (Easy)
Create `s = "Python"`. Print the first, third, and last characters using indexing.

**Expected Output:**
```
P t n
```

---

## Exercise 2 (Easy)
Given `s = "Hello, World!"`, use slicing to print "Hello" and "World".

**Expected Output:**
```
Hello
World
```

---

## Exercise 3 (Easy)
Create `s = "python"`. Use a string method to make it uppercase. Print the result.

**Expected Output:**
```
PYTHON
```

---

## Exercise 4 (Medium)
Given `s = "  hello world  "`, use strip() and then capitalize the first letter. Print the result.

**Expected Output:**
```
Hello world
```

---

## Exercise 5 (Medium)
Given `s = "apple,banana,cherry"`, split by comma and print the list. Then join the list with " | " and print.

**Expected Output:**
```
['apple', 'banana', 'cherry']
apple | banana | cherry
```

---

## Exercise 6 (Medium)
Check if "Python" contains "thon" using a string method. Check if "hello" starts with "he". Print both results.

**Expected Output:**
```
True True
```

---

## Exercise 7 (Medium)
Given `s = "Hello World"`, replace "World" with "Python". Print the result.

**Expected Output:**
```
Hello Python
```

---

## Exercise 8 (Hard)
Reverse the string "Python" using slicing. Print the result.

**Expected Output:**
```
nohtyP
```

---

## Exercise 9 (Hard)
Given `s = "mississippi"`, count how many times "s" appears. Find the index of the first "s" and the second "s".

**Expected Output:**
```
4 2 3
```
(4 occurrences; first at 2; second at 3)

---

## Exercise 10 (Hard)
Given `email = "  user@EXAMPLE.com  "`, strip it, convert to lowercase, and print. Then extract the part before @ and the part after @ into two variables. Print both.

**Expected Output:**
```
user@example.com
user example.com
```

---

## Solutions / Hints

<details>
<summary>Exercise 1 Hint</summary>
```python
s = "Python"
print(s[0], s[2], s[-1])
```
</details>

<details>
<summary>Exercise 8 Hint</summary>
```python
s = "Python"
print(s[::-1])
```
</details>

<details>
<summary>Exercise 10 Hint</summary>
Use strip(), lower(), then split("@") to get username and domain.
</details>
