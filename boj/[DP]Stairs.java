package boj;

import java.util.Scanner;

public class Stairs {
    public static void main(String[] args) {
        int[] dp = new int[301];
        int[] scores = new int[301];
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        for(int i=0; i<n; i++) {
            scores[i] = sc.nextInt();
        }
        dp[0] = scores[0];
        dp[1] = scores[0] + scores[1];
        dp[2] = Math.max(scores[1] + scores[2], scores[0] + scores[2]);
        if (n>=4) {
            for (int i = 3; i < n; i++) {
                dp[i] = Math.max(scores[i] + dp[i - 2], scores[i] + scores[i - 1] + dp[i - 3]);
            }
        }

        System.out.println(dp[n-1]);
    }
}
