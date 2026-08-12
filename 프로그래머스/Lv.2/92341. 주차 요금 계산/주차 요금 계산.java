import java.util.*;
import java.lang.*;


class Solution {
    public int[] solution(int[] fees, String[] records) {
        Map<String, Integer> map_t = new HashMap<>();
        Map<String, Integer> map_r = new HashMap<>();
        
        for(String str : records){
            String[] temp = str.split(" ");
            String[] time = temp[0].split(":");
            
            int min = Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]);
            
            if(temp[2].equals("IN")){
                map_t.put(temp[1], map_t.getOrDefault(temp[1], 0) - min);
                map_r.put(temp[1], map_r.getOrDefault(temp[1], 0) + 1);
            }
            else{
                map_t.put(temp[1], map_t.getOrDefault(temp[1], 0) + min);
                map_r.put(temp[1], map_r.getOrDefault(temp[1], 0) - 1);
            }
        }
        Iterator iter = map_t.keySet().iterator();
        String[] numbers = new String[map_t.size()];
        int idx = 0;
        
        while(iter.hasNext()){
            numbers[idx] = iter.next().toString();
            if(map_r.get(numbers[idx]) == 1) {
                 map_t.put(numbers[idx], map_t.get(numbers[idx]) + 1439);
            }
            idx++;
        }
        Arrays.sort(numbers);
        int[] answer = new int[numbers.length];
        
        for(int i = 0; i < numbers.length; i++){
            if(map_t.get(numbers[i]) < fees[0]) answer[i] = fees[1];
            else{
                answer[i] = fees[1] + 
                    (int)Math.ceil((double)(map_t.get(numbers[i]) - fees[0]) / fees[2]) * fees[3];
            }
        }
        
        return answer;
    }
}