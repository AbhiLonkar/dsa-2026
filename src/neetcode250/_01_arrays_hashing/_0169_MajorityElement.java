package neetcode250._01_arrays_hashing;

import java.util.HashMap;

public class _0169_MajorityElement {
    // Given an integer array we have to return an element who occurs more than nums.length/2 times

    // Let's put the elements and their counts in a hashmap and if at any point we encounter and element whose occurrence count is more than n/2 we return that element
    public static int majorityElement(int[] nums) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        int n = nums.length / 2;
        for (int i : nums) {
            hm.put(i, hm.getOrDefault(i, 0) + 1);
            if (hm.get(i) > n) {
                return i;
            }
        }
        return -1;
    }

    // if any element is in majority it means that it inherently occurs more times then the other elements
    // so what if we maintain a single variable to store the number of occurrences of an element, and whenever we reach 0 for this occurrence count it means that number of occurrences of a different number has cancelled out our current supposed majority element

    public static int majorityElementOpt(int[] nums) {
        int candidate = nums[0];
        int count = 1;
        for (int i = 1; i<nums.length; i++){
            if (count == 0){
                count++;
                candidate = nums[i];
            }
            else if (candidate == nums[i]) {
                count++;
            }
            else if (candidate != nums[i]) {
                count--;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(majorityElementOpt(new int[]{5,5,1,1,1,5,5}));
    }

}
