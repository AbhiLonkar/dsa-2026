package neetcode250._01_arrays_hashing;

import java.io.Flushable;
import java.util.*;

public class _06_GroupAnagramsOpt_49 {
    // hint instead of comparing a string with every other string why don't we compare the sorted strings themselves

    public static String sortedString(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

    // the approach would be something like store the unique keys in a hash set then traverse the original string array and then keep putting the strings with the same unique key in a hashmap and then add all the values of a hashmap into a list
    public static List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> uniqueKeys = new HashMap<>();
        for (String s: strs){
            uniqueKeys.put(sortedString(s), new ArrayList<>());
        }
        for (String s: strs){
            String uniqueKey = sortedString(s);
            List<String> oldList = uniqueKeys.get(uniqueKey);
            oldList.add(s);
            uniqueKeys.put(uniqueKey, oldList);
        }
        List<List<String>> res = new ArrayList<>(uniqueKeys.values());
        return res;
    }

    public static void main(String[] args) {
        System.out.println(groupAnagrams(new String[] {"act", "pots", "tops", "cat", "stop", "hat"}));
    }
}
