from template import input

N,K,T = map(int,input().split())

active = list(map(int,input().split()))
active.append(N)

cows = list(range(N))
cowsK = [-1]*N

cowsO = [-1]*N

for i in range(1,len(active)):
    gap = active[i]-active[i-1]
    counter = gap
    for j in range(active[i-1],active[i]):
        counter-=1
        cowsK[j] = gap
        cowsO[j] = counter

print(cowsO)

def location(gap,i):
    x=T+i
    return (((x//gap)*gap)+i)%N

for i in range(N):
    print(location(cowsK[i],cowsO[i]),end=", ")

