package com.company.array.SortingAlgorithms;

public class Sort {

    private void printArray(int[] arr){
        for (int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" -->");
        }
        System.out.println(" ");
    }

    private void bubbleSort(int[] arr){
        boolean isSwapped;
        int n=arr.length;
        for (int i=0;i<n-1;i++){
            isSwapped=false;
            for (int j=0;j<n-1-i;j++){
                if (arr[j]>arr[j+1]){
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                    isSwapped=true;
                }
            }
            if (!isSwapped){
                break;
            }
        }
        printArray(arr);
    }
    private void insertionSort(int[] arr){
        int n=arr.length;
        for (int i=1;i<n;i++){
            int temp=arr[i];
            int j=i-1;
            while (j>=0 && arr[j]>temp){
                arr[j+1]=arr[j];
                j--;
            }
            arr[j+1]=temp;
        }
        printArray(arr);
    }
    private void selectionSort(int[] arr){
        int n=arr.length;
        for (int i=0;i<n-1;i++){
            int min=i;
            for (int j=i+1;j<n;j++){
                if (arr[j]<arr[min]){
                    min=j;
                }
            }
            int temp=arr[min];
            arr[min]=arr[i];
            arr[i]=temp;
        }
        printArray(arr);
    }
    private void mergeArrays(int[] arr1,int[] arr2){
        int m=arr1.length;
        int n=arr2.length;
        int[] temp=new int[n+m];
        int i=0;
        int j=0;
        int k=0;
        while (i < m && j < n) {
            if (arr1[i]<arr2[j]){
                temp[k]=arr1[i];
                i++;
            }else {
                temp[k]=arr2[j];
                j++;
            }
            k++;
        }
        while (i<m){
            temp[k]=arr1[i];
            i++;
            k++;
        }
        while (j<n){
            temp[k]=arr2[j];
            j++;
            k++;
        }
        printArray(temp);
    }
    private void sort(int[] arr,int[] temp,int low,int high){
        if (low<high){
            int mid=low+(high-low)/2;
            sort(arr,temp,low,mid);
            sort(arr,temp,mid+1,high);
            merge(arr,temp,low,mid,high);
        }

    }

    private void merge(int[] arr, int[] temp, int low, int mid, int high){
        for (int i=low;i<=high;i++){
            temp[i]=arr[i];
        }
        int i=low;
        int j=mid+1;
        int k=low;
        while (i<=mid && j<=high){
            if (temp[i]<=temp[j]){
                arr[k]=temp[i];
                i++;
            }else {
                arr[k]=temp[j];
                j++;
            }
            k++;
        }
        while (i<=mid){
            arr[k]=temp[i];
            i++;
            k++;
        }
        printArray(arr);
    }
    private int partition(int[] arr){//quick sort algorithm
        int low=0;
        int high=arr.length-1;
        int i=low;
        int j=low;
        int pivot=high;
        while (i<=high){
            if (arr[i]<=arr[pivot]){
                int temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
                j++;
            }
            i++;
        }
        return j-1;
    }
    private void squareElements(int[] arr){
        int n=arr.length;
        int[] result=new int[n];
        int i=0;
        int j=n-1;
        for (int k=n-1;k>=0;k--){
            if (Math.abs(arr[i])>Math.abs(arr[j])){
                result[k]=arr[i]*arr[i];
                i++;
            }else {
                result[k]=arr[j]*arr[j];
                j--;
            }
        }
        printArray(result);
    }
    private void maxmin(int[] arr){
        int maxindx=arr.length-1;
        int minindx=0;
        int max=arr[maxindx]+1;
        for(int i=0;i<arr.length;i++){
            if (i%2==0){
                arr[i]=arr[i]+(arr[maxindx]%max)*max;
                maxindx--;
            }else {
                arr[i]=arr[i]+(arr[minindx]%max)*max;
                minindx++;
            }
        }
        printArray(arr);
        for (int i=0;i<arr.length;i++){
            arr[i]=arr[i]/max;
        }
        printArray(arr);
    }

    public static void main(String[] args){
        Sort sort=new Sort();
        int[] arr={2,9,4,6,7,8,18,13,22,15};
        int[] arr1={1,3,5,10,11,12,15,16,18};
        int[] arr2={-8,-4,-2,1,2,3,5,7};
        int[] temp=new int[arr.length];
//        sort.bubbleSort(arr);
//        sort.insertionSort(arr);
//        sort.selectionSort(arr);
//        sort.mergeArrays(arr,arr1);
        sort.squareElements(arr2);
        sort.maxmin(arr1);
        //sort.sort(arr,temp,0,9);
    }
}
