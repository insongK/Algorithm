import sys

input = sys.stdin.readline

N, M = map(int, input().split(" "))
nums = []
for i in range(N):
    temp = list(map(int, input().split(" ")))
    nums.append(temp)

s = [[0] * (N + 1) for _ in range(N + 1)]
for i, num in enumerate(nums):
    for j, n in enumerate(num):
        s[i + 1][j + 1] = s[i][j + 1] + s[i + 1][j] - s[i][j] + n

for _ in range(M):
    x1, y1, x2, y2 = map(int, input().split(" "))
    print(s[x2][y2] - s[x1 - 1][y2] - s[x2][y1 - 1] + s[x1 - 1][y1 - 1])
