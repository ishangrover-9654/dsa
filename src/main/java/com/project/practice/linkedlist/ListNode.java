package com.project.practice.linkedlist;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int val) {
        this.val = val;
    }

    public static void printList(ListNode listNode){
        while (listNode!=null){
            System.out.print(listNode.val + " -> ");
            listNode = listNode.next;
        }
        System.out.println("null");
    }
}
