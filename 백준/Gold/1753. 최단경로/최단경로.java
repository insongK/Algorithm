import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        List<int[]>[] G = new List[V]; for(int i = 0; i < V; i++) G[i] = new ArrayList<>();
        int[] dist = new int[V]; Arrays.fill(dist, 100000000);
        boolean[] visited = new boolean[V];
        
        int S = Integer.parseInt(br.readLine()) - 1;

        for(int i = 0; i < E; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken()) - 1;
            int v = Integer.parseInt(st.nextToken()) - 1;
            int w = Integer.parseInt(st.nextToken());

            G[u].add(new int[]{v, w});
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        dist[S] = 0;
        pq.offer(new int[]{S, dist[S]});

        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            if(visited[cur[0]]) continue;
            if(cur[1] > dist[cur[0]]) continue;

            visited[cur[0]] = true;
            for(int[] e : G[cur[0]]){
                if(!visited[e[0]] && dist[e[0]] > dist[cur[0]] + e[1]){
                    dist[e[0]] = dist[cur[0]] + e[1];
                    pq.offer(new int[]{e[0], dist[e[0]]});
                }
            }
        }
        
        for(int e : dist){
            if(e >= 100000000) System.out.println("INF");
            else System.out.println(e);
        }
        

    }
}