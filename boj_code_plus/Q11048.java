package boj_code_plus;

import java.util.Scanner;

public class Q11048 {
    static int[][] dir = {{1, 0}, {0, 1}, {1, 1}};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        // 미로 만들기
        int[][] maze = new int[N][M];
        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                maze[i][j] = sc.nextInt();
            }
        }

        // 옆으로
        for (int i=1; i<M; i++) {
            maze[0][i] = maze[0][i] + maze[0][i-1];
        }

        // 아래로
        for (int i=1; i<N; i++) {
            maze[i][0] = maze[i][0] + maze[i-1][0];
        }

        for (int i=1; i<N; i++) {
            for (int j=1; j<M; j++) {
                maze[i][j] = Math.max(Math.max(maze[i][j-1], maze[i-1][j]), maze[i-1][j-1]) + maze[i][j];
            }
        }

        System.out.println(maze[N-1][M-1]);
    }
}
