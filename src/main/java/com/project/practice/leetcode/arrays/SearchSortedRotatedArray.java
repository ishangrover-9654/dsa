package com.project.practice.leetcode.arrays;

public class SearchSortedRotatedArray {
    public static void main(String[] args) {

    }

    public int search(int[] nums, int target, int low, int high){
        if (low > high)
            return -1;

        int mid = (low + high) / 2;
        if (nums[mid]==target)
            return mid;

        /**
         * 1st half that is till mid it is sorted
         */
        if (nums[low] <= nums[mid]){
            /**
             * Check if it lies in 1st half
             */
            if (target >= nums[low] && target < nums[mid])
                return search(nums, target, low, mid -1);
            /**
             * It lies in another half
             */
            return search(nums, target, mid+1, high);
        }

        /**
         * 1st half till mid is not sorted, another half after mid
         * is sorted
         */
        else {
            /**
             * element lies in another half
             */
            if (target > nums[mid]  && target <= nums[high])
                return search(nums, target, mid + 1, high);
            return search(nums, target, low, mid - 1);
        }

    }
}
