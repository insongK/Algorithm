import java.io.*;
import java.util.*;

public class Main {
    static long mask;
    static int[][] festival;
    static int N, M, ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int TP = Integer.parseInt(st.nextToken());

        mask = 0;

        for(int i = 0; i < TP; i++){
            int person =  Integer.parseInt(st.nextToken()) - 1;
            mask |= 1L << person;
        }

        festival = new int[M][];

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int count =  Integer.parseInt(st.nextToken());
            festival[i] = new int[count];

            for(int j = 0; j < count; j++){
                festival[i][j] = Integer.parseInt(st.nextToken()) - 1;
            }
        }

        for(int i = 0; i < M; i++){
            for(int j = 0; j < M; j++){
                boolean flag = false;
                for(int p : festival[j]){
                    if((mask & 1L << p) != 0) flag = true;
                }

                if(flag){for(int p : festival[j]){
                    mask |= 1L << p;
                }}
            }
        }

        for(int i = 0; i < M; i++){
            boolean flag = false;
            for(int p : festival[i]){
                if((mask & 1L << p) != 0) {
                    flag = true;
                    break;
                }
            }

            if(flag) continue;
            ans++;
        }

        System.out.println(ans);
    }
}