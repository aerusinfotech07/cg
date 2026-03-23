# Pandas Read JSON

## read_json()

```python
import pandas as pd

df = pd.read_json("data.json")
print(df)
```

## From JSON String

```python
import pandas as pd

json_str = '{"name": ["Alice", "Bob"], "age": [25, 30]}'
df = pd.read_json(json_str)
```

## orient Parameter

```python
# Records (list of dicts)
df = pd.read_json('{"records": [{"a":1},{"a":2}]}', orient="records")

# Index
df = pd.read_json('{"0":{"a":1},"1":{"a":2}}', orient="index")
```

## Nested JSON

```python
# Use json_normalize for nested structures
from pandas import json_normalize
import json
data = json.loads(nested_json)
df = json_normalize(data)
```

## Next Steps

- [Analyzing Data](07_analyzing_data.md)
