import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int K = scanner.nextInt();
        int N = scanner.nextInt();
        int[] arr = new int[N];
        int arg_arr = 0;
        int max_value = 0;
        for (int i = 0; i < K; i++) {
            arr[i] = scanner.nextInt();
            if(max_value < arr[i]) max_value = arr[i];
        }
        long left = 1, right = max_value;
        while(left <= right){
            long count = 0;
            long mid = (left + right) / 2;

            for (int j : arr) {
                count += j / mid;
            }
            if(count >= N)  left = mid + 1;
            else right = mid - 1;
        }
        System.out.println(right);
    }
}