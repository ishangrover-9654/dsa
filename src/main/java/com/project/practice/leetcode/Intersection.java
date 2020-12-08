package com.project.practice.leetcode;

import com.project.practice.linkedlist.LinkNode;

public class Intersection {
    public static void main(String[] args) {
        // creating first linked list
       /* LinkNode<Integer> list = new LinkNode(3);
        list.next = new LinkNode(6);
        list.next.next = new LinkNode(9);
        list.next.next.next = new LinkNode(15);
        list.next.next.next.next = new LinkNode(30);*/

        LinkNode<Integer> list = new LinkNode(8);

        // creating second linked list
        LinkNode<Integer> list2 = new LinkNode(4);
        list2.next = new LinkNode(1);
        list2.next.next = new LinkNode(8);
        list2.next.next.next = new LinkNode(4);
        list2.next.next.next.next = new LinkNode(5);

        System.out.println(getIntersectionNode(list,list2).data);
    }

    public static LinkNode getIntersectionNode(LinkNode headA, LinkNode headB) {

            int c1 = getCount(headA);
            int c2 = getCount(headB);

            int d = Math.abs(c1-c2);

            LinkNode bigLink = c1 > c2 ? headA : headB;
            LinkNode smallLink = c1 > c2 ? headB : headA;

            for (int i = 1; i <=d ; i++) {
                bigLink = bigLink.next;
            }

            while (bigLink!=null && smallLink!=null){
                if (bigLink.data == smallLink.data){
                    return smallLink;
                }
                bigLink = bigLink.next;
                smallLink = smallLink.next;
            }
            return null;
    }

    public static int getCount(LinkNode node){
        int c = 0;
        while (node!=null){
            c++;
            node = node.next;
        }
        return c;
    }
}
