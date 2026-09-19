# 🤖 AI 분석

## 💡 접근 방식

주어진 직사각형을 2배 확대하여 경로를 탐색하는 BFS 알고리즘 사용. 출발점에서 목표 아이템까지 최단 경로를 찾음.

## ⏱️ 시간 복잡도

O(N*M) — BFS로 전체 맵을 탐색. 직사각형 면적은 최대 50x50(실제 102x102)에서 최악의 경우 모든 셀을 방문.

## 📦 공간 복잡도

O(N*M) — 방문 여부와 맵을 저장하는 배열 사용, 크기는 직사각형의 배수에 비례.

## 🔧 개선 사항

1) is_surface() 호출을 줄이기 위해 직사각형을 마킹할 때 동시에 경계 체크: maps[y][x] == 1이거나 maps[ny][nx] == 0일 때 탐색하기.
2) 방문 배열을 0/1 대신 -1/0으로 바꿔 더 명확하게 방문 상태를 정리.
3) counts를 분리할 필요 없이 두 배수 확대된 영역을 하나의 BFS로 직접 처리할 수 있도록 경로 길이 계산 회피.

## 🎯 다음 추천 문제

프로그래머스 60063번 - 블록 이동하기 | 유사한 BFS 탐색 문제로 경로 문제를 다룸. 직사각형을 다루기 때문에 연습에 적합.

## 🏷️ 태그

bfs, implementation

## ✨ 모범 답안

```python
from collections import deque

def solution(rectangle, characterX, characterY, itemX, itemY):
    size = 102
    maps = [[0] * size for _ in range(size)]
    visit = [[-1] * size for _ in range(size)]

    for sx, sy, ex, ey in rectangle:
        for y in range(sy * 2, ey * 2 + 1):
            for x in range(sx * 2, ex * 2 + 1):
                maps[y][x] = 1

    cx, cy = characterX * 2, characterY * 2
    ix, iy = itemX * 2, itemY * 2
    queue = deque([(cx, cy)])
    visit[cy][cx] = 0

    directions = [(-1, 0), (0, 1), (1, 0), (0, -1)]

    while queue:
        x, y = queue.popleft()
        count = visit[y][x]

        if x == ix and y == iy:
            return count // 2

        for dx, dy in directions:
            nx, ny = x + dx, y + dy
            if 0 <= nx < size and 0 <= ny < size and maps[ny][nx] == 1 and visit[ny][nx] == -1:
                visit[ny][nx] = count + 1
                queue.append((nx, ny))
```
