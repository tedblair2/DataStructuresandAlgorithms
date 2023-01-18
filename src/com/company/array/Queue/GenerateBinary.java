package com.company.array.Queue;

import java.util.LinkedList;
import java.util.Queue;

public class GenerateBinary {

    private void printArray(String[] arr){
        int n=arr.length;
        for (int i=0;i<n;i++){
            System.out.print(arr[i]+" ");
        }
    }

    private void generate(int n){
        String[] arr=new String[n];
        Queue<String> queue=new LinkedList<>();
        queue.offer("1");
        for (int i=0;i<n;i++){
            arr[i]=queue.poll();
            String n1=arr[i]+"0";
            String n2=arr[i]+"1";
            queue.offer(n1);
            queue.offer(n2);
        }
        printArray(arr);
    }

    public static void main(String[] args){
        GenerateBinary bn=new GenerateBinary();
        bn.generate(20);
    }
}
