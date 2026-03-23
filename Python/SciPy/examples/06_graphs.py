# SciPy Graphs
from scipy.sparse.csgraph import dijkstra
import numpy as np

graph = np.array([
    [0, 1, 2, 0],
    [1, 0, 0, 3],
    [2, 0, 0, 1],
    [0, 3, 1, 0]
])
dist_matrix = dijkstra(csgraph=graph, indices=0)
print("Distances from node 0:", dist_matrix)
