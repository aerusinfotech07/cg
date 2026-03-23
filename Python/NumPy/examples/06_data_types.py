# NumPy Data Types
import numpy as np

arr = np.array([1, 2, 3], dtype=np.float64)
print("dtype:", arr.dtype)

arr2 = np.array([1, 2, 3])
arr_float = arr2.astype(np.float64)
print("Converted:", arr_float, "dtype:", arr_float.dtype)
