package com.project.practice.arrays;

public class QuickSort {

    public static void main(String[] args) {
        int arr[] = {12, 11, 13, 5, 6, 7};

        ArrayUtil.print(arr);

        QuickSort sort = new QuickSort();
        sort.quickSort(arr, 0, arr.length-1);
        System.out.println();
        ArrayUtil.print(arr);
    }

    public int partition(int[] arr, int low, int high){
        int i = low - 1;
        int pivot = arr[high];
        for (int j=low;j < high; j++){
            if(arr[j] < pivot){
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

    public void quickSort(int arr[], int low, int high){
        if (low < high){
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi -1 );
            quickSort(arr, pi+1, high);
        }
    }
}
