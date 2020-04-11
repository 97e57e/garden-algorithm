package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Drawing {
    static int[][] drawing = new int[501][501];
    static boolean[][] visited = new boolean[501][501];
    static int[][] direction = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    static int n, m;

    static int maxArea = 0, currentArea = 0;
    static int numOfDrawing = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] rowCol;

        rowCol = bf.readLine().split(" ");
        n = Integer.parseInt(rowCol[0]);
        m = Integer.parseInt(rowCol[1]);
        String[] s;
        for (int i= 0; i<n; i++) {
             s = bf.readLine().split(" ");
            for (int j=0; j<m; j++) {
                drawing[i][j] = Integer.parseInt(s[j]);
            }
        }

        for (int i= 0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (!visited[i][j] && drawing[i][j] == 1) {
                    currentArea = 0;
                    dfs(i, j);
                    maxArea = Math.max(maxArea, currentArea);
                    numOfDrawing ++;
                }
            }
        }

        System.out.println(numOfDrawing);
        System.out.println(maxArea);

    }

    public static void dfs(int row, int col) {
        visited[row][col] = true;
        currentArea ++;

        for (int i=0; i<4; i++) {
            int newRow = row +direction[i][0];
            int newCol = col + direction[i][1];
            if (newRow>=0 && newRow<n && newCol>=0 && newCol<m) {
                if (!visited[newRow][newCol] && drawing[newRow][newCol] == 1)
                    dfs(newRow, newCol);
            }
        }
    }
}
