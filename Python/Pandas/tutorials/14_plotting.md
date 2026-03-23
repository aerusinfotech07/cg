# Pandas Plotting

## Installation

```bash
pip install matplotlib
```

## Plot Types

```python
df.plot()           # line (default)
df.plot(kind="bar")
df.plot(kind="hist")
df.plot(kind="scatter", x="col1", y="col2")
df.plot(kind="pie", y="col")
```

## Examples

```python
import pandas as pd

df = pd.DataFrame({"a": [1, 2, 3], "b": [4, 5, 6]})
df.plot(title="My Plot")
```

## Subplots

```python
df.plot(subplots=True)
```

## Save Figure

```python
df.plot() 
plt.savefig("output.png")
```

## Next Steps

- Return to [TUTORIAL_INDEX](TUTORIAL_INDEX.md)
