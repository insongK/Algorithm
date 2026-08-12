import java.lang.Math;

class Solution {
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = 0;
        int[][] floyd = new int[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(i == j) continue;
                floyd[i][j] = 999999;
            }
        }
        for(int i = 0; i < fares.length; i++){
            floyd[fares[i][0] - 1][fares[i][1] - 1] = fares[i][2];
            floyd[fares[i][1] - 1][fares[i][0] - 1] = fares[i][2];
        }
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                for(int k = 0; k < n; k++){
                    floyd[j][k] = Math.min(floyd[j][k], floyd[j][i] + floyd[i][k]);
                }
            }
        }
        answer = floyd[s - 1][a - 1] + floyd[s - 1][b - 1];
        for(int i = 0; i < n; i++){
            answer = Math.min(answer, floyd[s - 1][i] + floyd[i][a- 1] + floyd[i][b - 1]);
        }
        
        return answer;
    }
}