package com.project.practice.leetcode.arrays;

/**
 * Given an array of positive integers arr,  find a pattern of length m
 * that is repeated k or more times.
 *
 * A pattern is a subarray (consecutive sub-sequence) that consists of
 * one or more values, repeated multiple times consecutively without overlapping.
 * A pattern is defined by its length and the number of repetitions.
 *
 * Return true if there exists a pattern of length m that is repeated k or more times,
 * otherwise return false.
 *
 * Input: arr = [1,2,1,2,1,1,1,3], m = 2, k = 2
 * Output: true
 * Explanation: The pattern (1,2) of length 2 is repeated 2 consecutive times.
 * Another valid pattern (2,1) is also repeated 2 times.
 *
 *
 */
public class CheckRepeatedPatternKTimesInNumArray {
    public static void main(String[] args) {
        int arr [] = {1,2,1,2,1,1,1,3};
        System.out.println(containsPattern(arr, 2, 2));
    }

    public static boolean containsPattern(int[] arr, int m, int k) {
        int cnt = 0;
        for (int i = 0; i < arr.length - m; i++) {
            if (arr[i]!=arr[i+m])
                cnt = 0;
            else
                cnt++;

            if (cnt == m*(k-1))
                return true;
        }
        return false;
    }
}
