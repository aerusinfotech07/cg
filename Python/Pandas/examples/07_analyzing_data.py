# Pandas Analyzing Data
import pandas as pd

df = pd.DataFrame({"A": [1, 2, 3, 4, 5], "B": [10, 20, 30, 40, 50]})
print("head(2):\n", df.head(2))
print("describe():\n", df.describe())
print("shape:", df.shape)
print("columns:", df.columns.tolist())
