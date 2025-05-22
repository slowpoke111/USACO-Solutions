N, P = map(int, input().split())
postDistance = [[0 for _ in range(1001)] for _ in range(1001)]
totalLength = 0

for i in range(P + 1):
    if i == P:
        if prevX - firstX != 0:  # type:ignore
            for j in range(prevX, firstX, 1 if prevX < firstX else -1):  # type:ignore
                postDistance[firstY][j] = totalLength
                totalLength += 1
        else:
            for j in range(prevY, firstY, 1 if prevY < firstY else -1):  # type:ignore
                postDistance[j][firstX] = totalLength
                totalLength += 1
    else:
        if i == 0:
            prevX, prevY = map(int, input().split())
            firstX, firstY = prevX, prevY
            continue

        else:
            x, y = map(int, input().split())

        if x - prevX != 0:
            for j in range(prevX, x, 1 if prevX < x else -1):
                postDistance[y][j] = totalLength
                totalLength += 1

        else:
            for j in range(prevY, y, 1 if prevY < y else -1):
                postDistance[j][x] = totalLength
                totalLength += 1

        prevX, prevY = x, y

for i in range(N):
    xStart, yStart, xEnd, yEnd = map(int, input().split())

    distance = abs(postDistance[yStart][xStart] - postDistance[yEnd][xEnd])

    distance = distance if totalLength - distance > distance else totalLength - distance

    print(distance)
