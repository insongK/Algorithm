# 🤖 AI 분석

## 💡 접근 방식

문자열 내 각 문자를 순회하며 마지막 인덱스를 기록, 이전 인덱스로부터의 거리 반환. 해시맵 이용.

## ⏱️ 시간 복잡도

O(N) — 문자열 길이 N을 직접적으로 순회하므로 선형 시간. 각 문자의 인덱스를 저장하고 접근하는 데 상수 시간이 걸림.

## 📦 공간 복잡도

O(K) — K는 문자열 내 서로 다른 문자 수. 해시테이블에 각 문자의 인덱스를 저장.

## 🔧 개선 사항

1) 'map'를 내장 함수명과 같은 이름으로 사용함 → 'index_map'로 변수명 변경
2) 각 문자를 확인하기 전에 미리 append하여 처리 후 'else' 구문 제거 간소화
3) 기본 자료구조의 가변성 고려, 굳이 '-1'이 아닌 None으로 비교하여 증감 여부를 조정 가능
4) 파이썬의 collections.defaultdict 사용할 시, 체크 코드를 간소화할 수 있음

## 🎯 다음 추천 문제

프로그래머스 42576번 - 완주하지 못한 선수 | 해시맵을 이용한 문제 해결을 통해 비슷한 접근 학습.

## 🏷️ 태그

hash-table, implementation

## ✨ 모범 답안

```python
from collections import defaultdict

def solution(s):
    index_map = defaultdict(lambda: -1)
    answer = []
    for i, char in enumerate(s):
        distance = i - index_map[char]
        answer.append(distance if index_map[char] != -1 else -1)
        index_map[char] = i
    return answer
```
