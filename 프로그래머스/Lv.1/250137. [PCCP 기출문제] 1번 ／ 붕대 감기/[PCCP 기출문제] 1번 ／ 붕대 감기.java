import java.util.*;

class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = 0;
        int t = bandage[0], x = bandage[1], y = bandage[2];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        for(int[] attack:attacks) pq.offer(attack);
        
        int time = 0, ch = health;
        while(!pq.isEmpty()){
            int[] info = pq.poll();
            
            int heal = (info[0] - time - 1) * x;
            heal += ((info[0] - time - 1) / t > 0) ? ((info[0] - time - 1) / t) * y : 0;
            time = info[0];
            
            int nh = ch + heal;
            ch = (nh > health) ? health : nh;
            System.out.println(ch + " " + info[1]);
            ch -= info[1];
            if(ch <= 0) return -1;
        }
        
        return ch;
    }
}

/*

붕대 감기 t초 1초마다 x만큼 회복
t초 연속으로 하면 y만큼 체력 추가 회복
최대체력이 현재 체력이 최대 체력 불가

공격당하면 기술 취소
붕대 감기 0으로 초기화

공격 시간순 pq

시간, 체력
while pq is Empty
    pq.poll
    
    


```

*/