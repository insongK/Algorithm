# 🤖 AI 분석

## 💡 접근 방식

전화번호 정렬 후 부분 문자열(prefix) 확인. HashSet으로 빠른 검색으로 중복 판별.

## ⏱️ 시간 복잡도

O(N log N) — Arrays.sort() 사용하여 정렬 비용 O(N log N), 이후 O(N)으로 각 전화번호에 대해 최대 O(K) 비교, K는 전화번호의 최대 길이. 최악의 경우 O(N*(K+log N)).

## 📦 공간 복잡도

O(N) — HashSet에 모든 전화번호를 저장하므로 입력 크기 N에 비례.

## 🔧 개선 사항

1) StringBuilder를 사용하여 substrings을 생성하나, String의 substring()을 직접 사용하는 것이 더 간단합니다. sb.substring(0, i) 대신 phone.substring(0, i). 
2) 중복 검사 시 prefix를 HashSet의 add() 호출 이전에 검사하여 'return true'가 아니라 'return false'로 즉시 종료할 수 있습니다. 3) HashSet에 추가하기 전에 prefix 길이가 i인 경우에만 조건 확인하여 불필요한 반복 제거.

## 🎯 다음 추천 문제

프로그래머스 42578번 - 방금 그 곡 | 문자열 기반 문제로, 사전 정렬 및 부분 문자열 연습 확장.

## 🏷️ 태그

string, hash-table, sorting

## ✨ 모범 답안

```java
import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        Arrays.sort(phone_book);
        HashSet<String> set = new HashSet<>();
        for(String phone : phone_book){
            for(int i = 1; i < phone.length(); i++){
                String prefix = phone.substring(0, i);
                if(set.contains(prefix)) return false;
            }
            set.add(phone);
        }
        return true;
    }
}
```
