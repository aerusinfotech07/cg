# SciPy Significance Tests
from scipy import stats

group1 = [1, 2, 3, 4, 5]
group2 = [2, 3, 4, 5, 6]
t_stat, p_value = stats.ttest_ind(group1, group2)
print("t-test (independent): t=", t_stat, "p=", p_value)

observed = [10, 20, 30]
expected = [20, 20, 20]
chi2, p_val = stats.chisquare(observed, expected)
print("Chi-square: chi2=", chi2, "p=", p_val)
