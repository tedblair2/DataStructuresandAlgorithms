package com.company.array.SearchAlgorithms;

public class LinearSearch {


    private void searchArray(int[] arr,int x){
        for (int i=0;i<arr.length;i++){
            if (arr[i]==x){
                System.out.println("Value found at index "+i);
                return;
            }
        }
        System.out.println("Value not found.");

    }

    public static void main(String[] args){
        LinearSearch search=new LinearSearch();
        int[] arr={2,4,6,8,9,10,11,15};
        search.searchArray(arr,8);
    }
}
