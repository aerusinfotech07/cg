# Pandas Series
import pandas as pd

s = pd.Series([1, 2, 3, 4, 5])
print("Series:", s)
s2 = pd.Series([10, 20, 30], index=["a", "b", "c"])
print("Custom index:", s2)
print("s2['b']:", s2["b"])
