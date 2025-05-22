with open("billboard.in", "r") as f:
    billBoard1 = list(map(int, f.readline().split()))
    billBoard2 = list(map(int, f.readline().split()))
    truck = list(map(int, f.readline().split()))

amountCovered = 0

truckCoordinates = set()
billBoard1Coordinates = set()
billBoard2Coordinates = set()

for i in range(truck[0], truck[2]):
    for j in range(truck[1], truck[3]):
        truckCoordinates.add((i, j))

for i in range(billBoard1[0], billBoard1[2]):
    for j in range(billBoard1[1], billBoard1[3]):
        billBoard1Coordinates.add((i, j))

amountCovered += len(billBoard1Coordinates.intersection(truckCoordinates))

for i in range(billBoard2[0], billBoard2[2]):
    for j in range(billBoard2[1], billBoard2[3]):
        billBoard2Coordinates.add((i, j))

amountCovered += len(billBoard2Coordinates.intersection(truckCoordinates))

area = (billBoard1[2] - billBoard1[0]) * (billBoard1[3] - billBoard1[1])
area += (billBoard2[2] - billBoard2[0]) * (billBoard2[3] - billBoard2[1])

with open("billboard.out", "w") as f:
    f.write(str(area - amountCovered) + "\n")
