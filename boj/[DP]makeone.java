package boj;

import java.util.Scanner;

public class makeone {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] dp = new int[10000001];

        int n = sc.nextInt();
        dp[0] = 0;
        dp[1] = 0;
        for(int i=2; i<=n; i++) {
            dp[i] = dp[i-1] + 1;
            if (i%2 == 0) {
                dp[i] = Math.min(dp[i], dp[i/2] + 1);
            }
            if (i%3 == 0) {
                dp[i] = Math.min(dp[i], dp[i/3] + 1);
            }
        }
        System.out.println(dp[n]);
    }
}
