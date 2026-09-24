# 🤖 AI 분석

## 💡 접근 방식

HashMap을 이용하여 완료자를 카운트하고, 참가자 배열을 순회하며 미완주자를 찾아 반환하는 방식.

## ⏱️ 시간 복잡도

O(N) — 목록을 한 번씩 순회하므로 입력 크기 N에 선형적으로 비례.

## 📦 공간 복잡도

O(N) — HashMap을 사용하여 최대 N명의 참가자를 저장.

## 🔧 개선 사항

1) HashMap 사용 대신 정렬 후 participant와 completion을 비교하는 방식으로 단순화 가능. 
2) completion 배열로 HashMap 대신 Boolean 배열을 사용해 소모 메모리 감소 가능.
3) 불필요한 System.out.println() 주석 제거.

예시 개선 코드:
- Arrays.sort(participant);
- Arrays.sort(completion);
- 비교 루프 등

## 🎯 다음 추천 문제

프로그래머스 42577번 - 위장 | 해시를 활용한 문제로, 조합 및 카운팅 개념을 추가로 학습할 수 있는 문제.

## 🏷️ 태그

hash-table, sorting

## ✨ 모범 답안

```java
import java.util.Arrays;

class Solution {
    public String solution(String[] participant, String[] completion) {
        Arrays.sort(participant);
        Arrays.sort(completion);
        for (int i = 0; i < completion.length; i++) {
            if (!participant[i].equals(completion[i])) {
                return participant[i];
            } 
        } 
        return participant[participant.length - 1];
    }
}
```
