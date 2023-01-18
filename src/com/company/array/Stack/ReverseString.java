package com.company.array.Stack;

import java.util.Stack;

public class ReverseString {

    private void reverse(String words){
        Stack<Character> stack=new Stack<>();
        char[] arr=words.toCharArray();
        for (char c:arr){
            stack.push(c);
        }
        for (int i=0;i<arr.length;i++){
            arr[i]=stack.pop();
        }
        System.out.println("Reverse of string "+words+" is "+new String(arr));

    }

    public static void main(String[] args){
        ReverseString string=new ReverseString();
        string.reverse("PIZZA");
    }
}
