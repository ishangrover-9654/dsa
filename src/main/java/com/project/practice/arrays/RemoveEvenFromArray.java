package com.project.practice.arrays;

public class RemoveEvenFromArray {
    public static void main(String[] args) {
        int arr [] = {1, 2, 4, 5, 10, 6, 3};

        int c = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 1)
                arr[c++] = arr[i];
        }

        for (int i = c  ; i < arr.length; i++) {
            arr[i] = 0;
        }

        ArrayUtil.print(arr);

    }




}
