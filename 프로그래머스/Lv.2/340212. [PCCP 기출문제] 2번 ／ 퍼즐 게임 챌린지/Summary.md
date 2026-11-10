# 🤖 AI 분석

## 💡 접근 방식

이진 탐색으로 가능한 level을 찾으며, 각 level에서 소요되는 총 시간을 계산해 제한 시간과 비교하여 최솟값을 구함.

## ⏱️ 시간 복잡도

O(N log M) — N은 퍼즐의 수, M은 최대 diff로 이진 탐색 과정에서 N을 사용하는 시점이 존재한다.

## 📦 공간 복잡도

O(1) — 추가적인 자료구조 없이 몇 개의 변수만 사용하여 공간 요구 없음.

## 🔧 개선 사항

1) 중복된 total 초기화 및 level 계산을 loop 밖으로 이동하여 매 iteration 불필요한 연산을 줄임.
2) 효율적인 값을 더 빨리 찾기 위해 level의 갱신을 조건문으로 처리.
3) 배열이 크므로 총 시간 계산을 직관적으로 고치고 적절한 에러 처리를 추가하여 가독성 향상.

## 🎯 다음 추천 문제

프로그래머스 43238번 - 입국심사 | 이진 탐색을 활용하여 간단한 시간 계산 문제를 푸는 연습.

## 🏷️ 태그

binary-search, implementation

## ✨ 모범 답안

```java
class Solution {
	public int solution(int[] diffs, int[] times, long limit) {
		int MAX_DIFF = 0;
		for(int diff: diffs) MAX_DIFF = Math.max(MAX_DIFF, diff);
		int start = 1, end = MAX_DIFF, answer = 100000;
		while(start <= end){
			int level = (start + end) / 2;
			long total = 0;
			for(int i = 0; i < diffs.length; i++){
				if(diffs[i] <= level){
					total += times[i];
				}else{
					int miss = diffs[i] - level;
					total += miss * (times[i - 1] + times[i]) + times[i];
				}
			}
			if(total > limit) start = level + 1;
			else {
				end = level - 1;
				answer = Math.min(answer, level);
			}
		}
		return answer;
	}
}
```
