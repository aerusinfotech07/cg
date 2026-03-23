# Pandas Series

## What is a Series?

A **Series** is a 1D labeled array. It has an index and values.

```python
import pandas as pd

s = pd.Series([1, 2, 3, 4, 5])
print(s)
```

## Custom Index

```python
import pandas as pd

s = pd.Series([10, 20, 30], index=["a", "b", "c"])
print(s["b"])  # 20
```

## From Dictionary

```python
import pandas as pd

d = {"a": 1, "b": 2, "c": 3}
s = pd.Series(d)
```

## Indexing and Slicing

```python
import pandas as pd

s = pd.Series([10, 20, 30, 40], index=["a", "b", "c", "d"])
print(s["a"])
print(s[["a", "c"]])
print(s[1:3])
```

## Attributes

| Attribute | Description |
|-----------|-------------|
| `s.index` | Index labels |
| `s.values` | Underlying array |
| `s.dtype` | Data type |
| `s.shape` | Shape |

## Next Steps

- [Pandas DataFrames](04_dataframes.md)
