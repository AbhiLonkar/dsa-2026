package neetcode250._01_arrays_hashing;

public class _09_SortAnArray_912 {
    // TODO - Given an integer array we need to arrange the elements of the array in ascending order
    // TODO - we need to achieve this O(nlogn) time and need to use as little extra space as possible.

    // ? Since the required time complexity is O(nlogn) we can use the quick sort algo using the lomuto partition

    // Assuming end as the last idx position of the array
    public static int lomutoPartition(int[] arr, int start, int end) {
        int smallerElementWindow = start - 1;
        for (int i = start; i < end; i++) {
            if (arr[i] <= arr[end]) {
                smallerElementWindow++;
                int temp = arr[i];
                arr[i] = arr[smallerElementWindow];
                arr[smallerElementWindow] = temp;
            }
        }
        int temp = arr[end];
        arr[end] = arr[smallerElementWindow + 1];
        arr[smallerElementWindow + 1] = temp;
        return smallerElementWindow + 1;
    }

    public static void quickSort(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }
        int partitionIdx = lomutoPartition(arr, start, end);
        quickSort(arr, start, partitionIdx - 1);
        quickSort(arr, partitionIdx + 1, end);

    }

    public static void main(String[] args) {
        int[] arr = new int[]{9, 12, 5, 10, 14, 3, 10};
        quickSort(arr, 0, arr.length - 1);
        for (int i : arr) {
            System.out.println(i);
        }
    }
}
