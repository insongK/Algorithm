import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        String input = br.readLine();

        Deque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            char current = input.charAt(i);

            while (!stack.isEmpty() && K > 0 && stack.peekLast() < current) {
                stack.removeLast();
                K--;
            }

            stack.addLast(current);
        }

        while (K > 0) {
            stack.removeLast();
            K--;
        }

        StringBuilder sb = new StringBuilder();
        for (char c : stack) {
            sb.append(c);
        }

        System.out.println(sb);
    }
}