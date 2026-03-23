# Assignment: Python Comments

Practice writing effective comments in Python.

---

## Exercise 1 (Easy)
Add a single-line comment above a `print("Hello")` statement that says "Display greeting".

---

## Exercise 2 (Easy)
Add an inline comment at the end of `x = 10` that explains "Initialize counter".

---

## Exercise 3 (Easy)
Comment out a line of code so `print("Hidden")` does not run, but `print("Visible")` does.

**Expected Output:**
```
Visible
```

---

## Exercise 4 (Medium)
Write a multi-line comment (using `#` on each line) that describes what the following code does:
```python
total = 0
for i in range(5):
    total += i
print(total)
```

---

## Exercise 5 (Medium)
Add a docstring to this function that describes its purpose and parameters:
```python
def add(a, b):
    return a + b
```

---

## Exercise 6 (Medium)
Add a TODO comment indicating that error handling needs to be added to this function:
```python
def divide(a, b):
    return a / b
```

---

## Exercise 7 (Medium)
Add section header comments to organize this code into "Configuration" and "Main Logic" sections:
```python
max_retries = 3
timeout = 30

for i in range(max_retries):
    print(f"Attempt {i+1}")
```

---

## Exercise 8 (Hard)
Write a proper multi-line docstring for this function including Args and Returns:
```python
def calculate_average(numbers):
    return sum(numbers) / len(numbers)
```

---

## Exercise 9 (Hard)
Identify which comments are good vs bad. Rewrite the bad ones:
- `# set x to 5`
- `# Validate user input before processing`
- `# loop`
- `# Use int() because string comparison would give wrong result for "10" vs "9"`

---

## Exercise 10 (Hard)
Add appropriate comments to this code block to make it understandable to a new developer:
```python
result = []
for n in range(2, 100):
    is_prime = True
    for i in range(2, int(n**0.5) + 1):
        if n % i == 0:
            is_prime = False
            break
    if is_prime:
        result.append(n)
print(result[:10])
```

---

## Solutions / Hints

<details>
<summary>Exercise 1 Hint</summary>
```python
# Display greeting
print("Hello")
```
</details>

<details>
<summary>Exercise 3 Hint</summary>
```python
# print("Hidden")
print("Visible")
```
</details>

<details>
<summary>Exercise 5 Hint</summary>
```python
def add(a, b):
    """Add two numbers and return the result."""
    return a + b
```
</details>
