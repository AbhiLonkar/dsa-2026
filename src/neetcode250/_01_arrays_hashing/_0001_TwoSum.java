package neetcode250._01_arrays_hashing;

import java.util.HashMap;

public class _0001_TwoSum {
    // TODO: Given an integer array and a target element we need to return the indices of elements which add up to the target

    public static int[] twoSum(int[] arr, int target) {
        int n = arr.length;
        for (int i = 0; i<n; i++){
            for (int j = i+1; j<n; j++){
                if (arr[i] + arr[j] == target) {
                    return new int[] {i, j};
                }
            }
        }
        return new int[] {};
    }

    public static int[] twoSumOpt(int[] arr, int target){
        HashMap<Integer, Integer> hm = new HashMap<>();
        int n = arr.length;
        for (int i = 0; i<n; i++){
            // Need to generate a k v pair like which one of the right will be the el's position and on thr left will be target - el and if we encounter target - el at any point in that array we simply return those positions
            if (hm.containsKey(arr[i])){
                return new int[] {i, hm.get(arr[i])};
            }
            hm.put(target - arr[i], i);
        }
        return new int[] {};
    }

    public static void main(String[] args) {
        int[] res = twoSum(new int[] {3,3}, 6);
        for (int i: res){
            System.out.println(i);
        }
    }
}
