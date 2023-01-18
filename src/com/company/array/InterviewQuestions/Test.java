package com.company.array.InterviewQuestions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Test {

    private void printArray(int[] arr){
        for (int i=0;i<arr.length;i++){
            System.out.print(arr[i]+",");
        }
        System.out.println();
    }

    private void removeVowels(String word){
        Set<Character> vowels=Set.of('a','e','i','o','u');
        char[] arr=word.toCharArray();
        for (char c:arr){
            if (!vowels.contains(c)){
                System.out.print(c+"");
            }
        }
        System.out.println();
    }
    private void twoSumProb(int[] arr,int target){//returns indices of two numbers that when added equals the target
        int[] result=new int[2];
        Map map=new HashMap();
        for (int i=0;i<arr.length;i++){
            if (!map.containsKey(target-arr[i])){
                map.put(arr[i],i);
            }else {
                result[1]=i;
                result[0]= (int) map.get(target-arr[i]);
                printArray(result);
                return;
            }
        }
        System.out.println("Not found.");
    }
    private int[] twoSumAnother(int[] arr,int target){//return two numbers that add to the target from the array
        Arrays.sort(arr);
        int left=0;
        int right=arr.length-1;
        int[] result=new int[2];
        while (left<right){
            int sum=arr[left]+arr[right];
            if (sum==target){
                result[0]=arr[left];
                result[1]=arr[right];
                return result;
            }else if (sum<target){
                left++;
            }else {
                right--;
            }
        }
        return new int[0];
    }
    private boolean isSubsequence(String str,String seq){
        int i=0;
        int j=0;
        while (i<str.length() && j<seq.length()){
            if (str.charAt(i)==seq.charAt(j)){
                j++;
            }
            i++;
        }
        return j==seq.length();
    }
    private int firstNonRepeatingCharacter(String string){
        Map<Character,Integer> map=new HashMap<>();
        char[] arr=string.toCharArray();
        for (char c:arr){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        for (int i=0;i<arr.length;i++){
            if (map.get(arr[i])==1){
                return i;
            }
        }
        return -1;
    }
    private long reverseInteger(int number){
        boolean isNegative=number<0;
        if (isNegative){
            number=number* -1;
        }
        long reverse=0;
        int lastdigit;
        while (number>0){
            lastdigit=number%10;
            reverse=reverse * 10 + lastdigit;
            number=number/10;
        }
        return isNegative? reverse*-1:reverse;
    }
    private void threeSumProblem(int[] arr,int target){
        for (int i=0;i<arr.length-2;i++){
            int low=i+1;
            int high=arr.length-1;
            while (low<high){
                int sum=arr[i]+arr[low]+arr[high];
                if (sum==target){
                    System.out.println(arr[i]+","+arr[low]+","+arr[high]);
                    low++;
                    high--;
                }else if (sum<target){
                    low++;
                }else {
                    high--;
                }
            }
        }
    }
    private void productArrray(int[] arr){
        int[] result=new int[arr.length];
        int temp=1;
        for (int i=0;i<arr.length;i++){
            result[i]=temp;
            temp=temp*arr[i];
        }
        temp=1;
        for (int i=arr.length-1;i>=0;i--){
            result[i]=result[i]*temp;
            temp=temp*arr[i];
        }
        printArray(result);
    }
    private void slidingWindow(int[] arr,int window){
        int i=0;
        int j=window-1;
        int[] result=new int[arr.length-j];
        while (j<arr.length){
            int max=arr[i];
            for (int k=i;k<=j;k++){
                if (arr[k]>max){
                    max=arr[k];
                }
            }
            result[i]=max;
            i++;
            j++;
        }
        printArray(result);

    }
    private void maxSubArray(int[] arr,int window){
        int i=0;
        int j=window-1;
        int[] result=new int[arr.length-j];
        while (j<arr.length){
            int sum=0;
            for (int k=i;k<=j;k++){
                sum=sum+arr[k];
            }
            result[i]=sum;
            i++;
            j++;
        }
        int max=result[0];
        printArray(result);
        for (int k=0;k<result.length;k++){
            if (result[k]>max){
                max=result[k];
            }
        }
        System.out.println("Maximum sum of subarray for window "+window+" is "+max);
    }
    private void longestSubstring(String string){
        Map<Character,Integer> map=new HashMap<>();
        int maxlength=0;
        int start=0;
        for (int index=0;index<string.length();index++){
            char right=string.charAt(index);
            if (map.containsKey(right)){
                start=Math.max(start,map.get(right)+1);
            }
            map.put(right,index);
            maxlength=Math.max(maxlength,(index-start)+1);
        }
        System.out.println("Longest substring is "+maxlength);
    }

    public static void main(String[] args){
        Test test=new Test();
        int[] numbers={2,4,5,7,1,3,8};
        test.productArrray(numbers);
        test.slidingWindow(numbers,6);
        test.maxSubArray(numbers,6);
        test.longestSubstring("abcabcbb");
//        test.removeVowels("today is tuesday");
//        test.twoSumProb(numbers,12);
//        test.printArray(test.twoSumAnother(numbers,5));
//        boolean seq=test.isSubsequence("abcde","ce");
//        System.out.println(seq);
//        int result=test.firstNonRepeatingCharacter("ababab");
//        System.out.println(result);
//        System.out.println(test.reverseInteger(12345678));
//        test.threeSumProblem(numbers,11);
    }
}
