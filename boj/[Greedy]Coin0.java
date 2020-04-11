package boj;

import java.util.Scanner;

public class Coin0 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N, K;
        int[] values;
        int coinCount = 0;
        int money = 0;

        N = sc.nextInt();
        K= sc.nextInt();

        values = new int[N];

        for (int i = 0; i < N; i++){
            values[i] = sc.nextInt();
        }

        for (int i = values.length - 1; i>=0; i--) {
            while(money<K) {
                money += values[i];
                coinCount ++;
            }

            if (money == K) {
                break;
            } else {
                money -= values[i];
                coinCount --;
            }

        }
        System.out.println(coinCount);

    }
}
