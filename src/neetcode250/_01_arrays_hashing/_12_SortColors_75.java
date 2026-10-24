package neetcode250._01_arrays_hashing;

public class _12_SortColors_75 {

    // TODO - Given an integer array consisting of only 0 (red), 1 (while), 2 (blue) we need to sort these values in increasing order in place
    // TODO - follow up: Can we do it single pass with constant extra space?

    // ? Let's try with bubble sort - as its in place as well as stable

    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        // * here i represents the length of the sorted half on the right
        // * initially there are no elements in the sorted half when i = 0
        // * After first pass - largest element put in to the right half, i increments to 1 (window size is 1)
        // * After second pass - second largest element put in to the right half, i increments to 2 (window size is 2)
        // * After the third pass - third largest element put in to the right half, i increments to 3 (window size is 3)
        // * And so on, since with each pass the sorted window's size increases we can stop at n - 1 comparisons as the element at the 0th position will anyways be at its correct position at the end of the last iteration
        for (int i = 0; i < n - 1; i++) {
            // * We only compare the adjacent elements, and avoid comparing the elements of the unsorted half with the sorted half, by subtracting i (sorted window size)
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static int[] sortColors(int[] arr) {
        bubbleSort(arr);
        return arr;
    }

    public static void swap(int[] arr, int pos1, int pos2) {
        int temp = arr[pos1];
        arr[pos1] = arr[pos2];
        arr[pos2] = temp;
    }

    // ! The solution didn't work out
    public static int[] sortColorsOpt(int[] arr) {
        int n = arr.length;
        int leftZoneSize = 0;
        int rightZoneSize = 0;
        // swap the elements at the correct pos's and then increment the window size
        // for left the insertion point is the same as leftzonesize and for right its n - 1 - rightZoneSize
        int start = 0;
        while (start < n - 1 - rightZoneSize) {
            if (arr[start] == 0) {
                swap(arr, start, leftZoneSize);
                if (arr[start] == 2){
                    swap(arr, start, n - 1 - rightZoneSize);
                    rightZoneSize++;
                }
                leftZoneSize++;
            }
            if (arr[start] == 2) {
                swap(arr, start, n - 1 - rightZoneSize);
                if (arr[start] == 0){
                    swap(arr, start, leftZoneSize);
                    leftZoneSize++;
                }
                rightZoneSize++;

            }
            start++;
        }
        return arr;
    }

    public static int[] sortColorsCorrect(int[] arr){
        // the zones look something like this -
        // [ 0 zone ][ unknown zone ][ 2 zone ]
        // 0 ... leftZoneSize-1 all 0s
        // leftZoneSize ... start-1 all 1s
        // start ... n-1-rightZoneSize unknown zone
        // n-rightZoneSize ... n-1 all 2s
        int n = arr.length;
        int leftZoneStart = 0;
        int rightZoneStart = 0;
        int start = 0;
        while ( start <= n - 1 - rightZoneStart){
            if (arr[start] == 0){
                swap(arr, start, leftZoneStart);
                leftZoneStart++;
                // can increment start here as we are iterating from the left and are 100% sure that the element on the left of start are 0
                start++;
            }
            else if (arr[start] == 2){
                swap(arr, start, n - 1 - rightZoneStart);
                rightZoneStart++;
                // can't increment start here as we have no idea what the element which was brought from the right is
            }
            else {
                start++;
            }
        }
        return arr;
    }

    public static int[] sortColorsOpt2(int[] arr) {
        int n = arr.length;

        int leftZoneSize = 0;   // number of 0s fixed on the left
        int rightZoneSize = 0;  // number of 2s fixed on the right

        int start = 0;

        while (start <= n - 1 - rightZoneSize) {

            // 0 should go into the left zone
            if (arr[start] == 0) {
                swap(arr, start, leftZoneSize);
                leftZoneSize++;
                start++;
            }

            // 2 should go into the right zone
            else if (arr[start] == 2) {
                swap(arr, start, n - 1 - rightZoneSize);
                rightZoneSize++;

                // IMPORTANT:
                // Don't increment start here.
                // The element that came from the right is still unknown.
            }

            // 1 naturally belongs between the two zones
            else {
                start++;
            }
        }

        return arr;
    }


    public static void main(String[] args) {
        int[] res = sortColorsOpt(new int[]{0, 1, 2});
        for (int i : res) {
            System.out.println(i);
        }
    }
}
