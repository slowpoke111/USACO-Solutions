"""
ID:roobeel1
TASK:transform
LANG:PYTHON3
"""

import copy

square = []
correct = []

with open("transform.in", "r") as f:
    n = int(f.readline())
    for i in range(n):
        square.append(list(f.readline().strip()))

    for i in range(n):
        correct.append(list(f.readline().strip()))


def rotate90(square):
    squareCopy = copy.deepcopy(square)
    for i in range(len(square)):
        for j in range(len(square[i])):
            squareCopy[j][len(square[0]) - i - 1] = square[i][j]
    return squareCopy


def rotate180(square):
    return rotate90(rotate90(square))


def rotate270(square):
    return rotate90(rotate90(rotate90(square)))


def reflection(square):
    return [square[i][::-1] for i in range(len(square))]


with open("transform.out", "w") as f:
    if rotate90(square) == correct:
        f.write("1")
    elif rotate180(square) == correct:
        f.write("2")
    elif rotate270(square) == correct:
        f.write("3")
    elif reflection(square) == correct:
        f.write("4")
    elif (
        rotate90(reflection(square)) == correct
        or rotate180(reflection(square)) == correct
        or rotate270(reflection(square)) == correct
    ):
        f.write("5")
    elif square == correct:
        f.write("6")
    else:
        f.write("7")
    f.write("\n")
