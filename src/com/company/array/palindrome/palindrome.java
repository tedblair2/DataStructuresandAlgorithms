package com.company.array.palindrome;

public class palindrome {

    public static void main(String[] args){
        String check="rotator";
        palindromecheck(check);

    }
    public static void palindromecheck(String word){
        char[] arr=word.toCharArray();
        int start=0;
        int end=arr.length-1;

        while (start <end){
            if (arr[start]!=arr[end]){
                System.out.println("The word "+word+" is not a palindrome.");
                return;
            }
            start++;
            end--;
        }
        System.out.println("The word "+word+" is a palindrome.");
    }
}
