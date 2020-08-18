package boj_code_plus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GO_Q14891 {
    // 14 : 25
    // 15 : 35
    static boolean[] visited;
    static int LEFT_NS = 6;
    static int RIGHT_NS = 2;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 톱니 바퀴 초기화
        int[][] gears = new int[4][8];
        for (int i=0; i<4; i++) {
            String gear = br.readLine();

            for (int j=0; j<8; j++) {
                char[] chars = gear.toCharArray();
                gears[i][j] = chars[j] - '0';
            }
        }

        visited = new boolean[4];

        int K = Integer.parseInt(br.readLine());

        for (int i=0; i<K; i++) {
            String command = br.readLine();
            int numOfGear = Integer.parseInt(command.split(" ")[0]);
            int dir = Integer.parseInt(command.split(" ")[1]);

            visited[numOfGear-1] = true;
            rotate(gears, numOfGear, dir);
            visited[numOfGear-1] = false;
        }


        System.out.println(getPoint(gears));

    }

    public static void rotate(int[][] gears, int numOfGear, int dir) {
        if (numOfGear==0) return;
        int left = numOfGear - 1;
        int right = numOfGear + 1;

        int oppositeDir = dir == 1 ? -1 : 1;

        int leftNS = gears[numOfGear-1][LEFT_NS];
        int rightNS = gears[numOfGear-1][RIGHT_NS];

        // 왼쪽에 톱니가 있으면
        if (left>=1) {
            if (!visited[left-1]) {
                // 왼쪽 톱니가 극이 다르면
                if (leftNS != gears[left - 1][RIGHT_NS]) {
                    // 반대 방향 으로 돌려
                    visited[left - 1] = true;
                    rotate(gears, left, oppositeDir);
                    visited[left - 1] = false;

                }
            }
        }

        if (right<=4) {
            // 오른쪽 톱니가 극이 다르면
            if (!visited[right-1]) {
                if (rightNS != gears[right - 1][LEFT_NS]) {
                    // 반대 방향 으로 돌려
                    visited[right - 1] = true;
                    rotate(gears, right, oppositeDir);
                    visited[right - 1] = false;
                }
            }
        }

        rotateGear(gears, numOfGear, dir);
    }

    public static void rotateGear(int[][] gears, int numOfGear, int dir) {
        if (dir == 1) {
            // 시계
            int tmp = gears[numOfGear-1][7];
            for (int i=6; i>=0; i--) {
                gears[numOfGear-1][i+1] = gears[numOfGear-1][i];
            }
            gears[numOfGear-1][0] = tmp;
        } else {
            // 반시계
            int tmp = gears[numOfGear-1][0];
            for (int i=1; i<8; i++) {
                gears[numOfGear-1][i-1] = gears[numOfGear-1][i];
            }
            gears[numOfGear-1][7] = tmp;
        }
    }

    public static int getPoint(int[][] gears){
        int point = 0;
        if (gears[0][0] == 1) {
            point += 1;
        }

        if (gears[1][0] == 1) {
            point += 2;
        }

        if (gears[2][0] == 1) {
            point += 4;
        }

        if (gears[3][0] == 1) {
            point += 8;
        }

        return point;
    }

}
