package com.project.practice.leetcode.windowsliding;

import java.util.HashSet;
import java.util.Set;

public class LongestSubStringWithoutRepeating {

    public static void main(String[] args) {
        String s = "pwwkew";
        System.out.println(lengthOfLongestSubstring(s));
    }

    public static int lengthOfLongestSubstring(String s) {
        int len = s.length();
        Set<Character> set =  new HashSet<>();
        int maxLen =0, start = 0, end =0;

        while( end < len && start < len) {
            if (!set.contains(s.charAt(end))) {
                set.add(s.charAt(end++));
                maxLen = Math.max(end - start , maxLen);
            }
            else{
                set.remove(s.charAt(start++));
            }
        }
        return maxLen;
    }
}
