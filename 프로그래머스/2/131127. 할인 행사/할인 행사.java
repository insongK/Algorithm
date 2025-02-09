import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        Map<String, Integer> map = new HashMap<>();
        
        for(int i = 0; i <= discount.length - 10; i++){
            map.clear();
            for(int j = i; j < i + 10; j++){
                map.put(discount[j],map.getOrDefault(discount[j], 0) + 1);
            }
            
            int count = 0;
            for(int j = 0; j < want.length; j++){
                if(map.getOrDefault(want[j], 0) == number[j]) count++;
            }
            
            if(count == want.length) answer++;
        }
        return answer;
    }
}