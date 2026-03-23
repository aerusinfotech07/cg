# NumPy Copy vs View
import numpy as np

arr = np.array([1, 2, 3, 4, 5])
view = arr.view()
view[0] = 99
print("Original (view changed it):", arr)

arr2 = np.array([1, 2, 3, 4, 5])
copy = arr2.copy()
copy[0] = 99
print("Original (copy did not change):", arr2)
