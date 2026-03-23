# NumPy Array Search

## where() – Find Indices

```python
import numpy as np

arr = np.array([1, 2, 3, 4, 5, 4, 4])
x = np.where(arr == 4)
print(x)  # (array([3, 5, 6]),)
```

## searchsorted() – Sorted Arrays

```python
import numpy as np

arr = np.array([1, 3, 5, 7])
idx = np.searchsorted(arr, 4)
print(idx)  # 2 (insert position to keep sorted)
```

## Multiple Conditions

```python
import numpy as np

arr = np.array([1, 2, 3, 4, 5, 6])
x = np.where((arr > 2) & (arr < 6))
print(arr[x])  # [3 4 5]
```

## Next Steps

- [Array Sort](14_array_sort.md)
