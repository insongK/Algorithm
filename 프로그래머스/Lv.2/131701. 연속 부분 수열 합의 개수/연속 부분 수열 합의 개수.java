import java.util.*;

class Solution {
    public int solution(int[] elements) {
        int answer = 0;
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < elements.length; i++){
            for(int j = 0; j < elements.length; j++){
                int num = 0;
                for(int k = j; k <= j + i; k++){
                    num += elements[k % elements.length];
                }
                set.add(num);
            }
        }
        
        return set.size();
    }
}