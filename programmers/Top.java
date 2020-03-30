package programmers;

import java.util.Stack;

public class Top {
    public static void main(String[] args) {
        int[] input = {6, 9, 5, 7, 4};

        int[] answer = solution(input);

        for(int i=0; i<answer.length; i++){
            System.out.println(answer[i]);
        }
    }

    public static int[] solution(int[] heights) {
        Stack<int[]> st = new Stack<>();
        int[] answer = new int[heights.length];

        for (int i = 0; i <heights.length; i++) {
            int[] tower = {i+1, heights[i]};
            int idx = 0;

            while (!st.isEmpty()) {
                int[] top = st.peek();

                if (top[1] > tower[1]) {
                    idx = top[0];
                    break;
                }
                st.pop();
            }
            st.push(tower);
            answer[i] = idx;
        }

        return answer;
    }
}
