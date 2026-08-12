import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        LinkedList<Integer> temp = new LinkedList<>();
        LinkedList<Integer> queue_p = new LinkedList<>();
        for(int num: progresses){queue_p.add(num);}
        
        LinkedList<Integer> queue_s = new LinkedList<>();
        for(int num: speeds){queue_s.add(num);}
        
        while(queue_p.size() != 0){
            int done = (100 - queue_p.peek()) % queue_s.peek() != 0 ? 
            (100 - queue_p.peek()) / queue_s.peek() + 1: (100 - queue_p.peek()) / queue_s.peek();
            
            for(int i = 0; i < queue_p.size(); i++){
                queue_p.set(i, queue_p.get(i) + done * queue_s.get(i));
            }
            int count = 0;
            while(true){
                if(queue_p.peek() < 100) break;
                else{
                    count++;
                    queue_p.remove();
                    queue_s.remove();
                    if(queue_p.size() == 0) break;
                }
            }
            temp.add(count);
        }
        int[] answer = new int[temp.size()];
        int idx = 0;
        for(int num: temp){
            answer[idx++] = num;
        }
        
        return answer;
    }
}