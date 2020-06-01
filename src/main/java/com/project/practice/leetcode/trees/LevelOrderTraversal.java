package com.project.practice.leetcode.trees;

import java.util.*;

public class LevelOrderTraversal {
    static class TreeNode{
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

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        List<List<Integer>> res = new LevelOrderTraversal().levelOrder(root);
        res.stream().forEach(System.out::println);
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level = 0;
        while (!queue.isEmpty()){
            result.add(new ArrayList<>());
            int levelLen = queue.size();
            for (int i = 0; i < levelLen; i++) {
                TreeNode curNode = queue.poll();
                result.get(level).add(curNode.val);
                if (curNode.left!=null) queue.add(curNode.left);
                if (curNode.right!=null) queue.add(curNode.right);
            }
            level ++;
        }
        return result;
    }
}
