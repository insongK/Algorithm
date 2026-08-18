# 🤖 AI 분석

## 💡 접근 방식

키맵의 각 문자에 대해 입력된 키 누르는 최소 횟수를 사전으로 저장하고, 목표 문자열에 대해 해당 키를 누르기 위한 총 횟수를 계산.

## ⏱️ 시간 복잡도

O(K + T) — K는 keymap의 전체 문자 수, T는 targets의 전체 문자 수. 각 문자를 단 한 번만 탐색하므로 제한적 시간 소요.

## 📦 공간 복잡도

O(1) — maps는 영어 알파벳(a-z)만 포함하므로 최대 26개 원소를 가진 사전이 사용된다. 입력 크기와 관계없이 메모리가 제한적.

## 🔧 개선 사항

1) `maps.get(k) == None` 대신 `k not in maps` 사용해 가독성 및 성능 개선.
2) 불필요한 초기화 방식 `answer = [0 for i in range(len(targets))]` 대신 for 루프 안에서 초기화하여 중복 제거.
3) 결과를 리스트로 저장하기보다 digits 설정을 통해 단일 값으로 초기화 가능.

## 🎯 다음 추천 문제

프로그래머스 1845번 - 포켓몬 | 조건에 따라 다양한 선택을 학습하고 배열 탐색 연습.

## 🏷️ 태그

implementation

## ✨ 모범 답안

```python
def solution(keymap, targets):
    maps = {}
    for key in keymap:
        for i, k in enumerate(key):
            if k not in maps:
                maps[k] = i + 1
            else:
                maps[k] = min(maps[k], i + 1)

    answer = []
    for target in targets:
        total = 0
        for t in target:
            if t not in maps:
                total = -1
                break
            total += maps[t]
        answer.append(total)

    return answer
```
