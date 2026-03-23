# NumPy Introduction

## What is NumPy?

**NumPy** (Numerical Python) is an open-source library for numerical computing in Python. It provides:

- **ndarray** – fast, homogeneous multi-dimensional arrays
- **Vectorized operations** – element-wise math without Python loops
- **Foundation** for SciPy, Pandas, SciKit-Learn, and more

## Why NumPy?

| Python List | NumPy Array |
|-------------|-------------|
| Mixed types | Homogeneous (same dtype) |
| Slower | Faster (C-optimized) |
| No built-in math | Rich math operations |
| Memory inefficient | Contiguous memory |

## Basic Example

```python
import numpy as np

arr = np.array([1, 2, 3, 4, 5])
print(arr)
print(type(arr))
```

**Output:**
```
[1 2 3 4 5]
<class 'numpy.ndarray'>
```

## Key Concepts

- **ndarray** – NumPy's main object (n-dimensional array)
- **dtype** – data type of elements (int, float, etc.)
- **shape** – dimensions (rows, columns, …)
- **vectorization** – operations applied to entire arrays

## Next Steps

- [Getting Started](02_getting_started.md) – Install and import
