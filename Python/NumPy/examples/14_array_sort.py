# NumPy Array Sort
import numpy as np

arr = np.array([3, 2, 0, 1])
print("np.sort:", np.sort(arr))
print("argsort indices:", np.argsort(arr))

arr2 = np.array([[3, 2, 1], [6, 5, 4]])
print("Sort each row:\n", np.sort(arr2, axis=1))
