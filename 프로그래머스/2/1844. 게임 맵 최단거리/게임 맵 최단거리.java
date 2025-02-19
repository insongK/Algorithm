import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        int n = maps.length, m = maps[0].length;
        boolean[][] visit = new boolean[n][m];
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0, 1}); // {x, y, distance}
        visit[0][0] = true;
        
        while (!queue.isEmpty()) {
            int[] node = queue.poll();
            int x = node[0], y = node[1], dist = node[2];
            
            if (x == n - 1 && y == m - 1) {
                return dist;
            }
            
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if (nx >= 0 && nx < n && ny >= 0 && ny < m && maps[nx][ny] == 1 && !visit[nx][ny]) {
                    queue.offer(new int[]{nx, ny, dist + 1});
                    visit[nx][ny] = true;
                }
            }
        }
        
        return -1; // 도달 불가능한 경우
    }
}
