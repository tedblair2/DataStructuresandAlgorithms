package com.company.array.Stack;

public class stack {
    private ListNode top;
    private int length;

    public stack(){
        this.top = null;
        this.length = 0;
    }

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
    private int getLength(){
        return length;
    }
    public void pushElement(int value){
        ListNode node=new ListNode(value);
        node.next=top;
        top=node;
        length++;
    }
    public void popElement(){
        if (isEmpty()){
            System.out.println("Stack is empty");
        }
        top=top.next;
        length--;
    }
    private void peekElement(){
        if (isEmpty()){
            System.out.println("Stack is empty");
        }
        int data=top.data;
        System.out.println("Top data is "+data);
    }

    public static void main(String[] args){
        stack stack=new stack();
        stack.pushElement(2);
        stack.pushElement(5);
        stack.pushElement(9);
        stack.pushElement(1);
        stack.peekElement();
        stack.popElement();
        stack.peekElement();
    }
}
