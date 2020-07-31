package kakao;

import java.util.Stack;

public class Bracket {

    // 13:57 시작
    // 14:52 종료
    public static void main(String[] args) {
        Bracket bracket = new Bracket();

        String p = "()))((()";
        System.out.println(p);

        String solution = bracket.solution(p);
        System.out.println("solution = " + solution);

    }

    public String solution(String p) {
        String answer = "";
        answer = recursive(p);
        StringBuilder sb = new StringBuilder(answer);
        answer = sb.toString();
        return answer;
    }

    public String recursive(String p) {
        String answer = "";
        int start = 0;

        if (p.equals("")) return answer;
        if (isRight(p)) return p;

        StringBuilder sb = new StringBuilder();
        for (int i=2; i<=p.length(); i +=2) {
            String u = p.substring(start, i);
            String v = p.substring(i, p.length());

            if (isBalanced(u) && isBalanced(v)) {
                if (!isRight(u)) {
                    sb.append('(');
                    sb.append(recursive(v));
                    sb.append(')');
                    String w = u.substring(1, u.length() - 1);
                    sb.append(complete(w));
                } else {
                    sb.append(u);
                    sb.append(recursive(v));
                }
                break;
            }
        }

        return sb.toString();
    }

    // 균형잡힌 문자열
    // ( ) 갯수가 같음
    public boolean isBalanced(String s) {
        if (s.equals("")) return true;

        int left = 0;
        int right = 0;
        for (int i=0; i<s.length(); i++) {
            if (s.charAt(i) == '(') {
                left ++;
            } else {
                right ++;
            }
        }

        return (left==right);
    }

    public String complete(String s) {
        StringBuilder sb = new StringBuilder();

        for (int i=0; i<s.length(); i++) {
            if (s.charAt(i) == '(') {
                sb.append(')');
            } else {
                sb.append('(');
            }
        }
        return sb.toString();
    }

    // 올바른 문자열
    // ( ) 의 짝이 잘 맞
    public boolean isRight(String s) {
        if (s.equals("")) return true;

        Stack<Character> bracketStack = new Stack<>();
        for (int i=0; i<s.length(); i++) {
            char bracket = s.charAt(i);
            if (bracket == '(') {
                bracketStack.push(bracket);
            } else {
                if (bracketStack.isEmpty()) return false;

                if (bracketStack.peek() == '(') {
                    bracketStack.pop();
                } else {
                    return false;
                }
            }
        }

        return (bracketStack.size() == 0);
    }
}
