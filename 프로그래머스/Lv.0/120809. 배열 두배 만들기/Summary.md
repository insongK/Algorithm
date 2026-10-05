# 🤖 AI 분석

## 💡 접근 방식

주어진 배열의 모든 요소를 2배로 변환하여 새로운 배열로 반환하는 스트림 기반 솔루션.

## ⏱️ 시간 복잡도

O(N) — numbers 배열의 모든 요소(N개)를 순회하면서 2배 연산을 수행하므로 선형 시간 복잡도.

## 📦 공간 복잡도

O(N) — 입력 배열과 같은 크기의 새로운 배열을 생성하여 반환하므로 추가 공간 사용이 N.

## 🔧 개선 사항

1) Java 8 스트림의 경우 성능이 떨어질 수 있으니 전통적인 for 루프 사용해 성능 향상 가능.
2) 불필요한 람다 표현식을 피하고 기본 for문을 사용해 가독성과 성능 개선.
3) return 문을 즉시 사용하기보다 변수를 통해 명시적으로 작성해 가독성 개선.

## 🎯 다음 추천 문제

프로그래머스 120810 - 배열 세배 만들기 | 연산을 다양화하며 유사한 문제 훈련.

## 🏷️ 태그

array, implementation

## ✨ 모범 답안

```java
class Solution {
    public int[] solution(int[] numbers) {
        int[] result = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            result[i] = numbers[i] * 2;
        }
        return result;
    }
}
```
