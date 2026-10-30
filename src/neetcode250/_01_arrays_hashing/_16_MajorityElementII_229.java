package neetcode250._01_arrays_hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class _16_MajorityElementII_229 {
    // TODO Given an integer array we need to return an array which consists of all the elements which appear more than ⌊ n/3 ⌋ times
    // ! The elements must appear strictly more than ⌊ n/3 ⌋ times.
    // ! If n = 5, then only those elements which appear more than 2 times should be included in the resultant array

    // * nums = [5,2,3,2,2,2,2,5,5,5], n = 10. ⌊ 10/3 ⌋ = 3
    // * o/p = [5, 2]
    // * In the above input 5 and 2 appear 4 and 5 times respectively, which is greater than 3 so we add those elements in the resultant array

    // * nums = [1,2,3,4,5], n = 5. ⌊ 5/3 ⌋ = 1
    // * o/p = []
    // * In the above input no element appear more than 1 times so we return an empty array

    // * nums = [4,4,4,4,4], n = 5, ⌊ 5/3 ⌋ = 1
    // * o/p = [4]
    // * In the above input 4 appears 5 times which is more than 1 so we add it to the result array

    // ? Approach -
    // Create a hashmap with the counts of all the elements
    // Traverse the hashmap and then add those elements to the result array whose count is more than ⌊ n/3 ⌋

    // % Time complexity
    // Array traversal - O(N)
    // Hashmap traversal - O(N)
    // Overall time - O(N) + O(N)

    // % Space complexity
    // Hashmap - O(N)

    public static List<Integer> majorityElement(int[] arr) {
        int n = arr.length;
        int count = Math.floorDiv(n, 3);
        List<Integer> res = new ArrayList<>();
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i : arr) {
            if (hm.containsKey(i)) {
                hm.put(i, hm.get(i) + 1);
            } else {
                hm.put(i, 1);
            }
        }
        for (Integer k : hm.keySet()) {
            if (hm.get(k) > count) {
                res.add(k);
            }
        }
        return res;
    }

    // TODO, Follow up - Solve the problem without using a hashmap in O(1) space

    // Let's try to implement a sorting based approach

    // % Time complexity
    // Sorting - O(NLogN)
    // Array traversal - O(N)
    // Overall time - O(NLogN) + O(N)

    // % Space complexity
    // Sorting - O(LogN) due to recursion stack of quicksort

    public static List<Integer> majorityElementOpt(int[] arr) {
        int n = arr.length;
        List<Integer> res = new ArrayList<>();
        int floor = Math.floorDiv(n, 3);
        Arrays.sort(arr);
        int count = 0;
        int left = 0, right = 0;
        while (right < n && arr[left] == arr[right]) {
            count++;
            if (count > floor) {
                res.add(arr[left]);
            }
            left = right;
            right++;
            count = 0;
        }
        return res;
    }


    static void main() {
        System.out.println(majorityElement(new int[]{1, 2}));
    }
}
