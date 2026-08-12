import java.util.*;

class Solution {
    public int solution(int n, int[][] computers) {
        boolean[] visit = new boolean[n]; // 방문 여부 확인 배열
        int answer = 0;
        
        for (int i = 0; i < n; i++) {
            if (!visit[i]) { // 방문하지 않은 노드라면 BFS 실행
                bfs(n, computers, visit, i);
                answer++; // 네트워크 개수 증가
            }
        }
        return answer;
    }
    
    private void bfs(int n, int[][] computers, boolean[] visit, int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visit[start] = true;
        
        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int i = 0; i < n; i++) {
                if (computers[node][i] == 1 && !visit[i]) {
                    visit[i] = true;
                    queue.offer(i);
                }
            }
        }
    }
}
