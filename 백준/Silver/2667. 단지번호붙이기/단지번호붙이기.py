import sys
from collections import deque

N = int(sys.stdin.readline())

lines = sys.stdin.readlines()
map = [list(map(int, line.strip())) for line in lines]
visit = [[False] * N for _ in range(N)]


def BFS(x, y):
    q = deque()
    q.append((x, y))
    visit[x][y] = True
    count = 0

    while q:
        x, y = q.popleft()
        count += 1
        for dx, dy in [(-1, 0), (1, 0), (0, -1), (0, 1)]:
            cx = x + dx
            cy = y + dy
            if 0 <= cx < N and 0 <= cy < N:
                if map[cx][cy] == 1 and not visit[cx][cy]:
                    q.append((cx, cy))
                    visit[cx][cy] = True
    return count


answer = 0
count = []
for i in range(N):
    for j in range(N):
        if map[i][j] == 1 and not visit[i][j]:
            count.append(BFS(i, j))
            answer += 1

print(answer)
count.sort()
for c in count:
    print(c)
