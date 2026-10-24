package neetcode250._01_arrays_hashing;

public class _0014_LongestCommonPrefix {
    public static String longestCommonPrefix(String[] strs) {
        StringBuilder res = new StringBuilder();
        boolean isCharacterPresent = true;
        int n = strs.length;
        String fixedString = strs[0];
        int comparePos = 0;
        // I need to write a loop such that I can iterate over each character of each string and not change the position until we reach the last string
        while (comparePos < fixedString.length()) { // loop to iterate over each position of said string, one string at a time
            for (int i = 1; i < n; i++) { // loop to iterate over all the strings
                if (comparePos < strs[i].length()) {
                    if (fixedString.charAt(comparePos) != strs[i].charAt(comparePos)) {
                        isCharacterPresent = false;
                        break;
                    }
                } else {
                    break;
                }
            }
            if (isCharacterPresent) {
                res.append(fixedString.charAt(comparePos));
            }
            comparePos++;
            if (comparePos >= fixedString.length()) {
                isCharacterPresent = false;
            }
        }
        return res.toString();
    }

    public static String longestCommonPrefixV2(String[] strs) {
        int n = strs.length;
        String fixedString = strs[0];
        int currCharPos = 0;
        while (currCharPos < fixedString.length()) {
            for (int i = 1; i < n; i++) {
                if (currCharPos >= strs[i].length()) {
                    return fixedString.substring(0, currCharPos);
                }
                if (fixedString.charAt(currCharPos) != strs[i].charAt(currCharPos)){
                    return fixedString.substring(0, currCharPos);
                }
            }
            currCharPos++;
        }
        return fixedString.substring(0, currCharPos);
    }

    public static void main(String[] args) {
        System.out.println(longestCommonPrefixV2(new String[]{"abc","abcde","abcd"}));
    }
}
