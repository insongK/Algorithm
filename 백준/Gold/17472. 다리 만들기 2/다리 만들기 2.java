import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int H, W;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static int[][] map;
    static boolean[][] v;

    static boolean inRange(int r, int c){
        return r >= 0 && r < H && c >= 0 && c < W;
    }

    static void bfs(int r, int c, int n){
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{r, c});
        v[r][c] = true;

        while (!q.isEmpty()) {
            int[] rc = q.poll();
            int cr = rc[0];
            int cc = rc[1];
            map[cr][cc] = n;
            
            for(int d = 0; d < 4; d++){
                int nr = cr + dr[d];
                int nc = cc + dc[d];
                if(inRange(nr, nc) && !v[nr][nc] && map[nr][nc] == 1){
                    q.offer(new int[]{nr, nc});
                    v[nr][nc] = true;
                }
            }
        }
    }

    static int[] dfs(int r, int c, int d, int n){
        int[] info = {-1, 1};
        v[r][c] = true;
        
        int nr = r + dr[d];
        int nc = c + dc[d];

        if(inRange(nr, nc) && !v[nr][nc]){
            if(map[nr][nc] == 0){
            int[] res = dfs(nr, nc, d, n);
            info[0] = res[0];
            info[1] += res[1];
            }
            else info[0] =  map[nr][nc];
        }
        
        
        return info;
    }
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        map = new int[H][W];
        v = new boolean[H][W];
        
        
        for (int i = 0; i < H; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < W; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int n = 1;
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                if(map[i][j] == 1 && !v[i][j]) bfs(i, j, n++);
            }
        }

        List<int[]>[] G = new List[n]; for(int i = 0; i < n; i++) G[i] = new ArrayList<>();

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                for(int d = 0; d < 4; d++){
                    int nr = i + dr[d];
                    int nc = j + dc[d];
                    if(inRange(nr,nc) && map[i][j] != 0 && map[nr][nc] == 0){
                        v = new boolean[H][W];
                        int[] info = dfs(nr, nc, d, map[i][j]);
                        if(info[0] > 0 && info[1] >= 2) G[map[i][j]].add(new int[]{info[0],info[1]});
                    }
                }
            }
        }

        int mst = 0, cnt = 0;
        boolean[] visited = new boolean[n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1],b[1]));
        int[] P = new int[n]; Arrays.fill(P, Integer.MAX_VALUE);
        P[1] = 0;
        pq.offer(new int[]{1, P[1]});

        while(!pq.isEmpty()){
            
            int[] vd = pq.poll();
            int minVertex = vd[0];
            int min = vd[1];
            if(visited[minVertex]) continue;
            if(min < P[minVertex]) continue;
            mst += min;
            visited[minVertex] = true;
            if(cnt++ == n) continue;

            for(int[] e : G[minVertex]){
                if(!visited[e[0]] && P[e[0]] > e[1]){
                    P[e[0]] = e[1];
                    pq.offer(new int[]{e[0], e[1]});
                }
            }
        }
        boolean flag = false;
        for(int i = 1; i < n; i++) 
            if(P[i] == Integer.MAX_VALUE){
                flag = true;
                break;
            }
        
        if(flag) System.out.println(-1);
        else System.out.println(mst);
        

        
    }
}