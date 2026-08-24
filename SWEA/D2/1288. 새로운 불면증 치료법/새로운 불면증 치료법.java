import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		

		
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int N = sc.nextInt();
            boolean[] num = new boolean[10];

    		start: for(int i = N; i < Integer.MAX_VALUE; i += N){
                String s = String.valueOf(i);
                char[] c = s.toCharArray();

                for(int j = 0; j < c.length; j++){
                    num[c[j] - '0'] = true;
                }

                for(boolean e : num) if(!e) continue start;
                System.out.printf("#%d %d\n", test_case, i);
                break;
            }
		}
	}
}