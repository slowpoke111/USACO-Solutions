# from template import input

N, L = map(int, input().split())
citatations = sorted(list(map(int, input().split())), reverse=True)


def hIndex(c):
    for i in range(N):
        if c[i] <= i:
            return i
    return N


h = hIndex(citatations)
count = 0
for i in range(len(citatations)):
    if count == L:
        break
    elif citatations[i] == h:
        citatations[i] += 1
        count += 1

print(hIndex(citatations))
