# NumPy Array Sort

## sort() – Returns Sorted Copy

```python
import numpy as np

arr = np.array([3, 2, 0, 1])
s = np.sort(arr)
print(s)  # [0 1 2 3]
```

## In-Place Sort

```python
import numpy as np

arr = np.array([3, 2, 0, 1])
arr.sort()
print(arr)  # [0 1 2 3]
```

## 2D Sort (axis)

```python
import numpy as np

arr = np.array([[3, 2, 1], [6, 5, 4]])
s = np.sort(arr, axis=1)  # sort each row
```

## argsort() – Indices

```python
import numpy as np

arr = np.array([3, 1, 2])
idx = np.argsort(arr)
print(idx)  # [1 2 0]
print(arr[idx])  # [1 2 3]
```

## Next Steps

- [Array Filter](15_array_filter.md)
