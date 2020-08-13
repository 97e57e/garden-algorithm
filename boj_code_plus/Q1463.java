package boj_code_plus;

import java.util.Scanner;

public class Q1463 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[] dp = new int[10000001];

        // 3으로 나누어 떨어지면 3으로 나눈다
        // 2로 나노어 떨어지면 2로 나눈다
        // 1을 뺀다
        dp[0] = 0;
        dp[1] = 0;
        dp[2] = 1;

        for (int i=3; i<=N; i++) {
            dp[i] = dp[i-1] + 1;
            if (i%3 == 0) {
                dp[i] = Math.min(dp[i], dp[i/3] + 1);
            }
            if(i%2 == 0) {
                dp[i] = Math.min(dp[i], dp[i/2] + 1);
            }
        }

        System.out.println(dp[N]);
    }
}
