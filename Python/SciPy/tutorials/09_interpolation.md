# SciPy Interpolation

## interp1d – 1D Interpolation

```python
from scipy.interpolate import interp1d
import numpy as np

x = np.array([1, 2, 3, 4, 5])
y = np.array([1, 4, 9, 16, 25])
f = interp1d(x, y, kind="linear")
print(f(2.5))  # Interpolated value at 2.5
```

## Kinds

| kind | Description |
|------|-------------|
| `linear` | Linear interpolation |
| `cubic` | Cubic spline |
| `quadratic` | Quadratic spline |
| `nearest` | Nearest neighbor |

## UnivariateSpline

```python
from scipy.interpolate import UnivariateSpline

spline = UnivariateSpline(x, y, s=0)
print(spline(2.5))
```

## interp2d – 2D

```python
from scipy.interpolate import interp2d

# For 2D regular grids
f = interp2d(x, y, z, kind="linear")
```

## griddata – Irregular Data

```python
from scipy.interpolate import griddata

# For scattered/unstructured 2D data
zi = griddata((x, y), z, (xi, yi), method="linear")
```

## Next Steps

- [SciPy Significance Tests](10_significance_tests.md)
