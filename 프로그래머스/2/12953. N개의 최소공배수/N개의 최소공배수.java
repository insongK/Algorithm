class Solution {
    public int solution(int[] arr) {
        int answer = 1;
        
        while(answer <= Integer.MAX_VALUE){
            int count = 0;
            for(int i = 0; i < arr.length; i++){
                if(answer % arr[i] != 0) break;
                else count++;
            }
            if(count == arr.length) return answer;
            answer++;
        }
        return answer;
    }
}