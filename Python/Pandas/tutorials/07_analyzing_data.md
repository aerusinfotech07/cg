# Pandas Analyzing Data

## head() and tail()

```python
df.head(5)   # first 5 rows
df.tail(5)   # last 5 rows
```

## info()

```python
df.info()  # columns, dtypes, non-null counts
```

## describe()

```python
df.describe()  # mean, std, min, max, quartiles for numeric columns
```

## Shape and Columns

```python
df.shape      # (rows, columns)
df.columns    # column names
df.index      # index labels
df.dtypes     # column types
```

## Selection

```python
df["col"]           # single column
df[["col1","col2"]] # multiple columns
df.loc[0]           # row by label
df.iloc[0]          # row by position
```

## Filtering

```python
df[df["age"] > 25]
df[df["name"].str.contains("A")]
```

## Next Steps

- [Cleaning Data](08_cleaning_data.md)
