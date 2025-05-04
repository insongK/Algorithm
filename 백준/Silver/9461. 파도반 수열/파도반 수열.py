import sys

T = int(sys.stdin.readline())
num = [int(sys.stdin.readline()) for _ in range(T)]

for n in num:
    DP = [1, 1, 1, 2, 2]
    if 1 <= n <= 5:
        print(DP[n - 1])
        continue

    for i in range(5, n):
        DP.append(DP[i - 1] + DP[i - 5])
    print(DP[n - 1])
