package com.project.practice.leetcode.trees;

public class MinDepth {
    public static void main(String[] args) {

    }

    public int minDepth(TreeNode root){
        int minDepth = Integer.MAX_VALUE;

        if (root == null) {
            return 0;
        }

        if ((root.left == null) && (root.right == null)) {
            return 1;
        }

        if (root.left!=null)
            minDepth= Math.min(minDepth(root.left), minDepth);

        if (root.right!=null)
            minDepth = Math.min(minDepth(root.right) , minDepth);

        return minDepth + 1;

    }
}

