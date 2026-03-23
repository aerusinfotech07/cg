# Assignment: Python Variables

Practice creating variables, casting, and type checking.

---

## Exercise 1 (Easy)
Create variables `x = 5` and `y = "Hello"`. Print both.

**Expected Output:**
```
5
Hello
```

---

## Exercise 2 (Easy)
Demonstrate that a variable can change type. Start with `z = 100` (int), then reassign `z = "hundred"` (str). Print `z` and its type after each assignment.

**Expected Output:**
```
100 <class 'int'>
hundred <class 'str'>
```

---

## Exercise 3 (Easy)
Use casting: create `a = str(42)`, `b = int("42")`, `c = float(42)`. Print each with its type.

---

## Exercise 4 (Medium)
Create variables `name`, `age`, and `score` using single quotes for strings. Print them in one line: "Name: X, Age: Y, Score: Z".

---

## Exercise 5 (Medium)
Demonstrate case sensitivity: create `count = 1` and `Count = 2`. Print both and show they are different.

**Expected Output:**
```
1
2
```

---

## Exercise 6 (Hard)
Write a program that takes a string "123" and an integer 123. Use `type()` to show their types. Then use casting to convert the string to int and add them. Print the result.

**Expected Output:**
```
246
```

<details>
<summary>Hint</summary>
int("123") + 123 = 246
</details>
