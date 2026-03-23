# Pandas Plotting (requires matplotlib: pip install matplotlib)
import pandas as pd

df = pd.DataFrame({"x": [1, 2, 3, 4, 5], "y": [2, 4, 6, 8, 10]})
try:
    ax = df.plot(title="Simple Line Plot")
    ax.figure.savefig("pandas_plot.png")
    print("Plot saved to pandas_plot.png")
except Exception as e:
    print("Plotting requires matplotlib. Install with: pip install matplotlib")
    print("Error:", e)
