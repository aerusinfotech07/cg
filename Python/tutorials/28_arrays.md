# Python Arrays (array module)

## Table of Contents
1. [What is the array Module?](#1-what-is-the-array-module)
2. [Creating Arrays](#2-creating-arrays)
3. [Type Codes](#3-type-codes)
4. [Array Operations](#4-array-operations)
5. [array vs list](#5-array-vs-list)
6. [When to Use](#6-when-to-use)

---

## 1. What is the array Module?

The `array` module provides a space-efficient array of homogenous numeric types. Unlike lists, all elements must be the same type.

```python
import array

arr = array.array('i', [1, 2, 3, 4, 5])
print(arr)
```

**Output:**
```
array('i', [1, 2, 3, 4, 5])
```

---

## 2. Creating Arrays

```python
import array

# array(typecode, initializer)
arr = array.array('i', [1, 2, 3])
arr2 = array.array('i')  # Empty
arr3 = array.array('d', [1.0, 2.0, 3.0])
```

---

## 3. Type Codes

| Code | Type | Bytes |
|------|------|-------|
| `'b'` | signed char | 1 |
| `'B'` | unsigned char | 1 |
| `'i'` | signed int | 2 |
| `'I'` | unsigned int | 2 |
| `'l'` | signed long | 4 |
| `'f'` | float | 4 |
| `'d'` | double | 8 |

---

## 4. Array Operations

```python
import array

arr = array.array('i', [1, 2, 3])

# Append
arr.append(4)

# Extend
arr.extend([5, 6])

# Index

arr[0]  # 1
arr[-1]  # 6

# Slice
arr[1:4]

# Remove
arr.remove(3)

# Pop
arr.pop()
```

---

## 5. array vs list

| Feature | array | list |
|---------|-------|------|
| Type | Homogeneous | Any |
| Memory | More efficient | Less efficient |
| Flexibility | Numeric only | Any type |

---

## 6. When to Use

- Large numeric datasets
- Interfacing with C libraries
- Memory-critical applications

For most cases, use lists or NumPy for numerical work.

---

## Quick Reference

```python
import array
arr = array.array('i', [1, 2, 3])
arr.append(4)
arr.extend([5, 6])
```

---

## Next Steps

- Proceed to **Iterators** tutorial
