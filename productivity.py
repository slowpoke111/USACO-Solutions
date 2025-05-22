from bisect import bisect_right

# f = open("test.in")
# def input():
#    return f.readline()

N, Q = map(int, input().split())
c = input().split()
t = input().split()

x = sorted([int(c[i]) - int(t[i]) for i in range(len(c))])

for i in range(Q):
    V, S = map(int, input().split())
    print("YES" if len(x) - bisect_right(x, S) >= V else "NO")

# f.close()
