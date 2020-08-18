package boj_code_plus;

import java.util.Scanner;

public class GO_Q1476 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // (1 ≤ E ≤ 15, 1 ≤ S ≤ 28, 1 ≤ M ≤ 19)
        int E = sc.nextInt();
        int S = sc.nextInt();
        int M = sc.nextInt();

        int initE = 1;
        int initS = 1;
        int initM = 1;

        int year = 1;

        while(initE != E || initS != S || initM != M) {
            initE++;
            initM++;
            initS++;

            if (initE == 16) initE = 1;
            if (initS == 29) initS = 1;
            if (initM == 20) initM = 1;
            year ++;
        }
        System.out.println(year);

    }
}
