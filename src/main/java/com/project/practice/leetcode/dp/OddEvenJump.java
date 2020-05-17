package com.project.practice.leetcode.dp;

import java.util.Map;
import java.util.TreeMap;

public class OddEvenJump {
    public static void main(String[] args) {
        int[] A = {5,1,3,4,2};
        System.out.println(oddEvenJumps(A));
    }

    public static int oddEvenJumps(int[] A) {
        int n= A.length;

        boolean[] higher = new boolean[n];
        boolean[] lower = new boolean[n];

        higher[n-1] = true;
        lower[n-1] = true;

        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(A[n-1], n-1);

        int goodIndexCount = 1;
        for (int i = n-2; i >= 0 ; i--) {
            Map.Entry<Integer, Integer> higherEntry = map.ceilingEntry(A[i]);
            Map.Entry<Integer, Integer> lowerEntry = map.floorEntry(A[i]);

            if (higherEntry !=null){
                higher[i] = lower[higherEntry.getValue()];
            }

            if (lowerEntry !=null){
                lower[i] = higher[lowerEntry.getValue()];
            }

            if (higher[i]){
                goodIndexCount++;
            }
            map.put(A[i], i);
        }
        return goodIndexCount;
    }
}
