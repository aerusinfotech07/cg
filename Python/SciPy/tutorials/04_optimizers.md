# SciPy Optimizers

## minimize() - Unconstrained Minimization

```python
from scipy.optimize import minimize

def f(x):
    return (x[0] - 1)**2 + (x[1] - 2)**2

result = minimize(f, [0, 0])
print(result.x)
```

## Methods

| Method | Use Case |
|--------|----------|
| BFGS | Default, general |
| Nelder-Mead | No derivative |
| L-BFGS-B | Bounded |
| SLSQP | Constraints |

## minimize_scalar() - 1D

```python
from scipy.optimize import minimize_scalar

def f(x):
    return (x - 2)**2

result = minimize_scalar(f)
print(result.x)
```

## root() - Root Finding

```python
from scipy.optimize import root

def eq(x):
    return x**2 - 4

sol = root(eq, x0=1)
print(sol.x)
```

## curve_fit() - Curve Fitting

```python
from scipy.optimize import curve_fit
import numpy as np

def func(x, a, b):
    return a * x + b

x = np.array([1, 2, 3, 4])
y = np.array([2, 4, 6, 8])
popt, _ = curve_fit(func, x, y)
print(popt)
```

## Next Steps

- [SciPy Sparse Data](05_sparse_data.md)
