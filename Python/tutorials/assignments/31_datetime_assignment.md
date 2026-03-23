# Assignment: datetime Module

Practice using the datetime module.

---

## Exercise 1 (Easy)
Import datetime and print today's date using date.today().

---

## Exercise 2 (Easy)
Create datetime(2024, 3, 10, 14, 30, 0). Print it.

---

## Exercise 3 (Easy)
Use datetime.now() and strftime to print date as "YYYY-MM-DD" and time as "HH:MM:SS".

---

## Exercise 4 (Medium)
Calculate the number of days between date(2024,1,1) and date(2024,3,10).

---

## Exercise 5 (Medium)
Parse the string "2024-03-10" into a date using strptime.

---

## Exercise 6 (Medium)
Add 7 days to today using timedelta. Print the result.

---

## Exercise 7 (Medium)
Format datetime.now() as "Sunday, March 10, 2024" (weekday, month name, day, year).

---

## Exercise 8 (Hard)
Create a function that returns the age in days given a birth date.

---

## Exercise 9 (Hard)
Get the last day of the current month. (Hint: first day of next month minus 1 day.)

---

## Exercise 10 (Hard)
Parse "2024-03-10 14:30:00" and extract hour, minute, second into variables.

---

## Solutions / Hints

<details>
<summary>Exercise 4 Hint</summary>
```python
from datetime import date
d1 = date(2024, 1, 1)
d2 = date(2024, 3, 10)
print((d2 - d1).days)
```
</details>
