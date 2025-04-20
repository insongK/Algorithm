import sys
from collections import deque

input = sys.stdin.readline
answer = []

T = int(input())

# M = 가로 길이, N = 세로 길이, K = 배추 수
for _ in range(T):
    M, N, K = map(int, input().split())
    farms = [[False] * M for _ in range(N)]
    visit = [[False] * M for _ in range(N)]

    for _ in range(K):
        y, x = map(int, input().split())
        farms[x][y] = True

    def BFS(x, y):
        q = deque()
        q.append((x, y))
        visit[x][y] = True

        while q:
            x, y = q.popleft()
            for dx, dy in [(-1, 0), (1, 0), (0, -1), (0, 1)]:
                cx = x + dx
                cy = y + dy
                if 0 <= cx < N and 0 <= cy < M:
                    if farms[cx][cy] and not visit[cx][cy]:
                        q.append((cx, cy))
                        visit[cx][cy] = True

    count = 0
    for i in range(N):
        for j in range(M):
            if farms[i][j] and not visit[i][j]:
                BFS(i, j)
                count += 1
    answer.append(count)

for ans in answer:
    print(ans)
