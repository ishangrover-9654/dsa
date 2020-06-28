package com.project.practice.leetcode.trees;

import java.util.*;
import java.util.stream.Collectors;

public class ClosestKvalues {

    static double  max = Integer.MAX_VALUE;
    static int val;
    static SortedMap<Double, Integer> map = new TreeMap<>();
    static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        closestKValues(root, 2.1);
        System.out.println(val);

        List<Integer> res = map.values().stream().limit(2).collect(Collectors.toList());

        System.out.println(res);
    }

    public static void closestKValues(TreeNode root, double target) {


        double diff = Math.abs(root.val - target);
        /*if ( diff < max){
            max = diff;
            val = root.val;
        }*/
        map.put(diff, root.val);
        if (root.left!=null)
        closestKValues(root.left, target);

        if (root.right!=null)
        closestKValues(root.right, target);
    }
}
