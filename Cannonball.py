length, curr = input().split()
line = []

curr = int(curr)

for i in range(int(length)):
    x = input()
    line.append([int(x.split()[0]), int(x.split()[1])])
numTargets = 0
velocity = 1
direction = 1

if line[curr - 1][0] == 1:
    line[curr - 1][1] = 0
    numTargets += 1
    curr += velocity

try:
    while True:
        if curr < 0 or curr >= len(line):
            raise IndexError

        pos = line[curr - 1]

        if pos[0] == 0:
            direction *= -1
            velocity += pos[1]
            curr += pos[1]

        else:
            if velocity > pos[1] and pos[1] != 0:
                numTargets += 1
                pos[1] = 0

        curr += direction * velocity
except:
    print(numTargets)
