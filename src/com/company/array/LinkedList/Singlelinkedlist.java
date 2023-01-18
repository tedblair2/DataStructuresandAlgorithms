package com.company.array.LinkedList;

import java.util.List;

public class Singlelinkedlist {


    ListNode head;
    private static class ListNode{
        private int data;
        private ListNode next;//reference to next node in the list


        public ListNode(int data){
            this.data = data;
            this.next = null;
        }
    }
    public void printlist(){
        ListNode current=head;
        while (current !=null){
            System.out.print(current.data+" ==>");
            current=current.next;
        }
        System.out.println("null");
    }
    private void showlist(ListNode start){
        ListNode current=start;
        while (current != null){
            System.out.print(current.data+" -->");
            current=current.next;
        }
        System.out.println("null");
    }
    public int listsize(){
        if (head==null){
            System.out.println("List is empty.");
        }
        int count=0;
        ListNode current=head;
        while (current != null){
            count++;
            current=current.next;
        }
        return count;
    }
    public void insertStart(int value){
        ListNode node=new ListNode(value);
        node.next=head;//assign next of newnode to head
        head=node;//assign newnode as head
        printlist();
    }
    public void insertEnd(int value){
        ListNode node=new ListNode(value);
        if (head == null){
            head=node;
        }
        ListNode current=head;
        while (current.next != null){
            current=current.next;//assigns current to be the next node
        }
        current.next=node;//assign reference for the new node to the end node
        printlist();
    }
    public void insertAny(int value,int position){
        ListNode newnode=new ListNode(value);
        if (position==1){
            newnode.next=head;
            head=newnode;
        }else {
            ListNode previous=head;
            int count=1;
            while (count<position-1){
                previous=previous.next;
                count++;
            }
            ListNode current=previous.next;
            newnode.next=current;
            previous.next=newnode;
            printlist();
        }
    }
    private void deleteFirst(){
        if (head==null){
            System.out.println("List is empty");
        }
        ListNode temp=head;
        head=head.next;
        temp.next=null;
        printlist();
    }
    private void deleteLast(){
        if (head==null || head.next==null){
            System.out.println("List is empty");
        }
        ListNode current=head;
        ListNode previous=null;
        while (current.next != null){
            previous=current;
            current=current.next;
        }
        previous.next=null;
        printlist();

    }
    private void deleteAny(int position){
        if (position==1){
            head=head.next;
        }
        ListNode previous=head;
        int count=1;
        while (count<position-1){
            previous=previous.next;
            count++;
        }
        ListNode current=previous.next;
        previous.next=current.next;
        printlist();
    }
    private void searchelement(int value){
        ListNode current=head;
        while (current != null){
            if (current.data == value){
                System.out.println(value+" is present in the list.");
                return;
            }
            current=current.next;
        }
        System.out.println(value+" is not present in list.");
    }
    private ListNode reverselist(){
        ListNode current=head;
        ListNode previous=null;
        ListNode next=null;

        while (current != null){
            next=current.next;
            current.next=previous;
            previous=current;
            current=next;
        }
        return previous;
    }
    private void middleNode(){
        ListNode slowptr=head;
        ListNode fastptr=head;
        while (fastptr !=null && fastptr.next !=null){
            slowptr=slowptr.next;
            fastptr=fastptr.next.next;
        }
        System.out.println("Middle node is "+slowptr.data);
    }
    private void nNodefromEnd(int value){
        ListNode refptr=head;
        ListNode mainptr=head;
        int count=0;
        while (count<value){
            refptr=refptr.next;
            count++;
        }
        while (refptr !=null){
            refptr=refptr.next;
            mainptr=mainptr.next;
        }
        System.out.println("value you are looking for is "+mainptr.data);
    }
    private void removeDuplicates(){
        ListNode current=head;
        while (current !=null && current.next != null){
            if (current.data == current.next.data){
                current.next=current.next.next;
            }else {
                current=current.next;
            }
        }
        printlist();
    }
    private void insertSortlist(int value){
        ListNode node=new ListNode(value);
        ListNode next=head;
        ListNode prev=null;
        while (next != null && next.data <node.data){
            prev=next;
            next=next.next;
        }
        node.next=next;
        prev.next=node;
        printlist();
    }
    private void deletefromSorted(int key){
        ListNode current=head;
        ListNode prev=null;
        while (current != null && current.data != key){
            prev=current;
            current=current.next;
        }
        if (current == null) {
            System.out.println("Value not found");
        }
        prev.next=current.next;
        printlist();
    }
    private void detectloop(){
        ListNode fastptr=head;
        ListNode slowptr=head;
        while (fastptr!=null && fastptr.next!=null){
            fastptr=fastptr.next.next;
            slowptr=slowptr.next;
            if (fastptr==slowptr){
                System.out.print("Loop detected in linked list.");
                getStarting(slowptr);
                removeLoop(slowptr);
                return;
            }
        }
        System.out.println("No loop detected");
    }

    private void getStarting(ListNode slowptr){//floyd cycle detetion algortihm
        ListNode temp=head;
        while (slowptr!=temp){
            temp=temp.next;
            slowptr=slowptr.next;
        }
        System.out.println("It starts at "+temp.data);
    }
    private void removeLoop(ListNode slowptr){
        ListNode temp=head;
        while (slowptr.next !=temp.next){
            temp=temp.next;
            slowptr=slowptr.next;
        }
        slowptr.next=null;
        printlist();
    }
    private void mergeList(ListNode a,ListNode b){
        ListNode dummy=new ListNode(0);
        ListNode tail=dummy;
        while (a!=null && b!=null){
            if (a.data<=b.data){
                tail.next=a;
                a=a.next;
            }else {
                tail.next=b;
                b=b.next;
            }
            tail=tail.next;
        }
        if (a==null){
            tail.next=b;
        }else {
            tail.next=a;
        }
        showlist(dummy.next);
    }
    private void addTwoList(ListNode a,ListNode b){
        ListNode dummy=new ListNode(0);
        ListNode tail=dummy;
        int carry=0;
        while (a!=null||b!=null){
            int x=(a!=null)?a.data:0;
            int y=(b!=null)?b.data:0;
//            if (a!=null){
//                x=a.data;
//            }else {
//                x=0;
//            }
//            if (b!=null){
//                y=b.data;
//            }else {
//                y=0;
//            }
            int sum=carry+x+y;
            carry=sum/10;
            tail.next=new ListNode(sum%10);
            tail=tail.next;
            if (a!=null) a=a.next;
            if (b!=null) b=b.next;
        }
        if (carry>0){
            tail.next=new ListNode(carry);
        }
        showlist(dummy.next);
    }



    public static void main(String[] args){
        Singlelinkedlist list=new Singlelinkedlist();
        list.head=new ListNode(1);
        ListNode second=new ListNode(2);
        ListNode third=new ListNode(2);
        ListNode fourth=new ListNode(3);
        ListNode fifth=new ListNode(5);
        list.head.next=second;
        second.next=third;
        third.next=fourth;
        fourth.next=fifth;

        ListNode one=new ListNode(2);
        ListNode two=new ListNode(4);
        ListNode three=new ListNode(5);
        ListNode four=new ListNode(8);
        one.next=two;
        two.next=three;
        three.next=four;
        list.showlist(one);
        ListNode five=new ListNode(1);
        ListNode six=new ListNode(3);
        ListNode seven=new ListNode(6);
        five.next=six;
        six.next=seven;
        list.showlist(five);
        list.mergeList(one,five);
        list.addTwoList(one,five);
//        fifth.next=third;
//        list.detectloop();
        //list.printlist();
//        list.insertStart(1);
//        list.insertEnd(4);
//        list.insertAny(4,6);
//        list.deleteFirst();
//        list.deleteLast();
//        list.deleteAny(4);
        //list.searchelement(11);
        //list.reverselist();
//        list.middleNode();
//        list.nNodefromEnd(3);
//        list.removeDuplicates();
//        list.insertSortlist(5);
//        list.deletefromSorted(4);

    }
}
