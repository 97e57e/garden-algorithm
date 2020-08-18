package boj_code_plus;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class GO_Q1874 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] arr = new int[N];

        for (int i=0; i<N; i++) {
            arr[i] = sc.nextInt();
        }

        Stack<Integer> st = new Stack<>();
        List<Character> commandList = new ArrayList<>();

        int idx = 0;

        for (int i=1; i<=N; i++) {
            st.push(i);
            commandList.add('+');

            while(!st.isEmpty() && st.peek() == arr[idx]) {
                st.pop();
                commandList.add('-');
                idx++;
            }
        }

        if (st.isEmpty()) {
            for (Character character : commandList) {
                System.out.println(character);
            }
        } else {
            System.out.println("NO");
        }
    }
}
