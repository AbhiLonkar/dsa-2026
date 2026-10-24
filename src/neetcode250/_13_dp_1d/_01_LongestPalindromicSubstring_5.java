package neetcode250._13_dp_1d;

public class _01_LongestPalindromicSubstring_5 {
    // TODO - We're given a string we have to return the longest palindromic substring

    // ? Approach - Double for loop and a palindrome checker function
    // ? The issue with this is approach is O(n2) time complexity
    public static boolean isPalindrome(String s){
        int left = 0;
        int right = s.length()-1;
        while (left < right){
            if (s.charAt(left) != s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static String longestPalindromicSubstring(String s){
        String currLongest = String.valueOf(s.charAt(0));
        int n = s.length();
        if (n == 1){
            return s;
        }
        for (int i = 0; i<n; i++){
            for (int j = i+1; j<n; j++){
                String subString = s.substring(i, j+1);
                if (isPalindrome(subString)){
                    if (currLongest.length() < subString.length()){
                        currLongest = subString;
                    }
                }
            }
        }
        return currLongest;
    }

    public static void main(String[] args) {
        System.out.println(longestPalindromicSubstring("babad"));
    }
}
