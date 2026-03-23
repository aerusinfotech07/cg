# Pandas DataFrames

## What is a DataFrame?

A **DataFrame** is a 2D labeled structure with rows and columns. Similar to a spreadsheet or SQL table.

```python
import pandas as pd

df = pd.DataFrame({"name": ["Alice", "Bob"], "age": [25, 30]})
print(df)
```

## From List of Dicts

```python
import pandas as pd

data = [{"name": "Alice", "age": 25}, {"name": "Bob", "age": 30}]
df = pd.DataFrame(data)
```

## Access Columns

```python
df["name"]
df["age"]
df[["name", "age"]]
```

## Access Rows

```python
df.loc[0]      # by label
df.iloc[0]     # by position
df.head(2)     # first 2 rows
df.tail(2)     # last 2 rows
```

## Add/Remove Columns

```python
df["city"] = ["NYC", "LA"]
df.drop("city", axis=1, inplace=True)
```

## Next Steps

- [Read CSV](05_read_csv.md)
