# NumPy Copy vs View

## View – Shares Memory

A **view** is a new array object that shares data with the original. Changes to the view affect the original.

```python
import numpy as np

arr = np.array([1, 2, 3, 4, 5])
view = arr.view()
view[0] = 99
print(arr[0])   # 99 – original changed!
```

## Copy – Independent

A **copy** owns its data. Changes do not affect the original.

```python
import numpy as np

arr = np.array([1, 2, 3, 4, 5])
copy = arr.copy()
copy[0] = 99
print(arr[0])   # 1 – original unchanged
```

## Slicing Creates a View

```python
import numpy as np

arr = np.array([1, 2, 3, 4, 5])
s = arr[1:4]
s[0] = 99
print(arr)  # [1 99 3 4 5] – original changed
```

## When to Use

- **View** – when you want to modify a subset in place
- **Copy** – when you need an independent array

## Next Steps

- [Array Shape](08_array_shape.md)
