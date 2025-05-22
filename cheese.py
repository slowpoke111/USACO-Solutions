from typing import List
from template import input


def void2d(grid):
    count = 0
    for row in grid:
        if row == [False] * len(row):
            count += 1
    for col in zip(*grid):
        if col == (False,) * len(col):
            count += 1
    return count


def vertical(grid):
    final = [True] * len(grid[0][0])
    for plane in grid:
        for i in range(len(plane)):
            for j in range(len(plane[i])):
                final[j] = final[j] and plane[i][j]
    return final.count(True)


N, Q = map(int, input().split())

grid = [[[True] * N for i in range(N)] for j in range(N)]


def main():
    for i in range(Q):
        count = 0
        x, y, z = map(int, input().split())
        grid[z][y][x] = not grid[z][y][x]

        for plane in grid:
            count += void2d(plane)

        count += vertical(grid)

        print(count)
