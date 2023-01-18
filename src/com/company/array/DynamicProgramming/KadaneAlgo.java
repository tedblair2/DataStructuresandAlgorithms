package com.company.array.DynamicProgramming;

public class KadaneAlgo {

    private void maxSubArray(int[] arr){
        int maxsofar=arr[0];
        int currentmax=arr[0];
        for (int i=1;i<arr.length;i++){
            currentmax=currentmax+arr[i];
            if (currentmax<arr[i]){
                currentmax=arr[i];
            }
            if (currentmax>maxsofar){
                maxsofar=currentmax;
            }
        }
        System.out.println("Max so far is "+maxsofar);
    }

    public static void main(String[] args){
        KadaneAlgo algo=new KadaneAlgo();
        int[] arr={4,3,-2,6,-12,7,-1,6};
        algo.maxSubArray(arr);
    }
}
