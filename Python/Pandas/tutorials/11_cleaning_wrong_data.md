# Pandas Cleaning Wrong Data

## Replace Values

```python
df["col"].replace("old", "new")
df.replace("old", "new")
df.replace({"old1": "new1", "old2": "new2"})
```

## Replacing with Condition

```python
df.loc[df["age"] > 120, "age"] = df["age"].median()
```

## Remove Outliers

```python
# Remove rows where age > 100
df = df[df["age"] <= 100]

# Or use clip
df["age"] = df["age"].clip(upper=100)
```

## String Cleaning

```python
df["name"] = df["name"].str.strip()
df["name"] = df["name"].str.lower()
df["name"] = df["name"].str.replace("old", "new")
```

## Next Steps

- [Removing Duplicates](12_removing_duplicates.md)
