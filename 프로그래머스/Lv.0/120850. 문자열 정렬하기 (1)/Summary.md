# 🤖 AI 분석

## 💡 접근 방식

문자열에서 숫자만 추출 후 정렬하여 배열로 반환. 스트림 API 활용한 간결한 접근.

## ⏱️ 시간 복잡도

O(n log n) — 문자 수 n에 대해 필터링 O(n), 정렬 O(n log n) 수행.

## 📦 공간 복잡도

O(n) — 최악의 경우 모든 문자가 숫자인 경우 배열에 n개의 숫자 저장 필요.

## 🔧 개선 사항

1) indexOf 대신 Character.isDigit() 사용하여 가독성 향상. 
2) 정렬 과정 대신 해시맵이나 배열 사용해 0~9 개수를 세고, 최종 결과를 한 번에 조립하면 O(n)으로 가능. 
3) 메모리 사용 최적화를 위해 숫자 개수만큼만 배열 생성.

## 🎯 다음 추천 문제

프로그래머스 12916번 - 신고 결과 받기 | 문자열 처리와 해시맵 활용 문제로 발전적 난이도.

## 🏷️ 태그

array, string, implementation

## ✨ 모범 답안

```java
import java.util.*;

class Solution {
    public int[] solution(String my_string) {
        int[] counts = new int[10];
        for (char c : my_string.toCharArray()) {
            if (Character.isDigit(c)) {
                counts[c - '0']++;
            }
        }
        return IntStream.range(0, 10)
                        .flatMap(i -> IntStream.range(0, counts[i]).map(j -> i))
                        .toArray();
    }
}
```
