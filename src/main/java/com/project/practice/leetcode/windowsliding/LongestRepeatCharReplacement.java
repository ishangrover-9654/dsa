package com.project.practice.leetcode.windowsliding;

public class LongestRepeatCharReplacement {

    public static void main(String[] args) {
        String str = "AABABBA";
        System.out.println(characterReplacement(str, 1));
    }

    public static int characterReplacement(String s, int k) {
        int[] count = new int[26];
        int start = 0, maxCount = 0, maxWindow = 0;
        for (int end = 0; end < s.length(); end++) {
            maxCount = Math.max(maxCount, ++count[s.charAt(end) - 'A']);
            while(end - start + 1 - maxCount > k){
                count[s.charAt(start) - 'A']--;
                start++;
            }
            maxWindow = Math.max(maxWindow, end - start + 1);
        }
        return maxWindow;
    }
}
