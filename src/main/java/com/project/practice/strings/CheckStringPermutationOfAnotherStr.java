package com.project.practice.strings;

import com.project.practice.arrays.ArrayUtil;

/**
 * Maintain Count array
 * Increment count on traversing first string
 * Decrement count on traversing second array
 * if count is 0 return true
 */
public class CheckStringPermutationOfAnotherStr {
    public static void main(String[] args) {
        System.out.println(hasPermutation("asdegh", "edsahf"));
    }

    public static boolean hasPermutation (String str1, String str2) {
        int count[] = new int[26];
        for (int i = 0; i < str1.length() && i < str2.length(); i++) {
            count[str1.charAt(i) - 'a'] ++;
            count[str2.charAt(i) - 'a'] --;
        }

        for (int i = 0; i < str1.length(); i++) {
            if (count[str1.charAt(i) - 'a']!=0)
                return false;
        }

       // ArrayUtil.print(count);

        return true;
    }
}
