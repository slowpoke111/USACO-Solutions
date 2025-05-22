N = int(input())
tuition = sorted(map(int, input().strip().split()))

output = (0, 0)

for i, el in enumerate(tuition[::-1]):
    if el * (i + 1) >= output[0] * output[1]:
        output = (el, i + 1)


print(output[0] * output[1], output[0])
