# 🤖 AI 분석

## 💡 접근 방식

주어진 숫자 조합으로 모든 순열을 생성 후, 소수를 판별하여 집합에 추가. 순열 생성을 통해 모든 가능한 숫자를 탐색.

## ⏱️ 시간 복잡도

O(N! * N) — N! 순열 생성에 각 생성된 수에 대해 소수를 판별하는데 O(N) 소모. 다소 비효율적이므로 더 나은 방식 필요.

## 📦 공간 복잡도

O(K) — 소수 저장을 위한 집합(set) 사용으로 공간 소모가 K(소수의 개수)에 비례. 추가적으로 순열 생성을 위한 메모리 공간도 필요.

## 🔧 개선 사항

1) 순열 생성이 아닌 조합을 통해 중복 제거 및 더 효율적인 자료구조 사용. 2) 소수 판별 로직 최적화: 에라토스테네스의 체를 활용. 3) 숫자 조합을 문자열 형태로 직접 parseInt()로 변환하는 비효율성 개선.
간단한 예: set.add(Integer.parseInt(new String(num)+

## 🎯 다음 추천 문제

프로그래머스 12907번 - 합이 같은 부분집합 | 조합의 개념과 소수 판별을 연습할 수 있음.

## 🏷️ 태그

math, implementation, backtracking

## ✨ 모범 답안

```java
import java.util.HashSet;
import java.util.Set;

class Solution {
    Set<Integer> set = new HashSet<>();

    public void check(int n) {
        if (n < 2 || set.contains(n)) return;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return;
        }
        set.add(n);
    }

    public void permute(String str, String prefix) {
        int n = str.length();
        if (!prefix.isEmpty()) {
            check(Integer.parseInt(prefix));
        }

        for (int i = 0; i < n; i++) {
            permute(str.substring(0, i) + str.substring(i + 1), prefix + str.charAt(i));
        }
    }

    public int solution(String numbers) {
        permute(numbers, "");
        return set.size();
    }
}
```
