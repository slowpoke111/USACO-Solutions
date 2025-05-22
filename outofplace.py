with open("outofplace.in", "r") as f:
    f.readline()
    cows = list(map(int, f.readlines()))

cows2 = sorted(cows)

counter = -1

for i, j in zip(cows, cows2):
    print(i, j)
    if i != j:
        counter += 1

with open("outofplace.out", "w") as f:
    f.write(str(counter) + "\n")
