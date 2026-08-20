# 🤖 AI 분석

## 💡 접근 방식

이진 탐색을 통해 방어할 수 있는 최대 적의 수를 찾음. 전투에서 소모되는 자원 k를 고려하여 자원이 부족할 경우의 판단.

## ⏱️ 시간 복잡도

O(N log N) — 각 이진 탐색 단계에서 O(N)으로 적의 힘을 계산, 총 log N회의 재귀 호출로 N log N.

## 📦 공간 복잡도

O(N) — sorted()로 정렬된 리스트를 생성하므로 입력 크기에 따라 추가 메모리 소모.

## 🔧 개선 사항

1) 이진 탐색 내 정렬을 피하기 위해 max-heap 사용: 최대 적의 힘을 효율적으로 추출.
2) k와 n을 고려하여 방어 능력 확인을 보다 직관적으로 처리.
예시: heapq 모듈 사용, n과 k 비교하여 방어 여부 쉽게 결정할 수 있도록 개선.

## 🎯 다음 추천 문제

프로그래머스 12985번 - 불량 사용자 | 이진 탐색 및 최적화 문제 해결의 기초로 적합.

## 🏷️ 태그

greedy, binary-search

## ✨ 모범 답안

```python
import heapq

def solution(n, k, enemy):
    if k >= len(enemy):
        return len(enemy)

    max_heap = []
    defeated = 0

    for i, e in enumerate(enemy):
        heapq.heappush(max_heap, e)
        if len(max_heap) > k:
            heapq.heappop(max_heap)
        if sum(max_heap) > n:
            return i
    return len(enemy)
```
