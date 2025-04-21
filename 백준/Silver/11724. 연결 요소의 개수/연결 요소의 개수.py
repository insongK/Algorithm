import sys
from collections import deque

input = sys.stdin.readline
N, M = map(int, input().strip().split())

graph = [[] for _ in range(N)]
visit = [False] * N

for _ in range(M):
    src, dst = map(int, input().strip().split())
    graph[src - 1].append(dst - 1)
    graph[dst - 1].append(src - 1)

def BFS(start):
    q = deque()
    q.append(start)
    visit[start] = True
    while q:
        cur = q.popleft()
        for neighbor in graph[cur]:
            if not visit[neighbor]:
                visit[neighbor] = True
                q.append(neighbor)

answer = 0
for i in range(N):
    if not visit[i]:
        BFS(i)
        answer += 1

print(answer)
