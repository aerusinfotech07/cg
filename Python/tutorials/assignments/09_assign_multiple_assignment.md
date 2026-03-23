# Assignment: Multiple Assignment

Practice multiple variable assignment and unpacking.

---

## Exercise 1 (Easy)
Assign the values 1, 2, and 3 to variables x, y, and z in one line. Print them.

**Expected Output:**
```
1 2 3
```

---

## Exercise 2 (Easy)
Assign the same value 0 to variables a, b, and c in one line. Print them.

**Expected Output:**
```
0 0 0
```

---

## Exercise 3 (Easy)
Given `fruits = ["apple", "banana", "cherry"]`, unpack into variables first, second, and third. Print them.

**Expected Output:**
```
apple banana cherry
```

---

## Exercise 4 (Medium)
Swap the values of variables `a = 10` and `b = 20` using multiple assignment. Print both after swapping.

**Expected Output:**
```
20 10
```

---

## Exercise 5 (Medium)
Unpack the tuple `(100, 200)` into variables `x` and `y`. Print their sum.

**Expected Output:**
```
300
```

---

## Exercise 6 (Medium)
Given `items = [1, 2, 3, 4, 5]`, unpack so that `first` gets 1, and `rest` gets `[2, 3, 4, 5]`. Print both.

**Expected Output:**
```
1 [2, 3, 4, 5]
```

---

## Exercise 7 (Medium)
Write a line that unpacks `[10, 20, 30, 40, 50]` so that `first`=10, `last`=50, and `middle`=[20, 30, 40]. Print all three.

---

## Exercise 8 (Hard)
Create a function `get_stats()` that returns a tuple `(min_value, max_value)` for a list. Call it with `[3, 1, 4, 1, 5]` and unpack the result into `low` and `high`. Print them.

**Expected Output:**
```
1 5
```

---

## Exercise 9 (Hard)
Unpack the string "ABC" into variables a, b, and c. Print them with commas between.

**Expected Output:**
```
A, B, C
```

---

## Exercise 10 (Hard)
Given `data = [1, 2, 3, 4, 5, 6, 7]`, unpack so that:
- `a` = first element
- `b` = last element  
- `middle` = all elements in between

Print a, b, and middle.

**Expected Output:**
```
1 7 [2, 3, 4, 5, 6]
```

---

## Solutions / Hints

<details>
<summary>Exercise 1 Hint</summary>
```python
x, y, z = 1, 2, 3
print(x, y, z)
```
</details>

<details>
<summary>Exercise 4 Hint</summary>
```python
a, b = 10, 20
a, b = b, a
print(a, b)
```
</details>

<details>
<summary>Exercise 6 Hint</summary>
```python
items = [1, 2, 3, 4, 5]
first, *rest = items
print(first, rest)
```
</details>
