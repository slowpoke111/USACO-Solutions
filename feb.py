input()
S = input()


def g(N, same):
    if same:
        return N + 1

    return N


N = 0
minimum = 0
maximum = 0
y = False

for i in range(1, len(S)):
    if S[i] == S[i - 1] and S[i] != "F":
        minimum += 1
        maximum += 1

if set(S) == {"F"}:
    print(len(S))
    print("\n".join(map(str, range(len(S)))))

else:
    while S and S[0] == "F":
        maximum += 1
        S = S[1:]
        y = True

    while S and S[-1] == "F":
        maximum += 1
        S = S[:-1]
        y = True

    for i, el in enumerate(S):
        if el == "F" and N == 0:
            N = 1
            previous = S[i - 1]
        elif el == "F":
            N += 1
        elif el != "F" and i != 0 and S[i - 1] == "F":
            maximum += g(N, el == previous)
            minimum += g(N, el == previous) % 2
            N = 0

    if y:
        x = list(range(minimum, maximum + 1))

    else:
        x = list(range(minimum, maximum + 1, 2))

    print(len(x))
    print("\n".join([str(i) for i in x]))
