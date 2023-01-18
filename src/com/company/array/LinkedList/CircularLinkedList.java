package com.company.array.LinkedList;

import java.util.List;

public class CircularLinkedList {

    private ListNode last;
    private int length;

    public CircularLinkedList(){
        this.last = null;
        this.length = 0;
    }

    public static class ListNode{
        int data;
        ListNode next;

        public ListNode(int data){
            this.data=data;
        }
    }
    public int getLength(){
        return length;
    }
    public boolean isEmpty(){
        return length==0;
    }
    private void printlist(){
        ListNode first=last.next;
        while (first!=last){
            System.out.print(first.data+" -->");
            first=first.next;
        }
        System.out.println(first.data+" -->");
    }
    private void insertStart(int value){
        ListNode node=new ListNode(value);
        ListNode head=last.next;
        if (last==null){
            last=node;
        }else {
            node.next=head;
        }
        last.next=node;
        length++;
        printlist();
    }
    private void insertEnd(int value){
        ListNode node=new ListNode(value);
        ListNode temp=last;
        if (last==null){
            last=node;
            last.next=last;
        }else {
            node.next=last.next;
            temp.next=node;
        }
        last=node;
        length++;
        printlist();
    }
    private void deletefirst(){
        if (last==null){
            System.out.println("List is empty");
        }
        ListNode temp=last.next;
        last.next=temp.next;
        length--;
        printlist();
    }
    private void deleteLast(){
        if (last==null){
            System.out.println("List is empty.");
        }
        ListNode current=last.next;
        ListNode prev=null;
        while (current != last){
            prev=current;
            current=current.next;
        }
        prev.next=last.next;
        last=prev;
        length--;
        printlist();

    }


    public static void main(String[] args){
        CircularLinkedList list=new CircularLinkedList();
        ListNode first=new ListNode(2);
        ListNode second=new ListNode(1);
        ListNode third=new ListNode(5);
        ListNode fourth=new ListNode(6);
        list.last=new ListNode(8);
        first.next=second;
        second.next=third;
        third.next=fourth;
        fourth.next=list.last;
        list.last.next=first;
        list.printlist();
        list.insertStart(9);
        list.insertEnd(1);
        list.deletefirst();
        list.deleteLast();
        list.deleteLast();
    }
}
