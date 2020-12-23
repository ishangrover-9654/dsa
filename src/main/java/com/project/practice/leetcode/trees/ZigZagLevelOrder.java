package com.project.practice.leetcode.trees;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Given a binary tree, return the zigzag level order traversal of its nodes' values.
 * (ie, from left to right, then right to left for the next level and alternate between).
 *
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its zigzag level order traversal as:
 * [
 *   [3],
 *   [20,9],
 *   [15,7]
 * ]
 */
public class ZigZagLevelOrder {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);

        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        System.out.println(zigzagLevelOrder(root));

    }

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        if (root==null)
            return Collections.emptyList();

        LinkedList<TreeNode> queue = new LinkedList<>();

        List<List<Integer>> res = new ArrayList<>();

        queue.add(root);

        boolean zig = false;

        while (!queue.isEmpty()){
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++){
                TreeNode node = queue.poll();

                if (zig)
                    list.add(0, node.val);
                else
                    list.add(node.val);

                if (node.left!=null )
                    queue.add (node.left);

                if (node.right!=null)
                    queue.add (node.right);
            }
            res.add(list);

            zig = !zig;
        }
        return res;
    }
}
