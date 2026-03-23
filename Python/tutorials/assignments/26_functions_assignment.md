# Assignment: Python Functions

Practice defining and using functions.

---

## Exercise 1 (Easy)
Write a function `greet(name)` that returns "Hello, [name]!". Call with "Alice".

---

## Exercise 2 (Easy)
Write `add(a, b)` that returns a+b. Call with (3, 5).

---

## Exercise 3 (Easy)
Write `is_even(n)` that returns True if n is even, else False.

---

## Exercise 4 (Medium)
Write `min_max(lst)` that returns (min, max) of a list. Unpack and print for [3,1,4,1,5].

---

## Exercise 5 (Medium)
Write `greet(name, greeting="Hello")` with default. Call with name only and with both args.

---

## Exercise 6 (Medium)
Write `sum_all(*args)` that returns sum of all arguments. Call with sum_all(1,2,3,4,5).

---

## Exercise 7 (Medium)
Write `print_info(**kwargs)` that prints each key-value pair. Call with print_info(name="Alice", age=25).

---

## Exercise 8 (Hard)
Write `factorial(n)` recursively. Test with 5.

---

## Exercise 9 (Hard)
Write a function that accepts both positional and keyword args. Use *args and **kwargs.

---

## Exercise 10 (Hard)
Write `apply_twice(f, x)` that returns f(f(x)). Test with f=lambda x: x+1, x=5. Result: 7.

---

## Solutions / Hints

<details>
<summary>Exercise 4 Hint</summary>
```python
def min_max(lst):
    return min(lst), max(lst)
```
</details>

<details>
<summary>Exercise 8 Hint</summary>
```python
def factorial(n):
    if n <= 1: return 1
    return n * factorial(n-1)
```
</details>
