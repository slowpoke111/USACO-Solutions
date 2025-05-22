with open("cbarn.in", "r") as f:
    n = int(f.readline())
    x = []
    for i in range(n):
        x.append(int(f.readline()))

bestDistance = 10e10

for i in range(n):
    distance = 0
    numCows = sum(x)
    x2 = x[i:] + x[:i]
    for j in x2:
        numCows -= j
        distance += numCows

    if distance < bestDistance:
        bestDistance = distance

print(bestDistance)

with open("cbarn.out", "w") as f:
    f.write(str(bestDistance))
