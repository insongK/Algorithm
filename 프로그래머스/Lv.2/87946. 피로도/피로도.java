import java.util.*;

class Solution {
    int answer = 0;
    
    public void permutation(int[][] dungeons, int[] arr, int depth, int n,  int k){
        if(depth == n){
            int count = 0, temp_k = k;
            for(int num: arr){
                if(temp_k >= dungeons[num][0]){
                    temp_k -= dungeons[num][1];
                    count++;
                }  
            }
            if(answer < count) answer = count;
            return;
        }
        for(int i = depth; i < n; i++){
            swap(arr, depth, i);
            permutation(dungeons, arr, depth + 1, n, k);
            swap(arr, depth, i);
        }
    }
    
    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    public int solution(int k, int[][] dungeons) {
        int[] arr = new int[dungeons.length];
        for(int i = 0; i < arr.length; i++){
            arr[i] = i;
        }
        permutation(dungeons, arr, 0, arr.length, k);
        return answer;
    }
}