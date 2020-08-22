package boj_code_plus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Q10866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        LinkedList<Integer> list = new LinkedList<>();

        int N = Integer.parseInt(br.readLine());

        for (int i=0; i<N; i++) {
            String[] command = br.readLine().split(" ");

            switch (command[0]) {
                case "push_front":
                    list.addFirst(Integer.parseInt(command[1]));
                    break;
                case "push_back":
                    list.add(Integer.parseInt(command[1]));
                    break;
                case "pop_front":
                    if (list.isEmpty()) {
                        System.out.println(-1);
                    } else {
                        System.out.println(list.get(0));
                        list.removeFirst();
                    }
                    break;
                case "pop_back":
                    if (list.isEmpty()) {
                        System.out.println(-1);
                    } else {
                        System.out.println(list.getLast());
                        list.removeLast();
                    }
                    break;
                case "size":
                    System.out.println(list.size());
                    break;
                case "empty":
                    if (list.isEmpty()) {
                        System.out.println(1);
                    } else {
                        System.out.println(0);
                    }
                    break;
                case "front":
                    if (list.isEmpty()) {
                        System.out.println(-1);
                    } else {
                        System.out.println(list.getFirst());
                    }
                    break;
                case "back":
                    if (list.isEmpty()) {
                        System.out.println(-1);
                    } else {
                        System.out.println(list.getLast());
                    }
                    break;
            }

        }
    }
}
