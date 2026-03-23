# NumPy Array Iterating
import numpy as np

arr = np.array([[1, 2], [3, 4], [5, 6]])
print("Iterate rows:")
for row in arr:
    print(row)

print("nditer (element-wise):")
for x in np.nditer(arr):
    print(x, end=" ")
print()
