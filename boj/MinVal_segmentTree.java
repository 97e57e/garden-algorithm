package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MinVal_segmentTree {
    public static void main(String[] args) throws IOException {
        int N, M;
        String input;
        long[] nums;
        int a, b;
        long[] trees;

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        input = bf.readLine();

        N = Integer.parseInt(input.split(" ")[0]);
        M = Integer.parseInt(input.split(" ")[1]);

        nums = new long[N];
        trees = new long[N*4];

        for (int i=0; i<N; i++) {
            nums[i] = Integer.parseInt(bf.readLine());
        }

        init(trees, nums,0, nums.length - 1, 1);
//        for (long i : trees) {
//            System.out.print(i + " ");
//        }

        for (int i=0; i<M; i++) {
            input = bf.readLine();
            a = Integer.parseInt(input.split(" ")[0]);
            b = Integer.parseInt(input.split(" ")[1]);

            System.out.println(min(trees, nums, 0, nums.length - 1, a-1, b-1, 1, 0));
        }
    }

    public static void init(long[] trees, long[] nums, int start, int end, int node) {
        if (start == end) {
            trees[node] = nums[start];
            return;
        }
        int mid = (start+end) /2;
        init(trees, nums, start, mid, node*2);
        init(trees, nums, mid+1, end, node*2 +1);
        trees[node] = Math.min(trees[node*2], trees[node*2 + 1]);
    }

    public static long min(long[] trees, long[] nums, int start, int end, int left, int right, int node, long min) {
        if (left > end || right < start) {
            return 1000000000L;
        } else if (left <= start && end <= right) {
            return trees[node];
        } else if (start == end) {
            return trees[node];
        }
        int mid = (start+end) / 2;

        return Math.min(min(trees, nums, start, mid, left, right, node*2, min),
                min(trees, nums, mid+1, end, left, right, node*2+1, min));
    }
}
