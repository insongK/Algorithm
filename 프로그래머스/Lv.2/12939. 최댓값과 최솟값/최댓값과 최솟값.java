class Solution {
    public String solution(String s) {
        String[] str = s.split(" ");
        int[] num = new int[str.length];
        
        for(int i = 0; i < str.length; i++){
            num[i] = Integer.parseInt(str[i]);
        }
        int max = -Integer.MAX_VALUE; int min = Integer.MAX_VALUE;
        
        for(int i = 0; i < num.length; i++){
            if(num[i] > max) max = num[i];
            if(num[i] < min) min = num[i];
        }
        
        return min + " " + max;
    }
}