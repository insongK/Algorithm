import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int N, M;
    static int[] A, B;
    static boolean[] v;
    static StringBuilder sb = new StringBuilder();

    static void perm(int cnt) {
        if(cnt == M){
            for(int e : B) sb.append(e).append(" "); 
            sb.append("\n"); 
            return;
        }

        int used = -1;
        for(int i = 0; i < N; i++){
            if(v[i]) continue;
            if(used == A[i]) continue;
            v[i] = true;
            used = A[i];
            B[cnt] = A[i];
            perm(cnt + 1);
            v[i] = false;
        }
        
        
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        A = new int[N];
        v = new boolean[N];
        B = new int[M];
        

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(A);
        perm(0);
        System.out.print(sb);   
    }
}