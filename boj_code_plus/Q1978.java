package boj_code_plus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1978 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();

        int N = Integer.parseInt(s);

        int[] arr = new int[N];

        s = br.readLine();

        for (int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(s.split(" ")[i]);
        }

        int answer = 0;
        for (int i=0; i<N; i++) {
            int num = arr[i];
            if (num == 1) continue;

            boolean soSoo = false;
            for (int j=2; j<=num/2; j++) {
                if (num%j == 0) {
                    soSoo = true;
                    break;
                }
            }
            if (!soSoo) answer++;
        }

        System.out.println(answer);
    }
}
