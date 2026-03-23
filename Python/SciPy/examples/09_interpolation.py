# SciPy Interpolation
from scipy.interpolate import interp1d
import numpy as np

x = np.array([1, 2, 3, 4, 5])
y = np.array([1, 4, 9, 16, 25])
f = interp1d(x, y, kind="linear")
print("Interpolated at 2.5:", float(f(2.5)))
