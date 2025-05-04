import sys

T = int(sys.stdin.readline())
case = [int(sys.stdin.readline()) for _ in range(T)]

for num in case:
    DP = [1, 2, 4]
    for i in range(3, num):
        DP.append(DP[i - 1] + DP[i - 2] + DP[i - 3])
    print(DP[num - 1])
