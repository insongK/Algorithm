# 🤖 AI 분석

## 💡 접근 방식

주어진 문자열을 다양한 크기로 압축하여 최소 압축 길이를 계산. 주기(size)별로 문자열을 나누어 각각 비교 후 압축.

## ⏱️ 시간 복잡도

O(N^2) — 최대 N번을 루프하고, 각 압축 크기(size)마다 최대 N번의 문자열 슬라이싱을 수행. 전체 반복 및 슬라이싱 계산으로 N의 제곱 성능.

## 📦 공간 복잡도

O(N) — 압축된 문자열을 생성하기 위해 새로운 문자열을 만들어 저장하므로 최악의 경우 N만큼 필요.

## 🔧 개선 사항

1) 문자열 연결 시 불변 객체인 문자열을 사용하는 대신 리스트에 저장 후 join()으로 한번에 연결.
2) 압축 공정에 불필요한 계산 감소 및 중복 최소화: 이미 압축 길이가 최소일 경우 판별 및 중단.
3) count > 1 판별을 하나의 조건문에 통합 가능.

## 🎯 다음 추천 문제

프로그래머스 60058번 - 괄호 변환 | 문자열 조작의 복잡함을 이해하고 다른 유형의 문제로 확장하는 기회.

## 🏷️ 태그

string, implementation

## ✨ 모범 답안

```python
def solution(s):
    answer = len(s)
    for size in range(1, len(s) // 2 + 1):
        compressed = []
        prev = s[0:size]
        count = 1
        for i in range(size, len(s), size):
            cur = s[i:i+size]
            if cur == prev:
                count += 1
            else:
                compressed.append((str(count) if count > 1 else '') + prev)
                prev = cur
                count = 1
        compressed.append((str(count) if count > 1 else '') + prev)
        compressed_length = len(''.join(compressed))
        answer = min(answer, compressed_length)
    return answer
```
