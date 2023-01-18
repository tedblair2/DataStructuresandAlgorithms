package com.company.array;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Main main=new Main();
        //main.myArray();
        int[] arr={2,4,1,5,3,6,8};
        //main.resizeArray(arr,8);
        main.findMissing(arr);
        //main.moveZeros(arr);
        ///main.removeEven(arr);
        //main.reverseArray(arr);
//        main.findMin(arr);
//        main.findMax(arr);
//        main.findSecondMax(arr);
    }
    public void printArray(int[] arr){
        int n=arr.length;
        for (int i=0;i<n;i++){
            System.out.print(arr[i]+" ");
        }
    }
    public void myArray(){
        int[] arr=new int[4];
        arr[0]=3;
        arr[1]=4;
        arr[2]=9;
        arr[3]=10;
        arr[2]=8;//update value at index 2

        printArray(arr);
    }
    public void removeEven(int[] arr){
        int oddcount=0;
        for (int i=0;i<arr.length;i++){
            if (arr[i]%2 != 0){
                oddcount++;
            }
        }
        int[] result=new int[oddcount];
        int index=0;
        for(int i=0;i<arr.length;i++){
            if (arr[i]%2 !=0){
                result[index]=arr[i];
                index++;
            }
        }
        printArray(result);
    }
    public void reverseArray(int[] arr){
        int start=0;
        int end=arr.length-1;
        while (start<end){
            int temp=arr[start];
            arr[start]=arr[end];
            arr[end]=temp;
            start++;
            end--;
        }
        printArray(arr);
    }
    public void findMin(int[] arr){
        int min=arr[0];
        for (int i=0;i<arr.length;i++){
            if (arr[i]<min){
                min=arr[i];
            }
        }
        System.out.println("The minimum value of the array is "+min);
    }
    public void findMax(int[] arr){
        int max=arr[0];
        for (int i=0;i<arr.length;i++){
            if (arr[i]>max){
                max=arr[i];
            }
        }
        System.out.println("The maximum value of the array is "+max);
    }
    public void findSecondMax(int[] arr){
        int max=Integer.MIN_VALUE;
        int secondmax=Integer.MIN_VALUE;
        for (int i=0;i<arr.length;i++){
            if (arr[i] > max) {
                secondmax=max;
                max=arr[i];
            }else if (arr[i]>secondmax && arr[i] != max){
                secondmax=arr[i];
            }
        }
        System.out.println("The second maximum value of the array is "+secondmax);
    }
    public void moveZeros(int[] arr){
        int j=0;
        for (int i=0;i<arr.length;i++){
            if (arr[i] != 0 && arr[j] == 0){
                int temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
            }
            if (arr[j]!=0){
                j++;
            }
        }
        printArray(arr);
    }
    public void resizeArray(int[] arr,int capacity){
        int[] temp=new int[capacity];
        for (int i=0;i<arr.length;i++){
            temp[i]=arr[i];
        }
        arr=temp;
        printArray(arr);
    }
    public void findMissing(int[] arr){
        int sum=0;
        int n=arr.length+1;
        for (int i=0;i<arr.length;i++){
            sum=sum+arr[i];
        }
        int total=n*(n+1)/2;
        int missing=total-sum;

        System.out.println("Missing number is "+missing);
    }
}
