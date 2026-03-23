# Assignment: Properties

Practice @property, setters, and computed attributes.

---

## Exercise 1 (Easy)
Create class with _value and @property value that returns it. Access via instance.value.

---

## Exercise 2 (Easy)
Add setter for value. Set and get. Add validation in setter (e.g., reject negative).

---

## Exercise 3 (Medium)
Create Rectangle with width and height. @property area returns w*h. No setter.

---

## Exercise 4 (Medium)
Create Circle with _radius. @property radius with getter and setter. Setter rejects negative.

---

## Exercise 5 (Medium)
Create Person with first, last. @property full_name returns "first last". Setter splits "first last" and sets both.

---

## Exercise 6 (Medium)
Add @property.deleter for an attribute. Deleting runs cleanup (e.g., set to None).

---

## Exercise 7 (Hard)
Create Temperature with _celsius. @property fahrenheit that converts. Setter for fahrenheit that converts back to celsius.

---

## Exercise 8 (Hard)
Create class with multiple related properties. Changing one updates others (e.g., radius, diameter, circumference).

---

## Exercise 9 (Hard)
Use property() function instead of decorator. property(getter, setter, deleter, doc).

---

## Exercise 10 (Hard)
Create lazy property: computed on first access, cached. Use a flag or None to detect first access.

---

## Solutions / Hints

<details>
<summary>Exercise 3 Hint</summary>
```python
class Rectangle:
    def __init__(self, w, h):
        self.width = w
        self.height = h
    @property
    def area(self):
        return self.width * self.height
```
</details>
