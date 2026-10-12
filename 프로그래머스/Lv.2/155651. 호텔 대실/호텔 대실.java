import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        int N = book_time.length;
        int[] room = new int[1450];
        
        for(String[] time : book_time){
            int start_h = Integer.parseInt(time[0].substring(0,2)) * 60;
            int start_m = Integer.parseInt(time[0].substring(3,5));
            int start = start_h + start_m;
            // System.out.print(start_h + start_m + " ");
            
            int end_h = Integer.parseInt(time[1].substring(0,2)) * 60;
            int end_m = Integer.parseInt(time[1].substring(3,5));
            int end = end_h + end_m + 10;
            // System.out.println(end_h + end_m);
            
            for(int i = start; i < end; i++){
                room[i]++;
            }
        }
        
        return Arrays.stream(room).max().orElse(0);
    }
}

/*

book time <= 1000

시간을 분으로 치환해서 인덱스로 활용 00:00 -> 0 ~ 23:59 -> 1439 0~1440
방이 1개일때부터 N개일때 까지 반복:
    
    
일단 느낌이 1440 배열 만들고, 예약되어 있는 구간 +1씩 하면 그 중 가장 큰 수가 최소로 필요한 방의 개수 일거 같음.

*/