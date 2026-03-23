# NumPy Array Split
import numpy as np

arr = np.array([1, 2, 3, 4, 5, 6])
parts = np.array_split(arr, 3)
print("Split into 3:", [p.tolist() for p in parts])

arr2d = np.array([[1, 2], [3, 4], [5, 6], [7, 8]])
parts2 = np.array_split(arr2d, 2, axis=0)
print("2D split:", [p.tolist() for p in parts2])
