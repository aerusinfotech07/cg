# Pandas Cleaning Data

## Why Clean Data?

Real-world data often has:
- **Empty cells** (NaN, None)
- **Wrong format** (dates, numbers as text)
- **Wrong data** (typos, outliers)
- **Duplicates**

## Overview

| Topic | Method |
|-------|--------|
| Empty cells | `fillna()`, `dropna()` |
| Wrong format | `convert_dtypes()`, `pd.to_datetime()` |
| Wrong data | Replace, filter |
| Duplicates | `drop_duplicates()` |

## Empty Cells

```python
df.dropna()      # remove rows with NaN
df.fillna(0)     # fill NaN with 0
df.fillna(df.mean())  # fill with column mean
```

## Duplicates

```python
df.drop_duplicates()
df.drop_duplicates(subset=["col1"])
```

## Next Steps

- [Cleaning Empty Cells](09_cleaning_empty_cells.md)
