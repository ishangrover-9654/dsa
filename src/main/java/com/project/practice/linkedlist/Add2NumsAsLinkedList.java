package com.project.practice.linkedlist;

public class Add2NumsAsLinkedList {

    public static void main(String[] args) {
        ListNode list1 = new ListNode(2);
        list1.next = new ListNode(4);
        list1.next.next = new ListNode(3);

        ListNode list2 = new ListNode(5);
        list2.next = new ListNode(6);
        list2.next.next = new ListNode(4);

        ListNode listNode = addTwoNumbers(list1, list2);
        ListNode.printList(listNode);

    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode list1 = l1, list2 = l2;

        ListNode list3 = null, head = null;

        int c = 0;
        while (list1!=null || list2!=null){

            int sum = (list1!=null ? list1.val : 0) +
                    (list2!=null ? list2.val : 0) + c;
            c = sum / 10;
            sum = (sum % 10) ;

            if (list3==null){
                head = list3 = new ListNode(sum);
            }
            else{
                list3.next = new ListNode(sum);
                list3 = list3.next;
            }

            if (list1!=null)
                list1 = list1.next;
            if (list2!=null)
                list2 = list2.next;
        }

        if (c > 0){
            list3.next = new ListNode(c);
        }
        return head;
    }


}
