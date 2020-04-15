package boj;

import java.util.Scanner;

public class Coin1 {
    public static void main(String[] args) {
        int[] coins = {500, 100, 50, 10, 5, 1};
        int payment;
        int changeMoney;
        int money = 0, coinNum = 0;

        Scanner sc = new Scanner(System.in);

        payment = sc.nextInt();
        changeMoney = 1000 - payment;

        for (int i= 0; i<coins.length; i++) {
            while(money < changeMoney) {
                money += coins[i];
                coinNum ++;
            }
            if (money == changeMoney) {
                break;
            } else {
                money -= coins[i];
                coinNum --;
            }
        }
        System.out.println(coinNum);
    }
}
