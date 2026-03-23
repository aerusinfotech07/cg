# Pandas Read JSON
import pandas as pd

json_str = '{"name": ["Alice", "Bob", "Charlie"], "age": [25, 30, 35]}'
df = pd.read_json(json_str)
print(df)
