package programmers.KakaoWinter2019;

import java.util.Stack;

public class KakaoWinter1 {
    // 4:44 시
    // 5:03 시
    // 20분
    public static void main(String[] args) {
        int[][] board = {{0,0,0,0,0},
                         {0,0,1,0,3},
                         {0,2,5,0,1},
                         {4,2,4,4,2},
                         {3,5,1,3,1}};

        int[] moves = {1,5,3,5,1,2,1,4};

        int answer = solution(board, moves);
        System.out.println(answer);
    }

    public static int solution(int[][] board, int[] moves) {
        if (board == null || board.length == 0) return 0;

        int answer = 0;
        int[] heights = new int[board[0].length];
        Stack<Integer> st = new Stack<>();

        // init heights
        for (int i=0; i<board.length; i++) {
            for (int j=0; j<board[0].length; j++) {
                if (heights[j] == 0 && board[i][j] !=0) heights[j] = (board.length - i);
            }
        }

        for (int i=0; i<moves.length; i++) {
            if (heights[moves[i]-1] == 0) continue;

            int item = board[board.length - heights[moves[i] - 1]][moves[i] - 1];

            if (st.isEmpty()) {
                st.push(item);
            } else {
                if (st.peek() == item) {
                    st.pop();
                    answer +=2;
                }
                else {
                    st.push(item);
                }
            }
            board[board.length - heights[moves[i] - 1]][moves[i] - 1]=0;
            heights[moves[i]-1] -= 1;
        }

        return answer;
    }
}
