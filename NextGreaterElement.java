package com.example.demo.leetcode;

import java.util.Stack;

//https://www.geeksforgeeks.org/next-greater-element/
public class NextGreaterElement {
    public static void main(String[] args) {
        //int[] a = {4 , 5 , 2 , 25};
        int[] a = {13 , 7, 6 , 12 };
        a = nextGreater(a);
        for(int i=0;i<a.length;i++){
            System.out.print(a[i] + " ");
        }
    }
    static int[] nextGreater(int[] a){
        if(a==null || a.length==0) return a;
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for(int i=1;i<a.length;i++){
            while(!stack.isEmpty() && a[i]>a[stack.peek()]){
                int index = stack.pop();
                a[index] = a[i];
            }
            stack.push(i);
        }
        while(!stack.isEmpty()){
            a[stack.pop()] = -1;
        }
        return a;
    }
}
