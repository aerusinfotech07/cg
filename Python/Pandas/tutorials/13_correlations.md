# Pandas Correlations

## corr()

```python
df.corr()  # correlation matrix (Pearson)
```

## Correlation Between Two Columns

```python
df["col1"].corr(df["col2"])
```

## Methods

```python
df.corr(method="pearson")   # default, linear
df.corr(method="kendall")   # ordinal
df.corr(method="spearman")  # rank-based
```

## Interpretation

- **1** – strong positive correlation
- **-1** – strong negative correlation
- **0** – no linear correlation

## Next Steps

- [Pandas Plotting](14_plotting.md)
