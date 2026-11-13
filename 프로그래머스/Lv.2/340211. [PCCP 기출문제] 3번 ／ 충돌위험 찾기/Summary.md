# 🤖 AI 분석

## 💡 접근 방식

주어진 경로를 기반으로 두 점 사이의 최단 이동 경로 탐색. BFS를 이용해 경로를 탐색하면서 충돌을 체크.

## ⏱️ 시간 복잡도

O(N * M) — N: 경로 수, M: 각 경로의 길이. BFS로 모든 경로를 시뮬레이션하므로 경로의 길이에 비례.

## 📦 공간 복잡도

O(N) — BFS 큐와 방문 체크를 위한 배열 사용. 최악의 경우 각 경로마다 별도의 위치가 필요할 수 있음.

## 🔧 개선 사항

1) 매 반복마다 grid를 새로 생성하는 대신, 하나의 grid를 사용하고 초기화를 관리하여 성능 개선.
2) isArrived() 호출을 통해 체크를 단순화할 수 있다면 해당 로직을 줄여 평가 시간 축소.
3) 충돌 발생 시 추가 처리 로직을 제거하여 간소화.

## 🎯 다음 추천 문제

프로그래머스 67257번 - 수식 최대화 | 비슷한 길찾기 기법을 다양한 연산자 조합으로 확장하는 연습.

## 🏷️ 태그

bfs, implementation

## ✨ 모범 답안

```java
import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        PriorityQueue<int[]>[] q = new PriorityQueue[routes.length];
        int answer = 0;
        boolean[][] grid = new boolean[100][100];

        for (int i = 0; i < routes.length; i++) {
            q[i] = new PriorityQueue<>((a, b) -> a[0] - b[0]); // PriorityQueue for BFS
            q[i].offer(new int[]{routes[i][0], routes[i][1]});
        }

        while (isArrived(q)) {
            for (int i = 0; i < q.length; i++) {
                if (!q[i].isEmpty()) {
                    int[] p = q[i].poll();
                    if (grid[p[0]][p[1]])
                        answer++;
                    grid[p[0]][p[1]] = true;
                }
            }
        }
        return answer;
    }
}

private boolean isArrived(PriorityQueue<int[]>[] queues) {
    // Queue checking logic here.
}
```
