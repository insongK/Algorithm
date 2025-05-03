import sys

N, K = map(int, sys.stdin.readline().split())
coin = [int(sys.stdin.readline()) for _ in range(N)]

count = 0
for i in range(N - 1, -1, -1):
    c = coin[i]
    if K // c >= 1:
        count += K // c
        K %= c
    if K == 0:
        break

print(count)
