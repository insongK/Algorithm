import java.util.Scanner;

public class Main {
    static int[] dp = new int[1001];
    static int[] Arr = {};

    public static void Input() {
        Scanner scanner = new Scanner(System.in);
        int A = scanner.nextInt();
        Arr = new int[A];
        for (int i = 0; i < A; i++) {
            Arr[i] = scanner.nextInt();
        }
    }

    public static int Solve(int[] Arr, int[] dp) {
        for (int i = 0; i < Arr.length; i++) {
            dp[i] = 1;
            for (int j = 0; j <= i; j++) {
                if (Arr[i] < Arr[j] && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                }
            }
        }
        int Max = 0;
        for (int i = 0; i < Arr.length; i++) {
            if (dp[i] > Max) {
                Max = dp[i];
            }
        }
        return Max;
    }

    public static void main(String[] args) {
        Main.Input();
        System.out.println(Solve(Arr, dp));
    }

}