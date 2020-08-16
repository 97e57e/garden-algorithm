package algorithm;

public class QuickSort {
    public static void main(String[] args) {
        int[] input = {21, 10, 12, 20, 25, 13, 15, 22};

        quickSort(input, 0, input.length - 1);
        for (int i : input) {
            System.out.println(i);
        }
    }

    public static int partition(int[] arr, int left, int right) {
        int pivot = arr[left];
        int i = left;
        int j = right;
        int temp;

        while (i <= j) {
            while(i <= right && arr[i] <= pivot) {
                i++;
            }

            while(j > left && arr[j] >= pivot) {
                j--;
            }

            if (i > j) {
                temp = arr[j];
                arr[j] = pivot;
                arr[left] = temp;
            } else {
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        return j;
    }

    public static void quickSort(int[] arr, int left, int right) {

        if (left<right) {
            int pivot = partition(arr, left, right);

            quickSort(arr, left, pivot - 1);
            quickSort(arr, pivot + 1,right);
        }
    }
}
