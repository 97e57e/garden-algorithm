package boj_code_plus;

import java.util.*;

public class Q6588 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int[] prime = new int[1000001];

        for (int i=1; i<=1000000; i++) {
            prime[i] = i;
        }

        // 소수 구하기
        for (int i=2; i<=1000000; i++) {
            if (prime[i] == 0) continue;
            for (int j = i+i; j<=1000000; j+=i) {
                prime[j] = 0;
            }
        }

        // 소수 리스트 만들기
        List<Integer> primeList = new ArrayList<>();
        Set<Integer> primeSet = new HashSet<>();
        for (int i=3; i<=1000000; i++) {
            if (prime[i] != 0) {
                primeList.add(prime[i]);
                primeSet.add(prime[i]);
            }
        }


        int N = sc.nextInt();

        while(N != 0) {

            for (int i=0; i<primeList.size(); i++) {
                int primeNum = primeList.get(i);

                // 소수가 N보다 커지면 답을 구할 수 없으므로 정해진 문자열 출력
                if (primeNum > N) {
                    System.out.println("Goldbach's conjecture is wrong.");
                    break;
                }

                if (primeSet.contains(N-primeNum)) {
                    System.out.println(N + " = " + primeNum + " + " + (N-primeNum));
                    break;
                }
            }
            N = sc.nextInt();
        }
    }
}
