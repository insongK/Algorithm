import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        Queue<String> queue = new LinkedList<>();
        
        if(cacheSize == 0) return cities.length * 5;
        
        for(int i = 0; i < cities.length; i++){
            if(queue.size() < cacheSize){
                if(queue.contains(cities[i].toLowerCase())){
                    queue.remove(cities[i].toLowerCase());
                    queue.add(cities[i].toLowerCase());
                    answer++;
                }
                else{
                    queue.add(cities[i].toLowerCase());
                    answer += 5;
                }
                continue;
            }
            if(queue.contains(cities[i].toLowerCase())){
                queue.remove(cities[i].toLowerCase());
                queue.add(cities[i].toLowerCase());
                answer++;
            }
            else{
                queue.remove();
                queue.add(cities[i].toLowerCase());
                answer += 5;
            }
        }
        return answer;
    }
}