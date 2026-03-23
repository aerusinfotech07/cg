# Pandas Removing Duplicates
import pandas as pd

df = pd.DataFrame({"name": ["Alice", "Bob", "Alice"], "age": [25, 30, 25]})
print("Original:\n", df)
print("drop_duplicates():\n", df.drop_duplicates())
print("drop_duplicates(subset=['name']):\n", df.drop_duplicates(subset=["name"]))
