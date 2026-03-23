# Pandas Getting Started

## Installation

```bash
pip install pandas
```

## Import

```python
import pandas as pd
```

## First DataFrame

```python
import pandas as pd

df = pd.DataFrame({"A": [1, 2, 3], "B": [4, 5, 6]})
print(df)
```

## Version Check

```python
import pandas as pd
print(pd.__version__)
```

## From Dictionary

```python
import pandas as pd

data = {"name": ["Alice", "Bob"], "age": [25, 30]}
df = pd.DataFrame(data)
```

## Next Steps

- [Pandas Series](03_series.md)
