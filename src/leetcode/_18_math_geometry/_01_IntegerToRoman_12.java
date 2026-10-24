package leetcode._18_math_geometry;

import java.util.*;

public class _01_IntegerToRoman_12 {
    // TODO - Given a number we have to convert it into its roman equivalent
    // 1 <= num <= 3999

    public static String integerToRoman(int n) {
        // 1. Let's find the biggest divisor which doesn't return the remainder as 0
        // 2. Now return a string with multiples of the said divisor if the quotient is more than 1;
        // 3. Now we need to find the next divisor
        // 3.1 We only need to find the next divisor if the remainder is not 0
        // 4. Lets handle the cases when the remainder is 4 or 9
        int[] divisors = new int[]{1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
        HashMap<Integer, String> romanMap = new HashMap<Integer, String>();
        romanMap.put(1, "I");
        romanMap.put(5, "V");
        romanMap.put(10, "X");
        romanMap.put(50, "L");
        romanMap.put(100, "C");
        romanMap.put(500, "D");
        romanMap.put(1000, "M");
        romanMap.put(4, "IV");
        romanMap.put(9, "IX");
        romanMap.put(40, "XL");
        romanMap.put(90, "XC");
        romanMap.put(400, "CD");
        romanMap.put(900, "CM");
        StringBuilder res = new StringBuilder();
        for (int i = divisors.length - 1; i >= 0; i--) {
            int quotient = n / divisors[i];
            int remainder = n % divisors[i];
            String currRomanRep = romanMap.get(divisors[i]);
            int divResult = quotient * divisors[i];
            if (romanMap.containsKey(divResult)) {
                res.append(romanMap.get(divResult));
            } else {
                if (quotient != 0) {
                    res.append(String.valueOf(currRomanRep).repeat(quotient));
                }
            }
            n = remainder;
        }

        return res.toString();

    }

    public static String integerToRomanOpt(int n) {
        int[] divisors = new int[]{1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
        String[] romanMap = new String[]{"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};
        int len = divisors.length;
        StringBuilder res = new StringBuilder();
        for (int i = len - 1; i >= 0; i--) {
            while (n / divisors[i] != 0) {
                res.append(romanMap[i]);
                n -= divisors[i];
            }
        }
        return res.toString();
    }


    public static void main(String[] args) {
        System.out.println(integerToRomanOpt(1994));
    }
}

