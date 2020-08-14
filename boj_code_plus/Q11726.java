package boj_code_plus;

import java.util.Scanner;

public class Q11726 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

//        2×n 크기의 직사각형을 1×2, 2×1 타일로 채우는 방법의 수를 구하는 프로그램을 작성하시오.
//
//                아래 그림은 2×5 크기의 직사각형을 채운 한 가지 방법의 예이다.

        int N = sc.nextInt();

        int[] dp = new int[1001];

        dp[1] = 1;
        dp[2] = 2;

        for (int i=3; i<=N; i++) {
            dp[i] = dp[i-2] + dp[i-1];
            dp[i] %= 10007;
        }
        System.out.println(dp[N]);
    }
}
