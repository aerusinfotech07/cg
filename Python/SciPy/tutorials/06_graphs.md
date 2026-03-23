# SciPy Graphs

## csgraph - Compressed Sparse Graph

The scipy.sparse.csgraph module provides graph algorithms for sparse adjacency matrices.

## Shortest Path (Dijkstra)

```python
from scipy.sparse.csgraph import dijkstra
from scipy.sparse import csr_matrix
import numpy as np

graph = np.array([
    [0, 1, 2, 0],
    [1, 0, 0, 3],
    [2, 0, 0, 1],
    [0, 3, 1, 0]
])
dist_matrix, predecessors = dijkstra(csgraph=graph, indices=0, return_predecessors=True)
print("Distances from node 0:", dist_matrix)
```

## Connected Components

```python
from scipy.sparse.csgraph import connected_components

n_components, labels = connected_components(csgraph, directed=False)
```

## Floyd-Warshall

```python
from scipy.sparse.csgraph import floyd_warshall

dist = floyd_warshall(csgraph=graph)
```

## Minimum Spanning Tree

```python
from scipy.sparse.csgraph import minimum_spanning_tree

mst = minimum_spanning_tree(csgraph)
```

## Next Steps

- [SciPy Spatial Data](07_spatial_data.md)
