package com.project.practice.leetcode.arrays;

import com.project.practice.arrays.ArrayUtil;

public class QuickSort {
    public static void main(String[] args) {
        int arr[] = {9,1,3,5};
        quickSort(arr, 0, arr.length - 1);
        ArrayUtil.print(arr);
    }

    static int partition(int ar[], int low, int high){
        int pivot = ar[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (ar[j] < pivot) {
                i++;
                int temp = ar[i];
                ar[i] = ar[j];
                ar[j] = temp;
            }
        }

        int temp = ar [i+1];
        ar [i+1] = ar [high];
        ar[high] = temp;

        return i+1;
    }

    public static void quickSort(int arr[], int low, int high){
        if (low < high){
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi-1);
            quickSort(arr, pi+1, high);
        }
    }
}
