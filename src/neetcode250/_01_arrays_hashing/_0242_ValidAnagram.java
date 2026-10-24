package neetcode250._01_arrays_hashing;

public class _0242_ValidAnagram {
    public static boolean isAnagram(String s, String t){
        int[] countOfChars = new int[26];
        for(int i = 0; i<s.length(); i++){
            int pos = s.charAt(i) - 97;
            countOfChars[pos]++;
        }
        for(int i = 0; i<t.length(); i++){
            int pos = t.charAt(i) - 97;
            countOfChars[pos]--;
        }
        for (int i: countOfChars){
            if (i!=0){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println(isAnagram("xx", "x"));
    }
}
