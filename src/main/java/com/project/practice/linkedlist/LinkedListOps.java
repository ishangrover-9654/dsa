package com.project.practice.linkedlist;

public class LinkedListOps {

    public static void main(String[] args) {
        LinkedList2 list = new LinkedList2();
        list.add(1);
        list.add(2);
        list.add(5);
        list.add(3);
        list.add(4);


        list.printList();
        System.out.println();

        //list.setHead(list.reverse(list.getHead()));

        //list.printList();

        list.checkPallen();
    }

}

class LinkedList2<T> {

    private Node head;

    public LinkedList2() {
        this.head = null;
    }

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public void add(T data){
        Node item = new Node(data);
        if (head==null){
            head = item;
            //head.setNext(item);
        }
        else{
            Node curr = head;
            while(curr.getNext()!=null){
                curr = curr.getNext();
            }
            curr.setNext(item);
        }
    }

    public void printList(){
        Node curr = this.head;
        while(curr!=null){
            System.out.print(curr.getData()+" ");
            curr = curr.getNext();
        }

    }

    public boolean checkPallen() {

        Node slow, fast, mid, prevToMid;

        slow = fast = head;
        prevToMid = null;

        while (fast.getNext() != null && fast.getNext().getNext() != null) {
            slow = slow.getNext();
            fast = fast.getNext().getNext();
        }

        mid = slow;
        /**
         * Odd number of nodes
         */
        /*if (fast.getNext()==null){
            mid =
        }*/

        System.out.println(slow.getData());
        Node head2 = reverse(slow.getNext());
        //System.out.println(head2.getData());
        return true;
    }

    public Node reverse(Node node){

        Node prev = null;
        Node curr = node;
        Node next = curr.getNext();

        while(next!=null){
            curr.setNext(prev);
            prev=curr;
            curr = next;
            next =  next.getNext();
        }
        curr.setNext(prev);
        return curr;
    }



}

class Node<T> {
    private T data;
    private Node next;

    public Node(T data) {
        this.data = data;
        this.next = null;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public T getData() {
        return data;
    }
}
