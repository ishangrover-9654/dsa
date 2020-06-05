package com.project.practice.leetcode.trees;

public class PreorderValidSerialization {

    public static void main(String[] args) {
        String str = "9,3,4,#,#,1,#,#,2,#,6,#,#";
        int i= 0;
        System.out.println((str.charAt(i-1) == 'a'));
        System.out.println(isValidSerialization2(str));
    }

    /**
     * Approach 1
     * O(n) for both space and time
     * @param preorder
     * @return
     */
    public static boolean isValidSerialization1(String preorder) {
        int slots = 1;
        for (String str : preorder.split(",")){
            slots--;
            if (slots<0) return false;
            if (!str.equals("#")) slots +=2;

        }
        return slots==0;
    }

    /**
     * Approach 2
     * O(n) for both space and time
     * @param preorder
     * @return
     */
    public static boolean isValidSerialization2(String preorder) {
        int slots = 1;

        int n = preorder.length();
        for (int i = 0; i < n; ++i) {
            if (preorder.charAt(i) == ',') {
                // one node takes one slot
                --slots;

                // no more slots available
                if (slots < 0) return false;

                // non-empty node creates two children slots
                if (preorder.charAt(i - 1) != '#') slots += 2;
            }
        }

        // the last node
        slots = (preorder.charAt(n - 1) == '#') ? slots - 1 : slots + 1;
        // all slots should be used up
        return slots == 0;

    }
}
