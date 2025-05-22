#from template import input

M, N = map(int, input().split())

cowHeight = list(map(int, input().split()))

candyCane = list(map(int, input().split()))

for i in candyCane:
    bottom = 0
    for i2,j in enumerate(cowHeight):
        if bottom >= i:
            break
        if j>bottom:
            cowHeight[i2]+=min(j-bottom,i-bottom)
            bottom=j
        
print("\n".join(map(str,cowHeight)))