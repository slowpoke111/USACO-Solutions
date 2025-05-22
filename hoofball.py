with open("hoofball.in", "r") as f:
    N = int(f.readline())
    cows = list(map(int, f.readline().split()))

cows.sort()

passTo = {0: 1}
for i in range(1, N - 1):
    distance = cows[i + 1] - cows[i]
    distance2 = cows[i] - cows[i - 1]

    if distance >= distance2:
        passTo[i] = i - 1
    else:
        passTo[i] = i + 1

passTo[N - 1] = N - 2

x = []
output = []

for i in passTo.keys():
    x.append([k for k, v in passTo.items() if v == i])

for i in range(len(x)):
    if x[i] == [i - 1] and x[i - 1] == [i]:
        output.append(i)

    elif x[i] == []:
        output.append(i)

with open("hoofball.out", "w") as f:
    f.write(str(len(output)))
