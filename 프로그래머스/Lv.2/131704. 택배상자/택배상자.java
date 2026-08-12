import java.util.*;

class Solution {
    public int solution(int[] order) {
        int answer = 0;
        Queue<Integer> queue = new LinkedList<>();
        Stack<Integer> stack = new Stack<>();
        
        stack.push(1);
        for(int i = 2; i <= order.length; i++){
            queue.offer(i);
        }
        
        for(int num : order){
            if(stack.empty()) stack.push(queue.poll());
            
            while(stack.peek() != num && !queue.isEmpty()){
                stack.push(queue.poll());
            }
            if(stack.pop() == num) answer++;
            else{
                if(queue.isEmpty()) break;
            }
        }
        return answer;
    }
}