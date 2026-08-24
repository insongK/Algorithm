# 🤖 AI 분석

## 💡 접근 방식

N의 배수를 차례로 계산하며 각 배수의 모든 숫자를 체크해 0부터 9까지의 모든 숫자를 포함하면 결과를 출력하는 방식.

## ⏱️ 시간 복잡도

O(K) — N의 배수를 K번 확인하며, 각 확인에서 최대 10의 숫자를 체크. K는 가장 작은 N의 배수로, 일반적으로 O(N)지만 최악의 경우 N이 매우 클 경우 만일 0-9까지의 모든 숫자가 나오기 위한 경우는 이론상 O(∞).

## 📦 공간 복잡도

O(10) — 고정 크기의 boolean 배열을 사용하므로 O(1) 공간, 대략 상수 크기.

## 🔧 개선 사항

1) boolean 배열을 매번 초기화하지 않고, 필요한 경우만 초기화. 2) 배수가 꼭 10까지 채우기 위해 큰 수까지 계산될 필요 없어, 초기값 확인 이후 break 조건을 명확히. 3) System.out.printf보다 StringBuilder를 사용해 최종 결과를 한 번에 출력하는 것이 성능에 이점이 있음.

## 🎯 다음 추천 문제

SWEA 1289번 - 원재의 메모리 복구하기 | 대량 데이터 처리 및 추가 메모리에 대한 연산을 연습.

## 🏷️ 태그

implementation

## ✨ 모범 답안

```java
import java.util.Scanner;

class Solution {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            int N = sc.nextInt();
            boolean[] num = new boolean[10];
            int count = 0;
            int i = N;

            while (count < 10) {
                String s = String.valueOf(i);
                for (char c : s.toCharArray()) {
                    if (!num[c - '0']) {
                        num[c - '0'] = true;
                        count++;
                    }
                }
                i += N;
            }
            System.out.printf("#%d %d\n", test_case, i - N);
        }
    }
}
```
