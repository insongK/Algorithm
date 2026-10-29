# 🤖 AI 분석

## 💡 접근 방식

주어진 플레이어 수로 서버의 부하를 계산하고, 일정 조건에 따라 서버를 증설하는 구조. 24시간 시간대별 관리.

## ⏱️ 시간 복잡도

O(24 * k) — 24시간을 순회하며 각 시간대에서 k 길이의 범위 내에서 서버 부하를 관리. k는 상수로 취급하면 O(1)로 상수 시간에 완료.

## 📦 공간 복잡도

O(24) — 고정된 크기의 배열을 사용하므로 공간 복잡도는 O(1)과 같음.

## 🔧 개선 사항

1) 중복 코드 제거: `nk` 변수 및 관련 범위 업데이팅 로직을 메서드로 분리.
2) 조건문을 정리하여 가독성을 높이고 유지보수성 향상.
3) `available` 배열을 업데이트하는 로직을 별도의 함수로 분리하여 코드의 모듈화 및 재사용성 증가.

## 🎯 다음 추천 문제

프로그래머스 42862번 - 양궁 대회 | 비슷한 조건에서 최적의 결과를 계산하는 문제로 연습.

## 🏷️ 태그

implementation

## ✨ 모범 답안

```java
import java.util.*;

class Solution {
    public int solution(int[] players, int m, int k) {
        int[] available = new int[24];
        Arrays.fill(available, m - 1);
        int answer = 0;

        for(int i = 0; i < 24; i++) {
            if(players[i] <= available[i]) continue;
            int vol = players[i] - available[i];
            int increment = (vol / m) + (vol % m == 0 ? 0 : 1);
            updateAvailable(available, vol, m, i, k);
            answer += increment;
        }
        return answer;
    }

    private void updateAvailable(int[] available, int vol, int m, int start, int k) {
        int nk = Math.min(24, start + k);
        for(int j = start; j < nk; j++) {
            available[j] += (vol / m + (vol % m == 0 ? 0 : 1)) * m;
        }
    }
}
```
