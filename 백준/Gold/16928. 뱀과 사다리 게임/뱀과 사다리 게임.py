import sys
from collections import deque

N, M = map(int, sys.stdin.readline().split())
MAP = [i for i in range(101)]
visit = [False] * 101

for _ in range(N):
    x, y = map(int, sys.stdin.readline().split())
    MAP[x] = y

for _ in range(M):
    u, v = map(int, sys.stdin.readline().split())
    MAP[u] = v

q = deque()
q.append((1, 0))

while q:
    x, count = q.popleft()
    for dx in range(1, 7):
        cx = x + dx
        if cx <= 100:
            if cx == 100:
                print(count + 1)
                exit(0)
            if not visit[MAP[cx]]:
                q.append((MAP[cx], count + 1))
                visit[MAP[cx]] = True
