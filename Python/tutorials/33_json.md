# Python json Module

## Table of Contents
1. [What is JSON?](#1-what-is-json)
2. [json.loads() - Parse String](#2-jsonloads---parse-string)
3. [json.dumps() - To String](#3-jsondumps---to-string)
4. [json.load() - Read File](#4-jsonload---read-file)
5. [json.dump() - Write File](#5-jsondump---write-file)
6. [Formatting Options](#6-formatting-options)
7. [Custom Objects](#7-custom-objects)

---

## 1. What is JSON?

JSON (JavaScript Object Notation) is a lightweight data format. Python maps:

| JSON | Python |
|------|--------|
| object | dict |
| array | list |
| string | str |
| number | int/float |
| true/false | True/False |
| null | None |

---

## 2. json.loads() - Parse String

```python
import json

s = '{"name": "Alice", "age": 25}'
data = json.loads(s)
print(data["name"])
print(type(data))
```

**Output:**
```
Alice
<class 'dict'>
```

---

## 3. json.dumps() - To String

```python
import json

data = {"name": "Alice", "age": 25}
s = json.dumps(data)
print(s)
print(type(s))
```

**Output:**
```
{"name": "Alice", "age": 25}
<class 'str'>
```

---

## 4. json.load() - Read File

```python
import json

with open("data.json", "r") as f:
    data = json.load(f)
print(data)
```

---

## 5. json.dump() - Write File

```python
import json

data = {"name": "Alice", "age": 25}
with open("output.json", "w") as f:
    json.dump(data, f)
```

---

## 6. Formatting Options

```python
import json

data = {"name": "Alice", "age": 25}

# Pretty print
print(json.dumps(data, indent=2))

# Sort keys
print(json.dumps(data, sort_keys=True))

# Custom separators
print(json.dumps(data, separators=(',', ':')))
```

---

## 7. Custom Objects

For custom classes, use default/object_hook or implement encoding:

```python
import json

class Person:
    def __init__(self, name, age):
        self.name = name
        self.age = age

def to_dict(obj):
    return {"name": obj.name, "age": obj.age}

p = Person("Alice", 25)
print(json.dumps(p, default=to_dict))
```

---

## Quick Reference

| Function | Use |
|----------|-----|
| `json.loads(s)` | String → dict |
| `json.dumps(obj)` | dict → string |
| `json.load(f)` | File → dict |
| `json.dump(obj, f)` | dict → file |

---

## Next Steps

- Proceed to **regex** tutorial
