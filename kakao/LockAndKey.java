package kakao;

public class LockAndKey {
    // 15:19 시작
    // 16:04 종료
    public static void main(String[] args) {
        LockAndKey lockAndKey = new LockAndKey();

        int[][] key = {
                {0, 0, 0},
                {1, 0, 0},
                {0, 1, 1}
        };
        int[][] lock = {
                {1, 1, 1},
                {1, 1, 0},
                {1, 0, 1}
        };

        boolean solution = lockAndKey.solution(key, lock);
        System.out.println(solution);

    }
    static int lockLen;
    static int keyLen;

    public boolean solution(int[][] key, int[][] lock) {
        lockLen = lock.length;
        keyLen = key.length;

        if (lockLen <= 0 || keyLen <= 0) return false;

        int boardLen = lock.length + (key.length - 1)*2;
        int[][] board = new int[boardLen][boardLen];

        // fill board
        for (int i=0; i<lock.length; i++) {
            for (int j=0; j<lock.length; j++) {
                board[i+keyLen-1][j+keyLen-1] = lock[i][j];
            }
        }

        // move key
        for (int i=0; i<boardLen - (key.length-1); i++) {
            for (int j=0; j<boardLen - (key.length - 1); j++) {
                // 4번 돌림
                for (int z=0; z<4; z++) {
                    fill(board, i, j, key);
                    if (isComplete(board)) return true;
                    unFill(board, i, j, key);
                    key = rotateKey(key);
                    System.out.println("new key");
                    print(key);
                }
            }
        }
        return false;
    }

    private int[][] rotateKey(int[][] key) {
        int[][] newKey = new int[keyLen][keyLen];
        for (int i=0; i<keyLen; i++) {
            for (int j=0; j<keyLen; j++) {
                newKey[i][j] = key[j][keyLen-i-1];
            }
        }

        return newKey;
    }

    private void fill(int[][] board, int y, int x, int[][] key) {
        for (int i=0; i<keyLen; i++) {
            for (int j=0; j<keyLen; j++) {
                board[i+y][j+x] += key[i][j];
            }
        }
    }

    private void unFill(int[][] board, int y, int x, int[][] key) {
        for (int i=0; i<keyLen; i++) {
            for (int j=0; j<keyLen; j++) {
                board[i+y][j+x] -= key[i][j];
            }
        }
    }

    private boolean isComplete(int[][] board) {
        for (int i=0; i<lockLen; i++) {
            for (int j=0; j<lockLen; j++) {
                if (board[i+keyLen-1][j+keyLen-1] != 1) return false;
            }
        }
        return true;
    }

    public void print(int[][] b) {
        for (int i=0; i<b.length; i++) {
            for (int j=0; j<b.length; j++) {
                System.out.print(b[i][j] + " ");
            }
            System.out.println("");
        }
    }
}
