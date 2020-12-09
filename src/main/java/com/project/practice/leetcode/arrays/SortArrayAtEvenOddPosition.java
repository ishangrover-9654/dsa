package com.project.practice.leetcode.arrays;

import com.project.practice.arrays.ArrayUtil;

public class SortArrayAtEvenOddPosition {
    public static void main(String[] args) {
        int arr[] = {2,4,5,7};
        ArrayUtil.print(sortArrayByParityII(arr));

    }

    public static int[] sortArrayByParityII(int[] A) {

        int  j =1, n = A.length;

        for (int i = 0; i < n; i+=2) {
            if (A[i] % 2 ==1){
                while (A[j]%2==1)
                    j+=2;

                int temp = A[i];
                A[i] = A[j];
                A[j] = temp;
            }
        }

        return A;

    }

}
