import java.util.*;
import java.lang.*;

class Solution {
    public int solution(String word) {
        int answer = 0;
        String vowels = "AEIOU";
        
        for(int i = 0; i < word.length(); i++){
            int index = vowels.indexOf(word.charAt(i));
            
            for(int j = 0; j < index; j++){
                for(int k = 0; k < 5 - i; k++){
                    answer += Math.pow(5,k);
                }
            }
            answer++;
        }
        return answer;
    }
}

