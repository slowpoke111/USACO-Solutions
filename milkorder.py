#from template import input
from copy import copy
from typing import Dict
f = open("milkorder.in","r")
def input():
    return f.readline()

N, M, K = map(int,input().split())

hiearchy = list(map(int,input().split()))

position:Dict[int,int] = {}

for i in range(K):
    x,y = map(int,input().split())

    position[x] = y

order = [None for i in range(N)]

for i in position:
    order[position[i]-1] = i

def validate(order):
    x=0
    y=0
    while True:
        if order[x]==hiearchy[y]:
            y+=1
        x+=1
        if y==len(hiearchy):
            return True
        elif x==len(order):
            return False

for i in range(N):
    orderCopy = copy(order)
    if order[i]!=None:
        continue
    
    orderCopy[i] = 1        

    x=0
    newJ=0
    for j in range(N):
        if x==len(hiearchy):
            break
        if hiearchy[x] in orderCopy:
            x+=1
            continue
        if orderCopy[j]==hiearchy[x]:
            x+=1
            continue
        if j<newJ:
            if orderCopy[j]==hiearchy[x]:
                x+=1
            continue
        if orderCopy[j]!=None:
            continue

        if hiearchy[x] in position:
            newJ = orderCopy.index(hiearchy[x])
            if newJ<j:
                break
        else:
            orderCopy[j]=hiearchy[x]

        x+=1
    print(orderCopy)
    if not validate(orderCopy):
        continue
        
    if hiearchy[-1] in orderCopy:
        f1 = open("milkorder.out","w")
        print(i+1,file=f1)
        f1.close()
        break

f.close()