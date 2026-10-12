# 🤖 AI 분석

## 💡 접근 방식

시간을 분 단위로 변환하여 예약 시간을 기록. 겹치는 시간에 대해 10분 여유를 두고 카운트하여 최대 사용 방 개수를 도출.

## ⏱️ 시간 복잡도

O(N * K) — N: 예약 개수, K: 각 예약의 시간 범위 (끝나는 시간까지의 여유). 최악의 경우 K는 10분으로 고정되어, 실질적으로 O(N)로 축소됨.

## 📦 공간 복잡도

O(1) — 배열 크기는 상수(1440)로 고정되어 메모리 증가 없음. 단, 각 방 수를 추적하기 위한 고정 배열 사용.

## 🔧 개선 사항

1) 예약 시간 처리 과정에서 동일한 방 처리 방지를 위해 PriorityQueue를 사용, 각 방의 종료 시간을 관리하기.
2) 방이 필요 없는 시간대는 건너뛰어 불필요한 Iteration 제거.
3) 반복문에서 카운트하는 부분을 Condition으로 묶어 중복할당 최소화.
4) 최댓값 계산을 Array.stream() 대신 루프를 통해서 하여 불필요한 스트림 사용 줄이기.

## 🎯 다음 추천 문제

프로그래머스 12985번 - 점프와 순간이동 | 비슷하게 최적화된 방법으로 문제 해결을 통해 유사한 자료 구조에 대한 이해 심화.

## 🏷️ 태그

greedy, implementation

## ✨ 모범 답안

```java
import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        PriorityQueue<Integer> endTimes = new PriorityQueue<>();
        Arrays.sort(book_time, Comparator.comparing(t -> t[0]));
        for(String[] time : book_time){
            int start_h = Integer.parseInt(time[0].substring(0,2)) * 60;
            int start_m = Integer.parseInt(time[0].substring(3,5));
            int start = start_h + start_m;
            
            int end_h = Integer.parseInt(time[1].substring(0,2)) * 60;
            int end_m = Integer.parseInt(time[1].substring(3,5));
            int end = end_h + end_m + 10;

            while(!endTimes.isEmpty() && endTimes.peek() <= start) {
                endTimes.poll();
            }
            endTimes.offer(end);
        }
        return endTimes.size();
    }
}
```
