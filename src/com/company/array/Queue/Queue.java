package com.company.array.Queue;

public class Queue {
    ListNode front;
    ListNode rear;
    int length;

    public static class ListNode{
        int data;
        ListNode next;

        public ListNode(int data){
            this.data=data;
        }
    }
    private boolean isEmpty(){
        return length==0;
    }
    private int length(){
        return length;
    }
    private void printlist(){
        ListNode current=front;
        while (current!=rear){
            System.out.print(current.data+" -->");
            current=current.next;
        }
        System.out.println(current.data);
    }
    public void enqueue(int value){
        ListNode node=new ListNode(value);
        if (isEmpty()){
            front=node;
        }else {
            rear.next=node;
        }
        rear=node;
        length++;
    }
    private void dequeue(){
        if (isEmpty()){
            System.out.println("Queue is empty");
        }else {
            ListNode temp=front.next;
            front=temp;
            if (front==null){
                System.out.println("Queue is empty.");
            }
        }
        length--;
        printlist();

    }

    public static void main(String[] args){
        Queue queue=new Queue();
        queue.front=new ListNode(2);
        ListNode second=new ListNode(4);
        ListNode third=new ListNode(1);
        queue.rear=new ListNode(3);
        queue.front.next=second;
        second.next=third;
        third.next=queue.rear;
        queue.enqueue(1);
        queue.printlist();


    }
}
