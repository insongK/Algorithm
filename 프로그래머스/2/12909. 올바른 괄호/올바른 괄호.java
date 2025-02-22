import java.util.*;

class Solution {
    boolean solution(String s) {
        Stack<Character> stack = new Stack<>();
        
        for(char c: s.toCharArray()){
            if(c == '(') stack.push(c);
            else{
                if(stack.empty() || stack.peek() != '(') return false;    
                stack.pop();
            }
        }
        
        if(!stack.empty()) return false;

        return true;
    }
}