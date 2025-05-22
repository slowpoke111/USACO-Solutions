from template import input

count = {}


def updateMoo(s):
    def check(s):
        if len(s) != 3:
            return False
        if s[0] != s[1] and s[1] == s[2]:
            return True
        return False

    for i in range(3):
        for c in range(26):
            if chr(c + 97) != s[i]:
                if check(s[:i] + chr(c + 97) + s[i + 1 :]):
                    if s[:i] + chr(c + 97) + s[i + 1 :] in count:
                        count[s[:i] + chr(c + 97) + s[i + 1 :]] += 1
                    else:
                        count[s[:i] + chr(c + 97) + s[i + 1 :]] = 1


N, F = map(int, input().split())
s = input()
i = 0
for _i in range(N - 2):
    if s[i : i + 3] in count:
        i += 2
        continue
    if i + 3 >= N:
        break
    updateMoo(s[i : i + 3])


print(count)
