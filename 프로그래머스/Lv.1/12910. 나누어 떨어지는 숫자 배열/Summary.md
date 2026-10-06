# 🤖 AI 분석

## 💡 접근 방식

배열 요소 필터링 후 정렬하여 결과를 반환하는 스트림 기반 접근 방식.

## ⏱️ 시간 복잡도

O(N log N) — N개의 요소를 필터링한 뒤 정렬하므로, 필터링 O(N), 정렬 O(N log N) 총합.

## 📦 공간 복잡도

O(N) — 필터링을 통해 최대 N개 요소를 저장하는 결과 배열을 생성 따라서 최악 시 O(N).

## 🔧 개선 사항

1) 새로운 배열 생성 없이 직접 리스트에 추가해 메모리 사용 최적화 가능; 2) 정렬을 필터링 후에 수행하되, 정렬 순서를 유지하기 위해 Comparator를 사용할 수 있음.

## 🎯 다음 추천 문제

프로그래머스 12911번 - 다음 큰 숫자 | 배열을 다루는 문제로, 최적화 및 조건 부여 연습에 적합.

## 🏷️ 태그

array, sorting

## ✨ 모범 답안

```java
import java.util.*;

class Solution {
    public int[] solution(int[] arr, int divisor) {
        List<Integer> list = new ArrayList<>();
        for (int num : arr) {
            if (num % divisor == 0) {
                list.add(num);
            }
        }
        if(list.isEmpty()) return new int[]{-1};
        return list.stream().sorted().mapToInt(i -> i).toArray();
    }
}
```
