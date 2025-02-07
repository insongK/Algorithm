import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        int turn_count = 1, people_count = 1;
        Set<String> set = new HashSet<>();
        if(words[0].length() == 1){
            answer[0] = people_count; 
            answer[1] = turn_count; 
            return answer;
        }
        else{
            set.add(words[0]);
        }
        int i = 1;
        for(; i < words.length; i++){
            turn_count = (i / n) +  1; people_count = (i + 1) % n; 
            if(words[i].length() == 1) break;
            if(set.contains(words[i])) break;
            if(words[i - 1].charAt(words[i - 1].length() - 1) != words[i].charAt(0)) break;
            
            set.add(words[i]);
        }
        if(i == words.length){
            answer[0] = 0; 
            answer[1] = 0; 
        }
        else{
            answer[0] = people_count == 0 ? n: people_count; 
            answer[1] = turn_count; 
        }
        
        return answer;
    }
}