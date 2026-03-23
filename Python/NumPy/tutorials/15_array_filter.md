# NumPy Array Filter

## Boolean Indexing

```python
import numpy as np

arr = np.array([1, 2, 3, 4, 5, 6])
filtered = arr[arr > 3]
print(filtered)  # [4 5 6]
```

## Multiple Conditions

```python
import numpy as np

arr = np.array([1, 2, 3, 4, 5, 6])
filtered = arr[(arr > 2) & (arr < 6)]
print(filtered)  # [3 4 5]
```

## Boolean Array as Mask

```python
import numpy as np

arr = np.array([10, 20, 30, 40])
mask = np.array([True, False, True, False])
print(arr[mask])  # [10 30]
```

## np.where() for Replacement

```python
import numpy as np

arr = np.array([1, 2, 3, 4, 5])
result = np.where(arr > 3, arr, 0)
print(result)  # [0 0 0 4 5]
```

## Next Steps

- Return to [TUTORIAL_INDEX](TUTORIAL_INDEX.md)
