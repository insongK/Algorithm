# 🤖 AI 분석

## 💡 접근 방식

DFS를 통해 각 컴퓨터의 연결 상태를 탐색하여 네트워크 수를 계산. 방문 배열로 중복 탐색 방지.

## ⏱️ 시간 복잡도

O(N²) — 모든 연결을 확인하기 위해 각 컴퓨터와 다른 모든 컴퓨터를 최대 N번 순회하며 dfs 호출.

## 📦 공간 복잡도

O(N) — 방문 여부를 위한 배열 사용, 추가 재귀 스택 사용으로 최대 N만큼의 공간 필요.

## 🔧 개선 사항

1) 방문 배열을 매번 새로운 dfs 호출 시마다 초기화할 필요 없음. 이미 dfs에서 기 설정한 방문 상태를 활용.
2) 비트마스크나 인접 리스트로 메모리 사용량 줄일 수 있음.
3) 코드 가독성을 위해 메소드 분리 및 중복 코드 방지. dfs 메소드를 private로 선언하여 외부 접근 차단 시키기.

## 🎯 다음 추천 문제

프로그래머스 43165번 - 타겟 넘버 | DFS를 이용한 문제 풀이 기법 연습.

## 🏷️ 태그

dfs, graph

## ✨ 모범 답안

```java
import java.util.*;

class Solution {
    static boolean[] visit;
    static int answer = 0;
    
    private void dfs(int n, int[][] computers, int idx) {
        visit[idx] = true;
        for (int i = 0; i < n; i++) {
            if (!visit[i] && computers[idx][i] == 1) {
                dfs(n, computers, i);
            }
        }
    }
    
    public int solution(int n, int[][] computers) {
        visit = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visit[i]) {
                dfs(n, computers, i);
                answer++;
            } 
        }
        return answer;
    }
}
```
