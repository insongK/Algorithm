class Solution {
    
    
    public int solution(int[] diffs, int[] times, long limit) {
        int answer = 100000;
        
        int MAX_DIFF = 0;
        for(int diff: diffs) MAX_DIFF = Math.max(MAX_DIFF, diff);
        
        int start = 1, end = MAX_DIFF, level = (start + end) / 2;
        
        while(start <= end){
            long total = 0;
            for(int i = 0; i < diffs.length; i++){
                if(diffs[i] <= level){
                    total += times[i];
                }else{
                    int miss = diffs[i] - level;
                    total += miss * (times[i - 1] + times[i]) + times[i];
                }
            }
            // System.out.println(total + " " + level);
            if(total > limit) start = level + 1;
            else {
                end = level - 1;
                answer = Math.min(answer, level);
            }
            
            level = (start + end) / 2;
        }
        return answer;
    }
}


/*

순서대로 n개의 퍼즐을 제한 시간 내 퍼즐을 풀어야 됨

diff <= level time_cur 만큼 시간을 사용하여 해결 가능.

diff > level diff - level 번 틀림 퍼즐을 틀릴 때마다, time_cur만큼 시간 사용
    time_prev 만큼의 시간 사용해 이전 퍼즐을 다시 풀고 와야됨.
    푼 퍼즐은 time_cur만큼만 걸림
    
    모든 문제를 풀 수 있는 level의 최솟 값
    
    길이가 300,000만.... 
    NlogN 이진탐색 문제 같음
    