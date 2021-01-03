package com.project.practice.linkedlist;

public class MergeSortLinkedList {
    public static void main(String[] args) {

        LinkNode node1 = new LinkNode<>(4);
        node1.next = new LinkNode<>(1);
        node1.next.next = new LinkNode<>(5);
        node1.next.next.next = new LinkNode<>(2);
        node1.next.next.next.next = new LinkNode<>(3);

        sort(node1);

    }

    public static LinkNode sort (LinkNode<Integer> head){

        if (head == null || head.next == null)
            return head;

        LinkNode middle = getMiddle(head);
        LinkNode nextOfMiddle = middle.next;
        middle.next = null;
        LinkNode left = sort(head);
        LinkNode right = sort(middle);
        return merge(left, right);
        
    }

    private static LinkNode merge(LinkNode<Integer> left, LinkNode<Integer> right) {

        LinkNode result = null;
            if (left.data <= right.data){
                result = 
                left = left.next;
            }
            else {
                result.next = right;
                right = right.next;
            }
            result = result.next;

        return result;
    }

    private static LinkNode getMiddle(LinkNode<Integer> head) {
        LinkNode fast = head , slow = head;
        while (fast.next!=null && fast.next.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }


}


