# 🤖 AI 분석

## 💡 접근 방식

스택을 이용하여 괄호 문자열의 유효성을 확인. '('는 스택에 추가하고, ')'가 오면 스택에서 '('를 제거하며 유효성 판단.

## ⏱️ 시간 복잡도

O(N) — 주어진 문자열을 한 번 순회하므로, N은 문자열의 길이이다.

## 📦 공간 복잡도

O(N) — 최악의 경우 모든 '('가 스택에 쌓일 수 있어, 스택 크기가 최대 N까지 증가할 수 있다.

## 🔧 개선 사항

1) stack.poll() 대신 stack.isEmpty()를 이용해 더 직관적으로 비어있는지 확인.
2) return 구문을 줄여 리턴 결과를 바로 return. 마지막 라인을 'return stack.isEmpty()'를 사용하여 가독성 개선.

## 🎯 다음 추천 문제

프로그래머스 42584번 - 주식 가격 | 스택을 활용한 문제로 괄호 문제의 변형으로 연습하기 적합.

## 🏷️ 태그

stack, implementation

## ✨ 모범 답안

```java
import java.util.*;

class Solution {
    boolean solution(String s) {
        ArrayDeque<Character> stack = new ArrayDeque<>();
        
        for (char c : s.toCharArray()) {
            if (c == '(') stack.add(c);
            else {
                if (stack.isEmpty()) return false;
                stack.poll();
            }
        } 
        return stack.isEmpty();
    }
}
```
