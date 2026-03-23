# Assignment: while Loops

Practice while loops, break, and continue.

---

## Exercise 1 (Easy)
Use a while loop to print numbers 1 through 5.

**Expected Output:**
```
1
2
3
4
5
```

---

## Exercise 2 (Easy)
Countdown from 5 to 1, then print "Go!".

---

## Exercise 3 (Easy)
Use while to sum numbers 1 to 10. Print the sum.

**Expected Output:**
```
55
```

---

## Exercise 4 (Medium)
Use while with break: keep asking for input until user enters "quit".

---

## Exercise 5 (Medium)
Print numbers 1-10 but skip 5 using continue.

---

## Exercise 6 (Medium)
Use while with else: loop until i reaches 5, then print "Loop completed" from else.

---

## Exercise 7 (Medium)
Find the first number divisible by 7 and 11 in range 1-1000. Use while and break.

---

## Exercise 8 (Hard)
Implement a simple guessing game: secret=42, prompt user until correct. Print "Too high" or "Too low".

---

## Exercise 9 (Hard)
Use while to reverse a number: 12345 → 54321. (Hint: extract digits and build new number.)

---

## Exercise 10 (Hard)
Fibonacci: use while to generate first 10 Fibonacci numbers. Print them.

**Expected Output:**
```
0 1 1 2 3 5 8 13 21 34
```

---

## Solutions / Hints

<details>
<summary>Exercise 1 Hint</summary>
```python
i = 1
while i <= 5:
    print(i)
    i += 1
```
</details>

<details>
<summary>Exercise 10 Hint</summary>
a, b = 0, 1; while count < 10: print(a); a, b = b, a+b; count += 1
</details>
