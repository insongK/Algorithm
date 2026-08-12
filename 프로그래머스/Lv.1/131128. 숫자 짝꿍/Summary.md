# 🤖 AI 분석

## 💡 접근 방식

문자열 X, Y의 각 숫자를 카운트하여 공통된 숫자를 찾고, 큰 자리부터 조합하여 반환하는 방식.

## ⏱️ 시간 복잡도

O(N) — 입력 길이에 비례하여 각 문자열을 한 번씩 돌며 숫자 카운트와 결과 생성, N은 문자열의 길이. 최악 경우 O(10)인 숫자 비교는 무시가능.

## 📦 공간 복잡도

O(1) — 숫자 카운트를 위한 고정 크기 배열(길이 10) 사용, 입력 길이에 비례하지 않음.

## 🔧 개선 사항

1) StringBuilder의 append 호출을 최소화하기 위해 공통된 숫자를 한 번에 추가. StringBuilder 대신 직접 char 배열로 결과를 구성 후 문자열로 변환도 고려.
2) 출력이 -1인 경우를 문자열 조작이 아닌, 최소 1회만 처리할 수 있도록 구조 변경.
3) 불필요한 메모리 할당 방지를 위해 결과 문자열 생성 시 큰 자리부터 배정하도록 정렬하여 구성.

## 🎯 다음 추천 문제

프로그래머스 67256번 - 키패드 누르기 | 각 숫자의 거리 계산 및 조건 부합 여부를 다루는 문제 형식으로 감각을 익힐 수 있음.

## 🏷️ 태그

implementation

## ✨ 모범 답안

```java
import java.util.*;

class Solution {
    public String solution(String X, String Y) {
        int[] x_cnt = new int[10];
        int[] y_cnt = new int[10];
        StringBuilder sb = new StringBuilder();
        
        for (char ch : X.toCharArray()) x_cnt[ch - '0']++;
        for (char ch : Y.toCharArray()) y_cnt[ch - '0']++;
        
        for (int i = 9; i >= 0; i--) {
            int min = Math.min(x_cnt[i], y_cnt[i]);
            if (min > 0) {
                if (i == 0 && sb.length() == 0) return "0";
                for (int j = 0; j < min; j++) sb.append(i);
            }
        }
        return sb.length() == 0 ? "-1" : sb.toString();
    }
}
```
