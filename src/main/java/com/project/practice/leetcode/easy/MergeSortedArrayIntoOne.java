package com.project.practice.leetcode.easy;

public class MergeSortedArrayIntoOne {
    /**
     * Compare from last for both arrays..
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m-1, j = n-1, k= m + n -1;
        while(i>=0 && j>=0){
            nums1[k--] = nums1[i] > nums2[j] ? nums1[i--] : nums2[j--];
        }
        while (j >=0 )
            nums1[k--] = nums2[j--];
    }
}
