# ============================================
# Example 21: Case-Sensitive Variables
# a and A are different variables
# ============================================

a = 4
A = "Sally"

print("a =", a)   # 4
print("A =", A)   # Sally
# A will not overwrite a

# Another example
name = "John"
Name = "Jane"
NAME = "Bob"
print(name, Name, NAME)
