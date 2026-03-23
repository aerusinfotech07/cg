# NumPy Getting Started

## Installation

```bash
pip install numpy
```

## Import

The standard convention:

```python
import numpy as np
```

## First Array

```python
import numpy as np

arr = np.array([1, 2, 3, 4, 5])
print(arr)
print("Version:", np.__version__)
```

## Version Check

```python
import numpy as np
print(np.__version__)
```

## 2D Array

```python
import numpy as np

arr = np.array([[1, 2, 3], [4, 5, 6]])
print(arr)
```

**Output:**
```
[[1 2 3]
 [4 5 6]]
```

## Next Steps

- [Creating Arrays](03_creating_arrays.md)
