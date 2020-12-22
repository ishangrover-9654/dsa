package com.project.practice.leetcode.trees;

/**
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 *
 * For example, this binary tree [1,2,2,3,4,4,3] is symmetric:
 *
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 */
public class SymmetricTree {
    public static void main(String[] args) {
        TreeNode root =new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);

        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);

        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);

        System.out.println(isSymmetric(root));
    }

    public static boolean isSymmetric(TreeNode root){
        return isSymmetric(root, root);
    }

    public static boolean isSymmetric(TreeNode t1, TreeNode t2){
        if (t1==null && t2==null)
            return true;
        if (t1==null || t2==null)
            return false;
        return t1.val==t2.val && isSymmetric(t1.left, t2.right)
                && isSymmetric(t1.right, t2.left);
    }
}
