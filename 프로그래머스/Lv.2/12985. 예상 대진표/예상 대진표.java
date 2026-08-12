class Solution
{
    public int solution(int n, int a, int b)
    {
        int answer = 0;
        int A = a - 1;
        int B = b - 1;
        
        while(A != B){
            A /= 2;
            B /= 2;
            answer++;
        }

        return answer;
    }
}



//    0       1
//  0   1   2   3
// 0 1 2 3 4 5 6 7