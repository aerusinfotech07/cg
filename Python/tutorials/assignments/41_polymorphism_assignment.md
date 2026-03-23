# Assignment: Polymorphism

Practice polymorphism and operator overloading.

---

## Exercise 1 (Easy)
Create Dog and Cat, each with speak(). Write a function that calls speak() on any animal. Test with both.

---

## Exercise 2 (Easy)
Create class Point with x, y. Add __str__ to return "(x, y)". Print a Point.

---

## Exercise 3 (Medium)
Add __add__ to Point so p1 + p2 returns a new Point with summed coordinates.

---

## Exercise 4 (Medium)
Add __eq__ to Point so p1 == p2 compares coordinates. Test.

---

## Exercise 5 (Medium)
Create class Vector with __len__ returning magnitude (sqrt(x^2+y^2)). Use len(v).

---

## Exercise 6 (Medium)
Create a function process(items) that calls .process() on each item. Create two classes with process(). Pass list of mixed instances.

---

## Exercise 7 (Hard)
Add __lt__ to a class so instances can be sorted. Create a list and sort it.

---

## Exercise 8 (Hard)
Implement __getitem__ and __len__ to make a class iterable and support indexing.

---

## Exercise 9 (Hard)
Create __repr__ for Point. Difference from __str__: repr for debugging, str for display.

---

## Exercise 10 (Hard)
Create a container class that supports `in` operator by implementing __contains__.

---

## Solutions / Hints

<details>
<summary>Exercise 3 Hint</summary>
```python
def __add__(self, other):
    return Point(self.x + other.x, self.y + other.y)
```
</details>
