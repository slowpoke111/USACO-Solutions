from math import floor, ceil, inf


def solve(height, growthRate, shorterThan, i, j):
    heightDifference = height[i] - height[j]
    growthRateDifference = growthRate[i] - growthRate[j]

    # print(heightDifference, growthRateDifference, shorterThan)

    if growthRateDifference == 0:
        if (height[i] < height[j] and shorterThan[i] > shorterThan[j]) or (
            height[i] > height[j] and shorterThan[i] < shorterThan[j]
        ):
            return 0
        else:
            # print("C")
            return -1

    elif heightDifference == 0:
        if (growthRateDifference < 0 and shorterThan[i] < shorterThan[j]) or (
            growthRateDifference > 0 and shorterThan[i] > shorterThan[j]
        ):
            return -1
        else:
            return 1, inf

    elif (
        heightDifference > 0
        and growthRateDifference > 0
        and shorterThan[i] > shorterThan[j]
    ) or (
        heightDifference < 0
        and growthRateDifference < 0
        and shorterThan[i] < shorterThan[j]
    ):
        # print(heightDifference, growthRateDifference, shorterThan)
        return -1
    elif (
        heightDifference > 0
        and growthRateDifference > 0
        and shorterThan[i] < shorterThan[j]
    ) or (
        heightDifference < 0
        and growthRateDifference < 0
        and shorterThan[i] > shorterThan[j]
    ):
        return 0
    else:
        # print("B")
        x = abs(heightDifference / growthRateDifference)

        if x == int(x):
            if (
                shorterThan[i] < shorterThan[j]
                and height[i] > height[j]
                or shorterThan[i] > shorterThan[j]
                and height[i] < height[j]
            ):
                return 0, int(x - 1)
            else:
                return int(x + 1), inf

        else:
            if (
                shorterThan[i] < shorterThan[j]
                and height[i] > height[j]
                or shorterThan[i] > shorterThan[j]
                and height[i] < height[j]
            ):
                return 0, int(floor(x))

            else:
                return int(ceil(x)), inf


def case():
    N = int(input())
    height = list(map(int, input().split()))
    growthRate = list(map(int, input().split()))
    shorterThan = list(map(int, input().split()))

    shorterThanInverse = [-1 for _ in range(N)]

    for i in range(N):
        shorterThanInverse[shorterThan[i]] = i

    if N == 1:
        print(0)
        return

    min = 0
    max = inf

    for i in range(N - 1):
        x = solve(
            height,
            growthRate,
            shorterThan,
            shorterThanInverse[i],
            shorterThanInverse[i + 1],
        )

        if x == 0:
            continue

        elif x == -1:
            print(-1)
            return

        _min, _max = x

        # print(" "*15 + str(min))

        if _min > min:
            min = _min
        if _max < max:
            max = _max
        if _max < min or _min > max:
            # print(_max, max, _min, min, i, j)
            print(-1)  #
            return

    print(str(min))


for t in range(int(input())):
    case()
