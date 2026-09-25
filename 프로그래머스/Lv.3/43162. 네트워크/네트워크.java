import java.util.*;

class Solution {
    static boolean[] visit;
    static int answer = 0;
    
    public void dfs(int n, int[][] computers, int idx){
        visit[idx] = true;
        
        for(int i = 0; i < n; i++){
            if(idx != i && !visit[i] && computers[idx][i] == 1) dfs(n, computers, i);
        }
        
        return;
    }
    
    public int solution(int n, int[][] computers) {
        visit = new boolean[n];
        
        for(int i = 0; i < n; i++){
            if(!visit[i]){
                dfs(n, computers, i);
                answer++;
            }
            // System.out.println(Arrays.toString(visit));
        }
        
        return answer;
    }
}

/*

computer count n 200
visit[n] index = computer
for n:
if 1 -> another computer,

dfs calling count == network count

*/