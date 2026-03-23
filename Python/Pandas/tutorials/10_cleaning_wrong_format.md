# Pandas Cleaning Wrong Format

## Convert to Numeric

```python
df["col"] = pd.to_numeric(df["col"], errors="coerce")
```

## Convert to Datetime

```python
df["date"] = pd.to_datetime(df["date"])
df["date"] = pd.to_datetime(df["date"], format="%Y-%m-%d")
```

## Convert to Category

```python
df["col"] = df["col"].astype("category")
```

## Convert dtypes

```python
df["col"] = df["col"].astype(int)
df["col"] = df["col"].astype(str)
df["col"] = df["col"].astype(float)
```

## infer_objects()

```python
df = df.infer_objects()  # infer better dtypes
```

## convert_dtypes()

```python
df = df.convert_dtypes()  # convert to nullable dtypes
```

## Next Steps

- [Cleaning Wrong Data](11_cleaning_wrong_data.md)
