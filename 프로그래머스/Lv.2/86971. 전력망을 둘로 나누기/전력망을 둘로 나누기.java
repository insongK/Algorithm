import java.util.*;

class Solution {
    
    public int find(int x, int[] arr){
        if(arr[x] == x) return x;
        return arr[x] = find(arr[x], arr);
    }
    
    public void union(int x, int y, int[] arr){
        x = find(x, arr);
        y = find(y, arr);
        if (x == y) return;
        arr[y] = x;
    }
    
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        for(int i = 0; i < n - 1; i++){
            int[] arr = new int[n + 1];
            for (int k = 1; k <= n; k++) arr[k] = k;
            for(int j = 0; j < n - 1; j++){
                if(j == i) continue;
                union(wires[j][0], wires[j][1], arr);
            }
            for (int k = 1; k <= n; k++) find(k, arr);
            
            int cnt = 0;
            for (int k = 1; k <= n; k++) {
                if (arr[k] == arr[1]) cnt++;
            }
            answer = Math.min(answer, Math.abs(cnt - (n - cnt)));
        }
        return answer;
    }
}
            for(int j = 0; j < n - 1; j++){