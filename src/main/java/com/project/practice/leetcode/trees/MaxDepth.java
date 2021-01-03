package com.project.practice.leetcode.trees;


public class MaxDepth {
    public static void main(String[] args) {

    }

    public static int maxDepth(TreeNode root){
        if (root==null)
            return 0;
        int leftD = maxDepth(root.left);
        int rightD = maxDepth(root.right);

        int max = Math.max(leftD, rightD);

        return max + 1;

    }
}
