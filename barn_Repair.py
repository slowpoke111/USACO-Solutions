"""
ID:roobeel1
TASK:barn1
LANG:PYTHON3
"""

with open("barn1.in", "r") as f:
    M, _S, _C = f.readline().split()
    lines = [int(x) for x in f.readlines()]

lines.sort()

distances = []
for i in range(1, len(lines)):
    distances.append(lines[i] - lines[i - 1] - 1)

gaps = []
for i in range(int(M) - 1):
    x = max(distances)
    distances.remove(x)
    gaps.append(x)

with open("barn1.out", "w") as f:
    f.write(str(lines[-1] - lines[0] - (sum(gaps) - 1)) + "\n")
