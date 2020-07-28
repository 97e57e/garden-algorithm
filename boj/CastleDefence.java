package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Enemy{
    int y;
    int x;
    int d;
    public Enemy(int y, int x){
        this.y = y;
        this.x = x;
    }
}

public class CastleDefence {
    static int[][] board;
    static boolean[] ranger;
    static int N;
    static int M;
    static int D;
    static int max = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        N = Integer.parseInt(input.split(" ")[0]);
        M = Integer.parseInt(input.split(" ")[1]);
        D = Integer.parseInt(input.split(" ")[2]);

        board = new int[N][M];
        ranger = new boolean[M];

        for (int i=0; i<N; i++) {
            input = br.readLine();
            for (int j=0; j<M; j++) {
                board[i][j] = Integer.parseInt(input.split(" ")[j]);
            }
        }

        // =======세팅 완료========
        selectRanger(0, ranger.length, 3);

        System.out.println(max);
    }

    public static void selectRanger(int start, int n, int r) {
        if (r == 0) {
            play();
        }

        for (int i=start; i<n; i++) {
            ranger[i] = true;
            selectRanger(i+1, n, r-1);
            ranger[i] = false;
        }
    }

    public static void play() {
        int dead = 0;

        List<Enemy> enemies = new LinkedList<>();

        Set<Enemy> attackedEnemy = new HashSet<>();
        Set<Enemy> finishedEnemy = new HashSet<>();

        for (int i=0; i<board.length; i++) {
            for (int j=0; j<board[0].length; j++) {
                if (board[i][j] == 1) {
                    enemies.add(new Enemy(i, j));
                }
            }
        }

        // 적이 다 죽을 때 까지
        while(!enemies.isEmpty()) {
            Enemy picked;
            for (int i=0; i<ranger.length; i++) {
                picked = enemies.get(0);
                int rangerPosition = i;
                // 궁수 3명을 계산
                if (ranger[i]) {
                    // 궁수와 적 사이의 거리 갱신
                    enemies.forEach(e -> e.d = distance(N, rangerPosition, e.y, e.x));
                    // 현재 궁수와 가장 가까운 적을 선택
                    for (int j=1; j<enemies.size(); j++) {
                        if (enemies.get(j).d < picked.d) {
                            picked = enemies.get(j);
                        } else if (enemies.get(j).d == picked.d) {
                            picked = enemies.get(j).x < picked.x ? enemies.get(j) : picked;
                        }
                    }

                    // 공격 범위 내에 들어 오면 공격
                    if (picked.d <= D) {
                        attackedEnemy.add(picked);
                    }
                }
            }
            // 공격 당한 적을 삭제
            attackedEnemy.forEach(e -> enemies.remove(e));
                    
            // 적 한칸 전진
            go(enemies);
            
            // 판 밖으로 나간 적 제거
            for (Enemy enemy : enemies) {
                if (enemy.y == N) {
                    finishedEnemy.add(enemy);
                }
            }
            finishedEnemy.forEach(e -> enemies.remove(e));
            finishedEnemy.clear();
            
            dead += attackedEnemy.size();
            attackedEnemy.clear();
        }

        max = Math.max(dead, max);
    }

    public static void go(List<Enemy> enemies) {
        enemies.forEach(e -> e.y++);
    }

    public static int distance(int y1, int x1, int y2, int x2) {
        return Math.abs(y1-y2) + Math.abs(x1 - x2);
    }
}
