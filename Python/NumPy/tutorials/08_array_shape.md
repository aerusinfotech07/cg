# NumPy Array Shape

## shape Attribute

```python
import numpy as np

arr1 = np.array([1, 2, 3, 4, 5])
print(arr1.shape)  # (5,)

arr2 = np.array([[1, 2, 3], [4, 5, 6]])
print(arr2.shape)  # (2, 3)
```

## ndim – Number of Dimensions

```python
import numpy as np

arr = np.array([[1, 2], [3, 4]])
print(arr.ndim)   # 2
```

## size – Total Elements

```python
import numpy as np

arr = np.array([[1, 2, 3], [4, 5, 6]])
print(arr.size)   # 6
```

## Reshape with shape

```python
import numpy as np

arr = np.array([1, 2, 3, 4, 5, 6])
arr.shape = (2, 3)  # reshape in place
print(arr)
```

## Next Steps

- [Array Reshape](09_array_reshape.md)
