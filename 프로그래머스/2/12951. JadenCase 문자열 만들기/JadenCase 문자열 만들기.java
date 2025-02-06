class Solution {
    public String solution(String s) {
        String[] str = s.toLowerCase().split(" ");
        StringBuilder sb = new StringBuilder();
        StringBuilder answer = new StringBuilder();
        
        for(int i = 0; i < str.length; i++){
            if(str[i].length() == 0) {
                answer.append(" ");
                continue;
            }
            sb.append(str[i]);
            if(sb.charAt(0) >= 'a' && sb.charAt(0) <= 'z') {
                sb.replace(0 , 1, sb.substring(0, 1).toUpperCase()).substring(0);
            }
            answer.append(sb);
            if(i != str.length - 1) answer.append(" ");
            
            sb.delete(0 , sb.length());
        }
        if(answer.length() != s.length()){
            for(int i = 0; i <= s.length() - answer.length(); i++){
                answer.append(" ");
            }
        }
        
        return answer.substring(0);
    }
}