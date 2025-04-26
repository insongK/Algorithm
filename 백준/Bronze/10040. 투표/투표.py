import sys

input = sys.stdin.readline

N, M = map(int, input().split())

game = []
for _ in range(N):
    game.append(int(input()))

answer = [0] * N

for _ in range(M):
    stand = int(input())
    for i in range(N):
        if game[i] <= stand:
            answer[i] += 1
            break

max_index = 0
for i in range(N):
    if answer[i] > answer[max_index]:
        max_index = i

print(max_index + 1)
