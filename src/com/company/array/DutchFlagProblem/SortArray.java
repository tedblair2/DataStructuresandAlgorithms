package com.company.array.DutchFlagProblem;

public class SortArray {

    private void printArray(int[] arr){
        for (int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" -->");
        }
        System.out.println(" ");
    }

    private void sort(int[] arr){
        int i=0;
        int j=0;
        int k=arr.length-1;
        while (i<=k){
            if (arr[i]==0){
                swap(arr,i,j);
                i++;
                j++;
            }else if (arr[i]==1){
                i++;
            }else if (arr[i]==2){
                swap(arr,i,k);
                k--;
            }
        }
        printArray(arr);
    }

    private void swap(int[] arr, int i, int k){
        int temp=arr[i];
        arr[i]=arr[k];
        arr[k]=temp;
    }


    public static void main(String[] args){
        SortArray array=new SortArray();
        int[] arr={2,1,0,0,2,1,2,0,2};
        array.sort(arr);

    }
}
