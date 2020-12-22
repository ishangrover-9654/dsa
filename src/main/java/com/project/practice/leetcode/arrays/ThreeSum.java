package com.project.practice.leetcode.arrays;

import com.project.practice.arrays.ArrayUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    public static void main(String[] args) {
        int[] arr = {-1,0,1,2,-1,-4};
        quickSort(arr, 0, arr.length - 1);
        //ArrayUtil.print(arr);
        System.out.println(threeSum(arr));
    }

    public static int partition(int[] arr, int low, int high){
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot){
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;
        return i+1;
    }

    public static void quickSort(int arr[], int low, int high){
        if (low < high){
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i=0; i<nums.length-2;i++){
            if (i==0 || (i>0 && nums[i]!=nums[i-1])){
                int low = i+1, high = nums.length-1, sum = 0 - nums[i];
                while (low < high){
                    if ( sum ==  nums[low] + nums[high]){
                        res.add(Arrays.asList(nums[i], nums[low], nums[high]));
                        while (low < high && nums[low]==nums[low+1]) low++;
                        while (low < high && nums[high]==nums[high-1]) high--;
                        low++;
                        high--;
                    }

                    else if (nums[low] + nums[high] < sum) low++;
                    else high--;
                }
            }
        }


        return res;
    }
}
