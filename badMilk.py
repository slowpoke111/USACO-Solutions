x = {}
sick = {}

with open("badmilk.in", "r") as f:
    n, m, d, s = [int(i) for i in f.readline().split()]
    for i in range(d):
        curr = [int(i) for i in f.readline().split()]
        if curr[0] not in x:
            x[curr[0]] = {}
        if curr[1] in x[curr[0]] and x[curr[0]][curr[1]] > curr[2]:
            x[curr[0]][curr[1]] = curr[2]
        else:
            x[curr[0]][curr[1]] = curr[2]

    for i in range(s):
        curr = f.readline().split()
        sick[int(curr[0])] = int(curr[1])


def isBad(m):
    for j in range(1, n + 1):
        for milk, time in x[j].items():
            if m == milk:
                if j in sick and time > sick[j]:
                    return False

    for i in sick:
        if m not in x[i]:
            return False

    return True


milks = set(range(1, m + 1))

for i in range(1, m + 1):
    if not isBad(i):
        milks.remove(i)

c = 0
for milk in milks:
    z = set()
    for i in range(1, n + 1):
        if milk in x[i]:
            z.add(i)
    c = max(c, len(z))

with open("badmilk.out", "w") as f:
    f.write(str(c) + "\n")
