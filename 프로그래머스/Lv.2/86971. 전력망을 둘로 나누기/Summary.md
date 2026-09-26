# 🤖 AI 분석

## 💡 접근 방식

유니온-파인드 방식으로 전력망을 결합하여 구간을 나누고, 각 경우의 차이를 계산.

## ⏱️ 시간 복잡도

O(N^2) — 각 전선 하나씩 제거하는 순회마다 N-1 개의 전선을 처리하므로 전체 O(N^2). find()와 union()에서 추가적으로 O(N) 들어가므로 최악의 경우 O(N^2)로 유지.

## 📦 공간 복잡도

O(N) — 각 노드의 부모를 저장하기 위한 배열이 필요하여 O(N) 공간 사용.

## 🔧 개선 사항

1) 현재 find() 구현을 최적화할 수 있는 경로 압축(path compression)을 적용하여 find()의 성능을 향상.
2) union() 함수에서 union by rank 기법을 사용하여 트리의 높이를 최소화하여, 전체 연산을 효율적으로 만듦.
3) 코드 가독성을 위해 초기화 배열 생성 및 중복 코드 제거 고려

## 🎯 다음 추천 문제

프로그래머스 62048 - 멀리뛰기 | DP 또는 조합 문제로 연결된 개념 확장.

## 🏷️ 태그

graph, union-find

## ✨ 모범 답안

```java
import java.util.Arrays;

class Solution {

    public int find(int x, int[] arr) {
        if (arr[x] != x) {
            arr[x] = find(arr[x], arr);
        }
        return arr[x];
    }
    public void union(int x, int y, int[] arr) {
        int rootX = find(x, arr);
        int rootY = find(y, arr);
        if (rootX != rootY) {
            arr[rootY] = rootX;
        }
    }

    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        for (int i = 0; i < wires.length; i++) {
            int[] arr = new int[n + 1];
            for (int k = 1; k <= n; k++) arr[k] = k;

            for (int j = 0; j < wires.length; j++) {
                if (j == i) continue;
                union(wires[j][0], wires[j][1], arr);
            }

            int cnt = 0;
            for (int k = 1; k <= n; k++) {
                if (find(k, arr) == find(1, arr)) cnt++;
            }

            answer = Math.min(answer, Math.abs(cnt - (n - cnt)));
        }
        return answer;
    }
}
```
