import sys
input = sys.stdin.readline

N = int(input())
DP = [[0 if i == j else float('inf') for j in range(N)] for i in range(N)]
d = []

for i in range(N):
    r, c = map(int, input().split())
    if i == 0:
        d.append(r)
    d.append(c)

for length in range(1, N):
    for i in range(N - length):
        j = i + length
        for k in range(i, j):
            cost = DP[i][k] + DP[k + 1][j] + d[i] * d[k + 1] * d[j + 1]
            if DP[i][j] > cost:
                DP[i][j] = cost

print(DP[0][N - 1])