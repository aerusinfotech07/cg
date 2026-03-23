# SciPy Matlab Arrays - save and load .mat files
from scipy.io import savemat, loadmat
import numpy as np
import os

data = {"x": np.array([1, 2, 3]), "y": np.array([4, 5, 6])}
savemat("scipy_demo.mat", data)
mat = loadmat("scipy_demo.mat")
print("Loaded keys:", [k for k in mat.keys() if not k.startswith("__")])
print("x:", mat["x"].flatten())
if os.path.exists("scipy_demo.mat"):
    os.remove("scipy_demo.mat")
