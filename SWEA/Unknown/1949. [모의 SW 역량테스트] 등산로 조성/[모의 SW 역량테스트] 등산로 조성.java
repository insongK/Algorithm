import java.io.*;
import java.util.*;

public class Solution {
	static int N, K, ans;
	static int[][] map;
	static boolean[][] v;
	
	static int[] dr = {-1, 0, 1, 0}; //URDL
	static int[] dc = {0, 1, 0, -1};
	
	static boolean inRange(int r, int c) {
		return r>= 0 && r < N && c>= 0 && c < N;
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
			v[r][c] = false;
		}
		
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
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
					int n = Integer.parseInt(st.nextToken());
					map[i][j] = n;
					max = Math.max(max, n);
				}
			}
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					for(int k = 1; k <= K; k++) {
						int temp = map[i][j];
						map[i][j] -= k;
						for(int r = 0; r < N; r++) {
							for(int c = 0; c < N; c++) {
								v = new boolean[N][N];
								if(map[r][c] == max) dfs(r, c, 1);
							}
						}
						map[i][j] = temp;
					}
				}
			}
			
			sb.append("#").append(tc).append(" ").append(ans).append("\n");
			
		}
		System.out.println(sb);
	}

}