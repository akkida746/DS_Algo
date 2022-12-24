package com.example.demo.leetcode;

import org.yaml.snakeyaml.events.NodeEvent;

//https://www.geeksforgeeks.org/number-turns-reach-one-node-binary-tree/
public class NumberOfTurnsToReachNodes {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.left.left = new Node(8);
        root.right = new Node(3);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.right.left.left = new Node(9);
        root.right.left.right = new Node(10);
        int res = numberOfTurns(root, 4, 10, 0);
        res = res<=0?0:res-1;
        System.out.println(res);
    }
    static int numberOfTurns(Node root, int a, int b, int len){
        if(root==null) return 0;
        if(root.val == a || root.val == b) {
            return len;
        }
        int left = numberOfTurns(root.left, a, b, len + 1);
        int right = numberOfTurns(root.right, a, b, len + 1);
        if(left>0 && right>0){
            return left+right;
        }
        return Math.max(left, right);
    }
    static class Node{
        int val;
        Node left, right;
        Node(int val){
            this.val = val;
        }
    }
}
