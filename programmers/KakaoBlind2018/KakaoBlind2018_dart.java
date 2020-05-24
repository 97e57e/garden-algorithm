package programmers.KakaoBlind2018;

import java.util.Stack;

public class KakaoBlind2018_dart {
    // 8: 16시
    // 8: 37시
    // 걸린시간 : 21분
    public static void main(String[] args) {
        String dart = "1D2S0T";

        int answer = solution(dart);
        System.out.println(answer);
    }

    public static int solution(String dartResult) {
        int answer = 0;
        int top;
        int bottom;
        boolean flag = false;
        Stack<Integer> st = new Stack<>();
        for (int i=0; i<dartResult.length(); i++) {
            char ch = dartResult.charAt(i);
            switch (ch){
                case 'S':
                    flag = false;
                    break;
                case 'D':
                    flag = false;
                    top = st.pop();
                    st.push(top*top);
                    break;
                case 'T':
                    flag = false;
                    top = st.pop();
                    st.push(top*top*top);
                    break;
                case '*':
                    flag = false;
                    top = st.pop();
                    if (!st.isEmpty()) {
                        bottom = st.pop();
                        st.push(bottom*2);
                    }
                    st.push(top*2);
                    break;
                case '#':
                    flag = false;
                    top = st.pop();
                    st.push(top*(-1));
                    break;
                default:
                    int score;
                    if(flag) {
                        score = st.pop()*10;
                    } else {
                        score = (int)ch - 48;
                    }
                    st.push(score);
                    flag = true;
                    break;
            }
        }

        while(!st.isEmpty()) {
            answer += st.pop();
        }
        return answer;
    }
}
