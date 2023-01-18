package com.company.array.BinaryHeap;

public class Heap {
    Integer[] maxPQ;
    int size;

    public Heap(int capacity){
        maxPQ=new Integer[capacity+1];//first index is not used hence we add 1 to the capacity provided.
        size=0;
    }
    private boolean isEmpty(){
        return size==0;
    }
    private int size(){
        return size;
    }
    private void printHeap(Integer[] heap){
        for (int i=1;i<heap.length;i++){
            System.out.print(heap[i]+" -->");
        }
    }
    private void insertValue(int value){
        if (size==maxPQ.length-1){
            resize(maxPQ.length*2);
        }
        size++;
        maxPQ[size]=value;
        swim(size);
    }

    private void swim(int n){//bottom up reheapify of a max heap. used when inserting value in a heap.
        while (n>1 && maxPQ[n/2]<maxPQ[n]){
            int temp=maxPQ[n/2];
            maxPQ[n/2]=maxPQ[n];
            maxPQ[n]=temp;
            n=n/2;
        }
    }
    private void deleteMax(){
        int max=maxPQ[1];
        swap(1,size);
        size--;
        sink(1);
        maxPQ[size+1]=null;
        if (size>0 && (size==(maxPQ.length-1)/4)){
            resizeheap(maxPQ.length/2);
        }
    }

    private void resizeheap(int n){
        Integer[] temp=new Integer[n];
        for (int i=0;i<maxPQ.length;i++){
            temp[i]=maxPQ[i];
        }
        maxPQ=temp;
    }

    private void swap(int i, int size){
        int temp=maxPQ[i];
        maxPQ[i]=maxPQ[size];
        maxPQ[size]=temp;
    }

    private void sink(int k){//top down reheapify of a max heap. used when deleting value form a heap.
        while (2*k<=size){
            int j=2*k;
            if (j<size && maxPQ[j]<maxPQ[j+1]){
                j++;
            }
            if (maxPQ[k]>=maxPQ[j]){
                break;
            }
            swap(k,j);
            k=j;
        }
    }

    private void resize(int n){
        Integer[] temp=new Integer[n];
        for (int i=0;i<maxPQ.length;i++){
            temp[i]=maxPQ[i];
        }
        maxPQ=temp;
    }

    public static void main(String[] args){
        Heap heap=new Heap(4);
        heap.insertValue(4);
        heap.insertValue(9);
        heap.insertValue(5);
        heap.insertValue(6);
        heap.insertValue(7);
        heap.printHeap(heap.maxPQ);
        heap.deleteMax();
        heap.deleteMax();
        System.out.println(" ");
        heap.printHeap(heap.maxPQ);

    }
}
