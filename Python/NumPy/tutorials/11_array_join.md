# NumPy Array Join

## concatenate()

```python
import numpy as np

arr1 = np.array([1, 2, 3])
arr2 = np.array([4, 5, 6])
joined = np.concatenate((arr1, arr2))
print(joined)  # [1 2 3 4 5 6]
```

## 2D Join (axis)

```python
import numpy as np

arr1 = np.array([[1, 2], [3, 4]])
arr2 = np.array([[5, 6], [7, 8]])
v = np.concatenate((arr1, arr2), axis=0)  # vertical
h = np.concatenate((arr1, arr2), axis=1)   # horizontal
```

## stack() – New Dimension

```python
import numpy as np

arr1 = np.array([1, 2, 3])
arr2 = np.array([4, 5, 6])
s = np.stack((arr1, arr2), axis=0)
print(s.shape)  # (2, 3)
```

## hstack, vstack, dstack

```python
import numpy as np

a = np.array([1, 2, 3])
b = np.array([4, 5, 6])
print(np.hstack((a, b)))  # horizontal
print(np.vstack((a, b)))  # vertical
```

## Next Steps

- [Array Split](12_array_split.md)
