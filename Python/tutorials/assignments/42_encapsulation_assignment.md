# Assignment: Encapsulation

Practice private attributes and properties.

---

## Exercise 1 (Easy)
Create class with _balance (single underscore). Access it from outside. Explain convention.

---

## Exercise 2 (Easy)
Create class with __secret (double underscore). Try to access from outside. What happens?

---

## Exercise 3 (Medium)
Create Temperature with _celsius. Add @property celsius that returns it. Add setter that validates >= -273.15.

---

## Exercise 4 (Medium)
Create BankAccount with __balance. Add deposit and withdraw. Add get_balance() that returns __balance.

---

## Exercise 5 (Medium)
Create class with @property for read-only attribute (no setter). Try to assign to it. What error?

---

## Exercise 6 (Medium)
Create Rectangle with width and height. Add @property area that computes and returns w*h. No setter.

---

## Exercise 7 (Hard)
Create Person with _age. Property age validates 0-120. Raise ValueError if invalid.

---

## Exercise 8 (Hard)
Create class with @property and @deleter. Deleting the property runs custom cleanup.

---

## Exercise 9 (Hard)
Create a class where __init__ takes value but stores in __value. Property returns it. Explain name mangling.

---

## Exercise 10 (Hard)
Create a computed property: full_name from first_name and last_name. Setting full_name splits and updates both.

---

## Solutions / Hints

<details>
<summary>Exercise 3 Hint</summary>
```python
class Temperature:
    def __init__(self, c):
        self._celsius = c
    @property
    def celsius(self):
        return self._celsius
    @celsius.setter
    def celsius(self, v):
        if v < -273.15:
            raise ValueError("Below absolute zero")
        self._celsius = v
```
</details>
