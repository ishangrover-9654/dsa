package com.project.practice.leetcode.dp;

/**
 * Input: "abab"
 * Output: True
 * Explanation: It's the substring "ab" twice.
 *
 * Input: "aba"
 * Output: False
 *
 * Input: "abcabcabcabc"
 * Output: True
 * Explanation: It's the substring "abc" four times. (And the substring "abcabc" twice.)
 */
public class RepeatedSubstringPattern {
    public static void main(String[] args) {
        String s = "aba";
        System.out.println(repeatedSubstringPattern(s));
    }
    public static boolean  repeatedSubstringPattern(String s) {
        int n = s.length();
        int[] dp = new int[n];

        for (int i = 1; i < n; i++) {
            int j = dp[i-1];

            /**
             * abbb
             * after ab len = 1
             * but when its start to not be equal re assign j
             * to it's old value
             */
            while (j>0 && s.charAt(i)!=s.charAt(j)){
                j = dp[j - 1];
            }

            /**
             * increment length as start of the substring is same
             */
            if (s.charAt(i)==s.charAt(j)){
                ++j;
            }
            dp[i] = j;
        }
        /**
         * final length of repeated substring
         */
        int subLen = dp[n-1];

        return (subLen>0 && n % (n - subLen) == 0);
    }

}
