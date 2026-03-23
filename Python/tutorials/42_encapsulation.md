# Python Encapsulation

## Table of Contents
1. [What is Encapsulation?](#1-what-is-encapsulation)
2. [Private Convention (_prefix)](#2-private-convention-_prefix)
3. [Name Mangling (__prefix)](#3-name-mangling-__prefix)
4. [Properties](#4-properties)
5. [Getters and Setters](#5-getters-and-setters)
6. [Read-Only Attributes](#6-read-only-attributes)

---

## 1. What is Encapsulation?

**Encapsulation** bundles data and methods, and can hide internal details.
Python Encapsulation
Encapsulation is about protecting data inside a class.

It means keeping data (properties) and methods together in a class, while controlling how the data can be accessed from outside the class.

This prevents accidental changes to your data and hides the internal details of how your class works.

Why Use Encapsulation?
Encapsulation provides several benefits:

Data Protection: Prevents accidental modification of data
Validation: You can validate data before setting it
Flexibility: Internal implementation can change without affecting external code
Control: You have full control over how data is accessed and modified
---
Private Properties
In Python, you can make properties private by using a double underscore __ prefix:

ExampleGet your own Python Server
Create a private class property named __age:

class Person:
  def __init__(self, name, age):
    self.name = name
    self.__age = age # Private property

p1 = Person("Emil", 25)
print(p1.name)
print(p1.__age) # This will cause an error
Note: Private properties cannot be accessed directly from outside the class.

Get Private Property Value
To access a private property, you can create a getter method:

Example
Use a getter method to access a private property:

class Person:
  def __init__(self, name, age):
    self.name = name
    self.__age = age

  def get_age(self):
    return self.__age

p1 = Person("Tobias", 25)
print(p1.get_age())
Set Private Property Value
To modify a private property, you can create a setter method.

The setter method can also validate the value before setting it:

Example
Use a setter method to change a private property:

class Person:
  def __init__(self, name, age):
    self.name = name
    self.__age = age

  def get_age(self):
    return self.__age

  def set_age(self, age):
    if age > 0:
      self.__age = age
    else:
      print("Age must be positive")

p1 = Person("Tobias", 25)
print(p1.get_age())

p1.set_age(26)
print(p1.get_age())

Why Use Encapsulation?
Encapsulation provides several benefits:

Data Protection: Prevents accidental modification of data
Validation: You can validate data before setting it
Flexibility: Internal implementation can change without affecting external code
Control: You have full control over how data is accessed and modified
Example
Use encapsulation to protect and validate data:

class Student:
  def __init__(self, name):
    self.name = name
    self.__grade = 0

  def set_grade(self, grade):
    if 0 <= grade <= 100:
      self.__grade = grade
    else:
      print("Grade must be between 0 and 100")

  def get_grade(self):
    return self.__grade

  def get_status(self):
    if self.__grade >= 60:
      return "Passed"
    else:
      return "Failed"

student = Student("Emil")
student.set_grade(85)
print(student.get_grade())
print(student.get_status())


Protected Properties
Python also has a convention for protected properties using a single underscore _ prefix:

Example
Create a protected property:

class Person:
  def __init__(self, name, salary):
    self.name = name
    self._salary = salary # Protected property

p1 = Person("Linus", 50000)
print(p1.name)
print(p1._salary) # Can access, but shouldn't
Note: A single underscore _ is just a convention. It tells other programmers that the property is intended for internal use, but Python doesn't enforce this restriction.

Private Methods
You can also make methods private using the double underscore prefix:

Example
Create a private method:

class Calculator:
  def __init__(self):
    self.result = 0

  def __validate(self, num):
    if not isinstance(num, (int, float)):
      return False
    return True

  def add(self, num):
    if self.__validate(num):
      self.result += num
    else:
      print("Invalid number")

calc = Calculator()
calc.add(10)
calc.add(5)
print(calc.result)
# calc.__validate(5) # This would cause an error
Note: Just like private properties with double underscores, private methods cannot be called directly from outside the class. The __validate method can only be used by other methods inside the class.

Name Mangling
Name mangling is how Python implements private properties and methods.

When you use double underscores __, Python automatically renames it internally by adding _ClassName in front.

For example, __age becomes _Person__age.

Example
See how Python mangles the name:

class Person:
  def __init__(self, name, age):
    self.name = name
    self.__age = age

p1 = Person("Emil", 30)

# This is how Python mangles the name:
print(p1._Person__age) # Not recommended!
Note: While you can access private properties using the mangled name, it's not recommended. It defeats the purpose of encapsulation.

## Next Steps

- Proceed to **Constructors** tutorial
