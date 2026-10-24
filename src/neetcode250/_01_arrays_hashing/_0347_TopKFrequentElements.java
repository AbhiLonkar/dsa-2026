package neetcode250._01_arrays_hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class _0347_TopKFrequentElements {
    // TODO - Given an integer array and a count k we have to return k number of element with the highest frequency
    // TODO ex. nums = [1,2,2,2,2,2,3,3,3,4,4,4,4,7,7,7], k = 3
    // TODO 2 -> 5, 3 -> 3, 4 -> 4, 7 -> 3
    // TODO So we need to return 3 elements with the highest count
    // TODO which would be 2, 4, 7 or 3
    // ? res -> [2,4,7] or [2,4,3]

    // ? First let's try to count the occurrences of all the elements in the array
    // ? Now that counting is done we need to find k elements with the highest frequency
    // * How do I do that?
    // * Can I do something like while we haven't found k number of element we find the max from the count then add it in the res array, then remove it from the hashmap?


    public static int[] topKFrequent(int[] arr, int k) {
        HashMap<Integer, Integer> countMap = new HashMap<>();
        int[] res = new int[k];
        for (int i : arr) {
            countMap.put(i, countMap.getOrDefault(i, 0) + 1);
        }

        // the chokepoint is below, as if k = array length, we'll have to iterate O(n*k) times
        int insertPos = 0;
        while (insertPos < k) {
            int maxCount = Integer.MIN_VALUE;
            int maxCountEl = countMap.keySet().iterator().next();
            for (int key : countMap.keySet()) {
                if (countMap.get(key) > maxCount) {
                    maxCount = countMap.get(key);
                    maxCountEl = key;
                }
            }
            countMap.remove(maxCountEl);
            res[insertPos] = maxCountEl;
            insertPos++;
        }
        return res;
    }

    public static int[] topKFrequentOpt(int[] arr, int k) {
        int n = arr.length;
        HashMap<Integer, Integer> countMap = new HashMap<>();
        int[] res = new int[k];
        for (int i : arr) {
            countMap.put(i, countMap.getOrDefault(i, 0) + 1);
        }
        // We'll use a 2d array to store the elements whose count matches that position
        // but how do I decide the size of the parent array?
        // think of the worst case scenario only a singular element is present
        // [8,8,8,8,8,8,8,8]
        // in the above length is 8, I'll need to have at most 8 positions, because 8 is repeated 8 times and needs to be put into the 7th position (0 based indexing)
        // an approach would be to find the max frequency but with this approach we are adding extra looping through the hashmap
        List<List<Integer>> resList = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            resList.add(new ArrayList<>());
        }
        for (int key : countMap.keySet()) {
            int pos = countMap.get(key);
            List<Integer> childList = resList.get(pos - 1);
            childList.add(key);
        }
        int insertPos = 0;
        for (int i = n - 1; i >= 0; i--) {
            List<Integer> childList = resList.get(i);
            for (int j : childList) {
                res[insertPos] = j;
                insertPos++;
                if (insertPos >= k) {
                    return res;
                }
            }
        }
        return res;
    }


    public static void main(String[] args) {
        int[] res = topKFrequentOpt(new int[]{1, 1, 2, 2, 2, 3, 3, 4, 4, 4, 6, 6, 6, 7, 7, 7, 7, 7, 8}, 2);
        for (int i : res) {
            System.out.println(i);
        }
    }
}
