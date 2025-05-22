cows = []

with open("cowtip.in", "r") as f:
    n = int(f.readline())
    for i in range(n):
        cows.append(list(f.readline().strip()))


def flip(x, y):
    for i in range(x + 1):
        for j in range(y + 1):
            if cows[i][j] == "1":
                cows[i][j] = "0"
            else:
                cows[i][j] = "1"
    print(cows)


x = 0

for i in range(n - 1, -1, -1):
    for j in range(n - 1, -1, -1):
        print(i, j)
        if cows[i][j] == "1":
            flip(i, j)
            x += 1

with open("cowtip.out", "w") as f:
    f.write(str(x) + "\n")
