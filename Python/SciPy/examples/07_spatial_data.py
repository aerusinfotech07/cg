# SciPy Spatial Data
from scipy.spatial import KDTree
from scipy.spatial.distance import euclidean
import numpy as np

points = np.array([[1, 1], [2, 2], [3, 3], [4, 4]])
tree = KDTree(points)
dist, idx = tree.query([2.5, 2.5], k=2)
print("Nearest 2 points indices:", idx, "distances:", dist)
print("Euclidean (0,0) to (3,4):", euclidean([0, 0], [3, 4]))
