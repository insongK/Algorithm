# 🤖 AI 분석

## 💡 접근 방식

BFS를 활용해 게임 맵의 시작 위치(0,0)에서 목표 위치(R-1,C-1)까지의 최단 거리를 탐색.

## ⏱️ 시간 복잡도

O(R * C) — 모든 맵의 셀을 최대 한 번 방문하므로 행(R)과 열(C) 수의 곱.

## 📦 공간 복잡도

O(R * C) — 방문 여부를 기록하기 위한 2차원 리스트 사용.

## 🔧 개선 사항

1) 큐에서 pop(0)은 O(N)으로 성능 저하; collections.deque()를 사용하여 O(1)로 개선.
2) 방문 처리 순서를 변경하여 큐에 추가하기 전에 처리하면 불필요한 방문 방지.

## 🎯 다음 추천 문제

프로그래머스 42626번 - 더 맵게 | BFS 기초와 우선순위 큐를 결합한 문제로 난이도 상승.

## 🏷️ 태그

bfs, graph, implementation

## ✨ 모범 답안

```python
from collections import deque

def solution(maps):
    R = len(maps)
    C = len(maps[0])
    visit = [[False] * C for _ in range(R)]
    d = [(-1, 0), (0, 1), (1, 0), (0 , -1)]
    queue = deque([(0, 0, 1)])
    visit[0][0] = True

    while queue:
        r, c, count = queue.popleft()
        if r == R - 1 and c == C - 1:
            return count

        for dr, dc in d:
            nr = r + dr
            nc = c + dc
            if 0 <= nr < R < C and maps[nr][nc] == 1 and not visit[nr][nc]:
                visit[nr][nc] = True  
                queue.append((nr, nc, count + 1))

    return -1
```
