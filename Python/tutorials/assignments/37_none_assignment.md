# Assignment: None

Practice using and checking for None.

---

## Exercise 1 (Easy)
Assign None to a variable. Print it and its type.

---

## Exercise 2 (Easy)
Check if a variable is None using `is`. Print True or False.

---

## Exercise 3 (Easy)
Create a function that returns None explicitly. Call and print the result.

---

## Exercise 4 (Medium)
Write a function find(lst, target) that returns the index of target or None if not found.

---

## Exercise 5 (Medium)
Use dict.get("key") when key doesn't exist. What does it return? Print it.

---

## Exercise 6 (Medium)
Write a function with optional parameter defaulting to None. If None, use a default value.

---

## Exercise 7 (Medium)
Differentiate: create x=None and y=[]. Check both with `if not x` and `if not y`. Explain.

---

## Exercise 8 (Hard)
Implement optional chaining: given d={"a": {"b": 1}}, safely get d["a"]["b"]. Return None if any key missing.

---

## Exercise 9 (Hard)
Write a function that returns (value, None) on success and (None, error_msg) on failure. Unpack and handle.

---

## Exercise 10 (Hard)
Filter a list to remove None values. [1, None, 2, None, 3] → [1, 2, 3].

---

## Solutions / Hints

<details>
<summary>Exercise 4 Hint</summary>
```python
def find(lst, target):
    for i, x in enumerate(lst):
        if x == target:
            return i
    return None
```
</details>
