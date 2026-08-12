class Solution {
    public long solution(long n) {
        long answer = 0;
        StringBuilder sb = new StringBuilder();
        int[] arr = sb.append(n).chars().sorted().map(m -> m - 48).toArray();
        
        sb.delete(0, sb.length());
        for(int i = arr.length - 1; i >= 0; i--){
            sb.append(arr[i]);
        }
        
        answer = Long.parseLong(sb.substring(0, sb.length()));
        
        return answer;
    }
}