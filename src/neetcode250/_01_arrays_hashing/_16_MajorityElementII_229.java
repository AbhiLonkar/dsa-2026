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

    // Let's try to implement a sorting based approach

    // % Time complexity
    // Sorting - O(NLogN)
    // Array traversal - O(N)
    // Overall time - O(NLogN) + O(N)

    // % Space complexity
    // Sorting - O(LogN) due to recursion stack of quicksort

    public static List<Integer> majorityElementSorting(int[] arr) {
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

    // Still with the above approach we weren't able to achieve the linear time and constant space

    // TODO, Follow up - Solve the problem without using a hashmap in O(1) space

    // Rough work -
    // arr = [1,1,1,1,2,2,3,3,3,3], n=10, floor=3. So only 2 elements occur more than 3 times
    // arr = [1,1,1,2,2], n=5, floor=1, so only 2 elements occur more than 1 times
    // arr = [1,1,2,2,3,3], n=6, floor=2, no element occurs more than 2 times
    // arr = [1,1,1,1,1], n=5, floor=1, only 1 element occurs more than 1 times
    // arr = [1,1,1,1,2], n=5, floor=1, only 1 element occurs more than 1 times
    // arr = [1,1,1,1,1,2,2,2,3,3,3,3,3,4], n=14, floor=4, only 2 elements occurs more than 4 times
    // arr = [1,1,1,1,2,2,2,2,3], n=9, floor=3, only 2 elements occurs more than 3 times

    // arr = [1,1,1,1,2,2,2,2,3], n=9, floor=3
    // ? Can we try to fit 3 majority elements in there without changing array size?
    // ? I'll need to have 3 elements having count at least as 4. But I cannot do that without changing the array size

    // * It appears that for any n there can only be at most 2 elements which occur more than floor of n/3 times

    // ? Intuition for the algorithm - We'll use 2 candidates and each candidate will have a counter

    public static List<Integer> majorityElementOpt(int[] arr) {
        int n = arr.length;
        int floor = Math.floorDiv(n, 3);
        Integer candidateOne = null, candidateTwo = null;
        int count1 = 0, count2 = 0;

        // Candidate selection step
        for (int i = 0; i < n; i++) {
            // Assign a candidate and set its count to 1, also make sure that both the candidates aren't same
            if (candidateOne.equals(arr[i])) {
                count1++;
            }
            else if (candidateTwo.equals(arr[i])) {
                count2++;
            }
            // if we encounter a duplicate candidateOne we increment its counter
            else if (count1 == 0) {
                candidateOne = arr[i];
                count1 = 1;
            }
            // Assign a candidate and set its count to 1, also make sure that both the candidates aren't same
            else if (count2 == 0) {
                candidateTwo = arr[i];
                count2 = 1;
            }
            // if we encounter a duplicate candidateTwo we increment its counter

            // if we encounter a different element than candidateOne and candidateTwo we decrement both the counts
            else if (!candidateOne.equals(arr[i]) && !candidateTwo.equals(arr[i])) {
                count1--;
                count2--;
                if (count1 == 0) {
                    candidateOne = null;
                }
                if (count2 == 0) {
                    candidateTwo = null;
                }
            }
        }

        // Candidate verification step
        count1 = 0;
        count2 = 0;
        List<Integer> res = new ArrayList<>();
        for (Integer i : arr) {
            if (i.equals(candidateOne)) {
                count1++;
            } else if (i.equals(candidateTwo)) {
                count2++;
            }
        }
        if (count1 > floor) {
            res.add(candidateOne);
        }
        if (count2 > floor) {
            res.add(candidateTwo);
        }
        return res;
    }

    static void main() {
        System.out.println(majorityElementOpt(new int[]{2, 1, 1, 3, 1, 4, 5, 6}));
    }
}
