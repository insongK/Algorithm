import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < tangerine.length; i++){
            map.put(tangerine[i], map.getOrDefault(tangerine[i], 0) + 1);
        }
        Collection<Integer> c = map.values();
        
        Object[] arr = c.stream().sorted().toArray();
        
        int count = 0;
        for(int i = arr.length - 1; i >= 0; i--){
            if(count >= k) break;
            count += (int)arr[i];
            answer++;
        }
        
        return answer;
    }
}