# 🤖 AI 분석

## 💡 접근 방식

대기 작업을 요청 시간 순으로 처리, 우선순위 큐를 사용해 짧은 작업을 우선적으로 실행.

## ⏱️ 시간 복잡도

O(N log N) — 작업 수 N을 정렬하는 과정이 O(N log N) 걸리며, 각 작업을 우선순위 큐에 넣고 빼는 과정에서도 O(log N) 소요.

## 📦 공간 복잡도

O(N) — 우선순위 큐와 대기 큐를 유지하기 위해 최대 N개의 작업을 저장하므로 O(N) 공간 필요.

## 🔧 개선 사항

1) 코드 반복 제거: waitQ에서 꺼낸 후 pq에 추가하는 부분을 메소드로 분리하여 코드 간결화.
2) 주석을 명확하게 수정하고 불필요한 System.out.println() 코드 제거.
3) 전반적인 가독성을 위한 변수명 개선 및 중복 코드 제거.

## 🎯 다음 추천 문제

프로그래머스 42626 - 힙: 더 맵게 | 힙을 사용하는 문제로, 우선순위 큐와 비슷한 구조에서 조작 연습을 통해 연습 강화.

## 🏷️ 태그

heap, implementation

## ✨ 모범 답안

```java
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class DiskController {
    public int solution(int[][] jobs) {
        Arrays.sort(jobs, (a, b) -> Integer.compare(a[0], b[0]));
        Queue<int[]> waitQ = new LinkedList<>(Arrays.asList(jobs));
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] == b[2] ? Integer.compare(a[0], b[0]) : Integer.compare(a[2], b[2]));
        int answer = 0, time = 0;

        while (!waitQ.isEmpty() || !pq.isEmpty()) {
            addAvailableTasks(waitQ, pq, time);

            if (!pq.isEmpty()) {
                int[] task = pq.poll();
                time += task[2];
                answer += (time - task[1]);
            } else {
                time++;
            }
        }
        return answer / jobs.length;
    }

    private void addAvailableTasks(Queue<int[]> waitQ, PriorityQueue<int[]> pq, int time) {
        while (!waitQ.isEmpty() && waitQ.peek()[1] <= time) {
            pq.offer(waitQ.poll());
        }
    }
}
```
