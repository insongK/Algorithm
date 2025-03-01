class Solution {
    public int[] solution(int n, int s) {
        int[] answer = new int[n];
        if(n > s) return new int[]{-1};
        int share = s / n, remain = s % n;
        
        for(int i = n - 1; i >= 0; i--){
            if(remain != 0){
                answer[i] = share + 1;
                remain--;
            }
            else{
                answer[i] = share;
            }
        }
        
        return answer;
    }
}

