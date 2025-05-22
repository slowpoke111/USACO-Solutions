for i in range(int(input())):
    N = int(input())
    p: list[int] = list(map(int, input().split()))
    output = []

    while p:
        if p[0] > p[N - 1]:
            output.append(p[1])
            p.remove(p[0])

        else:
            output.append(p[N - 2])
            p.remove(p[N - 1])

        N -= 1

print(p)
