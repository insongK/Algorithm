# 🤖 AI 분석

## 💡 접근 방식

주어진 점수를 정렬 후 일정 묶음(m)의 최소 점수를 고려하여 총 점수 계산. 반복문으로 묶음마다 적립.

## ⏱️ 시간 복잡도

O(N log N) — 점수 정렬에 O(N log N) 소요, 그 후 O(N)로 묶음 합산. 전체는 정렬이 지배.

## 📦 공간 복잡도

O(1) — 정렬은 제자리(제자리 정렬)로 수행, 추가적인 메모리 사용 없음.

## 🔧 개선 사항

1) Python의 sort 메소드는 안정 정렬이므로, 필요한 경우 안정성을 보장하며 최적화 없이 정렬 가능.
2) score 배열의 길이를 반복문 사용 시 매번 계산 없이 조건문에 넣어 체크하면 약간의 성능 향상 가능 (예: 여러 번 index 계산을 피하기).

## 🎯 다음 추천 문제

프로그래머스 12982번 - 예산 | 정렬 및 그룹핑 개념을 활용한 다음 단계 문제로, 묶음 처리 연습.

## 🏷️ 태그

array, sort

## ✨ 모범 답안

```python
def solution(k, m, score):
    answer = 0
    score.sort(reverse=True)
    n = len(score)
    for i in range(0, n, m):
        if i + m <= n:
            answer += m * score[i + m - 1]  # 최소 점수
    return answer
```
