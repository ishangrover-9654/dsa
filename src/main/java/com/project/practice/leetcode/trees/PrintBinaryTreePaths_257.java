package com.project.practice.leetcode.trees;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree, return all root-to-leaf paths.
 *
 * Note: A leaf is a node with no children.
 *
 * Example:
 *
 * Input:
 *
 *    1
 *  /   \
 * 2     3
 *  \
 *   5
 *
 * Output: ["1->2->5", "1->3"]
 *
 * Explanation: All root-to-leaf paths are: 1->2->5, 1->3
 */
public class PrintBinaryTreePaths_257 {
    static List<String> res = new ArrayList<>();

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);

        print("", root);

        System.out.println(res);
    }

    public static void print (String str, TreeNode node){
        if (node.left == null && node.right==null){
            str +=  node.val;
            res.add(str);
        }

        if (node.left!=null){
            print(str + node.val + "->", node.left);
        }
        if(node.right!=null)
            print(str + node.val + "->", node.right);
    }
}
