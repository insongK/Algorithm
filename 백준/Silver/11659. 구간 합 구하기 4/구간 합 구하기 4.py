import sys
input = sys.stdin.readline

N, M = map(int, input().split(" "))
nums = list(map(int, input().split(" ")))
s = [0] * (N + 1)
for i,n in enumerate(nums):
    s[i + 1] = s[i] + n

for _ in range(M):
    i,j = map(int, input().split(" "))
    print(s[j] - s[i - 1])