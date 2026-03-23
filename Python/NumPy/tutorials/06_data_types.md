# NumPy Data Types

## Common dtypes

| dtype | Description |
|-------|-------------|
| `int8`, `int16`, `int32`, `int64` | Signed integers |
| `uint8`, `uint16`, … | Unsigned integers |
| `float16`, `float32`, `float64` | Floats |
| `complex64`, `complex128` | Complex numbers |
| `bool_` | Boolean |
| `str_` | String |

## Specifying dtype

```python
import numpy as np

arr = np.array([1, 2, 3], dtype=np.float64)
print(arr.dtype)  # float64

arr2 = np.array([1.1, 2.2], dtype=np.int32)  # truncates
```

## Converting dtype

```python
import numpy as np

arr = np.array([1, 2, 3])
arr_float = arr.astype(np.float64)
```

## Default dtypes

- Integers from lists → `int64` (or `int32` on 32-bit)
- Floats → `float64`

## Next Steps

- [Copy vs View](07_copy_vs_view.md)
