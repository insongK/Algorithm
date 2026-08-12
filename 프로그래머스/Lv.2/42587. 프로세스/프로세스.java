import java.util.*;

class Process{
    int priority;
    int index;

    public Process(int priority, int index) {
        this.priority = priority;
        this.index = index;
    }
}

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 1;
        
        Queue<Process> queue = new LinkedList<>();
        
        for(int i = 0; i < priorities.length; i++){
            queue.add(new Process(priorities[i], i));
        }
        
        while (!queue.isEmpty()) {
            Process excute_proc = queue.poll();
            Iterator<Process> iter = queue.iterator();
            boolean high_priority = false;
            while(iter.hasNext()){
                if(excute_proc.priority < iter.next().priority){
                    high_priority = true;
                    queue.add(excute_proc);
                    break;
                }
            }
            if(!high_priority){
                if(excute_proc.index == location) break;
                answer++;
            }
        }
        return answer;
    }
}
