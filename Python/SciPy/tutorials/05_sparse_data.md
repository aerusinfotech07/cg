# SciPy Sparse Data

## Why Sparse?

Sparse matrices store only non-zero elements, saving memory for large matrices with many zeros.

## CSR (Compressed Sparse Row)

```python
from scipy.sparse import csr_matrix
import numpy as np

data = np.array([1, 2, 3, 4])
row = np.array([0, 0, 1, 1])
col = np.array([0, 1, 0, 1])
M = csr_matrix((data, (row, col)), shape=(2, 2))
print(M.toarray())
```

## COO (Coordinate Format)

```python
from scipy.sparse import coo_matrix

M = coo_matrix(([1, 2, 3], ([0, 0, 1], [0, 1, 0])), shape=(2, 2))
```

## From Dense Array

```python
from scipy.sparse import csr_matrix
import numpy as np

dense = np.array([[1, 0, 0], [0, 2, 0], [0, 0, 3]])
sparse = csr_matrix(dense)
print(sparse)
```

## Operations

```python
sparse.toarray()
sparse.T
sparse * sparse
```

## Next Steps

- [SciPy Graphs](06_graphs.md)
