# SciPy Optimizers
from scipy.optimize import minimize, minimize_scalar

def f(x):
    return (x[0] - 1)**2 + (x[1] - 2)**2

result = minimize(f, [0, 0])
print("minimize result:", result.x)

def g(x):
    return (x - 2)**2
r2 = minimize_scalar(g)
print("minimize_scalar result:", r2.x)
