with open("lifeguards.in", "r") as f:
    N = int(f.readline())
    cows = []
    for i in range(N):
        cows.append(list(map(int, f.readline().split())))

time = [0 for i in range(1001)]

for i, j in cows:
    for k in range(i, j):
        time[k] += 1

min1 = 2e10
for i, j in cows:
    min1 = min(min1, time[i:j].count(1))

with open("lifeguards.out", "w") as f:
    f.write(str(len(time) - time.count(0) - min1) + "\n")
