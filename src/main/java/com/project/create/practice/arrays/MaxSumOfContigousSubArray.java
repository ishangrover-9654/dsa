package com.project.create.practice.arrays;

public class MaxSumOfContigousSubArray {

    public static void main(String[] args) {

        int curr_max = 0;
        int max = 0;

        int arr[] = {};

        for (int i=0;i<=arr.length;i++){
            curr_max = Math.max(curr_max, curr_max+arr[i]);
            max = Math.max(curr_max, max);
        }

        System.out.println(max);

    }
}
