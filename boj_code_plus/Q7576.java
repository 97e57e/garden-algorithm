package boj_code_plus;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q7576 {
    static int M, N;
    static int[][] tomato;
    static boolean[][] visited;
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        M = sc.nextInt();
        N = sc.nextInt();

        tomato = new int[N][M];
        visited = new boolean[N][M];

        // 세팅
        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                tomato[i][j] = sc.nextInt();
            }
        }

        int answer = bfs();

        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                if (tomato[i][j] == 0) {
                    answer = -1;
                    break;
                }
            }
        }
        System.out.println(answer);
    }
    static int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    public static int bfs() {
        Queue<Point> queue = new LinkedList<>();

        // 토마토 넣기
        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                if (tomato[i][j] == 1) {
                    queue.add(new Point(i, j, 0));
                    visited[i][j] = true;
                }
            }
        }
        int day = 0;
        while(!queue.isEmpty()) {
            Point current = queue.poll();

            // 위 아래 오른쪽 왼쪽 검사
            for (int z=0; z<4; z++) {
                int newY = current.y + dir[z][0];
                int newX = current.x + dir[z][1];
                //판에서 벗어 나지 않고
                if (newY>=0 && newY<N && newX >=0 && newX <M) {
                    if (!visited[newY][newX] && tomato[newY][newX] != -1) {
                        // 아직 방문 안했으면
                        visited[newY][newX] = true;
                        queue.add(new Point(newY, newX, current.day + 1));
                        tomato[newY][newX] = 1;
                    }
                }
            }
            day = current.day;
        }
        return day;
    }

    static class Point{
        int y;
        int x;
        int day;

        public Point(int y, int x, int day) {
            this.y = y;
            this.x = x;
            this.day = day;
        }
    }
}
