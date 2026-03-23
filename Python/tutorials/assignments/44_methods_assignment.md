# Assignment: Methods

Practice instance, class, and static methods.

---

## Exercise 1 (Easy)
Create class with instance method greet(self) returning "Hello". Call from instance.

---

## Exercise 2 (Easy)
Create class with @classmethod get_count(cls) that returns a class variable count. Call via class and instance.

---

## Exercise 3 (Easy)
Create class with @staticmethod add(a, b) returning a+b. Call without creating instance.

---

## Exercise 4 (Medium)
Create Counter class. @classmethod from_list(cls, lst) creates instance with count=len(lst). Instance method increment().

---

## Exercise 5 (Medium)
Add __str__ to a class. Create instance and print it. Also try str(instance).

---

## Exercise 6 (Medium)
Add __len__ to a class that holds a list. len(instance) should return list length.

---

## Exercise 7 (Medium)
Create @staticmethod is_valid_email(s) that returns True if "@" in s. Test.

---

## Exercise 8 (Hard)
Create class with __eq__ so two instances are equal if their attributes match. Test == and !=.

---

## Exercise 9 (Hard)
Create @classmethod alternate_constructor that takes different args and returns instance. E.g., from_string("a,b").

---

## Exercise 10 (Hard)
Implement __iter__ and __next__ to make a class iterable. Use in for loop.

---

## Solutions / Hints

<details>
<summary>Exercise 3 Hint</summary>
```python
class Math:
    @staticmethod
    def add(a, b):
        return a + b
print(Math.add(3, 5))
```
</details>
