import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder(s);
        
        for(int j = 1; j <= s.length(); j++){
            sb.append(sb.charAt(0));
            sb.delete(0, 1);
            int count = 0;
            for(int i = 0; i < sb.length(); i++){
                if(sb.charAt(i) == ')'){
                    if(stack.empty() || stack.peek() != '(') break;
                    else stack.pop();
                }
                else if(sb.charAt(i) == '}'){
                    if(stack.empty() || stack.peek() != '{') break;
                    else stack.pop();
                }
                else if(sb.charAt(i) == ']'){
                    if(stack.empty()  || stack.peek() != '[') break;
                    else stack.pop();
                }
                else{
                    stack.push(sb.charAt(i));
                }
                count++;
            }
            if(stack.empty() && count == s.length()) answer++;
        }
        
        return answer;
    }
}