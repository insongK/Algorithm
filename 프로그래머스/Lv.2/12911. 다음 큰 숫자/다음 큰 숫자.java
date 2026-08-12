class Solution {
    public int solution(int n) {
        int answer = n + 1;
        int n_count_1 = 0;
        
        for(int i = n; i > 0; i /= 2){
            if(i % 2 == 1) n_count_1++;
        }
        
        int answer_count_1 = 0;
        while(true){
            if(answer_count_1 == n_count_1) break;
            
            answer_count_1 = 0;
            for(int i = answer; i > 0; i /= 2){
                if(i % 2 == 1) answer_count_1++;
            }
            answer++;
        }
        return answer - 1;
    }
}