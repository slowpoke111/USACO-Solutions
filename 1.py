def factrorial(n):
    if n <= 1:
        return 1

    return n * factrorial(n - 1)


print(factrorial(300))
