package com.company.array.Hashing;

public class HashTable {

    private HashNode[] buckets;
    private int size;
    private int noOfBuckets;

    private static class HashNode{
        int key;
        String value;
        HashNode next;

        public HashNode(int key,String value){
            this.key=key;
            this.value=value;
        }
    }
    public HashTable(int capacity){
        this.noOfBuckets=capacity;
        this.buckets=new HashNode[capacity];
        this.size=0;
    }
    private int size(){
        return size;
    }
    private int getBucketIndex(int key){
        return key%buckets.length;
    }
    private void printHash(HashNode[] table){
        for (int i=0;i<table.length;i++){
            HashNode current=table[i];
            if (current!=null){
                System.out.print(i+" -->");
                while (current!=null){
                    System.out.print(current.key+","+current.value+"\t");
                    current=current.next;
                }
                System.out.println();
            }
        }
    }
    private void put(int key,String value){
        int index=getBucketIndex(key);
        HashNode head=buckets[index];
        while (head!=null){
            if (head.key==key){
                head.value=value;
                return;
            }
            head=head.next;
        }
        size++;
        head=buckets[index];
        HashNode node=new HashNode(key,value);
        node.next=head;
        buckets[index]=node;
    }
    private String get(int key){
        int index=getBucketIndex(key);
        HashNode head=buckets[index];
        while (head!=null){
            if (head.key==key){
                return head.value;
            }
            head=head.next;
        }
        return null;
    }
    private void remove(int key){
        int index=getBucketIndex(key);
        HashNode head=buckets[index];
        HashNode previous=null;
        while (head!=null){
            if (head.key==key){
                break;
            }
            previous=head;
            head=head.next;
        }
        if (head==null){
            System.out.println("No such node.");
            return;
        }
        size--;
        HashNode temp=head;
        if (previous!=null){
            previous.next=head.next;
        }else {
            buckets[index]=head.next;
        }
        System.out.println("Value "+temp.value+" removed successfully.");
    }

    public static void main(String[] args){
        HashTable table=new HashTable(10);
        table.put(4,"Ted");
        table.put(105,"Valerie");
        table.put(21,"Henry");
        table.put(31,"Israel");
        table.put(93,"Young");
        table.printHash(table.buckets);
        System.out.println();
//        String value=table.get(92);
//        if (value !=null){
//            System.out.println("Value is "+value);
//        }else {
//            System.out.println("Value not present.");
//        }
        table.remove(21);
        table.printHash(table.buckets);
        System.out.println("Size is "+table.size());
    }
}
