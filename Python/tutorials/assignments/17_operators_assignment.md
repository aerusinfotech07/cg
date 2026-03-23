# Assignment: Python Operators

Practice arithmetic, assignment, comparison, logical, and membership operators.

---

## Exercise 1 (Easy)
Calculate and print: 17 // 5, 17 % 5, 2 ** 8.

**Expected Output:**
```
3 2 256
```

---

## Exercise 2 (Easy)
Use assignment operators: start with `x = 10`, then `x += 5`, then `x *= 2`. Print x.

**Expected Output:**
```
30
```

---

## Exercise 3 (Easy)
Check: is 10 in [1, 2, 3, 10]? Is "a" in "apple"? Print both.

**Expected Output:**
```
True True
```

---

## Exercise 4 (Medium)
What is the result of `2 + 3 * 4`? Add parentheses to make it 20 instead.

---

## Exercise 5 (Medium)
Use `is` to check if two variables point to the same object. Create `a = [1,2,3]` and `b = a`. Check `a is b`. Then create `c = [1,2,3]` and check `a is c`.

---

## Exercise 6 (Medium)
Print the result of: 5 & 3, 5 | 3, 5 ^ 3. (Bitwise AND, OR, XOR)

**Expected Output:**
```
1 7 6
```

---

## Exercise 7 (Medium)
Write an expression using `and` and `or`: "x is positive or y is positive, but not both zero". Test with (5,0) and (0,0).

---

## Exercise 8 (Hard)
What does `[] or "default"` return? What does `"hello" and "world"` return? Explain short-circuit evaluation.

---

## Exercise 9 (Hard)
Use `is` vs `==`: Create `a = 256` and `b = 256`. Check `a is b`. Then try `a = 257` and `b = 257`. (Python caches small integers.)

---

## Exercise 10 (Hard)
Given `items = [1, 2, 3, 4, 5]`, use membership and comparison to print True if 3 is in items and the length is 5.

**Expected Output:**
```
True
```

---

## Solutions / Hints

<details>
<summary>Exercise 4 Hint</summary>
`2 + 3 * 4` = 14. Use `(2 + 3) * 4` for 20.
</details>

<details>
<summary>Exercise 8 Hint</summary>
`[] or "default"` → "default" (first falsy, so return second)
`"hello" and "world"` → "world" (first truthy, so return second)
</details>
