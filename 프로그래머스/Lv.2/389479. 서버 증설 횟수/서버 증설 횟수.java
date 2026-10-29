import java.util.*;

class Solution {
    public int solution(int[] players, int m, int k) {
        int[] available = new int[24];
        Arrays.fill(available, m - 1);
        
        int answer = 0;
        for(int i = 0; i < 24; i++){
            if(players[i] <= available[i]) continue;
            int vol = players[i] - available[i];
            if(vol % m == 0){
                int nk = i + k;
                if(nk < 24){
                    for(int j = i; j < nk; j++){
                        available[j] += vol;
                    }
                }else{
                    for(int j = i; j < 24; j++){
                        available[j] += vol;
                    }
                }
                answer += vol / m;
            }else{
                int nk = i + k;
                if(nk < 24){
                    for(int j = i; j < nk; j++){
                        available[j] += (vol / m + 1) * m;
                    }
                }else{
                    for(int j = i; j < 24; j++){
                        available[j] += (vol / m + 1) * m;
                    }
                }
                answer += vol / m + 1;
            }
            
        }
        return answer;
    }
}

/*
m명이 늘어날 때마다, 서버 1대 추가 어느 시간대 m명 미만 서버 증설 X

n * M 명이상 n+1 * m 미만 최소 n대의 증설 k 시간동안 운영
k = 5

풀이 방법 24개 배열 만듬

*/