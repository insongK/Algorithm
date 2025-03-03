import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        Map<String, String> map = new LinkedHashMap<>();
        
        int msg_count = 0;
        for(String str : record){
            String[] info = str.split(" ");
            String opcode = info[0], name = info[1], nickname = "";
            if(info.length == 3) nickname = info[2];
            
            if(opcode.equals("Enter") || opcode.equals("Change")){
                map.put(name, nickname);
            }
            if(opcode.equals("Enter") || opcode.equals("Leave")) msg_count++;
        }
        String[] answer = new String[msg_count];
        int idx = 0;
        for(String str : record){
            String[] info = str.split(" ");
            String opcode = info[0], name = info[1], nickname = "";
            if(info.length == 3) nickname = info[2];
            
            if(opcode.equals("Enter")){
                answer[idx++] = map.get(name) + "님이 들어왔습니다.";
            }
            if(opcode.equals("Leave")){
                answer[idx++] = map.get(name) + "님이 나갔습니다.";
            }
        }        
        
        return answer;
    }
}