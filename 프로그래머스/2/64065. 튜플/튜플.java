import java.util.*;

class Solution {
    public int[] solution(String s) {
        Set<Integer> set = new LinkedHashSet<>();
        String[] str = s.split("},\\{");
        for(int i = 0; i < str.length; i++){
            str[i] = str[i].replaceAll("\\{", "").replaceAll("\\}", "");
        }
        Arrays.sort(str, Comparator.comparingInt(String::length));
        for(int i = 0; i < str.length; i++){
            String[] temp = str[i].split(",");
            for(int j = 0; j < temp.length; j++){
                set.add(Integer.parseInt(temp[j]));
            }
        }
        int[] answer = set.stream().mapToInt(Integer::intValue).toArray();
        return answer;
    }
}