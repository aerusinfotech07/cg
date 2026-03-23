# Pandas Read CSV

## read_csv()

```python
import pandas as pd

df = pd.read_csv("data.csv")
print(df)
```

## Common Parameters

| Parameter | Description |
|-----------|-------------|
| `sep` | Delimiter (default `,`) |
| `header` | Row index for headers (default 0) |
| `index_col` | Column to use as index |
| `usecols` | Columns to read |
| `nrows` | Number of rows to read |

## Examples

```python
# Custom delimiter
df = pd.read_csv("data.txt", sep="\t")

# No header
df = pd.read_csv("data.csv", header=None)

# First column as index
df = pd.read_csv("data.csv", index_col=0)

# Read first 5 rows
df = pd.read_csv("data.csv", nrows=5)
```

## From String

```python
from io import StringIO
csv_data = "a,b,c\n1,2,3\n4,5,6"
df = pd.read_csv(StringIO(csv_data))
```

## Next Steps

- [Read JSON](06_read_json.md)
