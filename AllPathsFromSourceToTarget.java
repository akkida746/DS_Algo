package com.example.demo.leetcode;

import java.util.*;

//https://leetcode.com/problems/all-paths-from-source-to-target/description/
public class AllPathsFromSourceToTarget {
    public static void main(String[] args) {
        //int[][] graph = {{1,2},{3},{3},{}};
        int[][] graph = {{4,3,1},{3,2,4},{3},{4},{}};
        //int[][] graph = {{4,3,1},{3,2,4},{},{},{}};
        //int[][] graph = {{2},{},{1}};
        paths(graph);
    }
    static List<List<Integer>> paths(int[][] graph){
        TreeMap<Integer,List<Integer>> nodemap = new TreeMap<>();
        for(int i=0;i<graph.length;i++) {
            List<Integer> list = nodemap.getOrDefault(i,new ArrayList<>());
            for(int node: graph[i]){
                if(graph[i].length>0) list.add(node);
            }
            nodemap.put(i,list);
        }
        res = new ArrayList<>();
        int target = graph.length-1;
        for(int node: nodemap.keySet()){
            List<Integer> list = new ArrayList<>();
            list.add(node);
            traverse(nodemap, node, list, target);
        }
        System.out.println(res);
        return res;
    }
    static List<List<Integer>> res;
    static void traverse(Map<Integer,List<Integer>> nodemap, int node, List<Integer> list, int target){
        if(list.size()>0 && list.get(0)==0 && list.get(list.size()-1)==target){
            res.add(new ArrayList<>(list));
            return;
        }
        for(int n: nodemap.get(node)){
            List<Integer> temp = new ArrayList<>(list);
            temp.add(n);
            traverse(nodemap, n, temp, target);
        }
    }
}
