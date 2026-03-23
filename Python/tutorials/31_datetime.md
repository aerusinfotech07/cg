# Python datetime Module

## Table of Contents
1. [Import datetime](#1-import-datetime)
2. [date](#2-date)
3. [time](#3-time)
4. [datetime](#4-datetime)
5. [timedelta](#5-timedelta)
6. [Formatting (strftime)](#6-formatting-strftime)
7. [Parsing (strptime)](#7-parsing-strptime)
8. [Common Operations](#8-common-operations)

---

## 1. Import datetime

```python
import datetime
from datetime import date, time, datetime, timedelta
```

---

## 2. date

```python
from datetime import date

today = date.today()
print(today)  # 2024-03-10

d = date(2024, 3, 10)
print(d.year, d.month, d.day)
```

---

## 3. time

```python
from datetime import time

t = time(14, 30, 0)  # 2:30:00 PM
print(t.hour, t.minute, t.second)
```

---

## 4. datetime

```python
from datetime import datetime

now = datetime.now()
print(now)

dt = datetime(2024, 3, 10, 14, 30, 0)
print(dt)
```

---

## 5. timedelta

```python
from datetime import datetime, timedelta

now = datetime.now()
tomorrow = now + timedelta(days=1)
next_week = now + timedelta(weeks=1)
diff = tomorrow - now
print(diff.days)
```

---

## 6. Formatting (strftime)

```python
from datetime import datetime

now = datetime.now()
print(now.strftime("%Y-%m-%d"))       # 2024-03-10
print(now.strftime("%H:%M:%S"))       # 14:30:00
print(now.strftime("%A, %B %d, %Y"))   # Sunday, March 10, 2024
```

### Common format codes

| Code | Meaning |
|------|---------|
| `%Y` | Year (4 digits) |
| `%m` | Month (01-12) |
| `%d` | Day (01-31) |
| `%H` | Hour (00-23) |
| `%M` | Minute |
| `%S` | Second |
| `%A` | Weekday name |

---

## 7. Parsing (strptime)

```python
from datetime import datetime

s = "2024-03-10 14:30:00"
dt = datetime.strptime(s, "%Y-%m-%d %H:%M:%S")
print(dt)
```

---

## 8. Common Operations

```python
# Current date/time
now = datetime.now()

# Difference
d1 = datetime(2024, 1, 1)
d2 = datetime(2024, 3, 10)
print((d2 - d1).days)

# Compare
print(d1 < d2)
```

---

## Quick Reference

| Task | Code |
|------|------|
| Today | `date.today()` |
| Now | `datetime.now()` |
| Format | `dt.strftime("%Y-%m-%d")` |
| Parse | `datetime.strptime(s, fmt)` |
| Delta | `timedelta(days=1)` |

---

## Next Steps

- Proceed to **math** tutorial
