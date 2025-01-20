import java.util.Scanner;
import java.lang.Math;
public class Main {
    static int[] dp = new int[1000001];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        dp[2] = 1;
        dp[3] = 1;
        for (int i = 4; i <= N; i++) {
            if(i % 2 == 0 && i % 3 == 0) {
                dp[i] = Math.min(dp[i - 1], Math.min(dp[i / 2], dp[i / 3])) + 1;
            }
            else if(i % 2 == 0 && i % 3 != 0) {
                dp[i] = Math.min(dp[i - 1], dp[i / 2]) + 1;
            }
            else if(i % 2 != 0 && i % 3 == 0) {
                dp[i] = Math.min(dp[i - 1], dp[i / 3]) + 1;
            }
            else {
                dp[i] = dp[i-1] + 1;
            }
        }

        System.out.println(dp[N]);
    }
}