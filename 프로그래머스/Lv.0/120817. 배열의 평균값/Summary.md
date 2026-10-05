# 🤖 AI 분석

## 💡 접근 방식

주어진 정수 배열의 합을 스트림을 통해 계산하고, 이를 배열의 길이로 나누어 평균을 구함.

## ⏱️ 시간 복잡도

O(N) — 배열의 모든 요소를 합치기 위해 N번 순회해야 하며, N은 배열의 크기.

## 📦 공간 복잡도

O(1) — 추가적인 자료구조 없이 상수 공간에서 처리.

## 🔧 개선 사항

입력 배열이 비어있을 경우, 0으로 나누는 에러를 방지하는 조건문 추가. 예시: if (numbers.length == 0) return 0.0;

## 🎯 다음 추천 문제

프로그래머스 120818번 - 배열의 중앙값 | 평균값 계산에서 중앙값 계산으로 나아가며 배열 처리 연습.

## 🏷️ 태그

array, implementation

## ✨ 모범 답안

```java
import java.util.*;

class Solution {
    public double solution(int[] numbers) {
        if (numbers.length == 0) return 0.0;
        return (double)Arrays.stream(numbers).sum() / numbers.length;
    }
}
```
