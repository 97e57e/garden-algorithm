package boj_code_plus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GO_Q9093 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();

        int T = Integer.parseInt(s);

        for (int i=0; i<T; i++) {
            s = br.readLine();
            String[] words = s.split(" ");

            for (int j=0; j<words.length; j++) {
                StringBuilder sb = new StringBuilder();
                sb.append(words[j]);
                System.out.print(sb.reverse().toString() + " ");
            }
        }
    }
}
