N, P = map(int,input().split())

pasture = [[None for i in range(8)] for i in range(8)]

lastPost = ...
for i in range(P):
    curr:tuple = tuple(map(int, input().split()))


    if lastPost == None:
        pass
    
    else:
        if lastPost[0] == curr[0]:
            for i in range(lastPost[0],curr[0]+1, 1 if lastPost[0]<curr[0]+1 else -1):
                pasture[curr[1]][i] = 1
        else:
            for i in range(lastPost[1],curr[1]+1, 1 if lastPost[0]<curr[0]+1 else -1):
                pasture[i][curr[1]] = 1

    lastPost = curr

for i in range()

