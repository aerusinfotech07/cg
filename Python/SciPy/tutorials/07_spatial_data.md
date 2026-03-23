# SciPy Spatial Data

## KDTree - Nearest Neighbor

```python
from scipy.spatial import KDTree
import numpy as np

points = np.array([[1, 1], [2, 2], [3, 3], [4, 4]])
tree = KDTree(points)
dist, idx = tree.query([2.5, 2.5], k=2)
print("Nearest 2 points:", idx, "distances:", dist)
```

## Delaunay Triangulation

```python
from scipy.spatial import Delaunay
import numpy as np

points = np.array([[0, 0], [1, 0], [0.5, 1]])
tri = Delaunay(points)
print("Simplices:", tri.simplices)
```

## Convex Hull

```python
from scipy.spatial import ConvexHull
import numpy as np

points = np.random.rand(10, 2)
hull = ConvexHull(points)
print("Vertices:", hull.vertices)
```

## Voronoi Diagram

```python
from scipy.spatial import Voronoi

vor = Voronoi(points)
```

## Distance

```python
from scipy.spatial.distance import euclidean

p1 = [0, 0]
p2 = [3, 4]
print(euclidean(p1, p2))
```

## Next Steps

- [SciPy Matlab Arrays](08_matlab_arrays.md)
