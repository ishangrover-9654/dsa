package com.project.practice.arrays;

public class MergeSort {

    public static void main(String[] args) {
        int arr[] = {12, 11, 13, 5, 6, 7};

        ArrayUtil.print(arr);

        MergeSort mergeSort = new MergeSort();
        mergeSort.mergeSort(arr, 0, arr.length-1);
        System.out.println();
        ArrayUtil.print(arr);

    }

    public void merge(int arr[], int low, int mid, int high){
        int n1 = mid - low + 1;
        int n2 = high - mid;

        int arr1[] = new int[n1];
        int arr2[] = new int[n2];

        for (int i = 0; i < n1; i++)
            arr1[i] = arr[low + i];
        for (int i = 0; i < n2; i++)
            arr2[i] = arr[mid+1+i];

        int k=low;
        int i=0, j = 0;

        while (i < n2 && j < n2){
            if (arr1[i] <= arr2[j]){
                arr[k++] = arr1[i++];
            }
            else{
                arr[k++] = arr2[j++];
            }
        }

        while (i < n1){
            arr[k++] = arr1[i++];
        }

        while (j < n2){
            arr[k++] = arr2[j++];
        }
    }

    public void mergeSort(int[] arr, int low, int high){
        if (low < high){
            int mid = (low + high) / 2;
            mergeSort(arr, low, mid);
            mergeSort(arr, mid+1, high);
            merge(arr, low, mid, high);
        }
    }
}
