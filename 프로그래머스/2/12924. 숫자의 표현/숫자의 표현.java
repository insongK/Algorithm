class Solution {
    public int solution(int n) {
        int answer = 1;
        int i = 2;
        int j = 1;
        
        while(true){
            if((n - j) / i < 1) break;
            if((n - j) % i == 0) answer++;
            j += i;
            i ++;
        }
        return answer;
    }
}
