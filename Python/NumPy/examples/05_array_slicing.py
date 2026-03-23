# NumPy Array Slicing
import numpy as np

arr = np.array([1, 2, 3, 4, 5, 6, 7])
print("arr[1:5]:", arr[1:5])
print("arr[::2]:", arr[::2])

arr2d = np.array([[1, 2, 3], [4, 5, 6], [7, 8, 9]])
print("arr[1, 1:3]:", arr2d[1, 1:3])
print("arr[0:2, 0:2]:\n", arr2d[0:2, 0:2])
