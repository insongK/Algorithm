# 🤖 AI 분석

## 💡 접근 방식

이진 탐색을 활용하여 특정 라운드까지의 적을 무찌르는지 판별. 각 라운드 전투력을 정렬하여 합계를 계산.

## ⏱️ 시간 복잡도

O(N log N) — N은 enemy의 길이. 이진 탐색에서 매 라운드마다 최대 O(N log N)의 정렬 작업 발생. 하지만 k가 상대적으로 작은 경우는 효율적이므로 개선 필요.

## 📦 공간 복잡도

O(N) — 적의 리스트에 대한 별도의 가공 작업으로 인한 공간 사용. 소요되지 않은 공간을 줄일 방법이 있음.

## 🔧 개선 사항

1) bst 함수에서 sorted() 대신 힙 구조를 사용하여 적의 방어력을 더 효율적으로 관리
2) k만큼 최상위 적을 0처리할 필요 없이 필요 시 배열에서 제거
3) 중복 코드 제거 및 가독성을 위해 변수명을 명확하게 개선

## 🎯 다음 추천 문제

프로그래머스 12985번 - 예상 대진표 | 같은 구조의 전투를 다루며, 승패 로직을 중점적으로 연습하는 문제.

## 🏷️ 태그

binary-search, greedy

## ✨ 모범 답안

```python
import heapq

def solution(n, k, enemy):
    if k >= len(enemy):
        return len(enemy)
    
    left, right = 0, len(enemy)
    while left < right:
        mid = (left + right + 1) // 2
        total_enemy = enemy[:mid]
        if len(total_enemy) > k:
            largest_enemies = heapq.nlargest(k, total_enemy)
            if sum(total_enemy) - sum(largest_enemies) <= n:
                left = mid  # 더 많은 라운드를 진행 가능
            else:
                right = mid - 1  # 더 적은 라운드 필요
        else:
            left = mid
    return left
```
