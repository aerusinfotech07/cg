# Pandas Cleaning Empty Cells
import pandas as pd
import numpy as np

df = pd.DataFrame({"A": [1, np.nan, 3], "B": [4, 5, np.nan]})
print("Original:\n", df)
print("isna():\n", df.isna())
print("dropna():\n", df.dropna())
print("fillna(0):\n", df.fillna(0))
