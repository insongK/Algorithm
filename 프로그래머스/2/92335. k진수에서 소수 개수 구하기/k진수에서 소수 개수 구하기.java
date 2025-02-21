class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        String[] str = Integer.toString(n, k).split("0");

        for (String num : str) {
            if (!num.isEmpty()) {
                long prime = Long.parseLong(num);
                if (isPrime(prime)) {
                    answer++;
                }
            }
        }

        return answer;
    }

    private boolean isPrime(long num) {
        if (num < 2) return false;
        if (num == 2) return true;
        if (num % 2 == 0) return false;

        for (long i = 3; i * i <= num; i += 2) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}