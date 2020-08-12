package boj_code_plus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1943 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();

        int T = Integer.parseInt(s);

        for (int i=0; i<T; i++) {
            s = br.readLine();
            int a = Integer.parseInt(s.split(" ")[0]);
            int b = Integer.parseInt(s.split(" ")[1]);

            System.out.println(lcm(a, b));
        }
    }
    public static int gcd(int a, int b) {
        while(b!=0) {
            int r= a%b;
            a = b;
            b = r;
        }
        return a;
    }

    public static int lcm(int a, int b) {
        return a*b / gcd(a,b);
    }
}
