package boj_code_plus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q9613 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();

        int T = Integer.parseInt(s);

        for (int i=0; i<T; i++) {
            s = br.readLine();

            // 들어온 인풋의 개수로 배열 만들기

            int n = Integer.parseInt(s.split(" ")[0]);
            int[] intArr = new int[n];

            // 배열 할당
            for (int j=0; j<n; j++) {
                intArr[j] = Integer.parseInt(s.split(" ")[j+1]);
            }

            // 브루트 포스
            System.out.println(calc(intArr));
        }
    }

    public static long calc(int[] arr) {
        long sum = 0;
        for (int i=0; i<arr.length; i++) {
            for (int j=i+1; j<arr.length; j++) {
                sum += gcd(arr[i], arr[j]);
            }
        }
        return sum;
    }

    public static int gcd(int a, int b) {
        while(b!=0) {
            int r= a%b;
            a = b;
            b = r;
        }
        return a;
    }

}
