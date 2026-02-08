import java.io.*;
import java.util.*;

public class Main {
    static int[] dr = {-1, 0, 1, 0}; //ULDR
    static int[] dc = {0, -1, 0, 1};
    static int R, C;

    static boolean inRange(int r, int c) {
        return r >= 0 && r < R && c >= 0 && c < C;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        int[][] map = new int[R][C];
        int T = Integer.parseInt(st.nextToken());
        int air = 0;

        for(int i = 0; i < R; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < C; j++){
                int n = Integer.parseInt(st.nextToken());
                map[i][j] = n;
                if(n == -1) air = i;

            }
        }

        for(int t = 0; t < T; t++){
            int[][] tempMap = new int[R][C];
            for(int i = 0; i < R; i++){
                for(int j = 0; j < C; j++){
                    if(map[i][j] == -1) continue;
                    int dust = map[i][j];
                    for(int d = 0; d < 4; d++){
                        int nr = i + dr[d];
                        int nc = j + dc[d];
                        if(inRange(nr, nc) && map[nr][nc] != -1){
                            tempMap[nr][nc] += dust/5;
                            map[i][j] -= dust/5;
                        }
                    }
                    tempMap[i][j] += map[i][j];
                }
            }

            int r = air - 1 , c = 1;
            int tempDust = tempMap[r][c];
            tempMap[r][c] = 0;
            while(inRange(r, c)){
                int nr = r + dr[3];
                int nc = c + dc[3];
                if(inRange(nr, nc)){
                    int tempNextDust = tempMap[nr][nc];
                     tempMap[nr][nc] = tempDust;
                     tempDust = tempNextDust;

                }
                r = nr;
                c = nc;
            }
            r -= dr[3];
            c -= dc[3];
            while(inRange(r, c)){
                int nr = r + dr[0];
                int nc = c + dc[0];
                if(inRange(nr, nc)){
                    int tempNextDust = tempMap[nr][nc];
                    tempMap[nr][nc] = tempDust;
                    tempDust = tempNextDust;

                }
                r = nr;
                c = nc;
            }
            r -= dr[0];
            c -= dc[0];
            while(inRange(r, c)){
                int nr = r + dr[1];
                int nc = c + dc[1];
                if(inRange(nr, nc)){
                    int tempNextDust = tempMap[nr][nc];
                    tempMap[nr][nc] = tempDust;
                    tempDust = tempNextDust;

                }
                r = nr;
                c = nc;
            }
            r -= dr[1];
            c -= dc[1];

            while(r != air - 1){
                int nr = r + dr[2];
                int nc = c + dc[2];
                if(inRange(nr, nc)){
                    int tempNextDust = tempMap[nr][nc];
                    tempMap[nr][nc] = tempDust;
                    tempDust = tempNextDust;

                }
                r = nr;
                c = nc;
            }

            r = air; c = 1;
            tempDust = tempMap[r][c];
            tempMap[r][c] = 0;

            while(inRange(r, c)){
                int nr = r + dr[3];
                int nc = c + dc[3];
                if(inRange(nr, nc)){
                    int tempNextDust = tempMap[nr][nc];
                    tempMap[nr][nc] = tempDust;
                    tempDust = tempNextDust;

                }
                r = nr;
                c = nc;
            }
            r -= dr[3];
            c -= dc[3];
            while(inRange(r, c)){
                int nr = r + dr[2];
                int nc = c + dc[2];
                if(inRange(nr, nc)){
                    int tempNextDust = tempMap[nr][nc];
                    tempMap[nr][nc] = tempDust;
                    tempDust = tempNextDust;

                }
                r = nr;
                c = nc;
            }
            r -= dr[2];
            c -= dc[2];
            while(inRange(r, c)){
                int nr = r + dr[1];
                int nc = c + dc[1];
                if(inRange(nr, nc)){
                    int tempNextDust = tempMap[nr][nc];
                    tempMap[nr][nc] = tempDust;
                    tempDust = tempNextDust;

                }
                r = nr;
                c = nc;
            }
            r -= dr[1];
            c -= dc[1];

            while(r != air - 1){
                int nr = r + dr[0];
                int nc = c + dc[0];
                if(inRange(nr, nc)){
                    int tempNextDust = tempMap[nr][nc];
                    tempMap[nr][nc] = tempDust;
                    tempDust = tempNextDust;

                }
                r = nr;
                c = nc;
            }
            tempMap[air - 1][0] = -1;
            tempMap[air][0] = -1;
            map = tempMap;
        }
        int ans = 0;
        for(int i = 0; i < R; i++){
            for(int j = 0; j < C; j++){
                ans += map[i][j];
            }
        }
        System.out.println(ans + 2);



    }
}
