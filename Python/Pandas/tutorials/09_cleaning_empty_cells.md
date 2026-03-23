# Pandas Cleaning Empty Cells

## Detect Empty Cells

```python
df.isna()  # True where NaN
df.isnull()  # same as isna()
df.notna()  # True where not NaN
```

## Remove Empty Cells

```python
# Drop rows with any NaN
df.dropna()

# Drop rows where all values are NaN
df.dropna(how="all")

# Drop columns with NaN
df.dropna(axis=1)

# Drop if NaN in specific column
df.dropna(subset=["col1"])
```

## Replace Empty Cells

```python
# Fill with constant
df.fillna(0)

# Fill with column mean
df.fillna(df.mean())

# Fill with median
df["col"].fillna(df["col"].median())

# Forward fill
df.ffill()
```

## Next Steps

- [Cleaning Wrong Format](10_cleaning_wrong_format.md)
