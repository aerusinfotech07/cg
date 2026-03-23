# Pandas Read CSV - uses StringIO for demo without file
import pandas as pd
from io import StringIO

csv_data = "name,age,city\nAlice,25,NYC\nBob,30,LA\nCharlie,35,Chicago"
df = pd.read_csv(StringIO(csv_data))
print(df)
