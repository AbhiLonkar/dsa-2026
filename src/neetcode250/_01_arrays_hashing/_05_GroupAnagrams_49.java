package neetcode250._01_arrays_hashing;

import java.util.*;

public class _05_GroupAnagrams_49 {
    // given an array of strings we have to return of list of grouped anagrams in a list
    // ex - str = ["act","pots","tops","cat","stop","hat"]
    // output - Output: [["hat"],["act", "cat"],["stop", "pots", "tops"]]
    // Constraints:
    //    1 <= strs.length <= 10000.
    //    0 <= strs[i].length <= 100
    //    strs[i] is made up of lowercase English letters.


    // two strings are anagrams if all the characters from string 1 and present in string 2 as well
    // now which data structure should I use to check it?
    // don't need a hashmap as the question states that there'll only be lower case characters
    public static boolean isAnagram(String s1, String s2) {
        int[] occurences = new int[26];
        if (s1.length() != s2.length()) {
            return false;
        }
        for (int i = 0; i < s1.length(); i++) {
            int pos1 = s1.charAt(i) - 'a';
            int pos2 = s2.charAt(i) - 'a';
            occurences[pos1]++;
            occurences[pos2]--;
        }
        for (int i : occurences) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }

    public static String sortString(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

    // now we'll check each string with every other string of the array
    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        HashSet<String> encountered = new HashSet<>();
        for (int i = 0; i < strs.length; i++) {
            if (encountered.contains(sortString(strs[i]))) {
                continue;
            }
            List<String> anagrams = new ArrayList<>();
            anagrams.add(strs[i]);
            String s1 = strs[i];
            for (int j = i + 1; j < strs.length; j++) {
                String s2 = strs[j];
                if (isAnagram(s1, s2)) {
                    anagrams.add(s2);
                }
            }
            encountered.add(sortString(s1));
            res.add(anagrams);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(groupAnagrams(new String[]{"act", "pots", "tops", "cat", "stop", "hat"}));
    }
}
