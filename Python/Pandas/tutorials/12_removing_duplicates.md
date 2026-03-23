# Pandas Removing Duplicates

## drop_duplicates()

```python
df.drop_duplicates()  # remove duplicate rows
```

## Keep First/Last

```python
df.drop_duplicates(keep="first")   # default
df.drop_duplicates(keep="last")
df.drop_duplicates(keep=False)      # remove all duplicates
```

## Subset

```python
# Duplicates based on specific columns
df.drop_duplicates(subset=["col1"])
df.drop_duplicates(subset=["col1", "col2"])
```

## Duplicated()

```python
df.duplicated()  # boolean Series
df[df.duplicated()]  # show duplicate rows
df[~df.duplicated()]  # show unique rows
```

## Next Steps

- [Pandas Correlations](13_correlations.md)
