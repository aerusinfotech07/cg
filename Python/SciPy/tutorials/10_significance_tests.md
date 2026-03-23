# SciPy Significance Tests

## t-test (Independent Samples)

```python
from scipy import stats

group1 = [1, 2, 3, 4, 5]
group2 = [2, 3, 4, 5, 6]
t_stat, p_value = stats.ttest_ind(group1, group2)
print("t-statistic:", t_stat, "p-value:", p_value)
```

## t-test (Paired)

```python
before = [1, 2, 3, 4, 5]
after = [2, 3, 4, 5, 6]
t_stat, p_value = stats.ttest_rel(before, after)
```

## One-Sample t-test

```python
data = [1, 2, 3, 4, 5]
t_stat, p_value = stats.ttest_1samp(data, popmean=3)
```

## Mann-Whitney U (Non-parametric)

```python
u_stat, p_value = stats.mannwhitneyu(group1, group2)
```

## Chi-Square

```python
observed = [10, 20, 30]
expected = [20, 20, 20]
chi2, p_value = stats.chisquare(observed, expected)
```

## Kolmogorov-Smirnov

```python
stat, p_value = stats.ks_2samp(group1, group2)
```

## Interpretation

- **p < 0.05** – Often considered statistically significant
- **p >= 0.05** – Fail to reject null hypothesis

## Next Steps

- Return to [TUTORIAL_INDEX](../TUTORIAL_INDEX.md)
