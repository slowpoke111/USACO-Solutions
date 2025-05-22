"""
PROB: ride
USER: roobeel1
LANG: PYTHON3
"""

with open("ride.in", "r") as f:
    comet = f.readline()
    group = f.readline()

cometNum = 1
for i in comet:
    cometNum *= ord(i) - 64

groupNum = 1
for i in group:
    groupNum *= ord(i) - 64

with open("ride.out", "w") as f:
    if groupNum % 47 == cometNum % 47:
        f.write("GO\n")
    else:
        f.write("STAY\n")
