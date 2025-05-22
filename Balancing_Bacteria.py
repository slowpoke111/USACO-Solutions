# import sys
# sys.setrecursionlimit(2**31-1)

length = int(input())


def solve(data, curr=0):
    print(curr)
    if data == data[::-1] and len(data) > 1:
        return curr

    for i in range(1, length):
        newData = [x + 1 for x in data[0:i]]
        return solve(newData, curr + 1)
        newData = [x - 1 for x in data[0:i]]
        return solve(newData, curr + 1)


data = input().split()

for i in range(len(data)):
    data[i] = int(data[i])

print(solve(data))
