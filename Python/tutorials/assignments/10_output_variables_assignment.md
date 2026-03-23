# Assignment: Output Variables

Practice outputting variables with different methods.

---

## Exercise 1 (Easy)
Create variables `name = "Alice"` and `age = 25`. Print them using commas in one `print()` statement.

**Expected Output:**
```
Alice 25
```

---

## Exercise 2 (Easy)
Create `product = "Laptop"` and `price = 999.99`. Print "Product: [product] Price: [price]" using f-strings.

**Expected Output:**
```
Product: Laptop Price: 999.99
```

---

## Exercise 3 (Easy)
Print "The sum of 5 and 3 is 8" using variables `a = 5` and `b = 3` and an f-string for the sum.

**Expected Output:**
```
The sum of 5 and 3 is 8
```

---

## Exercise 4 (Medium)
Create `pi = 3.14159`. Print it with exactly 2 decimal places using an f-string.

**Expected Output:**
```
3.14
```

---

## Exercise 5 (Medium)
Create `score = 95`. Print it padded with zeros to 3 digits (e.g., 095) using f-string formatting.

**Expected Output:**
```
095
```

---

## Exercise 6 (Medium)
Print a formatted table header and row. Variables: `name="Alice"`, `age=25`, `city="NYC"`. Use f-strings with consistent spacing.

**Expected Output (example):**
```
Name    Age  City
Alice   25   NYC
```

---

## Exercise 7 (Medium)
Use the `format()` method to print "Hello, [name]! You are [age] years old." with `name="Bob"` and `age=30`.

**Expected Output:**
```
Hello, Bob! You are 30 years old.
```

---

## Exercise 8 (Hard)
Create a list `items = ["apple", "banana", "cherry"]`. Print "I have 3 items: apple, banana, cherry" using f-string and `", ".join(items)`.

**Expected Output:**
```
I have 3 items: apple, banana, cherry
```

---

## Exercise 9 (Hard)
Print a receipt format:
- Item: "Coffee", Price: 4.50, Quantity: 3
- Subtotal should be calculated and displayed with 2 decimal places

**Expected Output (example):**
```
Item: Coffee
Price: $4.50
Quantity: 3
Subtotal: $13.50
```

---

## Exercise 10 (Hard)
Create `data = {"name": "Alice", "score": 95, "grade": "A"}`. Loop through and print each key-value pair as "key: value" using f-strings.

**Expected Output:**
```
name: Alice
score: 95
grade: A
```

---

## Solutions / Hints

<details>
<summary>Exercise 2 Hint</summary>
```python
product = "Laptop"
price = 999.99
print(f"Product: {product} Price: {price}")
```
</details>

<details>
<summary>Exercise 4 Hint</summary>
```python
pi = 3.14159
print(f"{pi:.2f}")
```
</details>

<details>
<summary>Exercise 5 Hint</summary>
```python
score = 95
print(f"{score:03d}")
```
</details>
