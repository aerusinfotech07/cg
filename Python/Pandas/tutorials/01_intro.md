# Pandas Introduction

## What is Pandas?

**Pandas** is an open-source Python library for data manipulation and analysis. It provides:

- **DataFrame** – 2D tabular data (rows and columns)
- **Series** – 1D labeled array
- **Data I/O** – CSV, JSON, Excel, SQL, etc.
- **Analysis** – filtering, grouping, aggregation, statistics

## Why Pandas?

| Feature | Description |
|---------|-------------|
| Easy I/O | Read/write CSV, JSON, Excel, databases |
| Alignment | Automatic index alignment |
| Missing data | Built-in handling of NaN |
| Reshaping | Pivot, melt, stack, unstack |
| Time series | Date/time support |

## Basic Example

```python
import pandas as pd

df = pd.DataFrame({"name": ["Alice", "Bob"], "age": [25, 30]})
print(df)
```

**Output:**
```
    name  age
0  Alice   25
1    Bob   30
```

## Key Concepts

- **DataFrame** – table with rows and columns
- **Series** – single column (or row)
- **Index** – row labels
- **dtypes** – column data types

## Next Steps

- [Getting Started](02_getting_started.md)
