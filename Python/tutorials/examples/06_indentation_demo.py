# ============================================
# Example 6: Indentation Defines Scope
# Python uses indentation instead of curly braces
# ============================================

x = 10

if x > 0:
    print("Positive number")    # This is inside the if block
    print("Still inside if")    # Same indentation = same block
print("Outside if")             # Less indentation = outside the block

# Try changing x to a negative number and run again!
# x = -5
