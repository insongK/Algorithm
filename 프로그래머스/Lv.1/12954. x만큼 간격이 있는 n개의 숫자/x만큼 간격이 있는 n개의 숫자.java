import java.util.ArrayList;

class Solution {
    public long[] solution(int x, int n) {
        long[] answer = {};
        ArrayList<Long> al = new ArrayList<>();
        for(int i = 1; i <= n; i++){
            al.add((long)x * i);
        }
        
        int idx = 0;
        answer = new long[al.size()];
        for(long num: al){
            answer[idx++] = num;
        }
        return answer;
    }
}