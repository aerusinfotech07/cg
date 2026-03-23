# Assignment: Constructors

Practice __init__ and object initialization.

---

## Exercise 1 (Easy)
Create class Person with __init__(self, name, age). Create instance and print both attributes.

---

## Exercise 2 (Easy)
Add default age=0 to Person.__init__. Create Person("Alice") and Person("Bob", 25).

---

## Exercise 3 (Medium)
Create class Point with __init__(self, x=0, y=0). Create Point(), Point(3), Point(3, 4).

---

## Exercise 4 (Medium)
Create class with class attribute species="Mammal" and instance attribute name. Print both from instance.

---

## Exercise 5 (Medium)
Create Student with __init__(self, name, grades=None). If grades is None, use []. Avoid mutable default bug.

---

## Exercise 6 (Medium)
Create class that counts instances. Use class variable _count. Increment in __init__.

---

## Exercise 7 (Hard)
Create class with __init__ that accepts *args. Store args as list. Create with varying number of args.

---

## Exercise 8 (Hard)
Create class with __init__ that accepts **kwargs. Store as instance attributes. Create with keyword args.

---

## Exercise 9 (Hard)
Implement __new__ to create a singleton. Second instantiation returns same object.

---

## Exercise 10 (Hard)
Create a class that validates all __init__ arguments. Raise ValueError for invalid. Test with valid and invalid.

---

## Solutions / Hints

<details>
<summary>Exercise 5 Hint</summary>
```python
def __init__(self, name, grades=None):
    self.name = name
    self.grades = grades if grades is not None else []
```
</details>
