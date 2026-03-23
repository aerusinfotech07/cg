# Assignment: Iterators

Practice iter() and next() with iterators.

---

## Exercise 1 (Easy)
Create iter() from list [1,2,3]. Call next() three times and print each value.

---

## Exercise 2 (Easy)
Use iter() on string "abc". Loop with next() until StopIteration (use try/except).

---

## Exercise 3 (Easy)
Create iterator from range(5). Print all values using next() in a loop.

---

## Exercise 4 (Medium)
Create a simple iterator class that yields 1, 2, 3. Implement __iter__ and __next__.

---

## Exercise 5 (Medium)
Create CountUp(start, stop) iterator. Iterate and print values from start to stop-1.

---

## Exercise 6 (Medium)
Use iter() with two arguments: iter(callable, sentinel). Create iterator that stops when callable returns 0.

---

## Exercise 7 (Hard)
Create CycleIterator that cycles through [1,2,3] infinitely. Use it in a for loop with break after 7 prints.

---

## Exercise 8 (Hard)
Implement __iter__ and __next__ for a class that iterates over even numbers up to n.

---

## Exercise 9 (Hard)
Check if an object is iterable (has __iter__ or __getitem__). Test with list, int, string.

---

## Exercise 10 (Hard)
Create an iterator that yields (index, value) pairs (like enumerate). Test with ["a","b","c"].

---

## Solutions / Hints

<details>
<summary>Exercise 4 Hint</summary>
```python
class SimpleIter:
    def __init__(self):
        self.n = 0
    def __iter__(self):
        return self
    def __next__(self):
        self.n += 1
        if self.n > 3:
            raise StopIteration
        return self.n
```
</details>
