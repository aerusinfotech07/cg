# Pandas Cleaning Wrong Format
import pandas as pd

df = pd.DataFrame({"age": ["25", "30", "35"], "score": ["90.5", "85.0", "88.5"]})
print("Original dtypes:", df.dtypes)
df["age"] = pd.to_numeric(df["age"])
df["score"] = pd.to_numeric(df["score"])
print("After conversion:", df.dtypes)
print(df)
