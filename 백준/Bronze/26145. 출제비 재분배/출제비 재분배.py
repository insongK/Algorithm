import sys

input = sys.stdin.readline

N, M = map(int, input().split(" "))

B = list(map(int, input().split(" ")))

for _ in range(M):
    B.append(0)

c = 0

for _ in range(N):
    T = list(map(int, input().split(" ")))
    B[c] -= sum(T)
    c += 1
    for i in range(N + M):
        B[i] += T[i]

for b in B:
    print(b, end=" ")
