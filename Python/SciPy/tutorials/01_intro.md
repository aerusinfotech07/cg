# SciPy Introduction

## What is SciPy?

**SciPy** (Scientific Python) is an open-source library for scientific and technical computing. It builds on NumPy and provides:

- **Optimization** – minimize, maximize, root finding
- **Integration** – numerical integration
- **Interpolation** – 1D and ND interpolation
- **Linear algebra** – beyond NumPy
- **Statistics** – distributions, significance tests
- **Sparse matrices** – efficient storage
- **Spatial** – KDTree, Delaunay, convex hull
- **Signal/Image processing** – filters, FFT

## Subpackages

| Subpackage | Purpose |
|------------|---------|
| `scipy.optimize` | Optimization, minimization |
| `scipy.sparse` | Sparse matrices |
| `scipy.spatial` | Spatial algorithms |
| `scipy.stats` | Statistical functions |
| `scipy.interpolate` | Interpolation |
| `scipy.constants` | Physical constants |
| `scipy.io` | I/O (MATLAB, etc.) |

## Basic Example

```python
import scipy
print(scipy.__version__)
```

## Next Steps

- [Getting Started](02_getting_started.md)
