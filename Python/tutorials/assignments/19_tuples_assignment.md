# Assignment: Python Tuples

Practice tuple creation, access, and immutability.

---

## Exercise 1 (Easy)
Create a tuple `point = (10, 20)`. Print the x and y coordinates by unpacking.

**Expected Output:**
```
10 20
```

---

## Exercise 2 (Easy)
Create a single-element tuple containing 42. Print it and its type. (Remember the comma!)

---

## Exercise 3 (Easy)
Given `t = (1, 2, 3, 2, 4, 2)`, use count() and index() to find how many 2s and the index of the first 2.

**Expected Output:**
```
3 1
```

---

## Exercise 4 (Medium)
Swap variables a and b using tuple unpacking. a=5, b=10. Print after swap.

**Expected Output:**
```
10 5
```

---

## Exercise 5 (Medium)
Create a function that returns both the minimum and maximum of a list. Call it with [3, 1, 4, 1, 5] and unpack the result.

**Expected Output:**
```
1 5
```

---

## Exercise 6 (Medium)
Given `t = (1, 2, 3, 4, 5)`, unpack so that first=1, last=5, and middle=[2, 3, 4]. Print all three.

---

## Exercise 7 (Medium)
Convert the list [1, 2, 3] to a tuple. Convert the tuple (1, 2, 3) to a list. Print both.

---

## Exercise 8 (Hard)
Explain why you can't use a list as a dictionary key but you can use a tuple. Write a small example.

---

## Exercise 9 (Hard)
Given `t = (1, [2, 3])`, explain why `t[1].append(4)` works but `t[0] = 10` does not. Run and verify.

---

## Exercise 10 (Hard)
Create a tuple of tuples representing a 2x2 matrix: ((1,2), (3,4)). Access and print the element at row 1, column 0 (value 3).

**Expected Output:**
```
3
```

---

## Solutions / Hints

<details>
<summary>Exercise 2 Hint</summary>
```python
t = (42,)
print(t, type(t))
```
</details>

<details>
<summary>Exercise 5 Hint</summary>
```python
def min_max(lst):
    return min(lst), max(lst)
low, high = min_max([3, 1, 4, 1, 5])
print(low, high)
```
</details>

<details>
<summary>Exercise 9 Hint</summary>
The tuple is immutable, but the list inside is mutable. We're modifying the list, not the tuple.
</details>
