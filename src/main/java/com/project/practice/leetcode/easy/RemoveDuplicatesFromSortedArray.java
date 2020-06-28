package com.project.practice.leetcode.easy;

import java.util.Arrays;

public class RemoveDuplicatesFromSortedArray {

    public static void main(String[] args) {
        int nums[] = {0,0,1,1,1,2,2,3,3,4};
        System.out.println(removeDuplicates(nums));
        Arrays.asList(nums).stream().forEach(System.out::println);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }

    public static int removeDuplicates(int[] nums) {
        int ans = 1;
        int idx = 0;
        if (nums.length==0)
            return 0;
        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[i] != nums[i-1]){
                ans ++;
                idx++;
                nums[idx] = nums[i+1];
            }
        }
        nums[ans] = nums[nums.length -1];

        return ans + 1;
    }
}
