# 🤖 AI 분석

## 💡 접근 방식

다양한 배수를 생성하여 0-9 숫자가 모두 등장할 때까지 탐색하고 출력하는 반복 구조.

## ⏱️ 시간 복잡도

O(K) — N의 배수로 K번째 숫자에서 0-9를 모두 포함할 때 종료. 평균적으로 K는 10~90 사이일 수 있으며 최악은 10N. 범위가 크면 최악의 경우라도 K는 제한적.

## 📦 공간 복잡도

O(1) — 고정 크기 boolean 배열만 사용, 추가 메모리 사용 없음.

## 🔧 개선 사항

1) 불필요한 내부 반복 감소 - num 배열을 매 테스트 케이스마다 초기화할 필요는 없음. 초기화는 명시적으로 하여 상태를 청소.
2) 배수를 생성하여 체크할 때, 0-9 모두 검사 이후, i와 num 배열을 확장하는 방향으로 개선 가능.
3) I/O 속도 개선 - Scanner 대신 BufferedReader를 사용할 수 있습니다.

## 🎯 다음 추천 문제

SWEA 1209번 - Sum | 숫자 배열을 다루는 기본적인 합산 문제로 개선 실습 목록.

## 🏷️ 태그

math, implementation

## ✨ 모범 답안

```java
import java.io.BufferedReader;
import java.io.InputStreamReader;

class Solution {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            int N = Integer.parseInt(br.readLine());
            boolean[] num = new boolean[10];
            int count = 0;
            for (int i = N; ; i += N) {
                String s = String.valueOf(i);
                for (char c : s.toCharArray()) {
                    num[c - '0'] = true;
                }
                count += s.length();
                if (++count >= 10) {
                    boolean allPresent = true;
                    for (boolean e : num) if (!e) allPresent = false;
                    if (allPresent) {
                        System.out.printf("#%d %d\n", test_case, i);
                        break;
                    }
                }
            }
        }
    }
}
```
