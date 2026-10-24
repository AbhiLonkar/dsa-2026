package leetcode._02_two_pointers;

import java.lang.reflect.Array;
import java.util.*;

public class _0016_ThreeSumClosest {
    // TODO - Given an integer array and a target sum we need to return the "sum" of the triplet which is the closest to the target
    // ex. nums = [-1,2,1,-4], target = 1
    // Triplets -
    // [-1,2,1]  -> sum = 2
    // [-1,2,-4] -> sum = -3
    // [-1,1,-4] -> sum = -4
    // [2,1,-4] -> sum = -1

    // Now to find the closest we need to find the absolute difference between the target and the sum
    // We'll also need to track that minimum value and compare each triplet's generated sum with the current smallest sum

    // First lets write an algo to find the 3Sum, with a sorted array

    public static int closestThreeSum(int[] arr, int target) {
        int n = arr.length;
        int res = Integer.MAX_VALUE;
        for (int i = 0; i + 2 < n; i++) {
            int left = i + 1;
            int right = n - 1;
            while (left < right) {
                int sum = arr[i] + arr[left] + arr[right];
                int absDiff = Math.abs(sum - target);
                // now that I've found abs diff, ie I'm calculating the distance between the target and the sum we've got the current triplet
                // how do I decide what should be the the res, sum
                if (sum > target) {
                    right--;
                } else if (sum < target) {
                    left++;
                }

            }

        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(closestThreeSum(new int[]{-1, 2, 1, -4}, 1));
        // sorted = [-4,-1,1,2]
        // sum = -4 - 1 + 1 = -4; abs = |1 - (-4)| = 5; currMin = 5
        // left moved forward as sum is less than target, sum = -4 + 1 + 2 = -1, abs = |2 - (-1)| = 3, currMin = 3
        // left moved forward as sum is less than tareget, but it has now crossed right
        // so i increases
        //
    }
}
