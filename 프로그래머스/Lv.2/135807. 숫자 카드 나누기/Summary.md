# 🤖 AI 분석

## 💡 접근 방식

최대 공약수(GCD)를 이용해 두 배열에서 각각의 GCD를 계산 후, 각 GCD의 모든 약수 비교하여 카드 분배 가능한 숫자 찾기.

## ⏱️ 시간 복잡도

O(N * log(min(A, B))) — GCD 계산에 log를 사용하며, N개의 요소에 대해 GCD를 반복 계산. 약수 찾기는 O(X) (X: GCD의 크기)로 간주할 수 있으나, 총 시간복잡도에 GCD의 계산가도 포함됨.

## 📦 공간 복잡도

O(N) — 입력 배열 외 별도의 큐를 사용해 최대 공약수의 약수를 저장, 동시에 GCD가 배열 길이를 초과하지 않아 배열 크기의 선형 메모리 사용.

## 🔧 개선 사항

1) GCD는 최적 클래스를 활용해 반복적이며 비효율적인 기능 호출 없이 해결.
2) 약수 찾기를 좀 더 간단하게 할 수 있는 방법으로 N의 제곱근까지만 반복: for(int i = 1; i * i <= GCD; i++) 방식을 써서 i가 GCD의 약수일 시 추가로 GCD/i도 추가.
3) 리턴 값과 직접적으로 연관된 반복적인 작업의 제거.
4) GCD 계산을 한 번에 묶어서 처리해 효율성 증가.

## 🎯 다음 추천 문제

프로그래머스 120887번 - 두수의 합(기본적인 수학적 문제) | GCD와 약수 개념 심화 및 배열 문제를 간단하게 배우기.

## 🏷️ 태그

math, implementation

## ✨ 모범 답안

```java
import java.util.*;

class Solution {
    public int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    public int solution(int[] arrayA, int[] arrayB) {
        int gcdA = arrayA[0], gcdB = arrayB[0];
        for (int i = 1; i < arrayA.length; i++) {
            gcdA = gcd(gcdA, arrayA[i]);
            gcdB = gcd(gcdB, arrayB[i]);
        }
        int answer = 0;
        for (int i = 1; i * i <= gcdA; i++) {
            if (gcdA % i == 0) {
                if (i < gcdB) answer = Math.max(answer, i);
                if (gcdA / i < gcdB) answer = Math.max(answer, gcdA / i);
            }
        }
        return answer;
    }
}
```
