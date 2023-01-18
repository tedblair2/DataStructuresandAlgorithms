package com.company.array.SearchAlgorithms;

import com.company.array.BinaryTree.SearchTree;

public class SearchInsert {

    private void search(int[] arr,int target){
//        for (int i=0;i<arr.length;i++){
//            if (arr[i]==target){
//                System.out.println("Target is at index "+i);
//                return;
//            }
//            if (arr[i]>target){
//                System.out.println("Target should be at index "+i);
//                return;
//            }
//        }
        int low=0;
        int high=arr.length-1;
        while (low<=high){
            int mid=low+(high-low)/2;
            if (arr[mid]==target){
                System.out.println("Target found at index "+mid);
                return;
            }
            if (target<arr[mid]){
                high=mid-1;
            }else {
                low=mid+1;
            }
        }
        System.out.println("Target should be at index "+low);

    }

    public static void main(String[] args){
        SearchInsert insert=new SearchInsert();
        int[] arr={2,3,5,7,8};
        insert.search(arr,4);

    }
}
