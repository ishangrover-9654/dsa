package com.project.practice.leetcode.trees;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


/**
 * Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).
 *
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its bottom-up level order traversal as:
 * [
 *   [15,7],
 *   [9,20],
 *   [3]
 * ]
 */
public class BottomLevelOrderTraversal {
    public static void main(String[] args) {
        TreeNode tree = new TreeNode(3);

        tree.left = new TreeNode(9);
        tree.right = new TreeNode(20);
        //tree.left.left = new TreeNode(4);
        //tree.left.right = new TreeNode(5);
        tree.right.left = new TreeNode(15);
        tree.right.right = new TreeNode(7);

        traverseBottomUp(tree);

    }

    public static void traverse(TreeNode root){

    }

    public static void traverseBottomUp(TreeNode root){
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        LinkedList<List<Integer>> stack = new LinkedList();

        while (!queue.isEmpty()){

            int level = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < level; i++) {
                TreeNode elem = queue.poll();
                list.add(elem.val);

                if (elem.left!=null){
                    queue.add(elem.left);
                }

                if (elem.right!=null){
                    queue.add(elem.right);
                }
            }
            stack.push(list);
        }
        //stack.forEach( val -> System.out.println(val));
    }
}
