package com.project.practice.strings;

public class UniqueCharInStringWithoutAdditionalDS {
    public static void main(String[] args) {
        System.out.println(unique("aa"));
    }

    public static boolean unique(String str){
        int checker = 0;

        for (int i = 0; i < str.length(); i++) {
            int val = str.charAt(i) - 'a';

            if ((checker & (1 << val)) > 0)
                return false;

            checker |= 1 << val;

        }
        return true;
    }
}
