import java.util.*;

class Solution {
    public int solution(int x, int y, int n) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[] visit = new boolean[y + 1];
        
        queue.offer(new int[]{x, 0});
        visit[x] = true;
        
        while(!queue.isEmpty()){
            int[] info = queue.poll();
            int new_x = info[0], count = info[1];
            if(new_x == y) return count;
            
            if(new_x + n <= y && !visit[new_x + n]) {
                queue.offer(new int[]{new_x + n, count + 1});
                visit[new_x + n] = true;
            }
            if(new_x * 2 <= y && !visit[new_x * 2]) {
                queue.offer(new int[]{new_x * 2, count + 1});
                visit[new_x * 2] = true;
            }
            if(new_x * 3 <= y && !visit[new_x * 3]) {
                queue.offer(new int[]{new_x * 3, count + 1});
                visit[new_x * 3] = true;
            }
        }
        
        return -1;
    }
}