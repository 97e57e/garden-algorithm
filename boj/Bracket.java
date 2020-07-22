package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Bracket {
    public static void main(String[] args) throws IOException {
        Bracket bracket = new Bracket();

        // need
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(br.readLine());
        String expression = br.readLine();

        //solve
        int solution = bracket.solution(length, expression);

        //answer
        System.out.println(solution);
    }
    static List<Integer> numbers = new ArrayList<>();
    static List<Character> operator = new ArrayList<>();
    static int max = Integer.MIN_VALUE;

    public int solution(int length, String expression) {
        int answer;

        // container
        for (int i = 0; i<expression.length(); i++) {
            if (i%2 == 0) {
                numbers.add(expression.charAt(i) -'0');
            } else {
                operator.add(expression.charAt(i));
            }
        }
        dfs(0, numbers.get(0));

        return max;
    }

    public void dfs(int now, int sum) {
        if (now == operator.size()) {
            max = Math.max(max, sum);
            return;
        }

        //괄호 없이
        int newSum = operate(sum, numbers.get(now+1), operator.get(now));
        dfs(now+1, newSum);

        //괄호 추가
        if (now+1 < operator.size()) {
            newSum = operate(numbers.get(now+1), numbers.get(now+2), operator.get(now+1));
            newSum = operate(sum, newSum, operator.get(now));
            dfs(now+2, newSum);
        }
    }

    public int operate(int a, int b, char o) {
        switch (o){
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
        }
        return 0;
    }
}
