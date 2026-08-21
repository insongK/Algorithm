# 🤖 AI 분석

## 💡 접근 방식

BFS를 이용하여 미로에서 'S'에서 'L'까지, 그리고 'L'에서 'E'까지 최단 경로를 계산하여 총 거리 리턴.

## ⏱️ 시간 복잡도

O(W * H) — 각 BFS 호출에서 모든 노드(W * H)를 탐색하므로, 두 번 호출 시 O(2 * W * H)로 여기에 대해 비례 생략 가능.

## 📦 공간 복잡도

O(W * H) — BFS 큐와 방문 체크 2D 배열을 사용하므로, 공간 필요량이 입력 크기에 비례.

## 🔧 개선 사항

1) 리스트로 방문 정보를 관리하는 대신 set()을 사용하는 방법: set()은 중복 체크 및 조회가 빠르므로 성능 향상.  
2) q.pop(0) 대신 deque 사용: O(1) 시간 복잡도 지원.  
3) 사용자 변수명 및 코드 가독성 개선: 특정 방향을 의미하는 초깃값을 명확하게 하기 위해 보조 배열(directions)을 도입.  

기존의 BFS 전용 구조에 적합하게 변경.

## 🎯 다음 추천 문제

프로그래머스 43162번 - 네트워크 | BFS를 통한 연결 요소 탐색 문제로 이어지는 연습 단계.

## 🏷️ 태그

bfs, graph

## ✨ 모범 답안

```python
from collections import deque

def bfs(W, H, maps, start, end):
    q = deque([(start[0], start[1], 0)])  # 시작 위치와 거리 초기화
    visit = set()
    visit.add((start[0], start[1]))
    dr = [-1, 0, 1, 0]
    dc = [0, 1, 0, -1]

    while q:
        r, c, dist = q.popleft()
        if maps[r][c] == end:
            return dist
        for d in range(4):
            nr, nc = r + dr[d], c + dc[d]
            if 0 <= nr < W and 0 <= nc < H and (nr, nc) not in visit and maps[nr][nc] != "X":
                q.append((nr, nc, dist + 1))
                visit.add((nr, nc))
    return -1


def solution(maps):
    answer = 0
    start_S = [0, 0]
    start_L = [0, 0]
    for i, map in enumerate(maps):
        if 'S' in map:
            start_S = [i, map.index('S')]
        if 'L' in map:
            start_L = [i, map.index('L')]
    
    score = bfs(len(maps), len(maps[0]), maps, start_S, 'L')
    if score < 0:
        return -1
    answer += score
    score = bfs(len(maps), len(maps[0]), maps, start_L, 'E')
    if score < 0:
        return -1
    answer += score
    return answer
```
