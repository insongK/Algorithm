import sys

input = sys.stdin.readline

N = int(input())
d = list(map(int, input().split()))
DP = [[0] for _ in range(N)]

DP[0] = d[0]

for i in range(1, N):
    DP[i] = max(DP[i - 1] + d[i], d[i])

print(max(DP))
