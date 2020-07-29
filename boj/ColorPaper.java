package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ColorPaper {
    static int[][] paper = new int[10][10];
    static int answer = Integer.MAX_VALUE;
    static int[] papers = {5, 5, 5, 5, 5};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i=0; i<10; i++) {
            String input = br.readLine();
            for (int j=0; j<10; j++) {
                paper[i][j] = Integer.parseInt(input.split(" ")[j]);
            }
        }

        dfs(0, 0);

        if (answer == Integer.MAX_VALUE) {
            answer = -1;
        }
        System.out.println(answer);

    }

    public static void dfs(int idx, int cnt) {
        if (cnt >= answer) return;
        if (isCompleted()) {
            answer = Math.min(answer, cnt);
            return;
        }

        int y = idx/10;
        int x = idx%10;
        if (paper[y][x] == 1) {
            for (int z = 5; z > 0; z--) {
                if (check(y, x, z) && papers[z - 1] > 0) {
                    papers[z - 1]--;
                    cover(y, x, z);
                    dfs(idx + 1, cnt + 1);
                    uncover(y, x, z);
                    papers[z - 1]++;
                }
            }
        } else {
            dfs(idx +1, cnt);
        }
    }

    public static boolean isCompleted() {
        for (int i=0; i<10; i++) {
            for (int j=0; j<10; j++) {
                if (paper[i][j] == 1) return false;
            }
        }
        return true;
    }

    public static boolean check(int y, int x, int z) {
        if (y+z >10 || x+z >10) return false;
        for (int i=y; i<y+z; i++) {
            for (int j=x; j<x+z; j++) {
                if (paper[i][j] == 0) return false;
            }
        }
        return true;
    }

    public static void cover(int y, int x, int z) {
        for (int i=y; i<y+z; i++) {
            for (int j=x; j<x+z; j++) {
                paper[i][j] = 0;
            }
        }
    }

    public static void uncover(int y, int x, int z) {
        for (int i=y; i<y+z; i++) {
            for (int j=x; j<x+z; j++) {
                paper[i][j] = 1;
            }
        }
    }
}
