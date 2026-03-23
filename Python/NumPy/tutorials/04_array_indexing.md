# NumPy Array Indexing

## 1D Indexing

```python
import numpy as np

arr = np.array([10, 20, 30, 40, 50])
print(arr[0])   # 10
print(arr[2])   # 30
print(arr[-1])  # 50 (last)
print(arr[-2])  # 40 (second to last)
```

## 2D Indexing

```python
import numpy as np

arr = np.array([[1, 2, 3], [4, 5, 6]])
print(arr[0, 0])   # 1
print(arr[1, 2])   # 6
print(arr[0])      # [1 2 3] (first row)
```

## 3D Indexing

```python
import numpy as np

arr = np.array([[[1, 2], [3, 4]], [[5, 6], [7, 8]]])
print(arr[0, 1, 0])  # 3
```

## Negative Indexing

- `-1` = last element
- `-2` = second to last
- Works for each dimension

## Next Steps

- [Array Slicing](05_array_slicing.md)
