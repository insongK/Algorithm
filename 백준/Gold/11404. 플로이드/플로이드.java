import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int V = Integer.parseInt(br.readLine());
        int E = Integer.parseInt(br.readLine());

        int[][] dist = new int[V][V]; 
        for(int i = 0; i < V; i++){
            Arrays.fill(dist[i], 100000000);
            dist[i][i] = 0;
        }

        for(int i = 0; i < E; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken()) - 1;
            int v = Integer.parseInt(st.nextToken()) - 1;
            int w = Integer.parseInt(st.nextToken());

            dist[u][v] = Math.min(dist[u][v], w);
        }

        for(int k = 0; k < V; k++){
            for(int i = 0; i < V; i++){
                for(int j = 0; j < V; j++){
                if(dist[i][j] > dist[i][k] + dist[k][j]) dist[i][j] = dist[i][k] + dist[k][j];
                }
            }
        }

        for(int[] e : dist){
            for(int n : e){
                if(n >= 100000000) System.out.print("0 ");
                else System.out.print(n + " ");
            }
            System.out.println();
        }
        
    }
}