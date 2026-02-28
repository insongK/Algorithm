import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int N;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    static boolean inRange(int r, int c){
        return r >= 0 && r < N && c >= 0 && c < N;
    }
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;

        int tc = 1;
        while(true){
            N = Integer.parseInt(br.readLine());
            if(N == 0) break;

            int[][] map = new int[N][N];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            List<int[]>[][] G = new List[N][N]; for(int i = 0; i < N; i++) for(int j = 0; j < N; j++) G[i][j] = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    for(int d = 0; d < 4; d++){
                        int nr = i + dr[d];
                        int nc = j + dc[d];
                        if(inRange(nr,nc)){
                            G[i][j].add(new int[]{nr, nc, map[nr][nc]});
                        }
                    }
                }
            }

            PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1],b[1]));
            int[][] dist = new int[N][N]; for(int i = 0; i < N; i++) Arrays.fill(dist[i], 1000000);
            dist[0][0] = map[0][0];
            pq.offer(new int[]{0, 0, dist[0][0]});

            while(!pq.isEmpty()){
                int[] rcd = pq.poll();
                int r = rcd[0];
                int c = rcd[1];
                int d = rcd[2];
                for(int[] e : G[r][c]){
                    if(dist[e[0]][e[1]] > dist[r][c] + e[2]){
                        dist[e[0]][e[1]] = dist[r][c] + e[2];
                        pq.offer(new int[]{e[0], e[1], dist[e[0]][e[1]]});
                    }
                }
            }
            sb.append("Problem ").append(tc++).append(": ").append(dist[N - 1][N - 1]).append("\n");
        }
        System.out.println(sb);
    }
}