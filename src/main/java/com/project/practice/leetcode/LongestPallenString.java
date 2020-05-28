package com.project.practice.leetcode;

public class LongestPallenString {
    static int resultStart;
    static int resultLength;


    public static void main(String[] args) {
        System.out.println(longestPallen("aba"));
    }

    public static String longestPallen(String s){
        int sLen = s.length();
        for (int start = 0; start < sLen - 1; start++) {
            expand(s, start, start);
            expand(s, start, start + 1);
        }
        return s.substring(resultStart, resultStart + resultLength);
    }

    public static void expand(String s, int start, int end){
        while (start>=0 && end < s.length() && s.charAt(start)==s.charAt(end)){
            start--;
            end++;
        }
        if (resultLength  < end - start - 1){
            resultStart = start + 1;
            resultLength = end -start - 1;
        }
    }
}
