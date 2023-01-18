package com.company.array.SearchAlgorithms;

public class BinarySearch {

    public void search(int[] arr,int x){
        int low=0;
        int high=arr.length-1;
        while (low<=high){
            int mid=(high+low)/2;
            if (arr[mid]==x){
                System.out.println("Value found at index "+mid);
                return;
            }
            if (x<arr[mid]){
                high=mid-1;
            }else {
                low=mid+1;
            }
        }
        System.out.println("Value not found");
    }

    public static void main(String[] args){
        BinarySearch search=new BinarySearch();
        int[] arr={2,3,4,5,7,9,10,14,17};
        search.search(arr,6);

    }
}
