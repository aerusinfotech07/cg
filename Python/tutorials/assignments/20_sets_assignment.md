# Assignment: Python Sets

Practice set operations: unique elements, add, remove, union, intersection.

---

## Exercise 1 (Easy)
Create a set from the list [1, 2, 2, 3, 3, 3, 4]. Print it. What happened to duplicates?

**Expected Output:**
```
{1, 2, 3, 4}
```

---

## Exercise 2 (Easy)
Create `s = {1, 2, 3}`. Add 4 and 5. Remove 2. Print the set.

---

## Exercise 3 (Easy)
Given two sets `a = {1, 2, 3}` and `b = {3, 4, 5}`, print the union and intersection.

**Expected Output:**
```
{1, 2, 3, 4, 5}
{3}
```

---

## Exercise 4 (Medium)
Remove duplicates from the list [1, 2, 2, 3, 3, 3, 4, 4, 4, 4] using a set. Convert back to list and print. (Order may change.)

---

## Exercise 5 (Medium)
Given `a = {1, 2, 3}` and `b = {2, 3, 4}`, print a - b and b - a (difference).

**Expected Output:**
```
{1}
{4}
```

---

## Exercise 6 (Medium)
Check if {1, 2} is a subset of {1, 2, 3, 4}. Check if {1, 2, 3, 4} is a superset of {1, 2}. Print both.

**Expected Output:**
```
True True
```

---

## Exercise 7 (Medium)
Create a set of unique characters from the string "hello". Print it.

**Expected Output:**
```
{'h', 'e', 'l', 'o'}
```

---

## Exercise 8 (Hard)
Use symmetric_difference (or ^) on a={1,2,3} and b={3,4,5}. Print the result.

**Expected Output:**
```
{1, 2, 4, 5}
```

---

## Exercise 9 (Hard)
Create a frozenset from [1, 2, 3]. Use it as a dictionary key. Print the dictionary.

---

## Exercise 10 (Hard)
Given two lists, find elements that appear in both (intersection) and elements that appear in either (union). lists: [1,2,3,4] and [3,4,5,6].

**Expected Output:**
```
Intersection: {3, 4}
Union: {1, 2, 3, 4, 5, 6}
```

---

## Solutions / Hints

<details>
<summary>Exercise 2 Hint</summary>
```python
s.add(4)
s.add(5)
s.remove(2)
```
</details>

<details>
<summary>Exercise 4 Hint</summary>
```python
lst = [1, 2, 2, 3, 3, 3, 4, 4, 4, 4]
unique = list(set(lst))
```
</details>

<details>
<summary>Exercise 10 Hint</summary>
Convert to sets, use & for intersection, | for union.
</details>
