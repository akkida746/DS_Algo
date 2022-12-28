package com.example.demo.codility;

import java.util.Arrays;
import java.util.Map;

//https://app.codility.com/programmers/task/multivitamin/
public class Multivitamin {
    public static void main(String[] args) {
        //int[] juice = {1, 2, 3, 4};int[] capactity = {3, 6, 4, 4};
        //int[] juice = {1, 2, 3, 4};int[] capactity = {3, 6, 4, 4};
        //int[] juice = {2, 3};int[] capactity = {3, 4};
        int[] juice = {1, 1, 5};int[] capactity = {6, 5, 8};
        System.out.println(solve(juice, capactity));
    }
    static int solve(int[] juice, int[] capacity){
        for(int i=0;i<capacity.length;i++){
            int diff = capacity[i]-juice[i];
            subset(juice, diff,0,i,0, 1);
        }
        return max;
    }
    static int max = 1;
    static void subset(int[] a, int target, int index, int glass, int sum, int count){
        if(index>a.length-1){
            /*if(sum<=target){
                max = Math.max(max, count);
            }*/
            return;
        }
        if(sum<=target){
            max = Math.max(max, count);
        }
        subset(a, target, index+1, glass, sum, count);
        if(index!=glass && sum+a[index]<=target){
            subset(a, target, index+1, glass, sum+a[index], count+1);
        }
    }
}
