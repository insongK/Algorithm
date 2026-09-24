import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        int[] result = new int[30];
        HashMap<String, Integer> map = new HashMap<>();
        
        int index = 0;
        for(String[] cloth : clothes){
            if(map.get(cloth[1]) == null) map.put(cloth[1], index++);
            result[map.get(cloth[1])] += 1;
        }
        
        for(int i = 0; i < map.size(); i++){
            answer *= result[i] + 1;
        }
        
        // System.out.println(Arrays.toString(result));
        return answer - 1;
    }
}

/*
의상의 수 30
중복 x
20 이하 소문자 or _

경우의 수를 종류별로 저장
1개만 입을 떄, 2개만 입을 때, 3개만 입을 때 ..... N 개만 입을 때
종류와 인덱스 매핑 ex 얼굴 -> 0, 상의 -> 1 HashMap<String, Intger>
int arr[] = new int[map.length]
nC1 + nC2 + nC3 .... nCn = 각 요소 + 1 * -1

*/