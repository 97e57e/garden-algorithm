package programmers;

public class GoSchool {
    public static void main(String[] args) {
        GoSchool gs = new GoSchool();

        int m=4;
        int n=3;
        int[][] puddles = {{2,2}};

        int answer = gs.solution(m, n, puddles);
        System.out.println(answer);
    }

    public int solution(int m, int n, int[][] puddles) {
        long[][] map = new long[n][m];

        for (int i=0; i<puddles.length; i++) {
            int x = puddles[i][0];
            int y = puddles[i][1];

            map[y-1][x-1] = -1;
        }

        for (int i=0; i<map.length; i++) {
            if (map[i][0] == -1) break;
            map[i][0] = 1;
        }
        for (int i=0; i<map[0].length; i++) {
            if (map[0][i] == -1) break;
            map[0][i] = 1;
        }
        for (int i=1; i<map.length; i++) {
            for (int j=1; j<map[0].length; j++) {
                if (map[i][j] == -1) continue;
                int su = 0;
                if (map[i-1][j] != -1) su +=map[i-1][j];
                if (map[i][j-1] != -1) su +=map[i][j-1];
                map[i][j] = su;
            }
        }
        return (int)map[n-1][m-1]%1000000007;
    }
}
