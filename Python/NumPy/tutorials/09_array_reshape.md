# NumPy Array Reshape

## reshape() – New Shape, Same Data

```python
import numpy as np

arr = np.array([1, 2, 3, 4, 5, 6])
reshaped = arr.reshape(2, 3)
print(reshaped)
# [[1 2 3]
#  [4 5 6]]
```

## -1 for Unknown Dimension

```python
import numpy as np

arr = np.array([1, 2, 3, 4, 5, 6])
r = arr.reshape(2, -1)   # -1 = infer (3)
r2 = arr.reshape(-1, 2)  # 3 rows, 2 cols
```

## Flatten – 1D

```python
import numpy as np

arr = np.array([[1, 2], [3, 4]])
flat = arr.reshape(-1)  # or arr.flatten()
print(flat)  # [1 2 3 4]
```

## ravel() – View When Possible

```python
import numpy as np

arr = np.array([[1, 2], [3, 4]])
r = arr.ravel()  # view if possible
```

## Next Steps

- [Array Iterating](10_array_iterating.md)
