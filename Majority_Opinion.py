def solve(hay):
    values = []
    if len(hay) % 2 == 0:
        return [-1]
    for i in range(len(hay) + 1):
        for j in range(len(hay) + 1):
            if i != j:
                curr = hay[i:j]
                if len(curr) > 1:
                    most = 1
                    for k in curr:
                        if curr.count(k) > most:
                            most = curr.count(k)
                            index = k
                try:
                    values.append(index)
                except:
                    pass

    if len(values) < 1:
        return [-1]

    values = list(set(values))

    return values


T = int(input())

for i in range(T):
    input()
    data = [int(x) for x in input().split()]
    solution = solve(data)
    for i in solution[:1]:
        print(i, end="")
    if len(solution) > 1:
        try:
            print(i[-1])
        except:
            pass
    print()
