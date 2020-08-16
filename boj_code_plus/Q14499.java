package boj_code_plus;

import java.util.Scanner;

public class Q14499 {
    static int[][] map;
    static int[] commandArray;
    static int[] dice;
    static int[][] dir = {{0, 0}, {0, 1}, {0, -1}, {-1, 0}, {1, 0}};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int y = sc.nextInt();
        int x = sc.nextInt();
        int K = sc.nextInt();

        // 지도 생성
        map = new int[N][M];
        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        // 명령어 받기
        commandArray = new int[K];
        for (int i=0; i<K; i++) {
            commandArray[i] = sc.nextInt();
        }

        // 주사위 생성 및 위치 초기화
        dice = new int[7];

        for (int i=0; i<K; i++) {
            int command = commandArray[i];
            int newY = y + dir[command][0];
            int newX = x + dir[command][1];

            // 주사위 굴렸을 때 판 밖으로 안 벗어 나면
            if (newY >= 0 && newY < N && newX >= 0 && newX < M) {
                rollDice(command);
                if (map[newY][newX] == 0) {
                    map[newY][newX] = dice[1];
                } else {
                    dice[1] = map[newY][newX];
                    map[newY][newX] = 0;
                }
                y = newY;
                x = newX;
                System.out.println(dice[6]);
            }
        }


    }

    public static void rollDice(int dir) {
        int[] tmpDice = dice.clone();
        switch (dir) {
            case 1:
                // 동
                dice[1] = tmpDice[3];
                dice[6] = tmpDice[4];
                dice[3] = tmpDice[6];
                dice[4] = tmpDice[1];
                break;
            case 2:
                // 서
                dice[1] = tmpDice[4];
                dice[6] = tmpDice[3];
                dice[3] = tmpDice[1];
                dice[4] = tmpDice[6];
                break;
            case 3:
                // 북
                dice[1] = tmpDice[2];
                dice[2] = tmpDice[6];
                dice[5] = tmpDice[1];
                dice[6] = tmpDice[5];
                break;
            case 4:
                // 남
                dice[1] = tmpDice[5];
                dice[2] = tmpDice[1];
                dice[5] = tmpDice[6];
                dice[6] = tmpDice[2];
                break;
        }

    }
}
