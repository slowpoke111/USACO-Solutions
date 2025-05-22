with open("lostcow.in", "r") as f:
    x, y = f.readline().split()
    x, y = int(x), int(y)

distance = 1
num = 1
y2 = y - x

if not y2:
    distance = 0
else:
    while True:
        if abs(num) >= abs(y2) and ((y2 > 0 and num > 0) or (y2 < 0 and num < 0)):
            distance -= abs(y2 - num)
            break

        num *= -2
        distance += abs(num * 1.5)

with open("lostcow.out", "w") as f:
    f.write(str(int(distance)) + "\n")
