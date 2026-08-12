class Solution {
    public long solution(int a, int b, int[] g, int[] s, int[] w, int[] t) {
        long left = 1L, right = 400000000000000L;
        
        while(left + 1 < right){
            long mid = (left + right) / 2;
            long total = 0L, totalG = 0L, totalS = 0L;
            
            for(int i = 0; i < t.length; i++){
                long cnt = mid / (2L * t[i]);
                if (mid % (2L * t[i]) >= t[i]) cnt++;
    
                long tmp = Math.min(cnt * w[i], g[i] + s[i]);
                total += tmp;
                totalG += Math.min(tmp, g[i]);
                totalS += Math.min(tmp, s[i]);
            }
            if (total >= a+b && totalG >= a && totalS >= b){
                right = mid;
            }
            else{
                left = mid;
            }
        }
        
        return right;
    }
}