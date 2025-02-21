import java.util.*;

class Solution {
    public int solution(String dirs) {
        int answer = 0;
        int x = 0, y = 0;
        //          U.  D.  R.  L
        int[] dx = {0,  0,  1, -1};
        int[] dy = {1, -1,  0,  0};
        
        Set<String> set = new HashSet<>();
        
        for(char move: dirs.toCharArray()){
            int dir = "UDRL".indexOf(move);
            int nx = x + dx[dir], ny = y + dy[dir];
            if(nx > 5 || nx < -5 || ny > 5 || ny < -5) continue;
            
            String path1 = "" + x + y + nx + ny;
            String path2 = "" + nx + ny + x + y;
            
            if(!set.contains(path1) && !set.contains(path2)){
                set.add(path1);
                set.add(path2);
                answer++;
            }
            x = nx; y = ny;
        }
        
        return answer;
    }
}