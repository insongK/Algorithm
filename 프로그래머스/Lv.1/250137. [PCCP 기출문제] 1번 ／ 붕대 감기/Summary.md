# 🤖 AI 분석

## 💡 접근 방식

우선순위 큐를 사용하여 공격 순서대로 처리하고, 매 공격 전 주어진 시간에 따라 체력을 회복하는 방식.

## ⏱️ 시간 복잡도

O(N log N) — N개의 공격을 우선순위 큐에 추가하고 처리하는 과정에서 O(log N)의 시간 복잡도 발생.

## 📦 공간 복잡도

O(N) — 우선순위 큐에 공격 정보를 모두 저장하며, 입력 배열과 PQ 자료구조에서 N 크기를 차지함.

## 🔧 개선 사항

1) 변수의 명확한 이름 사용: heal 변수보다 hpRecovery가 의미 전달이 더 좋음.
2) PQ 외에도 공격 동작을 반복하면서 time 변수를 제외한 로직을 깔끔하게 정리.
3) 출력문 debug용으로 제거: 최종 코드를 깔끔하게 유지하기 위해.

## 🎯 다음 추천 문제

프로그래머스 144850번 - 연속 부분 수열 합의 개수 | 배열을 사용하여 부분 합을 처리하고 우선순위 큐를 응용하는 문제.

## 🏷️ 태그

implementation, math

## ✨ 모범 답안

```java
import java.util.*;

class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = 0;
        int t = bandage[0], x = bandage[1], y = bandage[2];
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        Collections.addAll(pq, attacks);
         
        int time = 0, currentHealth = health;
         
        while(!pq.isEmpty()){
            int[] attack = pq.poll();
             
            int recoverTime = attack[0] - time - 1;
            int hpRecovery = recoverTime * x;
            hpRecovery += recoverTime / t > 0 ? (recoverTime / t) * y : 0;
            time = attack[0];
             
            currentHealth = Math.min(health, currentHealth + hpRecovery);
            currentHealth -= attack[1];
            if(currentHealth <= 0) return -1;
        }
         
        return currentHealth;
    }
}
```
