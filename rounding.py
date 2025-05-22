from template import input
import math


def bessieRound(N, b):
    x = str(N)[b - 1]
    if int(x) >= 5:
        return round(N, -b) + 10**b
    else:
        return round(N, -b)

def chainRound(x, b):
    for i in range(1, b + 1):
        x = round(x + 1, -i)
    return x


def findP(x):
    return math.ceil(math.log10(x))


def main():
    T = int(input())

    for i in range(T):
        N = int(input())
        count = 0
        for j in range(2, N + 1):
            if bessieRound(j, findP(j)) != chainRound(j, findP(j)):
                count += 1
        print(count)


for i in range(140, 160):
    print(i, chainRound(i, findP(i)), bessieRound(i, findP(i)), findP(i))
