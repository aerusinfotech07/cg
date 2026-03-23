# Assignment: Python Lists

Practice list operations: access, change, add, remove, loop.

---

## Exercise 1 (Easy)
Create a list `fruits = ["apple", "banana", "cherry"]`. Print the first and last elements.

**Expected Output:**
```
apple cherry
```

---

## Exercise 2 (Easy)
Add "date" to the end of the fruits list. Insert "apricot" at index 1. Print the list.

**Expected Output:**
```
['apple', 'apricot', 'banana', 'cherry', 'date']
```

---

## Exercise 3 (Easy)
Remove "banana" from the list using remove(). Print the list.

---

## Exercise 4 (Medium)
Given `nums = [3, 1, 4, 1, 5]`, sort the list and print. Then reverse it and print.

**Expected Output:**
```
[1, 1, 3, 4, 5]
[5, 4, 3, 1, 1]
```

---

## Exercise 5 (Medium)
Loop through `fruits = ["apple", "banana", "cherry"]` with enumerate and print "1: banana", etc. (1-indexed).

**Expected Output:**
```
1: apple
2: banana
3: cherry
```

---

## Exercise 6 (Medium)
Use list comprehension to create a list of squares of numbers 0 through 4. Print it.

**Expected Output:**
```
[0, 1, 4, 9, 16]
```

---

## Exercise 7 (Medium)
Given `lst = [1, 2, 3, 4, 5]`, use slicing to get [2, 3, 4] and the reversed list. Print both.

---

## Exercise 8 (Hard)
Remove all occurrences of 1 from `nums = [1, 2, 1, 3, 1, 4]` without using a loop. (Hint: use list comprehension or filter.)

**Expected Output:**
```
[2, 3, 4]
```

---

## Exercise 9 (Hard)
Flatten this nested list: `[[1, 2], [3, 4], [5, 6]]` into `[1, 2, 3, 4, 5, 6]`. Use a loop or list comprehension.

---

## Exercise 10 (Hard)
Given `lst = [1, 2, 3, 4, 5]`, create a new list with each element doubled, but only for elements greater than 2. Result: [4, 6, 8, 10].

---

## Solutions / Hints

<details>
<summary>Exercise 2 Hint</summary>
```python
fruits.append("date")
fruits.insert(1, "apricot")
```
</details>

<details>
<summary>Exercise 6 Hint</summary>
```python
squares = [x**2 for x in range(5)]
```
</details>

<details>
<summary>Exercise 8 Hint</summary>
```python
nums = [x for x in nums if x != 1]
```
</details>
