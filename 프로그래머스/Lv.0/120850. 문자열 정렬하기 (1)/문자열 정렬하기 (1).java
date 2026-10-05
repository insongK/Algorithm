import java.util.*;

class Solution {
    public int[] solution(String my_string) {
        return my_string.chars().filter(x -> "0123456789".indexOf(x) != -1).map(x -> x - (int)'0').sorted().toArray();
    }
}