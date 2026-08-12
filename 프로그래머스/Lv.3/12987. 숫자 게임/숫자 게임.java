import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        Queue<Integer> queue_A = new PriorityQueue<>();
        for(int num: A){
            queue_A.offer(num);
        }
        Queue<Integer> queue_B = new PriorityQueue<>();
        for(int num: B){
            queue_B.offer(num);
        }
        
        int num_A = queue_A.poll();
        int num_B = queue_B.poll();
        
        while(!queue_B.isEmpty()){
            if(num_B > num_A){
                num_A = queue_A.poll();
                num_B = queue_B.poll();
                answer++;
            }
            else{
                num_B = queue_B.poll();
            }
        }
        if(num_B > num_A)  answer++;
        return answer;
    }
}
