package com.project.practice.leetcode.trees;

public class Tree2StrPreOrderBracket {
    static String res;
    public static void main(String[] args) {

        /* Let us construct below tree
             1
            /   \
           2     3
          / \     \
         4   5     6 */

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);
        res = "";
        tree2str(root);
        System.out.println(res);
    }

    public static void tree2str(TreeNode t) {
        if (t==null)
            return ;

        res += t.val ;
        if (t.left==null && t.right==null)
            return ;

        res += "(" ;
        tree2str(t.left);
        res+= ")";

        if (t.right!=null){
            res +=  "(" ;
            tree2str(t.right);
            res+= ")";
        }
    }
}
