import java.util.*;
import java.lang.*;

class Solution {
    public int solution(String str1, String str2) {
        str1 = str1.toUpperCase();
        Map<String, Integer> map1 = new HashMap<>();
        Set<String> set1 = new HashSet<>();
        for(int i = 0 ; i < str1.length() - 1; i++){
            String temp = str1.substring(i, i + 2);
            if((temp.charAt(0) >= 'A' && temp.charAt(0) <= 'Z') &&
               (temp.charAt(1) >= 'A' && temp.charAt(1) <= 'Z')){
                map1.put(temp, map1.getOrDefault(temp, 0) + 1);
                set1.add(temp);
            }
        }
        
        str2 = str2.toUpperCase();
        Map<String, Integer> map2 = new HashMap<>();
        Set<String> set2 = new HashSet<>();
        for(int i = 0 ; i < str2.length() - 1; i++){
            String temp = str2.substring(i, i + 2);
            if((temp.charAt(0) >= 'A' && temp.charAt(0) <= 'Z') &&
               (temp.charAt(1) >= 'A' && temp.charAt(1) <= 'Z')){
                map2.put(temp, map2.getOrDefault(temp, 0) + 1);
                set2.add(temp);
            }
        }
        
        int intersection = 0;
        Iterator<String> iter1 = set1.iterator();
        
        while(iter1.hasNext()){
            String temp = iter1.next();
            if(map2.getOrDefault(temp,0) >= 1)
                 intersection += Math.min(map1.get(temp), map2.get(temp));
            else continue;
        }
        
        int union = 0;
        iter1 = set1.iterator();
        while(iter1.hasNext()){
            String temp = iter1.next();
            if(map2.getOrDefault(temp,0) >= 1)
                 union += Math.max(map1.get(temp), map2.get(temp));
            else union += map1.get(temp);
        }
        Iterator<String> iter2 = set2.iterator();
        while(iter2.hasNext()){
            String temp = iter2.next();
            if(map1.getOrDefault(temp,0) >= 1) continue;
            else union += map2.get(temp);
        }
        float answer = (union == 0) ? 1: (float)intersection / (float)union;

        return (int)(answer * 65536);
    }
}