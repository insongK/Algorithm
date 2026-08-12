import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = {0, 0};
        Queue<Integer> min_q = new PriorityQueue<>();
        Queue<Integer> max_q = new PriorityQueue<>(Collections.reverseOrder());
        
        for(String str : operations){
            String[] operation = str.split(" ");
            
            if(operation[0].equals("I")){
                min_q.offer(Integer.parseInt(operation[1]));
                max_q.offer(Integer.parseInt(operation[1]));
            }
            else{
                if(operation[1].equals("-1") && !min_q.isEmpty()){
                    int min = min_q.poll();
                    max_q.remove(min);
                }
                if(operation[1].equals("1") && !max_q.isEmpty()){
                    int max = max_q.poll();
                    min_q.remove(max);
                }
            }
        }
        if(!min_q.isEmpty() && !max_q.isEmpty()){
            answer[0] = max_q.poll();
            answer[1] = min_q.poll();
        }
        
        return answer;
    }
}