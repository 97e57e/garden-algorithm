package tmp;

import java.util.List;

public class SegmentTree {
    public static void main(String[] args) {
        SegmentTree st = new SegmentTree();

        int[] arr = {5, 3, 7, 9, 6, 4, 1, 2, 1};
        STree segmentTree = new STree(arr, arr.length);

        int[] sa = segmentTree.sArr;

        for (int a : sa) {
            System.out.println(a);
        }
    }
}

class STree {
    int[] sArr;

    public STree(int[] arr, int n) {
        sArr = new int[n * 4];

        init(arr, 0, n-1, 1);
    }

    int init(int[] arr, int left, int right, int node){
        if (left == right) {
            sArr[node] = arr[left];
        } else {
            int mid = (left+right) / 2;

            sArr[node] += init(arr, left, mid, node*2);
            sArr[node] += init(arr, mid+1, right, node*2+1);
        }

        return sArr[node];
    }
}
