package algorithm;

import java.util.List;

public class Combination {
    static boolean[] visited;
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int n = 5;
        int c = 3;

        visited = new boolean[arr.length];

        comb(arr, 0, n, c);


    }

    static List<Integer> list;

    public static void comb(int[] arr, int start, int n, int r) {
        if (r == 0) {
            print(arr);
        }

        for (int i=start; i<n; i++) {
            visited[i] = true;
            comb(arr, i+1, n, r-1);
            visited[i] = false;
        }
    }

    public static void print(int[] arr) {
        for (int i=0; i<arr.length; i++) {
            if (visited[i] == true) {
                System.out.print(arr[i] + " ");
            }
        }
        System.out.println("");
    }
}
