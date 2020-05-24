package com.project.practice.leetcode.trees;

public class MaxPathSum {
    static int max_sum = Integer.MIN_VALUE;
    public static void main(String[] args) {
        /*TreeNode root = new TreeNode(-10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);*/

        TreeNode root = new TreeNode(5);
        /*root.left = new TreeNode(2);
        root.right = new TreeNode(3);*/
        root.left = new TreeNode(4);
        root.left.left = new TreeNode(11);
        root.left.left.right = new TreeNode(2);
        root.left.left.left = new TreeNode(7);
        root.right = new TreeNode(8);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.right = new TreeNode(1);



        max_gain(root);
        System.out.println(max_sum);
    }
    public static int max_gain(TreeNode node){
        if (node == null) return 0;
        int leftSum = Math.max(max_gain(node.left),0);
        int rightSum = Math.max(max_gain(node.right),0);
        int currSum = node.val + leftSum + rightSum;
        max_sum = Math.max(currSum, max_sum);
        return currSum;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}