# NumPy Array Join
import numpy as np

arr1 = np.array([1, 2, 3])
arr2 = np.array([4, 5, 6])
print("concatenate:", np.concatenate((arr1, arr2)))

arr3 = np.array([[1, 2], [3, 4]])
arr4 = np.array([[5, 6], [7, 8]])
print("vstack:\n", np.vstack((arr3, arr4)))
print("hstack:\n", np.hstack((arr3, arr4)))
