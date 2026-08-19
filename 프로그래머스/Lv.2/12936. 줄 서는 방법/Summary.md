# 🤖 AI 분석

## 💡 접근 방식

주어진 n명의 사람을 k번째 순서의 줄 서는 방법을 조합론적으로 계산하여 생성. 팩토리얼을 사용해 각 단계에서 가능한 경우의 수를 정리.

## ⏱️ 시간 복잡도

O(n²) — 각 단계에서 pop() 호출 시 리스트를 이동하는 시간이 O(n)이며, 이를 n번 반복하여 최악의 경우 O(n²) 시간 복잡도.

## 📦 공간 복잡도

O(n) — people 리스트와 결과 저장 리스트를 사용하여 n개의 요소를 유지함. 추가적인 변수를 사용하지 않음.

## 🔧 개선 사항

1) pop() 대신 인덱스를 사용하여 해당 값을 접근하고, 제거를 마지막 요소로 이동 후 pop. 
2) e.g. people[idx], people[idx] = people[-1], people[idx] 호출 후 len(people) -= 1로 효율성 향상. 3) 정답을 join()으로 포맷팅하여 결괏값 문자열 그 자체로 변환.

## 🎯 다음 추천 문제

프로그래머스 12937번 - 짝수와 홀수 | 같은 조합론적 사고를 요하지만, 조건이 더 단순한 문제.

## 🏷️ 태그

math, implementation

## ✨ 모범 답안

```python
from math import factorial

def solution(n, k):
    answer = []
    people = list(range(1, n + 1))
    k -= 1  # 0-indexed로 변환

    for i in range(n, 0, -1):
        f = factorial(i - 1)
        idx = k // f
        answer.append(people[idx])
        people[idx], people[-1] = people[-1], people[idx]
        k %= f
        people.pop()  # 마지막 요소 제거

    return answer
```
