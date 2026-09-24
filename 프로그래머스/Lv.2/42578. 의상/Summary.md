# 🤖 AI 분석

## 💡 접근 방식

의상 종류별로 개수를 세어 경우의 수 계산. 각 종류의 의상 수 + 1을 곱하고 1을 빼는 방식으로 경우의 수 도출.

## ⏱️ 시간 복잡도

O(N) — 의상의 종류별 개수를 세는데 한 번만 순회하고, 그 후 각 종류만큼 연산하므로 전체적으로 입력 크기 N에 비례.

## 📦 공간 복잡도

O(K) — K는 의상의 종류 수. HashMap과 결과 배열을 사용해 의상 종류 수에 비례하는 공간 요구.

## 🔧 개선 사항

1) HashMap 대신 ArrayList를 사용해 인덱스 기반으로 의상 수를 관리하여 추가 메모리 절약 가능.
2) 결과 계산 시, HashMap의 직접 접근을 피하고 forEach 활용하여 코드 단순화.
3) `result`에 대한 크기 제한을 명확하게 (예: 최대 30개)
4) 중복된 주석 제거.

## 🎯 다음 추천 문제

프로그래머스 42860번 - 조이스틱 | 문자열 조작 필요 문제로, 문자별 조합 계산 확장 및 성능 향상 필요.

## 🏷️ 태그

hash-table, implementation

## ✨ 모범 답안

```java
import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        Map<String, Integer> countMap = new HashMap<>();
        
        for (String[] cloth : clothes) {
            countMap.put(cloth[1], countMap.getOrDefault(cloth[1], 0) + 1);
        }
        
        for (int count : countMap.values()) {
            answer *= (count + 1);
        }
        
        return answer - 1;
    }
}
```
