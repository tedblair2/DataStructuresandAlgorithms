package com.company.array.LinkedList;

public class DoubleLinkedList {
    private ListNode head;
    private ListNode tail;
    private int length;

    public DoubleLinkedList(){
        this.head = null;
        this.tail = null;
        this.length = 0;
    }

    public static class ListNode{
        int data;
        ListNode next;
        ListNode prev;

        public ListNode(int data){
            this.data = data;
        }
    }
    private boolean isEmpty(){
        return length==0;
    }
    private int length(){
        return length;
    }
    private void printforward(){//propagating forward in the list
        ListNode temp=head;
        while (temp !=null){
            System.out.print(temp.data+" -->");
            temp=temp.next;
        }
        System.out.println("null");
    }
    private void printbackward(){//propagating backwards in the list
        ListNode temp=tail;
        while (temp != null){
            System.out.print(temp.data+" -->");
            temp=temp.prev;
        }
        System.out.println("null");
    }
    private void insertStart(int value){
        ListNode node=new ListNode(value);
        if (isEmpty()){
            tail=node;
        }else {
            head.prev=node;
        }
        node.next=head;
        head=node;
        length++;
    }
    private void insertEnd(int value){
        ListNode node=new ListNode(value);
        if (isEmpty()){
            head=node;
        }else {
            tail.next=node;
            node.prev=tail;
        }
        tail=node;
        length++;
    }
    private void deleteFirst(){
        if (isEmpty()){
            System.out.println("List is empty");
        }
        ListNode current=head;
        if (head==tail){
            tail=null;
        }else {
            head.next.prev=null;
        }
        head=head.next;
        current.next=null;
        length--;
    }
    private void deleteLast(){
        if (isEmpty()){
            System.out.println("List is empty");
        }
        ListNode current=tail;
        if (tail==head){
            head=null;
        }else {
            tail.prev.next=null;
        }
        tail=tail.prev;
        current.prev=null;
        length--;

    }

    public static void main(String[] args){
        DoubleLinkedList list=new DoubleLinkedList();
//        list.head=new ListNode(2);
//        ListNode two=new ListNode(5);
//        ListNode three=new ListNode(3);
//        ListNode four=new ListNode(9);
//        list.tail=new ListNode(6);
//        list.head.next=two;
//        list.head.prev=null;
//        two.next=three;
//        two.prev=list.head;
//        three.next=four;
//        three.prev=two;
//        four.next=list.tail;
//        four.prev=three;
//        list.tail.prev=four;
//        list.printforward();
//        list.printbackward();
        list.insertStart(8);
        list.insertStart(5);
        list.insertStart(3);
        list.insertEnd(4);
        list.insertEnd(10);
        list.printforward();
        list.printbackward();
        list.deleteFirst();
        list.printforward();
        list.printbackward();
        list.deleteLast();
        list.printforward();
        list.printbackward();
        int size=list.length;
        System.out.println("Size of list is "+size);
    }
}
