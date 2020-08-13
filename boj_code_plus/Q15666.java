package boj_code_plus;

import java.util.*;

public class Q15666 {
    static int N, M;
    static List<List<Integer>> answer = new ArrayList<>();
    static Set<List<Integer>> answerSet = new HashSet<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        List<Integer> list = new ArrayList<>();

        for (int i=0; i<N; i++) {
            int num = sc.nextInt();
            if (!list.contains(num)) {
                list.add(num);
            }
        }

        Collections.sort(list);

        List<Integer> printList = new ArrayList<>();

        permutation(list, printList, 0);

        for (List<Integer> item : answer) {
            for (Integer integer : item) {
                System.out.print(integer + " ");
            }
            System.out.println("");
        }


    }

    public static void permutation(List<Integer> list, List<Integer> printList, int idx) {
        if (idx == M) {
            List<Integer> resultList = new ArrayList<>(printList);
            Collections.sort(resultList);
            if (!answerSet.contains(resultList)) {
                answer.add(resultList);
                answerSet.add(resultList);
            }
            return;
        }

        for (int i=0; i<list.size(); i++) {
            printList.add(list.get(i));
            permutation(list, printList, idx+1);
            printList.remove(printList.size()-1);
        }
    }
}
