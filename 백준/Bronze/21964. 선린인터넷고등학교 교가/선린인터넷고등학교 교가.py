import sys

input = sys.stdin.readline

N = int(input())
S = list(input().strip())

for i in range(N - 5, N):
    print(S[i], end="")
