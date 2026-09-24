import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        Arrays.sort(phone_book);
        HashSet<String> set = new HashSet<>();
        for(String phone : phone_book){
            StringBuilder sb = new StringBuilder(phone);
            
            for(int i = 1; i < sb.length(); i++){
                String prefix = sb.substring(0, i);
                // System.out.println(prefix);
                if(set.contains(prefix)) return false;
            }
            set.add(sb.toString());
            // System.out.println(set);
        }
        return true;
    }
}
    