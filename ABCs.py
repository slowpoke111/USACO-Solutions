numbers = [int(x) for x in input().strip().split()]

A = min(numbers)
numbers.remove(A)
B = min(numbers)
numbers.remove(B)

C = max(numbers) - A - B

print(f"{A} {B} {C}")
