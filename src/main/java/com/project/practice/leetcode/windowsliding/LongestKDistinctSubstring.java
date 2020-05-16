package com.project.practice.leetcode.windowsliding;

import javafx.beans.binding.IntegerBinding;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class LongestKDistinctSubstring {

    public static void main(String[] args) {
        String s = "bacc";
        int k = 2;
        System.out.println
         (new LongestKDistinctSubstring().
                 lengthOfLongestSubstringKDistinct(s, k));
    }

    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int len= s.length();
        if (len*k == 0) return 0;

        int start = 0;
        int end = 0;
        int maxLen = 1;
        Map<Character, Integer> map = new LinkedHashMap<>(k+1);

        while( end < len){
            Character character = s.charAt(end);

            if (map.containsKey(character))
                map.remove(character);
            map.put(character, end++);

            if (map.size() == k + 1){
                Map.Entry<Character, Integer> leftMost = map.entrySet().iterator().next();
                map.remove(leftMost.getKey());
                start = leftMost.getValue() + 1;
            }

            maxLen = Math.max(maxLen, end - start);
        }
        return maxLen;
    }
}
