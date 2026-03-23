# SciPy Matlab Arrays

## savemat() – Save to .mat

```python
from scipy.io import savemat
import numpy as np

data = {"x": np.array([1, 2, 3]), "y": np.array([4, 5, 6])}
savemat("data.mat", data)
```

## loadmat() – Load from .mat

```python
from scipy.io import loadmat

mat = loadmat("data.mat")
print(mat.keys())
x = mat["x"]
```

## Structure Arrays

MATLAB structs become nested dicts. Use `struct_as_record=False` for object-like access.

```python
mat = loadmat("file.mat", struct_as_record=False)
```

## whosmat() – Inspect Without Loading

```python
from scipy.io import whosmat

info = whosmat("data.mat")
print(info)
```

## mminfo() – File Info

```python
from scipy.io import mminfo
# For older MATLAB v4 files
```

## Next Steps

- [SciPy Interpolation](09_interpolation.md)
