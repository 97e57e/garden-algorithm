package boj_code_plus;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class Q11723 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();

        int M = Integer.parseInt(s);

        Set<Integer> set = new HashSet<>();

        for (int i=0; i<M; i++) {
            s = br.readLine();
            String command = s.split(" ")[0];

            if (command.equals("all") || command.equals("empty")) {
                if (command.equals("all")) {
                    set = fullSet();
                } else {
                    set = emptySet();
                }

            } else {
                int num = Integer.parseInt(s.split(" ")[1]);
                if (command.equals("add")) {
                    set.add(num);
                } else if (command.equals("remove")) {
                    set.remove(num);
                } else if (command.equals("toggle")) {
                    if (set.contains(num)) {
                        set.remove(num);
                    } else {
                        set.add(num);
                    }
                } else {
                    if (set.contains(num)) {
                        bw.write(1 + "\n");
                    } else {
                        bw.write(0 + "\n");
                    }

                }
            }
        }

        br.close();
        bw.close();
    }

    public static Set<Integer> fullSet() {
        Set<Integer> newSet = new HashSet<>();
        for (int i=1; i<=20; i++) {
            newSet.add(i);
        }
        return newSet;
    }

    public static Set<Integer> emptySet() {
        return new HashSet<>();
    }
}
