package com.example.demo.leetcode;

//https://leetcode.com/problems/shortest-distance-to-target-string-in-a-circular-array/solutions/2948002/java-one-simple-loop/
//https://leetcode.com/problems/shortest-distance-to-target-string-in-a-circular-array/description/
public class ShortestDistanceToTargetStringInCircularArray {
    public static void main(String[] args) {
        String[] words = {"a","b","leetcode"};
        String target = "leetcode";
        int start = 0;
        System.out.println(shortestDist(words, target, start));
    }
    static int shortestDist(String[] words, String target, int startIndex){
        int n = words.length;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (words[i].equals(target)) {
                int distance = Math.abs(startIndex - i);
                min = Math.min(min, Math.min(distance, n - distance));
            }
        }

        return min == Integer.MAX_VALUE ? -1 : min;
    }
}
