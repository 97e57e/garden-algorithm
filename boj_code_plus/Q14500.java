package boj_code_plus;

import java.util.Scanner;

public class GO_Q14500 {
    static int N, M;
    static int[][] map;
    static boolean[][] visited;
    static int max = Integer.MIN_VALUE;
    static int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        visited = new boolean[N][M];

        // 맵 초기화
        map = new int[N][M];
        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                map[i][j] = sc.nextInt();
            }
        }
        // 테트로미노 최대값
        for (int i=0; i<N; i++){
            for (int j=0; j<M; j++) {
                visited[i][j] = true;
                dfs(i, j, 1, map[i][j]);
                visited[i][j] = false;
            }
        }

        // ㅗ ㅏ ㅓ ㅜ 모양
        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                int horizon = j;
                int vertical = i;
                int sum = 0;

                // 옆으로 세 칸
                while(horizon < j + 3) {
                    if (horizon == M) break;
                    sum += map[i][horizon];
                    horizon++;
                }

                // 갈 수 있으면
                if (horizon == j+3) {
                    if (i-1>=0) {
                        sum += map[i-1][j+1];
                        max = Math.max(sum, max);
                        sum -= map[i-1][j+1];
                    }

                    if (i+1<N) {
                        sum += map[i+1][j+1];
                        max = Math.max(sum, max);
                    }
                }

                sum = 0;
                // 아래로 세 칸
                while(vertical < i + 3) {
                    if (vertical == N) break;
                    sum += map[vertical][j];
                    vertical++;
                }

                // 갈 수 있으면
                if (vertical == i+3) {
                    if (j-1>=0) {
                        sum += map[i+1][j-1];
                        max = Math.max(sum, max);
                        sum -= map[i+1][j-1];
                    }

                    if (j+1<M) {
                        sum += map[i+1][j+1];
                        max = Math.max(sum, max);
                    }
                }

            }
        }

        System.out.println(max);

    }

    public static void dfs(int y, int x, int len, int sum) {
        if (len == 4) {
            max = Math.max(sum, max);
            return;
        }

        for (int i=0; i<4; i++) {
            int newY = y + dir[i][0];
            int newX = x + dir[i][1];

            if (newY>=0 && newY <N && newX >=0 && newX < M) {
                if (!visited[newY][newX]) {
                    visited[newY][newX] = true;
                    dfs(newY, newX, len + 1, sum + map[newY][newX]);
                    visited[newY][newX] = false;
                }
            }
        }
    }

}
