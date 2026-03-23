# Pandas Correlations
import pandas as pd

df = pd.DataFrame({"A": [1, 2, 3, 4, 5], "B": [2, 4, 6, 8, 10], "C": [1, 1, 1, 1, 1]})
print("DataFrame:\n", df)
print("Correlation matrix:\n", df.corr())
print("A vs B correlation:", df["A"].corr(df["B"]))
