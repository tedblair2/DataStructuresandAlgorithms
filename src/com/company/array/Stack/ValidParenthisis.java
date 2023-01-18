package com.company.array.Stack;

import java.util.Stack;

public class ValidParenthisis {

    private static void isValid(String s){
        Stack<Character> stack=new Stack<>();
        for (char c:s.toCharArray()){
            if (c =='(' || c=='{' || c=='['){
                stack.push(c);
            }else {
                if (stack.isEmpty()){
                    System.out.println("String is not valid");
                    return;
                }else {
                    if ((c==')' && stack.peek()=='(')|| (c=='}' && stack.peek()=='{')||(c==']' && stack.peek()=='[')){
                        stack.pop();
                    }else {
                        System.out.println("String is not valid");
                        return;
                    }
                }
            }
        }
        if (stack.isEmpty()){
            System.out.println("String is valid");
        }
    }

    public static void main(String[] args){
        isValid("({)");
    }
}
