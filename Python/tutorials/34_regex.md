# Python re Module (Regular Expressions)

## Table of Contents
1. [Import re](#1-import-re)
2. [re.search()](#2-research)
3. [re.match()](#3-rematch)
4. [re.findall()](#4-refindall)
5. [re.sub()](#5-resub)
6. [Common Patterns](#6-common-patterns)
7. [Compiled Patterns](#7-compiled-patterns)
8. [Groups](#8-groups)

---

## 1. Import re

```python
import re
```

---

## 2. re.search()

Find first match anywhere in string:

```python
import re

text = "Hello, my email is user@example.co.in"
match = re.search(r'\w+@\w+\.\w+', text)
if match:
    print(match.group())
```

**Output:**
```
user@example.com
```

---

## 3. re.match()

Match only at start of string:

```python
import re

print(re.match(r'Hello', "Hello World"))  # Match
print(re.match(r'World', "Hello World"))  # None
```

---

## 4. re.findall()

Find all matches:

```python
import re

text = "Prices: 10, 20, 30"
numbers = re.findall(r'\d+', text)
print(numbers)  # ['10', '20', '30']
```

---

## 5. re.sub()

Replace matches:

```python
import re

text = "Hello World"
new_text = re.sub(r'World', 'Python', text)
print(new_text)  # Hello Python
```

---

## 6. Common Patterns

| Pattern | Meaning |
|---------|---------|
| `\d` | Digit |
| `\w` | Word character |
| `\s` | Whitespace |
| `\D` | Non-digit |
| `.` | Any character |
| `*` | Zero or more |
| `+` | One or more |
| `?` | Zero or one |
| `[]` | Character class |
| `^` | Start |
| `$` | End |

---

## 7. Compiled Patterns

```python
import re

pattern = re.compile(r'\d+')
print(pattern.findall("a1b2c3"))  # ['1', '2', '3']
```

---

## 8. Groups

```python
import re

text = "Date: 2024-03-10"
match = re.search(r'(\d{4})-(\d{2})-(\d{2})', text)
if match:
    print(match.group(0))  # 2024-03-10
    print(match.group(1))  # 2024
    print(match.group(2))  # 03
    print(match.group(3))  # 10
```

---

## Quick Reference

| Function | Use |
|----------|-----|
| `re.search()` | First match |
| `re.match()` | Match at start |
| `re.findall()` | All matches |
| `re.sub()` | Replace |
| `re.compile()` | Compile pattern |

---

## Next Steps

- Proceed to **try except** tutorial
