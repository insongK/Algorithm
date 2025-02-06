class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        int count_0 = 0;        
        int count_total = 0;
        
        while(true){
            if(s.equals("1")) break;
            
            String temp_str = s.replaceAll("0", "");
            count_0 += s.length() - temp_str.length();
            
            int len = temp_str.length();
            StringBuilder sb = new StringBuilder();
            for(int i = len; i > 0; i /= 2){
                sb.append(i % 2);
            }
            s = sb.reverse().substring(0);
            count_total++;
        }
        answer[0] = count_total; answer[1] = count_0;
        
        return answer;
    }
}