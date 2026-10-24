package neetcode250._18_math_geometry;

import java.util.HashMap;

public class _0013_RomanToInteger {
    // TODO - Given a string which has roman characters we need to convert the said string into a integer

    public static int romanToInteger(String s){
        // A hint: need to check whether the before value is smaller than the next value
        HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
        hm.put('I', 1);
        hm.put('V', 5);
        hm.put('X', 10);
        hm.put('L', 50);
        hm.put('C', 100);
        hm.put('D', 500);
        hm.put('M', 1000);
        int res = 0;
        for (int i = 0; i<s.length(); i++){
            if (i + 1 <s.length() && (hm.get(s.charAt(i)) < hm.get(s.charAt(i+1)))) {
                res -= hm.get(s.charAt(i));
            }
            else {
                res += hm.get(s.charAt(i));
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(romanToInteger("MCMXCIV"));
    }
}
