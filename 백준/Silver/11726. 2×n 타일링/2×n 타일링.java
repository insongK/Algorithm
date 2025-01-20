import java.util.Scanner;

public class Main {
    static int[] dp = new int[1001];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        for(int i = 3; i <= n; i++) {
            dp[i] = dp[i-1] % 10007 + dp[i-2] % 10007;
        }
        System.out.print(dp[n] % 10007);
    }
}