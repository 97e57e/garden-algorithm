package algorithm;

public class MergeSort {
    public static void main(String[] args) {
        int[] input = {21, 10, 12, 20, 25, 13, 15, 22};
        sorted = new int[input.length];

        mergeSort(input, 0, input.length -1);

        for (int i : input) {
            System.out.println(i);
        }

    }

    static int[] sorted;

    public static void mergeSort(int[] arr, int left, int right) {
        int mid;

        if (left<right) {
            mid = (left + right) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid+1, right);
            merge(arr, left, mid, right);
        }
    }

    public static void merge(int[] arr, int left, int mid, int right) {

        int i, j, k;

        i = left;
        j = mid + 1;
        k = left;

        while(i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                sorted[k++] = arr[i++];
            } else {
                sorted[k++] = arr[j++];
            }
        }

        if (i > mid) {
            for (int idx=j; idx<=right; idx++) {
                sorted[k++] = arr[idx];
            }
        } else {
            for (int idx=i; idx<=mid; idx++) {
                sorted[k++] = arr[idx];
            }
        }

        for (int idx=left; idx<=right; idx++) {
            arr[idx] = sorted[idx];
        }
    }
}
