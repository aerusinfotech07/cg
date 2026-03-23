# NumPy Array Search
import numpy as np

arr = np.array([1, 2, 3, 4, 5, 4, 4])
idx = np.where(arr == 4)
print("Indices where arr==4:", idx[0])

arr2 = np.array([1, 3, 5, 7])
pos = np.searchsorted(arr2, 4)
print("searchsorted(4):", pos)
