package com.project.practice.leetcode.windowsliding;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class LengthOfLongestSubstringTwoDistinct {

    public static void main(String[] args) {
        String s = "eceba";
        System.out.println(lengthOfLongestSubstringTwoDistinct(s));
    }

    public static int lengthOfLongestSubstringTwoDistinct(String s) {
        int len = s.length();
        if (len < 3) return len;

        int maxLen = 2;
        int end=0, start =0;
        Map<Character, Integer> map = new HashMap<>();
        while ( end < len) {
            if (map.size() < 3){
                map.put(s.charAt(end), end++);
            }
            if (map.size() == 3)
            {
                int minIdx = Collections.min(map.values());
                map.remove(s.charAt(minIdx));
                start = minIdx + 1;
            }
            maxLen = Math.max(end -start , maxLen);
        }
        return maxLen;
    }
}
