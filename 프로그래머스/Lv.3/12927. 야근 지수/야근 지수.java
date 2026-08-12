import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        
        for (int work : works) {
            maxHeap.offer(work);
        }

        while (n > 0 && !maxHeap.isEmpty()) {
            int maxWork = maxHeap.poll();
            if (maxWork == 0) break;
            maxHeap.offer(maxWork - 1);
            n--;
        }

        long answer = 0;
        while (!maxHeap.isEmpty()) {
            int work = maxHeap.poll();
            answer += (long) work * work;
        }

        return answer;
    }
}