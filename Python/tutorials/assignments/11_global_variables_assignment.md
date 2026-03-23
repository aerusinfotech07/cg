# Assignment: Global vs Local Variables

Practice understanding variable scope.

---

## Exercise 1 (Easy)
Create a global variable `count = 0`. Inside a function `increment()`, print the value of `count` (just read it). Call the function.

**Expected Output:**
```
0
```

---

## Exercise 2 (Easy)
Write a function `greet()` that creates a local variable `message = "Hello"` and prints it. Call the function. What happens if you try to print `message` outside the function?

---

## Exercise 3 (Medium)
Fix this code so it correctly increments a global `counter`:
```python
counter = 0
def increment():
    counter = counter + 1  # Error!
increment()
print(counter)
```

**Expected Output:**
```
1
```

---

## Exercise 4 (Medium)
Predict the output:
```python
x = 10
def demo():
    x = 5
    print(x)
demo()
print(x)
```

---

## Exercise 5 (Medium)
Write a function `add_to_total(value)` that adds `value` to a global variable `total` and prints the new total. Start with `total = 0`, then call `add_to_total(10)` and `add_to_total(5)`.

**Expected Output:**
```
10
15
```

---

## Exercise 6 (Medium)
What is the output?
```python
name = "global"
def outer():
    name = "outer"
    def inner():
        print(name)
    inner()
outer()
```

---

## Exercise 7 (Hard)
Use `nonlocal` to modify the outer function's variable from the inner function. Print the variable from both inner and outer.

```python
def outer():
    x = 10
    def inner():
        # Modify x here
        pass
    inner()
    print(x)  # Should print 20
outer()
```

**Expected Output:**
```
20
```

---

## Exercise 8 (Hard)
Create a function `create_counter()` that returns a function. The returned function should increment and return a counter each time it's called. Use a variable in the enclosing scope (not global).

**Expected behavior:**
```python
counter = create_counter()
print(counter())  # 1
print(counter())  # 2
print(counter())  # 3
```

---

## Exercise 9 (Hard)
Identify the scope (local, global, or enclosing) of each variable in this code:
```python
a = 1
def f():
    b = 2
    def g():
        c = 3
        print(a, b, c)
    g()
f()
```

---

## Exercise 10 (Hard)
Write a function `swap_globals()` that swaps the values of two global variables `x` and `y`. Test with `x=5`, `y=10`.

**Expected Output:**
```
Before: 5 10
After: 10 5
```

---

## Solutions / Hints

<details>
<summary>Exercise 3 Hint</summary>
Add `global counter` inside the function before modifying it.
</details>

<details>
<summary>Exercise 4 Hint</summary>
Output: 5 (from demo), then 10 (global x unchanged)
</details>

<details>
<summary>Exercise 7 Hint</summary>
Use `nonlocal x` then `x = 20` inside inner()
</details>
