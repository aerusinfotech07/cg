# Assignment: range()

Practice using range() for loops and sequences.

---

## Exercise 1 (Easy)
Use range(5) to print 0, 1, 2, 3, 4.

---

## Exercise 2 (Easy)
Use range(1, 6) to print 1 through 5.

---

## Exercise 3 (Easy)
Use range(0, 10, 2) to print even numbers 0-8.

---

## Exercise 4 (Medium)
Use range to print 5, 4, 3, 2, 1 (countdown).

---

## Exercise 5 (Medium)
Create a list of squares 0^2 through 4^2 using range and list comprehension.

**Expected Output:**
```
[0, 1, 4, 9, 16]
```

---

## Exercise 6 (Medium)
Use range to sum numbers 1 to 100. Print the sum.

---

## Exercise 7 (Medium)
Check if 7 is in range(10). Print the result.

---

## Exercise 8 (Hard)
Create range(2, 21, 2). Convert to list and print. (Even numbers 2-20.)

---

## Exercise 9 (Hard)
Use range in a loop to print a triangle of numbers:
```
1
12
123
1234
12345
```

---

## Exercise 10 (Hard)
Create a list of all multiples of 3 from 0 to 30 using range and list().

---

## Solutions / Hints

<details>
<summary>Exercise 4 Hint</summary>
```python
for i in range(5, 0, -1):
    print(i)
```
</details>

<details>
<summary>Exercise 9 Hint</summary>
```python
for i in range(1, 6):
    for j in range(1, i+1):
        print(j, end="")
    print()
```
</details>
