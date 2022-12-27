package com.example.demo.leetcode;

import com.sun.source.tree.Tree;

import java.util.*;

//https://cheonhyangzhang.gitbooks.io/leetcode-solutions/content/323-number-of-connected-components-in-an-undirected-graph.html
//https://www.hackerearth.com/practice/notes/disjoint-set-union-union-find/
public class NoOfConnectedComponentsInUndirectedGraph {
    public static void main(String[] args) {
        int n = 8;
        int[][] edges = {{0,1},{1,2},{2,3},{3,4},{5,6},{6,7}};
        System.out.println(connectedComponents(edges, n));
    }
    static int connectedComponents(int[][] edges, int n){
        DisjointSet disjointSet = new DisjointSet(n);
        for(int i=0;i<edges.length;i++){
            disjointSet.union(edges[i][0],edges[i][1]);
        }
        Set<Integer> set = new HashSet<>();
        for(int node: disjointSet.parentMap.keySet()){
            set.add(disjointSet.parentMap.get(node));
        }
        return set.size();
    }
    static class DisjointSet{
        Map<Integer,Integer> parentMap = new HashMap<>();
        DisjointSet(int n){
            for(int i=0;i<n;i++){
                parentMap.put(i,i);
            }
        }
        void union(int a, int b){
            int x = findRoot(a);
            int y = findRoot(b);
            parentMap.put(y,x);
        }
        int findRoot(int a){
            if(parentMap.get(a)==a) return a;
            return findRoot(parentMap.get(a));
        }
    }
}
