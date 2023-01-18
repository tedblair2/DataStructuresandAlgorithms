package com.company.array.DynamicProgramming;

public class Fibonacci {

    private int fib(int n){
        if (n==0){
            return 0;
        }
        if (n==1){
            return 1;
        }
        return fib(n-1)+fib(n-2);
    }

    private int bottomFib(int n){
        int[] table=new int[n+1];
        table[0]=0;
        table[1]=1;
        for (int i=2;i<table.length;i++){
            table[i]=table[i-1]+table[i-2];
        }
        return table[n];
    }
    private int topdownFib(int n,int[] arr){
        if (arr[n]==0){
            if (n<2){
                arr[n]=n;
            }else {
                arr[n]=topdownFib(n-1,arr)+topdownFib(n-2,arr);
            }
        }
        return arr[n];
    }

    public static void main(String[] args){
        Fibonacci fib=new Fibonacci();
        int sum=fib.fib(7);
        int add=fib.bottomFib(7);
        int another=fib.topdownFib(7,new int[7+1]);
        System.out.println("Sum is "+sum);
        System.out.println("Sum is "+add);
        System.out.println("Sum is "+another);

    }
}
