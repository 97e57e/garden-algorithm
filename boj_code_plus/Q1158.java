package boj_code_plus;

import java.util.*;

public class Q1158 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> answer = new ArrayList<>();

        for (int i=1;i <=N; i++) {
            queue.add(i);
        }

        int count;
        while(!queue.isEmpty()) {
            count = 0;
            while(count++ < K - 1) {
                int num = queue.poll();
                queue.add(num);
            }

            answer.add(queue.poll());

        }
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        for (int i : answer) {
            sb.append(i);
            sb.append(", ");
        }

        sb.delete(sb.length()-2, sb.length());
        sb.append(">");
        System.out.println(sb.toString());

    }
}
