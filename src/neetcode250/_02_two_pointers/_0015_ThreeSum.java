package neetcode250._02_two_pointers;

import java.util.*;

public class _0015_ThreeSum {
    // TODO - Given an integer array we have to return a list of triplets who when added equate to 0
    // TODO - nums[i] + nums[j] + nums[k] == 0, and i, j and k should all be different
    // TODO - There should be no duplicate triplets

    // Constraints - 3 <= nums.length <= 3000
    // -105 <= nums[i] <= 105

    public static List<List<Integer>> threeSum(int[] nums) {
        // 1. Lets write a function to find the triplets whose sum is 0
        // first approach that I can think of is through a triple for loop
        // the time limit exceeded with this approach
        HashSet<List<Integer>> uniqueTriplets = new HashSet<List<Integer>>();
        int n = nums.length;
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> triplet = new ArrayList<>();
                        triplet.add(nums[i]);
                        triplet.add(nums[j]);
                        triplet.add(nums[k]);
                        // To keep unique triplets because while inserting into hashset if the array elements is not correct even though the elements are present it'll not treat them as duplicate
                        Collections.sort(triplet);
                        // We now just added the triplet into the unique triplet hashset, to avoid duplicates
                        uniqueTriplets.add(triplet);
                    }
                }
            }
        }
        // we simply generate a new list with the entries from the hashset
        return new ArrayList<>(uniqueTriplets);
    }

    public static List<List<Integer>> threeSumOpt(int[] nums) {
        // Logic would be to fix an element and since the remaining subarray is sorted I'll just implement twosum on the sorted array
        // now about handling the duplicates, if current fixed element was the same as the last fixed element we need to fix that combination
        // think of it such that x + y + z = 0, we wouldnt want to generate a same combination by keeping x as the same, so we instead skip that iteration entirely
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        // fixing an element (x in this case)
        for (int i = 0; i + 2 < n; i++) {
            if (i > 0 && nums[i - 1] == nums[i]) {
                continue;
            }
            int left = i + 1;
            int right = n - 1;
            while (left < right) {
                // sum = x + l + r;
                int sum = nums[i] + nums[left] + nums[right];
                if (sum > 0) {
                    // if sum exceeds 0 means our current right value is large so we need to move the right pointer backwards
                    right--;
                } else if (sum < 0) {
                    // if sum is lesser than 0 means our current left value is small so we need to move the left pointer forwards
                    left++;
                } else {
                    // we find a valid triplet combination
                    List<Integer> triplet = new ArrayList<>();
                    triplet.add(nums[i]);
                    triplet.add(nums[left]);
                    triplet.add(nums[right]);
                    res.add(triplet);
                    // lets move to the next left & right element
                    left++;
                    right--;
                    // but if our new left element is the same as our previous left which generated a valid solution with our fixed number (fixed hasn't moved yet) we need to move left forward till we find a new value for nums[left]
                    while (left < right && nums[left - 1] == nums[left]) {
                        left++;
                    }
                    // but if our new right element is the same as our previous right which generated a valid solution with our fixed number (fixed hasn't moved yet) we need to move right backward till we find a new value for nums[right]
                    while (left < right && nums[right + 1] == nums[right]) {
                        right--;
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        List<List<Integer>> res = threeSumOpt(new int[]{-1, 0, 1, 2, -1, -4});
        System.out.println(res);
    }
}
