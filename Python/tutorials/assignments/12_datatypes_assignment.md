# Assignment: Data Types

Practice identifying and using Python data types.

---

## Exercise 1 (Easy)
Create one variable of each: int, float, str, bool, and list. Print the type of each using `type()`.

**Expected Output (example):**
```
<class 'int'>
<class 'float'>
<class 'str'>
<class 'bool'>
<class 'list'>
```

---

## Exercise 2 (Easy)
What is the type of each?
- `42`
- `3.14`
- `"hello"`
- `True`
- `[1, 2, 3]`
- `(1, 2, 3)`
- `{1, 2, 3}`
- `{"a": 1}`

---

## Exercise 3 (Easy)
Create a variable containing a complex number `3+4j`. Print its real and imaginary parts.

**Expected Output:**
```
3.0 4.0
```

---

## Exercise 4 (Medium)
Which of these are mutable: list, tuple, set, dict, str? Write a short code example showing mutation for one mutable type.

---

## Exercise 5 (Medium)
Create an empty version of each: list, tuple, set, dict. Print their types and lengths.

---

## Exercise 6 (Medium)
What will `type(type(5))` return? Run it and explain.

---

## Exercise 7 (Medium)
Create a nested structure: a list containing a dict, which contains a list. Access and print an inner element.

---

## Exercise 8 (Hard)
Determine the output without running:
```python
a = (1, [2, 3])
a[1].append(4)
print(a)
```

---

## Exercise 9 (Hard)
Create a frozenset and show that it can be used as a dictionary key (unlike a regular set).

---

## Exercise 10 (Hard)
Explain the difference between `{}` and `set()` when creating an empty set. Why can't we use `{}` for an empty set?

---

## Solutions / Hints

<details>
<summary>Exercise 1 Hint</summary>
```python
a = 1
b = 1.0
c = "hi"
d = True
e = [1, 2]
for x in [a, b, c, d, e]:
    print(type(x))
```
</details>

<details>
<summary>Exercise 4 Hint</summary>
Mutable: list, set, dict. Immutable: tuple, str.
</details>

<details>
<summary>Exercise 8 Hint</summary>
Output: (1, [2, 3, 4]) - the tuple is immutable but the list inside can be modified.
</details>
