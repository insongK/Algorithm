import sys
from collections import deque

N, M = map(int, sys.stdin.readline().split())
cheese = []
for _ in range(N):
    cheese.append(list(map(int, sys.stdin.readline().split())))


zero_count = 0
one_count = 0

for i in range(N):
    for j in range(M):
        if cheese[i][j] == 1:
            one_count += 1


def BFS(one_count):
    temp = one_count
    visit = [[False] * M for _ in range(N)]
    melting_spot = []
    q = deque()
    q.append((0, 0))
    visit[0][0] = True
    while q:
        x, y = q.popleft()
        for dx, dy in [(-1, 0), (1, 0), (0, -1), (0, 1)]:
            cx = x + dx
            cy = y + dy
            if 0 <= cx < N and 0 <= cy < M:
                if not visit[cx][cy]:
                    if cheese[cx][cy] == 0:
                        q.append((cx, cy))
                        visit[cx][cy] = True
                    else:
                        melting_spot.append((cx, cy))
    for x, y in melting_spot:
        if cheese[x][y] == 1:
            cheese[x][y] = 0
            temp -= 1
    return temp


count = 0
while one_count != 0:
    prev = one_count
    one_count = BFS(one_count)
    count += 1

print(count)
print(prev)
