# Assignment: Python Dictionaries

Practice dictionary operations: access, add, change, remove, loop.

---

## Exercise 1 (Easy)
Create a dictionary `person = {"name": "Alice", "age": 25, "city": "NYC"}`. Print the name and age.

**Expected Output:**
```
Alice 25
```

---

## Exercise 2 (Easy)
Add a new key "email" with value "alice@example.com" to the person dict. Change "age" to 26. Print the dict.

---

## Exercise 3 (Easy)
Use get() to safely access "country" from person (default "Unknown"). Print the result.

**Expected Output:**
```
Unknown
```

---

## Exercise 4 (Medium)
Loop through person and print each key-value pair as "key: value".

**Expected Output (example):**
```
name: Alice
age: 26
city: NYC
email: alice@example.com
```

---

## Exercise 5 (Medium)
Create a dict from two lists: keys = ["a", "b", "c"] and values = [1, 2, 3]. Use zip() and dict().

**Expected Output:**
```
{'a': 1, 'b': 2, 'c': 3}
```

---

## Exercise 6 (Medium)
Remove the "age" key from person using pop(). Print the removed value and the updated dict.

---

## Exercise 7 (Medium)
Use dict comprehension to create {1: 1, 2: 4, 3: 9, 4: 16} (keys 1-4, values squared).

---

## Exercise 8 (Hard)
Given a nested dict `users = {"alice": {"age": 25, "city": "NYC"}, "bob": {"age": 30, "city": "LA"}}`, print alice's city. Add "email" to bob's nested dict.

---

## Exercise 9 (Hard)
Merge two dicts: d1 = {"a": 1, "b": 2} and d2 = {"b": 3, "c": 4}. If keys overlap, d2 should override. Print merged dict.

**Expected Output:**
```
{'a': 1, 'b': 3, 'c': 4}
```

---

## Exercise 10 (Hard)
Count the frequency of each character in the string "hello". Store in a dict. Print it.

**Expected Output:**
```
{'h': 1, 'e': 1, 'l': 2, 'o': 1}
```

---

## Solutions / Hints

<details>
<summary>Exercise 5 Hint</summary>
```python
keys = ["a", "b", "c"]
values = [1, 2, 3]
d = dict(zip(keys, values))
```
</details>

<details>
<summary>Exercise 9 Hint</summary>
```python
merged = {**d1, **d2}
# Or: merged = d1.copy(); merged.update(d2)
```
</details>

<details>
<summary>Exercise 10 Hint</summary>
```python
s = "hello"
freq = {}
for c in s:
    freq[c] = freq.get(c, 0) + 1
print(freq)
```
</details>
