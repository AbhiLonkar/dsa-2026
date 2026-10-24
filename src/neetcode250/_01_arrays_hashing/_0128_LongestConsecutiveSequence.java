package neetcode250._01_arrays_hashing;

import java.util.Arrays;
import java.util.HashSet;


public class _0128_LongestConsecutiveSequence {
    // ? this algo is working in O(nlogn) time due to the sorting based approach
    // How to solve it in O(N) time?
    public static int longestConsecutiveSequence(int[] arr) {
        Arrays.sort(arr);
        int currSize = 1;
        int maxSize = 1;
        for (int i = 0; i < arr.length - 1; i++) {
            int diff = Math.abs(arr[i + 1] - arr[i]);
            if (diff == 1) {
                currSize++;
                if (currSize > maxSize) {
                    maxSize = currSize;
                }
            }
            // Start a new sequence
            else if (diff > 1) {
                currSize = 1;
            }
        }
        return maxSize;
    }

    public static int longestConsecutiveSequenceOpt(int[] arr) {
        // ? In the optimal approach we'll be putting all the elements of the array into the hashset as hashset supports O(1) lookup

        HashSet<Integer> hs = new HashSet<>();
        for (int i : arr) {
            hs.add(i);
        }
        int longest = 1;
        int currLongest = 1;

        // ? 1. Find the starting element of a sequence
        // ? How? Check if its previous element (currEl - 1) exists in the hashset
        for (int currEl : hs) {
            int prevEl = currEl - 1;
            int nextEl = currEl + 1;
            if (!hs.contains(prevEl)) {
                while (hs.contains(nextEl)) {
                    nextEl = nextEl + 1;
                    currLongest++;
                    longest = Math.max(currLongest, longest);
                }
                currLongest = 1;
            }
        }
        return longest;
    }

    public static void main(String[] args) {
        System.out.println(longestConsecutiveSequenceOpt(new int[]{102, 4, 100, 1, 101, 3, 2}));
    }
}
