# 🤖 AI 분석

## 💡 접근 방식

DFS를 사용하여 산악 지형에서의 경로를 탐색하며, 등산로 조성을 위해 한 지점을 K만큼 낮춘 후 최대 경로 길이 계산.

## ⏱️ 시간 복잡도

O(N² * K * (N² + E)) — N²개의 지점에서 최대 K번 지형을 낮춘 후, 각 지점에서 DFS를 수행해 O(N²)의 깊이 탐색(각 지점에서 최대 4방향 탐색) 수행. E는 간선 수로 최대 O(N²).

## 📦 공간 복잡도

O(N²) — 방문 배열 v와 맵 배열 map이 모두 N*N 크기.

## 🔧 개선 사항

1) 매 반복에서 Map 배열 복사 없이 값 수정 후 복구하는 방식 대신, K 범위 내에서의 높이를 저장해 탐색 시 재사용
2) DFS에 진입하기 전 map[r][c] == max 조건 체크로 불필요한 DFS 호출 줄이기
3) DFS를 호출하는 로직의 구조를 개선해 중복 계산 방지

## 🎯 다음 추천 문제

백준 2178번 - 미로 탐색 | 다양한 탐색 기법과 리소스 관리 훈련을 위해 최적 경로 문제로 확장.

## 🏷️ 태그

graph, depth-first-search, implementation

## ✨ 모범 답안

```java
import java.io.*;
import java.util.*;

public class Solution {
    static int N, K, ans;
    static int[][] map;
    static boolean[][] v;

    static int[] dr = {-1, 0, 1, 0}; //URDL
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
            if(inRange(nr, nc) && !v[nr][nc] && map[nr][nc] < map[r][c]) {
                dfs(nr, nc, count + 1);
            }
        }
        v[r][c] = false;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= T; tc++) {
            ans = 0;
            st = new StringTokenizer(br.readLine());
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
                        if(original - k < 0) continue; // 탐색 가능한 높이 체크
                        map[i][j] -= k;
                        v = new boolean[N][N];
                        for(int r = 0; r < N; r++) {
                            for(int c = 0; c < N; c++) {
                                if(map[r][c] == max) dfs(r, c, 1);
                            }
                        }
                        map[i][j] = original; // 복구
                    }
                }
            }

            sb.append("#").append(tc).append(" ").append(ans).append("\n");
        }
        System.out.println(sb);
    }
}
```
