*/
import java.util.*;

class Solution {
    
    public int GCD(int a, int b){
        if(a == b) return a;
        else if(a > b){
            int remain = a % b;
            if(remain == 0) return b;
            else return GCD(b, remain);
        }
        else{
            int remain = b % a;
            if(remain == 0) return a;
            else return GCD(a, remain);
        }
    }
    
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        int prevA = 0, prevB = 0;
        if(arrayA.length == 1){
            prevA = arrayA[0];
            prevB = arrayB[0];
        }
        else{
            prevA = GCD(arrayA[0], arrayA[1]);
            prevB = GCD(arrayB[0], arrayB[1]);
        }
        for(int i = 2; i < arrayA.length; i++){
            prevA = GCD(prevA, arrayA[i]);
            prevB = GCD(prevB, arrayB[i]);
            // System.out.println(prevA + " " + prevB);
        }
        
        ArrayDeque<Integer> qA = new ArrayDeque<>();
        ArrayDeque<Integer> qB = new ArrayDeque<>();
        
        for(int i = 2; i <= prevA; i++){
            if(prevA % i == 0){
                qA.offer(i);
            }
        }
        for(int i = 2; i <= prevB; i++){
            if(prevB % i == 0){
                qB.offer(i);
            }
        }
        startA: while(!qA.isEmpty()){
            int n = qA.poll();