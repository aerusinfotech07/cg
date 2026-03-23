# NumPy Array Iterating

## 1D – Direct Iteration

```python
import numpy as np

arr = np.array([1, 2, 3, 4])
for x in arr:
    print(x)
```

## 2D – Iterate Rows

```python
import numpy as np

arr = np.array([[1, 2], [3, 4], [5, 6]])
for row in arr:
    print(row)
```

## nditer() – Element-wise

```python
import numpy as np

arr = np.array([[1, 2], [3, 4]])
for x in np.nditer(arr):
    print(x)
```

## ndenumerate() – With Index

```python
import numpy as np

arr = np.array([10, 20, 30])
for idx, x in np.ndenumerate(arr):
    print(idx, x)
```

## Next Steps

- [Array Join](11_array_join.md)
