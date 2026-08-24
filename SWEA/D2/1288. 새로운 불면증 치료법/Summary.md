# 🤖 AI 분석

## 💡 접근 방식

불면증 극복을 위해 N의 배수로 증가하며 숫자 체크. 모든 자릿수를 포함하는 최소 값을 찾는 중첩 루프 사용.

## ⏱️ 시간 복잡도

O(10 * (k/N)) — k는 자릿수 모두 포함되기까지의 총 증가량. 최악의 경우 한 숫자가 모두 나올 때까지 반복하므로, N의 배수가 10의 자릿수를 찾는데 걸리는 시간은 상대적으로 정적.

## 📦 공간 복잡도

O(1) — boolean 배열 num(크기 10)만 필요. 추가 공간은 상수로 고정됨.

## 🔧 개선 사항

1) boolean[] 배열 초기화: 각 테스트 케이스마다 초기화해야 하므로 loop 내에서 num 배열을 초기화. 
2) 10개의 숫자가 발견되었을 때의 break 로직을 단순화: ArrayList 등으로 대체하여 정리 및 유지 보수 용이.

## 🎯 다음 추천 문제

SW Expert Academy 1289번 - 두 개의 숫자 | 비슷한 숫자 판별 로직을 연습하며, 배열 사용 및 처리 로직을 확장할 수 있는 문제.

## 🏷️ 태그

implementation

## ✨ 모범 답안

```java
import java.util.Scanner;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			boolean[] num = new boolean[10];
			int i = N;
			while (true) {
				String s = String.valueOf(i);
				for (char c : s.toCharArray()) {
					num[c - '0'] = true;
				}
				boolean allFound = true;
				for (boolean e : num) {
					if (!e) {
						allFound = false;
						break;
					}
				}
				if (allFound) {
					System.out.printf("#%d %d\n", test_case, i);
					break;
				}
				i += N;
			}
		}
	}
}
```
