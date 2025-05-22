# f = open("test.in",'r')
# def input():
#    return f.readline().strip()

for i in range(int(input())):
    N, K = map(int, input().split())
    cows = input()

    dividerG = -1
    dividerH = -1
    output = ["." for _ in range(N)]

    for i, breed in enumerate(cows):

        if breed == "G" and i <= dividerG:
            continue
        elif breed == "H" and i <= dividerH:
            continue
        # print(dividerG,dividerH,i)
        position = i + K

        position = position if position < N else N - 1
        position = position if output[position] == "." else position - 1

        output[position] = breed

        if breed == "H":
            dividerH = position + K
        else:
            dividerG = position + K

    print(output.count("G") + output.count("H"))
    print("".join(output))
# f.close()
