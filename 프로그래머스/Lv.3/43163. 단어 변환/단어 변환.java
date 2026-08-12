import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[] visit = new boolean[words.length];
        
        for(int i = 0; i < words.length; i++){
            int count = 0;
            for(int j = 0; j < words[i].length(); j++){
                if(words[i].charAt(j) != begin.charAt(j)) count++;
            }
            if(count == 1){
                queue.offer(new int[]{i, 1});
            }
        }
        while(!queue.isEmpty()){
            int[] word_info = queue.poll();
            int index = word_info[0], dist = word_info[1];
            String word = words[index];
            visit[index] = true;
            
            if(word.equals(target)) return dist;
            
            for(int i = 0; i < words.length; i++){
                int count = 0;
                for(int j = 0; j < words[i].length(); j++){
                    if(words[i].charAt(j) != word.charAt(j)) count++;
                }
                if(count == 1 && !visit[i]){
                    queue.offer(new int[]{i, dist + 1});
                    visit[i] = true;
                }
            }
        }
        return 0;
    }
}