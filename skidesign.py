"""
ID: roobeel1
LANG:PYTHON3
TASK:skidesign
"""

with open("skidesign.in", "r") as f:
    f.readline()
    hills = [int(i.strip()) for i in f.readlines()]

best = 1e9
for i in range(100):
    total = 0
    for j in range(len(hills)):
        if hills[j] > i + 17:
            total += (hills[j] - (i + 17)) ** 2
        elif hills[j] < i:
            total += (i - hills[j]) ** 2

    if total < best:
        best = total

with open("skidesign.out", "w") as f:
    f.write(str(best) + "\n")
