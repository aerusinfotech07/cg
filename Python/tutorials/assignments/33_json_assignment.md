# Assignment: json Module

Practice JSON serialization and parsing.

---

## Exercise 1 (Easy)
Use json.loads to parse '{"name": "Alice", "age": 25}'. Print the name.

---

## Exercise 2 (Easy)
Use json.dumps to convert {"a": 1, "b": 2} to a string. Print it.

---

## Exercise 3 (Easy)
Parse a JSON array '[1, 2, 3, 4, 5]'. Print the sum.

---

## Exercise 4 (Medium)
Create a dict, use json.dumps with indent=2. Print the pretty-printed result.

---

## Exercise 5 (Medium)
Write a dict to a file using json.dump. Read it back with json.load. Verify.

---

## Exercise 6 (Medium)
Parse JSON with nested structure: '{"user": {"name": "Alice", "age": 25}}'. Extract and print the name.

---

## Exercise 7 (Medium)
Use json.dumps with sort_keys=True. Compare output with and without.

---

## Exercise 8 (Hard)
Handle invalid JSON: wrap json.loads in try/except. Print "Invalid JSON" on error.

---

## Exercise 9 (Hard)
Convert a list of dicts to JSON string. Parse it back. Verify round-trip.

---

## Exercise 10 (Hard)
Create a custom class, implement a to_dict method. Use json.dumps with default=to_dict. Parse back.

---

## Solutions / Hints

<details>
<summary>Exercise 1 Hint</summary>
```python
import json
data = json.loads('{"name": "Alice", "age": 25}')
print(data["name"])
```
</details>
