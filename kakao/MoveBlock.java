package kakao;

public class MoveBlock {
    // 12:58 시작
    // 첫 번째 시도 dfs로 모든 경우의 수 탐색
    // 풀지 못함.
    
    public static void main(String[] args) {
        MoveBlock moveBlock = new MoveBlock();

        int[][] board = {
                {0, 0, 0, 1, 1},
                {0, 0, 0, 1, 0},
                {0, 1, 0, 1, 1},
                {1, 1, 0, 0, 1},
                {0, 0, 0, 0, 0}
        };

        int solution = moveBlock.solution(board);
        System.out.println(solution);

    }

    static int N;
    static int min = Integer.MAX_VALUE;
    static boolean[][] visited;
    public int solution(int[][] board) {
        int answer = 0;
        N = board.length;
        visited = new boolean[N][N];

        int firstY = 0;
        int firstX = 1;

        dfs(firstY, firstX, 0, 0, board);

        answer = min;

        return answer;
    }

    public void dfs(int y, int x, int state, int time, int[][] board) {
        if (y == N-1 && x == N-1) {
            min = Math.min(time, min);
        }

        if (visited[y][x]) return;

        if (state == 0) {
            // 로봇이 가로로 있다.
            if (x+1 < N && board[y][x+1] != 1) {
                // 오른 쪽이 1이 아니고 범위를 안 벗어 나면 오른 쪽으로 이동 가능
                visited[y][x+1] = true;
                dfs(y, x+1, 0, time+1, board);
                visited[y][x+1] = false;
            } else if (y < N-1 && board[y+1][x-1] != 1 && board[y+1][x] != 1) {
                // 맨 아래가 아니고, 아래가 비어 있으면
                // 반시계 회전,
                visited[y+1][x] = true;
                dfs(y+1, x, 1, time+1, board);
                visited[y+1][x] = false;
                // 아래로 이동
                visited[y+1][x] = true;
                dfs(y+1, x, 0, time+1, board);
                visited[y+1][x] = false;
                // 시계 회전
                visited[y+1][x-1] = true;
                dfs(y+1, x-1, 1, time+1, board);
                visited[y+1][x-1] = false;
            } else if (y-1 >=0 && board[y-1][x] != 1 && board[y-1][x-1] != 1) {
                //맨 위가 아니고 위가 비어 있으면
                //반시계 회전
                visited[y-1][x-1] = true;
                dfs(y-1, x-1, 1, time+1, board);
                visited[y-1][x-1] = false;
                //위로 이동
                visited[y-1][x] = true;
                dfs(y-1, x, 0, time+1, board);
                visited[y-1][x] = false;
                //시계 회전
                visited[y-1][x] = true;
                dfs(y-1, x, 1, time+1, board);
                visited[y-1][x] = false;
            } else if (x-1 >= 0 && board[y][x-1] != 1) {
                // 왼쪽이 비어있으면 왼쪽으로
                visited[y][x-1] = true;
                dfs(y, x-1, 0, time+1, board);
                visited[y][x-1] = false;
            }
        } else if (state == 1) {
            // 로봇이 세로로 있다.
            if (y+1 < N && board[y+1][x] != 1 ) {
                // 아래가 1이 아니고 비어있으면 아래로 이동 가능
                visited[y+1][x] = true;
                dfs(y+1, x, 1, time+1, board);
                visited[y+1][x] = false;
            } else if (x+1 < N && board[y-1][x+1] != 1 && board[y][x+1] != 1) {
                // 오른 쪽 끝이 아니고 오른쪽이 비어있으면
                //시계 회전
                visited[y][x+1] = true;
                dfs(y, x+1, 0, time+1, board);
                visited[y][x+1] = false;
                // 오른쪽으로 이동
                visited[y][x+1] = true;
                dfs(y, x+1, 1, time+1, board);
                visited[y][x+1] = false;
            }
        }
    }

    public void print(int[][] board) {
        for (int i=0; i<board.length; i++) {
            for (int j=0; j<board[0].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println(" ");
        }
    }
}
