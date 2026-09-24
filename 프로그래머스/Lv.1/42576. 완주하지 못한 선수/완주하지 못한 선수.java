import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> player = new HashMap<String, Integer>();
        
        for(int i = 0; i < completion.length; i++){
            if(player.get(completion[i]) == null) player.put(completion[i], 1);
            else player.replace(completion[i], player.get(completion[i]) + 1);
        }
        // System.out.println(player);
        
        for(int i = 0; i < participant.length; i++){
            if(player.getOrDefault(participant[i], 0) == 0) return participant[i];
            else player.replace(participant[i], player.get(participant[i]) - 1);
        }
        
        return "error";
    }
}


// check completion