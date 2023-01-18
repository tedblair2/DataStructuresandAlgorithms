package com.company.array.Stack;

import java.util.Stack;

public class NextGreaterElement {

    private static void printArray(int[] arr){
        int n=arr.length;
        for (int i=0;i<n;i++){
            System.out.print(arr[i]+" ");
        }
    }

    private static void nextGreaterElement(int[] arr){
        int[] result=new int[arr.length];
        Stack<Integer> stack=new Stack<>();
        for (int i=arr.length-1;i>=0;i--){
            if (!stack.isEmpty()){
                while (!stack.isEmpty() && stack.peek()<=arr[i]){
                    stack.pop();
                }
            }
            if (stack.isEmpty()){
                result[i]=-1;
            }else {
                result[i]=stack.peek();
            }
            stack.push(arr[i]);
        }
        printArray(result);
    }

    public static void main(String[] args){
        int[] arr={2,4,1,9,3,8,11};
        nextGreaterElement(arr);

    }
}
