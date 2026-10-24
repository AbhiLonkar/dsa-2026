package neetcode250._01_arrays_hashing;

public class _0027_RemoveElement {
    // Given an integer array and a value we need to remove all the occurrences of value in the array, move the remaining values to the start and return the count of the remaining values

    // ? Approach - Let's keep two pointers read and write, read will iterate over the entire array, and write which will be used to say at which position our target is present.
    // ? When we encounter our target we keep moving the read pointer until we find a non target value, once we find it we swap it with the target present at our write position.
    // ? After swapping we move both the read and write pointers forward
    // ? At the end we'll just return write + 1, as all the elements on the left of write will be non target value element
    public static int removeElement(int[] nums, int target) {
        int n = nums.length;
        int write = 0;
        for (int read = 0; read < n; read++) {
            if (nums[read] != target) {
                nums[write] = nums[read];
                write++;
            }
        }
        return write;
    }

    public static void main(String[] args) {
        System.out.println(removeElement(new int[]{3, 2, 2, 3}, 2));
    }
}
