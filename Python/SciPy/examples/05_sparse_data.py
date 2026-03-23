# SciPy Sparse Data
from scipy.sparse import csr_matrix
import numpy as np

dense = np.array([[1, 0, 0], [0, 2, 0], [0, 0, 3]])
sparse = csr_matrix(dense)
print("Sparse matrix:")
print(sparse)
print("To dense:")
print(sparse.toarray())
