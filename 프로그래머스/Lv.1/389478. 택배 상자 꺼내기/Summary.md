# 🤖 AI 분석

## 💡 접근 방식

주어진 상자 수와 너비에 따라 특정 규칙으로 상자를 꺼내는 과정 시뮬레이션. 주기적인 꺼내는 수치를 계산해 계속 더함.

## ⏱️ 시간 복잡도

O(N) — 상자를 꺼내는 과정에서 num가 n을 초과하는 수까지 반복적으로 계산하므로 최악의 경우 O(N) 시간. 간단한 규칙을 도출하면서 반복을 줄일 수 있음.

## 📦 공간 복잡도

O(1) — 입력 수와 상관없이 사용되는 변수 수가 고정되어 메모리 사용이 일정.

## 🔧 개선 사항

1) 상자를 꺼내는 주기를 활용하여 필요 계산을 줄인다.
2) 반복문을 제외하고 공식으로 구할 수 있는 밑바탕을 찾아 계산 간소화. 
3) while 대신 단순 수학 계산으로 정답을 구할 수 있다. 

예시: k = (num-1) // (cnt_1 + cnt_2); return 2*k + (num-k*(cnt_1+cnt_2)) // (cnt_1 if k%2==0 else cnt_2)

## 🎯 다음 추천 문제

프로그래머스 67256번 - 키패드 누르기 | 좌표계를 생각하며 특정 계산과 시뮬레이션을 다루는 중간 단계 문제.

## 🏷️ 태그

simulation, math, greedy

## ✨ 모범 답안

```python
def solution(n, w, num):
    mod = num % w
    if mod == 0:
        mod = w
    cnt_1 = 2 * w - 1 - 2 * (mod - 1)
    cnt_2 = 1 + 2 * (mod - 1)

    # number of full cycles of cnt_1 and cnt_2
    k = (num - 1) // (cnt_1 + cnt_2)
    remaining = (num - 1) % (cnt_1 + cnt_2)

    # result calculation
    answer = 2 * k + (remaining // (cnt_1 if k % 2 == 0 else cnt_2))
    return answer
```
