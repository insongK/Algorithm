import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        
        int end = people.length - 1;
        for(int i = 0; i < people.length; i++){
            if(i > end) break;
            
            if(people[i] + people[end] <= limit){
                answer++;
                end--;
            }
            else{
                answer++;
                end--; i--;
            }
        }
        return answer;
    }
}