class Solution {
    public int[] solution(long n) {
        StringBuilder sb = new StringBuilder();
        sb.append(n).reverse();
        
        int[] answer = new int[sb.length()];
        
        for(int i = 0; i < answer.length; i++){
            answer[i] = Integer.parseInt(sb.substring(i, i + 1));
        }
        
        return answer;
    }
}