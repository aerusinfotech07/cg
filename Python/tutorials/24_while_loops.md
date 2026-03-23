# Python while Loops

## Table of Contents
1. [while Loop Basics](#1-while-loop-basics)
2. [Loop with Condition](#2-loop-with-condition)
3. [break Statement](#3-break-statement)
4. [continue Statement](#4-continue-statement)
5. [else with while](#5-else-with-while)
6. [Infinite Loops](#6-infinite-loops)
7. [Common Patterns](#7-common-patterns)

---

## 1. while Loop Basics

Execute a block of code while a condition is True:

```python
i = 0
while i < 5:
    print(i)
    i += 1
```

**Output:**
```
0
1
2
3
4
```

---

## 2. Loop with Condition

The condition is checked before each iteration:

```python
count = 0
while count < 3:
    print(f"Count: {count}")
    count += 1
```

---

## 3. break Statement

Exit the loop immediately:

```python
i = 0
while True:
    if i >= 5:
        break
    print(i)
    i += 1
```

---

## 4. continue Statement

Skip to the next iteration:

```python
i = 0
while i < 5:
    i += 1
    if i == 3:
        continue
    print(i)
```

**Output:**
```
1
2
4
5
```

---

## 5. else with while

The `else` block runs if the loop completes without `break`:

```python
i = 0
while i < 3:
    print(i)
    i += 1
else:
    print("Loop finished normally")
```

---

## 6. Infinite Loops

Avoid infinite loops—ensure the condition eventually becomes False:

```python
# Dangerous - runs forever
# while True:
#     print("loop")
```

---

## 7. Common Patterns

### User Input Until Valid

```python
while True:
    age = input("Enter age (0-120): ")
    if age.isdigit() and 0 <= int(age) <= 120:
        break
    print("Invalid. Try again.")
```

### Countdown

```python
n = 5
while n > 0:
    print(n)
    n -= 1
print("Go!")
```

---

## Quick Reference

| Statement | Use |
|-----------|-----|
| `while cond:` | Loop while True |
| `break` | Exit loop |
| `continue` | Skip to next iteration |
| `else` | Run if no break |

---

## Next Steps

- Proceed to **for Loops** tutorial
