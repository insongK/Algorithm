import sys
from collections import deque

answer = []


def BFS(x, y):
    q = deque()
    q.append((x, y))
    visit[x][y] = True

    while q:
        x, y = q.popleft()
        for dx, dy in [
            (-1, -1),
            (-1, 0),
            (-1, 1),
            (0, -1),
            (0, 1),
            (1, -1),
            (1, 0),
            (1, 1),
        ]:
            cx = x + dx
            cy = y + dy
            if 0 <= cx < H and 0 <= cy < W:
                if MAP[cx][cy] == 1 and not visit[cx][cy]:
                    q.append((cx, cy))
                    visit[cx][cy] = True


while True:
    W, H = map(int, sys.stdin.readline().split())

    if W == 0 and H == 0:
        break

    MAP = []
    for _ in range(H):
        MAP.append(list(map(int, sys.stdin.readline().split())))

    visit = [[False] * W for _ in range(H)]

    count = 0
    for i in range(H):
        for j in range(W):
            if MAP[i][j] == 1 and not visit[i][j]:
                BFS(i, j)
                count += 1
    answer.append(count)

for ans in answer:
    print(ans)
