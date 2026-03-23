# NumPy Array Filter
import numpy as np

arr = np.array([1, 2, 3, 4, 5, 6])
print("arr > 3:", arr[arr > 3])
print("(arr > 2) & (arr < 6):", arr[(arr > 2) & (arr < 6)])

result = np.where(arr > 3, arr, 0)
print("np.where(arr>3, arr, 0):", result)
