# NumPy Creating Arrays

## From Lists/Tuples

```python
import numpy as np

arr1 = np.array([1, 2, 3, 4, 5])
arr2 = np.array([[1, 2], [3, 4]])
arr3 = np.array((1, 2, 3))  # from tuple
```

## zeros() – Array of Zeros

```python
import numpy as np

z = np.zeros(5)           # 1D: [0. 0. 0. 0. 0.]
z2 = np.zeros((2, 3))     # 2D: 2 rows, 3 columns
```

## ones() – Array of Ones

```python
import numpy as np

o = np.ones(4)
o2 = np.ones((3, 2))
```

## arange() – Range of Values

```python
import numpy as np

a = np.arange(5)          # [0 1 2 3 4]
b = np.arange(2, 10, 2)  # [2 4 6 8]
```

## linspace() – Evenly Spaced

```python
import numpy as np

l = np.linspace(0, 1, 5)  # 5 values from 0 to 1
```

## empty() – Uninitialized (fast)

```python
import numpy as np

e = np.empty((2, 2))  # random values, not zeros
```

## random – Random Arrays

```python
import numpy as np

r = np.random.rand(3, 3)  # 3x3 random floats [0, 1)
```

## Next Steps

- [Array Indexing](04_array_indexing.md)
