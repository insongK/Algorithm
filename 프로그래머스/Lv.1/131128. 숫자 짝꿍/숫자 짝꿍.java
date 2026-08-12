import java.util.*;

class Solution {
    public String solution(String X, String Y) {
        StringBuilder sb = new StringBuilder();
        char[] x = X.toCharArray();
        char[] y = Y.toCharArray();
        int x_len = x.length;
        int y_len = y.length;
        int[] x_cnt = new int[10];
        int[] y_cnt = new int[10];
        
        for(int i=0; i < x_len; i++){
            x_cnt[x[i] - '0']++;
        }
        for(int i=0; i < y_len; i++){
            y_cnt[y[i] - '0']++;
        }
        // System.out.println(Arrays.toString(x_cnt));
        // System.out.println(Arrays.toString(y_cnt));
        
        for(int i = 9; i >= 0; i--){
            int min = Math.min(x_cnt[i], y_cnt[i]);
            if(i == 0 && sb.length() == 0 && min != 0){
                sb.append('0');
                break;
            }
            for(int j = 0; j < min; j++){
                sb.append(i);
            }
        }
        if(sb.length() == 0) return "-1";
        String answer = sb.toString();
        return answer;
    }
}

// X, Y 
// 공통 수 찾기
// 0~9 3백만 개


// 가장 큰 수 찾기