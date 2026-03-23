# Pandas DataFrames
import pandas as pd

df = pd.DataFrame({"name": ["Alice", "Bob", "Charlie"], "age": [25, 30, 35]})
print(df)
print("Column 'name':", df["name"].tolist())
print("First row:", df.loc[0].tolist())
