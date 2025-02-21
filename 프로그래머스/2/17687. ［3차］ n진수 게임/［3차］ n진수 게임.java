class Solution {
    public String solution(int n, int t, int m, int p) {
        StringBuilder sb = new StringBuilder();
        
        int count = 0;
        while(sb.length() < t * m){
            sb.append(Integer.toString(count, n).toUpperCase());
            count++;
        }
        
        StringBuilder answer = new StringBuilder();
        for(int i = p - 1; i < t * m; i += m){
            answer.append(sb.charAt(i));
        }
        
        return answer.toString();
    }
}