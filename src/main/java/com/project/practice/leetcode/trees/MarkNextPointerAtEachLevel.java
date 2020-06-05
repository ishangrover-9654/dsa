package com.project.practice.leetcode.trees;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Problem Explanation at :
 * https://leetcode.com/problems/populating-next-right-pointers-in-each-node/
 */
public class MarkNextPointerAtEachLevel {

    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };

    public static void main(String[] args) {

    }

    /**
     * Approach 1 :
     * 0(n) running and O(n) extra space
     */
    public static Node traverse1(Node root){
        if (root==null) return root;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()){
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                Node currNode = queue.poll();
                if (i < len - 1){
                    currNode.next = queue.peek();
                }
                if (currNode.left!=null) queue.add(currNode.left);
                if (currNode.right!=null) queue.add(currNode.right);
            }
        }
        return root;
    }

    /**
     * Approach 2 :
     * O(n) running and O(1) space
     * @param root
     * @return
     */
    public static Node traverse2(Node root){
        // Start with the root node. There are no next pointers
        // that need to be set up on the first level
        Node leftmost = root;
        // Once we reach the final level, we are done
        while (leftmost.left != null){
            // Iterate the "linked list" starting from the head
            // node and using the next pointers, establish the
            // corresponding links for the next level
            Node head = leftmost;
            while (head!=null){
                // CONNECTION 1
                head.left.next = head.right;

                // CONNECTION 2
                if (head.next != null) {
                    head.right.next = head.next.left;
                }
                // Progress along the list (nodes on the current level)
                head = head.next;
            }
            // Move onto the next level
            leftmost = leftmost.left;
        }
        return root;
    }
}
