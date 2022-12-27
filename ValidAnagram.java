package com.example.demo.leetcode;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/valid-anagram/
public class ValidAnagram {
    public static void main(String[] args) {
        String a = "anagram";
        String b = "nagaram";
        System.out.println(checkStrings(a,b));
    }
    static boolean checkStrings(String a, String b){
        if(a.length()!=b.length()) return false;
        Map<Character,Integer> freqmap = new HashMap<>();
        for(int i=0;i<a.length();i++){
            char c = a.charAt(i);
            freqmap.put(c, freqmap.getOrDefault(c,0)+1);
        }
        for(int i=0;i<b.length();i++){
            char c = b.charAt(i);
            if(null==freqmap.get(c) || freqmap.get(c)==0) return false;
            freqmap.put(c, freqmap.get(c)-1);
        }
        return true;
    }
}
