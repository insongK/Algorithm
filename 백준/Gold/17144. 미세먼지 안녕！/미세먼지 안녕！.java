import java.io.*;
import java.util.*;

public class Main {
    static int R, C, T;
    static final int[] dr = {-1, 1, 0, 0};
    static final int[] dc = {0, 0, -1, 1};

    static boolean inRange(int r, int c) {
        return 0 <= r && r < R && 0 <= c && c < C;
    }

    // 1) 확산 단계
    static int[][] diffuse(int[][] map, int upper, int lower) {
        int[][] next = new int[R][C];
        next[upper][0] = -1;
        next[lower][0] = -1;

        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (map[r][c] <= 0) continue; // 0 or -1

                int amount = map[r][c] / 5;
                if (amount == 0) {
                    next[r][c] += map[r][c];
                    continue;
                }

                int spreadCnt = 0;
                for (int d = 0; d < 4; d++) {
                    int nr = r + dr[d];
                    int nc = c + dc[d];
                    if (!inRange(nr, nc) || map[nr][nc] == -1) continue;
                    next[nr][nc] += amount;
                    spreadCnt++;
                }
                next[r][c] += map[r][c] - amount * spreadCnt;
            }
        }
        return next;
    }

    // 2) 공기청정기 순환 단계 (BOJ 17144 표준 시뮬레이션)
    static void circulate(int[][] a, int upper, int lower) {
        // 위쪽(반시계)
        // 1) 왼쪽 세로(위로)
        for (int r = upper - 1; r > 0; r--) a[r][0] = a[r - 1][0];
        // 2) 위쪽 가로(왼쪽)
        for (int c = 0; c < C - 1; c++) a[0][c] = a[0][c + 1];
        // 3) 오른쪽 세로(아래로)
        for (int r = 0; r < upper; r++) a[r][C - 1] = a[r + 1][C - 1];
        // 4) 아래쪽 가로(오른쪽)
        for (int c = C - 1; c > 1; c--) a[upper][c] = a[upper][c - 1];
        a[upper][1] = 0;
        a[upper][0] = -1;

        // 아래쪽(시계)
        // 1) 왼쪽 세로(아래로)
        for (int r = lower + 1; r < R - 1; r++) a[r][0] = a[r + 1][0];
        // 2) 아래쪽 가로(왼쪽)
        for (int c = 0; c < C - 1; c++) a[R - 1][c] = a[R - 1][c + 1];
        // 3) 오른쪽 세로(위로)
        for (int r = R - 1; r > lower; r--) a[r][C - 1] = a[r - 1][C - 1];
        // 4) 위쪽 가로(오른쪽)
        for (int c = C - 1; c > 1; c--) a[lower][c] = a[lower][c - 1];
        a[lower][1] = 0;
        a[lower][0] = -1;
    }

    static int sumDust(int[][] map) {
        int sum = 0;
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (map[r][c] > 0) sum += map[r][c];
            }
        }
        return sum;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        int[][] map = new int[R][C];
        int upper = -1, lower = -1;

        for (int r = 0; r < R; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < C; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
            }
            // 공기청정기는 항상 1열(0번 열)에 있고, 두 줄 연속
            if (map[r][0] == -1) {
                if (upper == -1) upper = r;
                else lower = r;
            }
        }

        for (int t = 0; t < T; t++) {
            map = diffuse(map, upper, lower);
            circulate(map, upper, lower);
        }

        System.out.println(sumDust(map));
    }
}
