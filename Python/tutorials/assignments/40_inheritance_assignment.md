# Assignment: Inheritance

Practice class inheritance and method overriding.

---

## Exercise 1 (Easy)
Create Animal with speak() returning "Sound". Create Dog(Animal) with speak() returning "Woof!". Test.

---

## Exercise 2 (Easy)
Create Vehicle with __init__(brand). Create Car(Vehicle) that adds model. Use super() in __init__.

---

## Exercise 3 (Medium)
Create Shape with area() returning 0. Override in Rectangle and Circle.

---

## Exercise 4 (Medium)
Create Person with name. Create Employee(Person) with name and salary. Use super().__init__(name).

---

## Exercise 5 (Medium)
Use isinstance() and issubclass() to verify Dog is Animal, and dog instance is Dog and Animal.

---

## Exercise 6 (Medium)
Create a hierarchy: Animal -> Mammal -> Dog. Each level adds attributes. Create Dog and access all.

---

## Exercise 7 (Hard)
Create BankAccount with balance. Create SavingsAccount(BankAccount) that adds interest_rate and apply_interest().

---

## Exercise 8 (Hard)
Override __str__ in both parent and child. Call super().__str__() in child and extend the result.

---

## Exercise 9 (Hard)
Create multiple inheritance: class C(A, B). Both A and B have method foo(). Which is called? Test.

---

## Exercise 10 (Hard)
Create abstract-style base: Animal with speak() that raises NotImplementedError. Dog overrides it. Cat overrides it.

---

## Solutions / Hints

<details>
<summary>Exercise 2 Hint</summary>
```python
class Vehicle:
    def __init__(self, brand):
        self.brand = brand
class Car(Vehicle):
    def __init__(self, brand, model):
        super().__init__(brand)
        self.model = model
```
</details>
