# Assignment: match case (Python 3.10+)

Practice pattern matching with match statements.

---

## Exercise 1 (Easy)
Use match to handle command: "start", "stop", "quit". Print appropriate message for each. Default: "Unknown".

---

## Exercise 2 (Easy)
Match HTTP status codes: 200="OK", 404="Not Found", 500="Server Error". Use _ for default.

---

## Exercise 3 (Medium)
Match a tuple (x, y): (0,0)="Origin", (x,0)="On x-axis", (0,y)="On y-axis", (x,y)="Point". Test with (3,4).

---

## Exercise 4 (Medium)
Match multiple values with |: "red"|"green"|"blue" print "Primary color", "yellow"|"cyan"|"magenta" print "Secondary".

---

## Exercise 5 (Medium)
Match a list: []="Empty", [x]="Single", [x,y]="Pair", _="Long list". Test with [1,2].

---

## Exercise 6 (Medium)
Match day number 1-7 to weekday name. 1=Monday, 7=Sunday.

---

## Exercise 7 (Hard)
Match a dict structure: {"type": "user", "name": x} vs {"type": "admin", "name": x}. Print different messages.

---

## Exercise 8 (Hard)
Match (operator, a, b) and compute: ("+", a, b), ("-", a, b), etc. Return result.

---

## Exercise 9 (Hard)
Match a string length: len 0="Empty", 1="Single char", 2-5="Short", 6+="Long". Use a variable for the string.

---

## Exercise 10 (Hard)
Match nested structure: (1, [2, 3]) vs (1, [2]) vs (1, []). Print "Pair with 2 items", "Pair with 1", "Pair empty".

---

## Solutions / Hints

<details>
<summary>Exercise 1 Hint</summary>
```python
match command:
    case "start": print("Starting...")
    case "stop": print("Stopping...")
    case "quit": print("Quitting...")
    case _: print("Unknown")
```
</details>
