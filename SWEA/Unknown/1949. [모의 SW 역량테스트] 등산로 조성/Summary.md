# 🤖 AI 분석

## 💡 접근 방식

DFS를 활용해 등산로를 탐색, 최장 경로를 계산. 각 위치에서 최대 K만큼의 높이를 감소시키며 모든 시작점에서 DFS 실행.

## ⏱️ 시간 복잡도

O(K * N^2 * (N^2 + N)) — 모든 N^2 지점에서 시작해 최대 K 번 높이를 낮추고, 각 경우의 DFS는 O(N^2) 탐색. 이로 인해 O(K * N^2) + O(N^2)로 총 O(K * N^2)로 추정.

## 📦 공간 복잡도

O(N^2) — 방문 여부를 기록하는 boolean 배열과 약간의 추가 변수 사용. DFS 재귀 호출로 인한 스택 깊이도 최대 N^2이지만 전체 구조에서 이 부분은 주요 공간 사용 아님.

## 🔧 개선 사항

1) DFS 중복 호출을 줄이는 캐싱 전략 적용. 2) 방문 배열에 대한 reset 호출을 반복 대신 DFS 복귀 지점에서만 진행. 3) 다음 높이를 조사하기 전 DFS 탐색 상태를 복원할 수 있도록 재귀 매개변수 체계 수정.
4) 각 탐색을 별도의 클래스로 캡슐화를 통한 재사용성 제고.

## 🎯 다음 추천 문제

SWEA 1251번 - 하나로 연결하기 | 그래프 기반 경로 문제로 연습하며 추가 최적화 및 탐색 기법을 향상시킬 수 있다.

## 🏷️ 태그

dfs, graph, dynamic-programming

## ✨ 모범 답안

```java
import java.io.*;
import java.util.*;

public class Solution {
    static int N, K, ans;
    static int[][] map;
    static boolean[][] v;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    static boolean inRange(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < N;
    }

    static void dfs(int r, int c, int count) {
        v[r][c] = true;
        ans = Math.max(ans, count);
        for(int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];
            if(inRange(nr, nc) && !v[nr][nc]) {
                if(map[nr][nc] < map[r][c]) {
                    dfs(nr, nc, count + 1);
                }
            }
        }
        v[r][c] = false;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder(); 

        for(int tc = 1; tc <= T; tc++) {
            ans = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            map = new int[N][N];

            int max = 0;
            for(int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    max = Math.max(max, map[i][j]);
                }
            }

            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    int original = map[i][j];
                    for(int k = 1; k <= K; k++) {
                        map[i][j] = original - k;
                        v = new boolean[N][N];
                        for(int r = 0; r < N; r++) {
                            for(int c = 0; c < N; c++) {
                                if(map[r][c] == max) {
                                    dfs(r, c, 1);
                                }
                            }
                        }
                    }
                    map[i][j] = original; // 복구
                }
            }
            sb.append("#").append(tc).append(" ").append(ans).append("\n");
        }
        System.out.println(sb);
    }
}
```
