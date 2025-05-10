import sys

input = sys.stdin.readline

N = int(input())
W = [list(map(int, input().split())) for _ in range(N)]
DP = [0] * (N + 1)

for i in range(N):
    T, P = W[i]

    DP[i + 1] = max(DP[i + 1], DP[i])

    if i + T <= N:
        DP[i + T] = max(DP[i + T], DP[i] + P)

print(DP[N])
