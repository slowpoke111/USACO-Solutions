N, Q = input().split()
statement = input().replace("true", "True")
statement = statement.replace("false", "False")
statement = statement.split()

# print(statement)

output = ""

for i in range(int(Q)):
    start, end, value = input().split()
    start, end = int(start), int(end)

    if end - start == len(statement) - 1:
        output += "Y"
        continue

    newStatement = statement
    newStatement[start - 1] = value.strip().capitalize()

    x = 0
    for i in range(start, end + 2):
        # print(i,x)
        try:
            _ = newStatement.pop(i - x)
            x += 1
            # print(newStatement)
        except:
            pass

    if end == len(statement):
        newStatement[-1] = value
    newStatement = str([k + " " for k in newStatement]).strip()

    if eval(str(newStatement).strip()) == value.capitalize():
        output += "Y"
    else:
        output += "N"

print(output)
