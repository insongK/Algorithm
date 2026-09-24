import java.util.*;

class Solution {
    boolean solution(String s) {
        ArrayDeque<Character> stack = new ArrayDeque<>();
        char[] arr = s.toCharArray();
        
        for(char c:arr){
            if(c == '(') stack.add(c);
            else {
                if(stack.poll() == null) return false;
            }
        }

        return stack.size() == 0 ? true:false;
    }
}