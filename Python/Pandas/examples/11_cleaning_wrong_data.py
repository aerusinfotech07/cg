# Pandas Cleaning Wrong Data
import pandas as pd

df = pd.DataFrame({"name": ["Alice", "bob", "CHARLIE"], "age": [25, 999, 35]})
print("Original:\n", df)
df["name"] = df["name"].str.title()
df.loc[df["age"] > 120, "age"] = df["age"].median()
print("Cleaned:\n", df)
