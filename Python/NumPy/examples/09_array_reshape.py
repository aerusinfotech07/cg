# NumPy Array Reshape
import numpy as np

arr = np.array([1, 2, 3, 4, 5, 6])
reshaped = arr.reshape(2, 3)
print("Reshape (2,3):\n", reshaped)

flat = arr.reshape(-1)
print("Flatten:", flat)
