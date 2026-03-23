# NumPy Array Slicing

## Syntax: `[start:end:step]`

```python
import numpy as np

arr = np.array([1, 2, 3, 4, 5, 6, 7])
print(arr[1:5])    # [2 3 4 5]
print(arr[2:])     # [3 4 5 6 7]
print(arr[:4])     # [1 2 3 4]
print(arr[::2])    # [1 3 5 7] (step 2)
```

## Negative Slicing

```python
import numpy as np

arr = np.array([1, 2, 3, 4, 5])
print(arr[-3:-1])  # [3 4]
```

## 2D Slicing

```python
import numpy as np

arr = np.array([[1, 2, 3], [4, 5, 6], [7, 8, 9]])
print(arr[1, 1:3])   # [5 6]
print(arr[0:2, 1])   # [2 5]
print(arr[0:2, 0:2]) # [[1 2] [4 5]]
```

## Next Steps

- [Data Types](06_data_types.md)
