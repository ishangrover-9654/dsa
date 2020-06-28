package com.project.practice.leetcode.easy;

public class ReverseInteger {

    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
        System.out.println(reverseInt(2147483647));
    }

    public static int reverseInt(int x){
        int rev = 0, oldVal=0;
        while (x!=0){
            int mod = x % 10;
            rev = rev * 10 + mod;
            x = x / 10;
            if ((rev - mod) / 10 != oldVal){
                return 0;
            }
            oldVal = rev;
        }
        return rev;
    }

}
