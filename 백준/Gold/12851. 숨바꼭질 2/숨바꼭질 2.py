import sys
from collections import deque

input = sys.stdin.readline
MAX = 100001

N, K = map(int, input().split())
dist = [-1] * MAX

q = deque()
q.append(N)
dist[N] = 0

total_count = 0
low_cost = 0

while q:
    x = q.popleft()

    if x == K:
        low_cost = dist[x]
        total_count += 1
        continue

    for dx in [-1, 1, x]:
        nx = x + dx
        if 0 <= nx < MAX:
            if dist[nx] == -1 or dist[nx] == dist[x] + 1:
                dist[nx] = dist[x] + 1
                q.append(nx)

print(low_cost)
print(total_count)
