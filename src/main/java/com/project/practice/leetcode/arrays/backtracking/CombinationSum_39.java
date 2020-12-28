package com.project.practice.leetcode.arrays.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of candidates where the chosen numbers sum to target. You may return the combinations in any order.
 *
 * The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the frequency of at least one of the chosen numbers is different.
 *
 * It is guaranteed that the number of unique combinations that sum up to target is less than 150 combinations for the given input.
 *
 *
 *
 * Example 1:
 *
 * Input: candidates = [2,3,6,7], target = 7
 * Output: [[2,2,3],[7]]
 * Explanation:
 * 2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
 * 7 is a candidate, and 7 = 7.
 * These are the only two combinations.
 * Example 2:
 *
 * Input: candidates = [2,3,5], target = 8
 * Output: [[2,2,2,2],[2,3,3],[3,5]]
 * Example 3:
 *
 * Input: candidates = [2], target = 1
 * Output: []
 */
public class CombinationSum_39 {


   static List<List<Integer>> res = new ArrayList<>();
    public static void main(String[] args) {
        int[] arr = {2,3,6,7};
        int target = 7;

        System.out.println(combinationSum(arr, target));
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {

        combination(candidates, 0, target, new ArrayList<>());
        return res;
    }

    public static void combination(int[] arr, int idx, int target, List<Integer> list){
        if (target==0){
            res.add(new ArrayList<>(list));
            return;
        }


        for (int i = idx; i < arr.length; i++) {
         if (arr[i] <= target){
             list.add(arr[i]);
             combination(arr, i, target - arr[i], list);
             list.remove(list.size() - 1);
         }
        }
    }

}
