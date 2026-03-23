# Assignment: Python Classes

Practice creating classes and objects.

---

## Exercise 1 (Easy)
Create a class Dog with __init__(self, name). Create an instance and print the name.

---

## Exercise 2 (Easy)
Add a method bark() to Dog that returns "Woof!". Call it.

---

## Exercise 3 (Easy)
Create class Rectangle with width and height. Add method area() that returns width*height.

---

## Exercise 4 (Medium)
Create class Person with name and age. Add method introduce() that returns "Hi, I'm [name], [age]."

---

## Exercise 5 (Medium)
Create class BankAccount with balance. Add deposit(amount) and withdraw(amount) methods.

---

## Exercise 6 (Medium)
Add __str__ to Person to return "Person(name, age)". Print an instance.

---

## Exercise 7 (Medium)
Create class Counter with count attribute. Add increment() and reset() methods.

---

## Exercise 8 (Hard)
Create class Student extending Person. Add grade attribute. Override introduce() to include grade.

---

## Exercise 9 (Hard)
Create class Point with x, y. Add method distance_to(other) that returns Euclidean distance.

---

## Exercise 10 (Hard)
Create class Circle with radius. Add area() and circumference() methods. Use math.pi.

---

## Solutions / Hints

<details>
<summary>Exercise 3 Hint</summary>
```python
class Rectangle:
    def __init__(self, w, h):
        self.width = w
        self.height = h
    def area(self):
        return self.width * self.height
```
</details>
