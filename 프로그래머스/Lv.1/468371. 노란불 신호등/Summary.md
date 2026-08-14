# 🤖 AI 분석

## 💡 접근 방식

주어진 신호등 주기를 계산하여 각 초에 신호등의 수를 세고 모든 신호등이 노란불일 때의 최솟값을 찾는 방식.

## ⏱️ 시간 복잡도

O(max_val * N) — max_val은 모든 신호 주기의 합으로 신호 수(N)에 따라 최대 O(N²) 시나리오 발생. N~상대적으로 작은 수일 경우 효율적.

## 📦 공간 복잡도

O(max_val) — 상태 추적용 리스트 생성에 max_val 공간 할당.

## 🔧 개선 사항

1) 노란불 계산 효율화: 각 신호에 대해 주기를 직접 계산하여 반복하지 않고 직접 인덱스를 업데이트할 수 있음.
2) 최종적으로 노란불 카운팅 시 별도의 리스트보다 더 간결하게 배정할 수 있음.

## 🎯 다음 추천 문제

프로그래머스 12987 - 수열과 구간 쿼리 | 비슷한 주기로 여러 조건을 평가하고 순차적인 판단을 요하는 문제.

## 🏷️ 태그

implementation, math

## ✨ 모범 답안

```python
def solution(signals):
    periods = [sum(signal) for signal in signals]
    max_val = math.prod(periods)

    total_Y_time = [0] * max_val
    for G, Y, R in signals:
        k = 0
        while k < max_val:
            start = k + G
            end = start + Y
            if start < max_val:
                total_Y_time[start:end] = [x + 1 for x in total_Y_time[start:end]]
            k += G + R

    for idx in range(max_val):
        if total_Y_time[idx] == len(signals):
            return idx + 1

    return -1
```
