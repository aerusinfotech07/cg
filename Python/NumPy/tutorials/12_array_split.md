# NumPy Array Split

## array_split() – Into N Parts

```python
import numpy as np

arr = np.array([1, 2, 3, 4, 5, 6])
parts = np.array_split(arr, 3)
print(parts)  # [array([1,2]), array([3,4]), array([5,6])]
```

## split() – Equal Parts Only

```python
import numpy as np

arr = np.array([1, 2, 3, 4, 5, 6])
parts = np.split(arr, 3)  # must divide evenly
```

## 2D Split

```python
import numpy as np

arr = np.array([[1, 2], [3, 4], [5, 6], [7, 8]])
parts = np.array_split(arr, 2, axis=0)
```

## hsplit, vsplit

```python
import numpy as np

arr = np.array([[1, 2, 3], [4, 5, 6]])
h = np.hsplit(arr, 3)  # split columns
```

## Next Steps

- [Array Search](13_array_search.md)
