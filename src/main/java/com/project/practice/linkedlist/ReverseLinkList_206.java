package com.project.practice.linkedlist;

import java.util.List;

public class ReverseLinkList_206 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);

        ListNode node = reverse(head);

        ListNode.printList(node);

    }

    public static ListNode reverse(ListNode node){
        if (node==null )
            return null;

        ListNode prev =null, next;
        ListNode curr = node;
        while (curr!=null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
