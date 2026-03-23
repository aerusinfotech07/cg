# Assignment: for Loops

Practice for loops, range, enumerate, and zip.

---

## Exercise 1 (Easy)
Loop through ["apple", "banana", "cherry"] and print each fruit.

---

## Exercise 2 (Easy)
Use for and range(5) to print 0, 1, 2, 3, 4.

---

## Exercise 3 (Easy)
Loop through "Python" and print each character.

---

## Exercise 4 (Medium)
Use enumerate to print "1: apple", "2: banana", "3: cherry" (1-indexed).

---

## Exercise 5 (Medium)
Use zip to pair names=["Alice","Bob"] with ages=[25,30]. Print "Alice is 25", etc.

---

## Exercise 6 (Medium)
Print a 3x3 grid of asterisks using nested for loops.

---

## Exercise 7 (Medium)
Use for-else: loop through [2,4,6,8], if 5 is found break. Else print "5 not found".

---

## Exercise 8 (Hard)
Given a list of lists [[1,2],[3,4],[5,6]], flatten it to [1,2,3,4,5,6] using nested for loops.

---

## Exercise 9 (Hard)
Loop through a dict and print keys and values. Then create a new dict with values doubled.

---

## Exercise 10 (Hard)
Print a multiplication table for 5: 5x1=5, 5x2=10, ... 5x10=50. Use for loop.

---

## Solutions / Hints

<details>
<summary>Exercise 4 Hint</summary>
```python
for i, fruit in enumerate(fruits, 1):
    print(f"{i}: {fruit}")
```
</details>

<details>
<summary>Exercise 6 Hint</summary>
```python
for i in range(3):
    for j in range(3):
        print("*", end=" ")
    print()
```
</details>
