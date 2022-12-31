package com.example.demo.leetcode;

import java.util.Stack;

//https://leetcode.com/problems/daily-temperatures/
//https://leetcode.com/problems/daily-temperatures/discuss/109832/Java-Easy-AC-Solution-with-Stack
public class DailyTemperatures {
    public static void main(String[] args) {
        int[] temperatures = {73,74,75,71,69,72,76,73};
        int[] res = solve(temperatures);
        for(int i=0;i<res.length;i++){
            System.out.print(res[i] + " ");
        }
    }
    static int[] solve(int[] temperatures){
        int[] res = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<temperatures.length;i++){
            while(!stack.isEmpty() && temperatures[stack.peek()]<temperatures[i]){
                res[stack.peek()] = i-stack.pop();
            }
            stack.add(i);
        }
        return res;
    }
}
